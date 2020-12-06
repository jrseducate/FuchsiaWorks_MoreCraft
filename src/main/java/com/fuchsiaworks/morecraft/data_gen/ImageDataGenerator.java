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
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import com.fuchsiaworks.morecraft.block.Blocks;
import com.fuchsiaworks.morecraft.block.ColoredBlockHelper;
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
			set(r, g, b, a);
		}

		public ImagePixel(int r, int g, int b) {
			this(r, g, b, 255);
		}

		public ImagePixel(ImagePixel imagePixel) {
			this(imagePixel.r, imagePixel.g, imagePixel.b, imagePixel.a);
		}

		public int[] toArray() {
			return new int[] { r, g, b, a };
		}

		public int getLuminance() {
			return (int) ((r * 0.2126f) + (g * 0.7152f) + (b * 0.0722f));
		}

		public float getLuminanceFloat() {
			return ((r * 0.2126f) + (g * 0.7152f) + (b * 0.0722f)) / 255;
		}

		public void set(ImagePixel imagePixel) {
			set(imagePixel.r, imagePixel.g, imagePixel.b, imagePixel.a);
		}

		public void set(int r, int g, int b, int a) {
			this.r = r;
			this.g = g;
			this.b = b;
			this.a = a;
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

		public ImageData(BufferedImage bufferedImage) {
			this(bufferedImage, null);
		}

		public ImageData(BufferedImage bufferedImage, BiConsumer<ImageCoord, ImagePixel> callback) {
			this(bufferedImage.getWidth(), bufferedImage.getHeight());

			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					Color colorPixel = new Color(bufferedImage.getRGB(x, y), true);
					int r = colorPixel.getRed();
					int g = colorPixel.getGreen();
					int b = colorPixel.getBlue();
					int a = colorPixel.getAlpha();

					ImageCoord imageCoord = new ImageCoord(x, y);
					ImagePixel imagePixel = new ImagePixel(r, g, b, a);

					if (callback != null) {
						callback.accept(imageCoord, imagePixel);
					}

					setPixel(x, y, imagePixel);
				}
			}
		}

		public int getPixelIndex(int x, int y) {
			return (y * width) + x;
		}

		public ImagePixel getPixel(ImageCoord imageCoord) {
			return getPixel(imageCoord.x, imageCoord.y);
		}

		public ImagePixel getPixel(int x, int y) {
			int i = getPixelIndex(x, y);

			return pixels[i];
		}

		public void setPixel(ImageCoord imageCoord, ImagePixel imagePixel) {
			setPixel(imageCoord.x, imageCoord.y, imagePixel);
		}

		public void setPixel(int x, int y, ImagePixel imagePixel) {
			int i = getPixelIndex(x, y);

			pixels[i] = imagePixel;
		}

		public void writeToRaster(WritableRaster raster) {
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					// ImagePixel imagePixel = getPixel(x, y);
					//
					// if(imagePixel == null) {
					// imagePixel = ImagePixel.EMPTY;
					// }

					raster.setPixel(x, y, getPixel(x, y).toArray());
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
			int[] nBits = { 8, 8, 8, 8 };
			ComponentColorModel colorModel = new ComponentColorModel(cs, nBits, true, false, Transparency.TRANSLUCENT,
					DataBuffer.TYPE_BYTE);
			WritableRaster raster = Raster.createBandedRaster(DataBuffer.TYPE_BYTE, imageData.width, imageData.height,
					4, new Point(0, 0));
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

	public static class ImageHelper {
		public String templateFilePath;
		public String referenceFilePath;
		public String outputFilePath;
		public BiConsumer<ImageHelper, DataGenerator> callback;
		public ImagePixel[] colors;

		public ImageHelper(BiConsumer<ImageHelper, DataGenerator> callback) {
			this.callback = callback;
		}

		public BufferedImage loadTemplateImage(DataGenerator generator) {
			return loadImage(generator, templateFilePath);
		}

		public BufferedImage loadImage(DataGenerator generator, String path) {
			Path generatorPath = generator.getOutputFolder();
			Path parentPath = generatorPath.getParent();

			try {
				return ImageIO.read(parentPath.resolve(path).toFile());
			} catch (Exception ex) {
			}

			return null;
		}

		public void generate(DataGenerator generator, String templateFilePath, String outputFilePath,
				ImagePixel[] colors) {
			this.templateFilePath = templateFilePath;
			this.outputFilePath = outputFilePath;
			this.colors = colors;

			callback.accept(this, generator);
		}

		public void generate(DataGenerator generator, String templateFilePath, String outputFilePath) {
			this.templateFilePath = templateFilePath;
			this.outputFilePath = outputFilePath;

			callback.accept(this, generator);
		}

		public void generate(DataGenerator generator, String templateFilePath, String referenceFilePath,
				String outputFilePath) {
			this.templateFilePath = templateFilePath;
			this.referenceFilePath = referenceFilePath;
			this.outputFilePath = outputFilePath;

			callback.accept(this, generator);
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
		if (directory.exists()) {
			try {
				FileUtils.cleanDirectory(directory);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (!directory.exists()) {
			directory.mkdirs();
		}
	}

	public static String EXTRA_PATH = "extra/";
	public static String DATAGEN_PATH = EXTRA_PATH + "datagen_templates/";
	public static String DATAGEN_IMAGES_PATH = DATAGEN_PATH + "images/";

	public static ImageHelper IMAGE_TEMPLATE_MASKED_TEXTURE = new ImageHelper((imageHelper, generator) -> {
		BufferedImage bufferedImage = imageHelper.loadTemplateImage(generator);

		if (bufferedImage != null) {
			ImagePixel[] colors = imageHelper.colors;

			new ImageDataProvider(imageHelper.outputFilePath,
					() -> new ImageData(bufferedImage, (imageCoord, imagePixel) -> {
						int luminance = imagePixel.getLuminance();
						int index = (int) Math.min(colors.length - 1, Math.round(colors.length * (luminance / 255.0f)));
						ImagePixel newPixel = ImagePixel.EMPTY;

						if (imagePixel.a > 0) {
							newPixel = colors[index];
						}

						imagePixel.set(newPixel);
					})).generate(generator);
		}
	});

	public static ImageHelper IMAGE_TEMPLATE_TINT = new ImageHelper((imageHelper, generator) -> {
		BufferedImage bufferedImage = imageHelper.loadTemplateImage(generator);

		if (bufferedImage != null) {
			new ImageDataProvider(imageHelper.outputFilePath, () -> new ImageData(bufferedImage)).generate(generator);
		}
	});

	public static ImageHelper IMAGE_TEMPLATE_MASKED_TINT = new ImageHelper((imageHelper, generator) -> {
		BufferedImage bufferedImage = imageHelper.loadTemplateImage(generator);
		BufferedImage referenceBufferedImage = imageHelper.loadImage(generator, imageHelper.referenceFilePath);

		if (bufferedImage != null && referenceBufferedImage != null) {
			ImageData referenceImageData = new ImageData(referenceBufferedImage);

			new ImageDataProvider(imageHelper.outputFilePath,
					() -> new ImageData(bufferedImage, (imageCoord, imagePixel) -> {
						ImagePixel referenceImagePixel = referenceImageData.getPixel(imageCoord);

						if (referenceImagePixel.a <= 0) {
							imagePixel.set(0, 0, 0, 0);
						}
					})).generate(generator);
		}
	});

	public static void generateItemImage(DataGenerator generator, String templateImagePath, Item item,
			ImagePixel... imagePixels) {
		String id = item.getRegistryName().getPath();
		IMAGE_TEMPLATE_MASKED_TEXTURE.generate(generator, templateImagePath,
				ImageDataGenerator.ASSETS_TEXTURES_ITEM_PATH + id + ".png", imagePixels);
	}

	public static void onGatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();

		Path generatorPath = generator.getOutputFolder();

		CleanDirectory(generatorPath.resolve(ASSETS_TEXTURES_ITEM_PATH).toFile());
		CleanDirectory(generatorPath.resolve(ASSETS_TEXTURES_BLOCK_PATH).toFile());
		CleanDirectory(generatorPath.resolve(ASSETS_TEXTURES_ENTITY_PATH).toFile());

		Wait(1000);

		ColoredBlockHelper.Color[] colors = ColoredBlockHelper.Color.values();

		for (int i = 0; i < colors.length; i++) {
			String color = colors[i].name;
			String tintName = "tint_" + color;
			String tintPath = DATAGEN_IMAGES_PATH + tintName + ".png";

			IMAGE_TEMPLATE_TINT.generate(generator, tintPath, ASSETS_TEXTURES_BLOCK_PATH + tintName + ".png");

			IMAGE_TEMPLATE_MASKED_TINT.generate(generator, tintPath, DATAGEN_IMAGES_PATH + "trapdoor_acacia_mask.png",
					ASSETS_TEXTURES_BLOCK_PATH + "acacia_trapdoor_" + tintName + ".png");
			IMAGE_TEMPLATE_MASKED_TINT.generate(generator, tintPath, DATAGEN_IMAGES_PATH + "trapdoor_crimson_mask.png",
					ASSETS_TEXTURES_BLOCK_PATH + "crimson_trapdoor_" + tintName + ".png");
			IMAGE_TEMPLATE_MASKED_TINT.generate(generator, tintPath, DATAGEN_IMAGES_PATH + "trapdoor_jungle_mask.png",
					ASSETS_TEXTURES_BLOCK_PATH + "jungle_trapdoor_" + tintName + ".png");
			IMAGE_TEMPLATE_MASKED_TINT.generate(generator, tintPath, DATAGEN_IMAGES_PATH + "trapdoor_oak_mask.png",
					ASSETS_TEXTURES_BLOCK_PATH + "oak_trapdoor_" + tintName + ".png");
			IMAGE_TEMPLATE_MASKED_TINT.generate(generator, tintPath, DATAGEN_IMAGES_PATH + "trapdoor_warped_mask.png",
					ASSETS_TEXTURES_BLOCK_PATH + "warped_trapdoor_" + tintName + ".png");
		}

		Blocks.onGatherImageData(generator);
		Items.onGatherImageData(generator);
	}
}
