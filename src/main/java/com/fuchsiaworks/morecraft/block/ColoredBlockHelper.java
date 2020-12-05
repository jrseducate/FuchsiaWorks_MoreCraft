package com.fuchsiaworks.morecraft.block;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.fuchsiaworks.morecraft.JsonBuilder;
import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.Utils;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator.JsonDataProvider;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

public class ColoredBlockHelper {
	public static enum Color {
		BLACK("black"),
		BLUE("blue"),
		BROWN("brown"),
		CYAN("cyan"),
		GRAY("gray"),
		GREEN("green"),
		LIGHT_BLUE("light_blue"),
		LIGHT_GRAY("light_gray"),
		LIME("lime"),
		MAGENTA("magenta"),
		PINK("pink"),
		PURPLE("purple"),
		RED("red"),
		ORANGE("orange"),
		WHITE("white"),
		YELLOW("yellow");
		
		public static HashMap<String, Color> lookupMap = Utils.Init(() -> {
			HashMap<String, Color> lookupMap = new HashMap<>();
			Color[] colors = Color.values();
			
			for(int i = 0; i < colors.length; i++) {
				lookupMap.put(colors[i].name, colors[i]);
			}
			
			return lookupMap;
		});
		
		public static Color GetColor(String name) {
			return lookupMap.get(name);
		}
		
		public String name;
		
		Color(String name) {
			this.name = name;
		}
	}

	public String idTemplate;
	public Block[] blocks;
	public Item[] items;
	public Class<? extends Block> classObj;
	public Constructor<? extends Block> classConstructor;

	public ColoredBlockHelper(String idTemplate, Properties properties) {
		this(idTemplate, properties, Block.class);
	}

	public ColoredBlockHelper(String idTemplate, Properties properties, Class<? extends Block> classObj) {
		this.idTemplate = idTemplate;
		this.classObj = classObj;

		Color[] colors = Color.values();

		isTinted = true;
		blocks = new Block[colors.length];
		items = new Item[colors.length];

		for (Color colorEnum : colors) {
			int index = colorEnum.ordinal();
			String color = colorEnum.name;
			String id = idTemplate.replace("{color}", color);

			Block block = getNewBlock(properties, id);
			Item item = getNewItem(block, id);

			blocks[index] = block;
			items[index] = item;
		}
	}

