package com.fuchsiaworks.morecraft.block;

import java.util.ArrayList;
import java.util.List;

import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator.JsonDataProvider;
import com.google.gson.JsonObject;

import net.minecraft.block.AbstractBlock.Properties;
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
				JsonObject json = new JsonObject();
				
				JsonObject variants = new JsonObject();
				
				JsonObject variantBottom = new JsonObject();
				variantBottom.addProperty("model", MoreCraft.MOD_ID + ":block/" + bottomModel);
				variants.add("type=bottom", variantBottom);
				
				JsonObject variantDouble = new JsonObject();
				variantDouble.addProperty("model", doubleModel);
				variants.add("type=double", variantDouble);
				
				JsonObject variantTop = new JsonObject();
				variantTop.addProperty("model", MoreCraft.MOD_ID + ":block/" + topModel);
				variants.add("type=top", variantTop);
				
				json.add("variants", variants);
				
				return json;
			}));
			
			// BLOCK MODELS
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + bottomModel + ".json", () -> {
				JsonObject json = new JsonObject();
				JsonObject textures = new JsonObject();

				if(isTinted) {
					json.addProperty("parent", MoreCraft.MOD_ID + ":block/slab_tint");
					textures.addProperty("bottom", texture);
					textures.addProperty("top", texture);
					textures.addProperty("side", texture);
					textures.addProperty("tint", MoreCraft.MOD_ID + ":block/" + color + "_tint");
				}
				else {
					json.addProperty("parent", "block/slab");
					textures.addProperty("bottom", texture);
					textures.addProperty("top", texture);
					textures.addProperty("side", texture);
				}
				
				json.add("textures", textures);
				
				return json;
			}));
			
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + topModel + ".json", () -> {
				JsonObject json = new JsonObject();
				JsonObject textures = new JsonObject();

				if(isTinted) {
					json.addProperty("parent", MoreCraft.MOD_ID + ":block/slab_top_tint");				
					textures.addProperty("bottom", texture);
					textures.addProperty("top", texture);
					textures.addProperty("side", texture);
					textures.addProperty("tint", MoreCraft.MOD_ID + ":block/" + color + "_tint");
				}
				else {
					json.addProperty("parent", "block/slab_top");
					textures.addProperty("bottom", texture);
					textures.addProperty("top", texture);
					textures.addProperty("side", texture);
				}
				
				json.add("textures", textures);
				
				return json;
			}));
		});
		
		return dataProviders;
	}
}
