package com.fuchsiaworks.morecraft.data_gen;

import java.awt.Color;
import java.awt.Point;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Supplier;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import com.fuchsiaworks.morecraft.block.Blocks;
import com.fuchsiaworks.morecraft.item.Items;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.item.Item;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

public class ImageDataGenerator extends BaseDataGenerator {

	public static class ImageCoord {
		public int x, y;
		
		public ImageCoord(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return x + ":" + y;
		}
		
		@Override
		public int hashCode() {
			return super.toString().hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			return super.hashCode() == obj.hashCode();
		}
	}
	
	public static class ImagePixel {
		public int r, g, b, a;
		
		public static ImagePixel EMPTY = new ImagePixel(0, 0, 0, 0);
		
		public ImagePixel(int r, int g, int b, int a) {
			this.r = r;
			this.g = g;
			this.b = b;
			this.a = a;
		}
		
		public ImagePixel(int r, int g, int b) {
			this(r, g, b, 255);
		}

		public int[] toArray() {
			return new int[] {r, g, b, a};
		}
		
		@Override
		public String toString() {
			return r + ":" + g + ":" + b + ":" + a;
		}
		
		@Override
		public int hashCode() {
			return super.toString().hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			return super.hashCode() == obj.hashCode();
		}

		public int getLuminance() {
			return (int)((r * 0.2126f) + (g * 0.7152f) + (b * 0.0722f));
		}

		public float getLuminanceFloat() {
			return ((r * 0.2126f) + (g * 0.7152f) + (b * 0.0722f)) / 255;
		}
	}
	
	public static class ImageData {
		public int width, height;
		public ImagePixel[] pixels;
		
		public ImageData(int width, int height) {
			this.width = width;
			this.height = height;
			this.pixels = new ImagePixel[width * height];
		}
		
		public int getPixelIndex(int x, int y) {
			return (y * width) + x;
		}
		
		public void setPixel(int x, int y, ImagePixel imagePixel) {
			int i = getPixelIndex(x, y);
			
			pixels[i] = imagePixel;
		}

		public void writeToRaster(WritableRaster raster) {
			for(int y = 0; y < height; y++) {
				for(int x = 0; x < width; x++) {
					int i = getPixelIndex(x, y);
					ImagePixel imagePixel = pixels[i];
					
					if(imagePixel == null) {
						imagePixel = ImagePixel.EMPTY;
					}
					
					raster.setPixel(x, y, imagePixel.toArray());
				}
			}
		}
	}
	
	public static class ImageDataProvider implements IDataProvider {

		public DataGenerator generator;
		public String filePath;
		public Supplier<ImageData> imageDataSupplier;

		public ImageDataProvider(String filePath, Supplier<ImageData> imageDataSupplier) {
			this.filePath = filePath;
			this.imageDataSupplier = imageDataSupplier;
		}

		public ImageDataProvider bind(DataGenerator generator) {
			this.generator = generator;

			return this;
		}

		@Override
		public String getName() {
			return filePath;
		}

		@Override
		public void act(DirectoryCache cache) {
			Path path = generator.getOutputFolder().resolve(filePath);
			ImageData imageData = imageDataSupplier.get();
			
			ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
		    int[] nBits = {8, 8, 8, 8};
			ComponentColorModel colorModel = new ComponentColorModel(cs, nBits, true, false, Transparency.TRANSLUCENT, DataBuffer.TYPE_BYTE);
			WritableRaster raster = Raster.createBandedRaster(DataBuffer.TYPE_BYTE, imageData.width, imageData.height, 4, new Point(0,0));
			imageData.writeToRaster(raster);
			BufferedImage bufferedImage = new BufferedImage(colorModel, raster, false, null);
			
			File outputfile = new File(path.toAbsolutePath().toString());

			try {				
				ImageIO.write(bufferedImage, "png", outputfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void generate(DataGenerator generator) {
			generator.addProvider(bind(generator));
		}

	}
	
	public static class ImageTemplate {
		public String fileTemplatePath;
		public BufferedImage bufferedImage;
		
		public ImageTemplate(String filePath) {
			this.fileTemplatePath = filePath;
		}
		
		public ImageTemplate loadImage(DataGenerator generator) {
			Path generatorPath = generator.getOutputFolder();
			Path parentPath = generatorPath.getParent();
			
			try {
				this.bufferedImage = ImageIO.read(parentPath.resolve(fileTemplatePath).toFile());
			}
			catch(Exception ex) {}
			
			return this;
		}

		public void generate(DataGenerator generator, String filePath, ImagePixel[] colors) {
			loadImage(generator);
			
			if(this.bufferedImage != null) {
				int width = bufferedImage.getWidth();
				int height = bufferedImage.getHeight();
				ImageData imageData = new ImageData(width, height);

				for(int y = 0; y < height; y++) {
					for(int x = 0; x < width; x++) {
			            Color color = new Color(bufferedImage.getRGB(x, y), true);
						int r = color.getRed();
						int g = color.getGreen();
						int b = color.getBlue();
						int a = color.getAlpha();
						
						ImagePixel imagePixel = new ImagePixel(r, g, b, a);
						
						if(a > 0) {
							float luminance = imagePixel.getLuminanceFloat();
							int index = (int)Math.min(colors.length - 1, Math.round(colors.length * luminance));
							ImagePixel colorPixel = colors[index];
							
							imageData.setPixel(x, y, colorPixel);
						}
					}
				}
				
				ImageDataProvider imageDataProvider = new ImageDataProvider(filePath, () -> imageData);
				imageDataProvider.generate(generator);
			}
		}
	}
	
	public static void Wait(int ms) {
		try {
		    Thread.sleep(ms);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
	}
	
	public static void CleanDirectory(File directory) {
		if(directory.exists()) {
			try {
				FileUtils.cleanDirectory(directory);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(!directory.exists()) {
			directory.mkdirs();
		}
	}
	
	public static String EXTRA_PATH = "extra/";
	public static String DATAGEN_PATH = EXTRA_PATH + "datagen_templates/";
	public static String DATAGEN_IMAGES_PATH = DATAGEN_PATH + "images/";

	public static ImageTemplate IMAGE_TEMPLATE_DICED_FOOD = new ImageTemplate(DATAGEN_IMAGES_PATH + "chopped_food.png");
	
	public static void generateItemImage(DataGenerator generator, ImageTemplate imageTemplate, Item item, ImagePixel... imagePixels) {
		String id = item.getRegistryName().getPath();
		imageTemplate.generate(generator, ImageDataGenerator.ASSETS_TEXTURES_ITEM_PATH + id + ".png", imagePixels);
	}
	
	public static void onGatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		
		Path generatorPath = generator.getOutputFolder();
		
		CleanDirectory(generatorPath.resolve(ASSETS_TEXTURES_ITEM_PATH).toFile());
		CleanDirectory(generatorPath.resolve(ASSETS_TEXTURES_BLOCK_PATH).toFile());
		CleanDirectory(generatorPath.resolve(ASSETS_TEXTURES_ENTITY_PATH).toFile());
		
		Wait(1000);
		
		Blocks.onGatherImageData(generator);
		Items.onGatherImageData(generator);
	}
}