	public Block getNewBlock(AbstractBlock.Properties properties, String id) {
		return newBlock(properties).setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, id));
	}

	public Block newBlock(AbstractBlock.Properties properties) {
		try {
			if (classConstructor == null) {
				classConstructor = classObj.getConstructor(AbstractBlock.Properties.class);
			}

			return classConstructor.newInstance(properties);
		} catch (Exception ex) {
			return null;
		}
	}

	public Item getNewItem(Block block, String id) {
		return new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
				.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, id));
	}

	public Item newItem(Block block, Item.Properties properties) {
		return new BlockItem(block, properties);
	}
	
	public Block getBlock(Color color) {
		return blocks[color.ordinal()];
	}
	
	public Block getBlock(String color) {
		return getBlock(Color.GetColor(color));
	}

	public void eachBlock(BiConsumer<Block, String> callback) {
		for (Color colorEnum : Color.values()) {
			callback.accept(getBlock(colorEnum), colorEnum.name);
		}
	}

	public void eachBlock(Consumer<Block> callback) {
		eachBlock((block, color) -> {
			callback.accept(block);
		});
	}
	
	public Item getItem(Color color) {
		return items[color.ordinal()];
	}
	
	public Item getItem(String color) {
		return getItem(Color.GetColor(color));
	}

	public void eachItem(BiConsumer<Item, String> callback) {
		for (Color colorEnum : Color.values()) {
			callback.accept(getItem(colorEnum), colorEnum.name);
		}
	}

	public void eachItem(Consumer<Item> callback) {
		eachItem((item, color) -> {
			callback.accept(item);
		});
	}

	public void registerBlocks(final RegistryEvent.Register<Block> blockRegistryEvent) {
		eachBlock((block) -> blockRegistryEvent.getRegistry().register(block));
	}

	public void bindBlockRenderLayers(RenderType renderType) {
		eachBlock((block) -> RenderTypeLookup.setRenderLayer(block, renderType));
	}

	public void registerItems(final RegistryEvent.Register<Item> itemRegistryEvent) {
		eachItem((item) -> itemRegistryEvent.getRegistry().register(item));
	}
	
	public boolean isTinted;
	
	public ColoredBlockHelper asNonTinted() {
		isTinted = false;
		
		return this;
	}
	
	public String textureIdTemplate;

	public ColoredBlockHelper setTexture(String textureIdTemplate) {
		this.textureIdTemplate = textureIdTemplate;
		
		return this;
	}
	
	public String getTexture(String color) {
		String result = new String(textureIdTemplate);
		
		if(result.indexOf("minecraft:") == -1) {
			result = MoreCraft.MOD_ID + ":block/" + result;
		}
		
		return result.replace("{color}", color);
	}
	
	public void generateBlocksJson(DataGenerator generator) {
		List<JsonDataProvider> assetGenerators = getBlockDataProviders();
		
		for(JsonDataProvider assetGenerator : assetGenerators) {
			generator.addProvider(assetGenerator.bind(generator));
		}
	}
	
	public void generateItemsJson(DataGenerator generator) {
		List<JsonDataProvider> assetGenerators = getItemDataProviders();
		
		for(JsonDataProvider assetGenerator : assetGenerators) {
			generator.addProvider(assetGenerator.bind(generator));
		}
	}
	
	public List<JsonDataProvider> getBlockDataProviders() {
		List<JsonDataProvider> dataProviders = new ArrayList<JsonDataProvider>();
		
		eachBlock((block, color) -> {
			String id = block.getRegistryName().getPath();
			String texture = getTexture(color);
			
			// BLOCKSTATES
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_BLOCKSTATES_PATH + id + ".json", () -> {
				return JsonBuilder.newObject((json) -> {
					json.addObject("variants", (variants) -> {
						variants.addObject("", (variant) -> {
							variant.add("model", MoreCraft.MOD_ID + ":block/" + id);
						});
					});
				}).build();
			}));
			
			// BLOCK MODELS
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + id + ".json", () -> {
				return JsonBuilder.newObject((json) -> {
					if(isTinted) {
						json.add("parent", MoreCraft.MOD_ID + ":block/cube_all_tint");
					}
					else {
						json.add("parent", "block/cube_all");
					}
					
					json.addObject("textures", (textures) -> {
						textures.add("all", texture);
						
						if(isTinted) {
							textures.add("tint", MoreCraft.MOD_ID + ":block/" + color + "_tint");
						}
					});
				}).build();
			}));
		});
		
		return dataProviders;
	}
	
	public List<JsonDataProvider> getItemDataProviders() {
		List<JsonDataProvider> dataProviders = new ArrayList<JsonDataProvider>();
		
		eachItem((item, color) -> {
			String id = item.getRegistryName().getPath();
			
			// ITEM MODELS
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_ITEM_PATH + id + ".json", () -> {
				return JsonBuilder.newObject((json) -> {
					json.add("parent", MoreCraft.MOD_ID + ":block/" + id);
				}).build();
			}));
		});
		
		return dataProviders;
	}
	
	public void generateRecipesJson(DataGenerator generator, String dyedIngredientTag) {
		List<JsonDataProvider> assetGenerators = getRecipeDataProviders(dyedIngredientTag);
		
		for(JsonDataProvider assetGenerator : assetGenerators) {
			assetGenerator.generate(generator);
		}
	}
	
	public String getDyedIngredientTag(String dyedIngredientTag) {
		if(dyedIngredientTag.indexOf("minecraft:") == -1) {
			dyedIngredientTag = MoreCraft.MOD_ID + ":" + dyedIngredientTag;
		}
		
		return dyedIngredientTag;
	}
	
	public List<JsonDataProvider> getRecipeDataProviders(String dyedIngredientTag) {
		List<JsonDataProvider> dataProviders = new ArrayList<JsonDataProvider>();
		
		final String finalDyedIngredientTag = getDyedIngredientTag(dyedIngredientTag);

		eachBlock((block, color) -> {
			String id = block.getRegistryName().getPath();
			
			for(int i = 1; i <= 8; i++) {
				final int count = i;
				dataProviders.add(new JsonDataProvider(JsonDataGenerator.DATA_RECIPES_PATH + id + "_crafting_shapeless_" + count + ".json", () -> {
					return JsonBuilder.newObject((json) -> {
						json.add("type", "minecraft:crafting_shapeless");
						json.addArray("ingredients", (ingredients) -> {
							ingredients.addObject((ingredient) -> {
								ingredient.add("item", "minecraft:" + color + "_dye");
							});
							for(int j = 0; j < count; j++) {
								ingredients.addObject((ingredient) -> {
									ingredient.add("tag", finalDyedIngredientTag);
								});
							}
						});
						json.addObject("result", (result) -> {
							result.add("item", MoreCraft.MOD_ID + ":" + id);
							result.add("count", count);
						});
					}).build();
				}));
			}
		});
		
		return dataProviders;
	}
}
