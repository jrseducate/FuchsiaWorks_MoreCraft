package com.fuchsiaworks.morecraft.block;

import java.util.ArrayList;
import java.util.List;

import com.fuchsiaworks.morecraft.JsonBuilder;
import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator.JsonDataProvider;

import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.data.DataGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;

public class ColoredSlabBlockHelper extends ColoredBlockHelper {

	public ColoredSlabBlockHelper(String idTemplate, Properties properties) {
		this(idTemplate, properties, SlabBlock.class);
	}

	public ColoredSlabBlockHelper(String idTemplate, Properties properties, Class<? extends SlabBlock> classObj) {
		super(idTemplate, properties, classObj);
	}
	
	public String doubleModelIdTemplate;
	
	public ColoredSlabBlockHelper setDoubleModel(String doubleModelIdTemplate) {
		this.doubleModelIdTemplate = doubleModelIdTemplate;
		
		return this;
	}
	
	public String getDoubleModel(String color) {
		String result = new String(doubleModelIdTemplate);
		
		if(result.indexOf("minecraft:") == -1) {
			result = MoreCraft.MOD_ID + ":block/" + result;
		}
		
		return result.replace("{color}", color);
	}
	
	@Override
	public List<JsonDataProvider> getBlockDataProviders() {
		List<JsonDataProvider> dataProviders = new ArrayList<JsonDataProvider>();
		
		eachBlock((block, color) -> {
			String id = block.getRegistryName().getPath();
			String texture = getTexture(color);
			String bottomModel = id;
			String topModel = id + "_top";
			String doubleModel = getDoubleModel(color);
			
			// BLOCKSTATES
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_BLOCKSTATES_PATH + id + ".json", () -> {
				return JsonBuilder.newObject((json) -> {
					json.addObject("variants", (variants) -> {
						variants.addObject("type=bottom", (variant) -> {
							variant.add("model", MoreCraft.MOD_ID + ":block/" + bottomModel);
						});
						variants.addObject("type=double", (variant) -> {
							variant.add("model", doubleModel);
						});
						variants.addObject("type=top", (variant) -> {
							variant.add("model", MoreCraft.MOD_ID + ":block/" + topModel);
						});
					});
				}).build();
			}));
			
			// BLOCK MODELS
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + bottomModel + ".json", () -> {
				return JsonBuilder.newObject((json) -> {
					if(isTinted) {
						json.add("parent", MoreCraft.MOD_ID + ":block/slab_tint");
					}
					else {
						json.add("parent", "block/slab");
					}
					
					json.addObject("textures", (textures) -> {
						textures.add("bottom", texture);
						textures.add("top", texture);
						textures.add("side", texture);
						
						if(isTinted) {
							textures.add("tint", MoreCraft.MOD_ID + ":block/" + color + "_tint");
						}
					});
				}).build();
			}));
			
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + topModel + ".json", () -> {
				return JsonBuilder.newObject((json) -> {
					if(isTinted) {
						json.add("parent", MoreCraft.MOD_ID + ":block/slab_top_tint");
					}
					else {
						json.add("parent", "block/slab_top");
					}
					
					json.addObject("textures", (textures) -> {
						textures.add("bottom", texture);
						textures.add("top", texture);
						textures.add("side", texture);
						
						if(isTinted) {
							textures.add("tint", MoreCraft.MOD_ID + ":block/" + color + "_tint");
						}
					});
				}).build();
			}));
		});
		
		return dataProviders;
	}
	
	public void generateRecipesJson(DataGenerator generator, String dyedIngredientTag, ColoredBlockHelper coloredBlocks) {
		List<JsonDataProvider> assetGenerators = getRecipeDataProviders(dyedIngredientTag, coloredBlocks);
		
		for(JsonDataProvider assetGenerator : assetGenerators) {
			assetGenerator.generate(generator);
		}
	}
	
	public List<JsonDataProvider> getRecipeDataProviders(String dyedIngredientTag, ColoredBlockHelper coloredBlocks) {
		List<JsonDataProvider> providers = super.getRecipeDataProviders(dyedIngredientTag);

		eachBlock((block, color) -> {
			String id = block.getRegistryName().getPath();
			Block blockIngredient = coloredBlocks.getBlock(color);
			String blockIngredientName = blockIngredient.getRegistryName().toString();
			
			providers.add(new JsonDataProvider(JsonDataGenerator.DATA_RECIPES_PATH + id + "_crafting_shaped.json", () -> {
				return JsonBuilder.newObject((json) -> {
					json.add("type", "minecraft:crafting_shaped");
					json.addArray("pattern", (pattern) -> {
						pattern.add("xxx");
					});
					json.addObject("key", (key) -> {
						key.addObject("x", (x) -> {
							x.add("item", blockIngredientName);
						});
					});
					json.addObject("result", (result) -> {
						result.add("item", MoreCraft.MOD_ID + ":" + id);
						result.add("count", 6);
					});
				}).build();
			}));
		});
		
		return providers;
	}
}
