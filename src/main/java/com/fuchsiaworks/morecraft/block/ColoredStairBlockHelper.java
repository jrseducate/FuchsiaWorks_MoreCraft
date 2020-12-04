package com.fuchsiaworks.morecraft.block;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator.JsonDataProvider;
import com.google.gson.JsonObject;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class ColoredStairBlockHelper extends ColoredBlockHelper {

	public BlockState defaultBlockState;

	public ColoredStairBlockHelper(String idTemplate, Properties properties, BlockState defaultBlockState) {
		this(idTemplate, properties, defaultBlockState, StairsBlock.class);
	}

	public ColoredStairBlockHelper(String idTemplate, Properties properties, BlockState defaultBlockState,
			Class<? extends StairsBlock> classObj) {
		super(idTemplate, properties, classObj);

		this.defaultBlockState = defaultBlockState;
	}

	@Override
	public Block newBlock(Properties properties) {
		try {
			if (classConstructor == null) {
				classConstructor = classObj.getConstructor(Supplier.class, AbstractBlock.Properties.class);
			}

			return classConstructor.newInstance(new Supplier<BlockState>() {
				@Override
				public BlockState get() {
					return defaultBlockState;
				}
			}, properties);
		} catch (Exception ex) {
			return null;
		}
	}
	
	public JsonObject getBlockStateVariant(String model, Integer x, Integer y) {
		JsonObject variant = new JsonObject();
		
		variant.addProperty("model", MoreCraft.MOD_ID + ":block/" + model);
		
		if(x != null || y != null) {
			if(x != null) {
				variant.addProperty("x", x);
			}
			
			if(y != null) {
				variant.addProperty("y", y);
			}
			
			variant.addProperty("uvlock", true);
		}
		
		return variant;
	}
	
	@Override
	public List<JsonDataProvider> getBlockDataProviders() {
		List<JsonDataProvider> dataProviders = new ArrayList<JsonDataProvider>();
		
		eachBlock((block, color) -> {
			String id = block.getRegistryName().getPath();
			String texture = getTexture(color);
			String model = id;
			String innerModel = id + "_inner";
			String outerModel = id + "_outer";
			
			// BLOCKSTATES
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_BLOCKSTATES_PATH + id + ".json", () -> {
				JsonObject json = new JsonObject();
				
				JsonObject variants = new JsonObject();
				
				variants.add("facing=east,half=bottom,shape=inner_left", getBlockStateVariant(innerModel, null, 270));
				variants.add("facing=east,half=bottom,shape=inner_right", getBlockStateVariant(innerModel, null, null));
				variants.add("facing=east,half=bottom,shape=outer_left", getBlockStateVariant(outerModel, null, 270));
				variants.add("facing=east,half=bottom,shape=outer_right", getBlockStateVariant(outerModel, null, null));
				variants.add("facing=east,half=bottom,shape=straight", getBlockStateVariant(model, null, null));
				variants.add("facing=east,half=top,shape=inner_left", getBlockStateVariant(innerModel, 180, null));
				variants.add("facing=east,half=top,shape=inner_right", getBlockStateVariant(innerModel, 180, 90));
				variants.add("facing=east,half=top,shape=outer_left", getBlockStateVariant(outerModel, 180, null));
				variants.add("facing=east,half=top,shape=outer_right", getBlockStateVariant(outerModel, 180, 90));
				variants.add("facing=east,half=top,shape=straight", getBlockStateVariant(model, 180, null));
				variants.add("facing=north,half=bottom,shape=inner_left", getBlockStateVariant(innerModel, null, 180));
				variants.add("facing=north,half=bottom,shape=inner_right", getBlockStateVariant(innerModel, null, 270));
				variants.add("facing=north,half=bottom,shape=outer_left", getBlockStateVariant(outerModel, null, 180));
				variants.add("facing=north,half=bottom,shape=outer_right", getBlockStateVariant(outerModel, null, 270));
				variants.add("facing=north,half=bottom,shape=straight", getBlockStateVariant(model, null, 270));
				variants.add("facing=north,half=top,shape=inner_left", getBlockStateVariant(innerModel, 180, 270));
				variants.add("facing=north,half=top,shape=inner_right", getBlockStateVariant(innerModel, 180, null));
				variants.add("facing=north,half=top,shape=outer_left", getBlockStateVariant(outerModel, 180, 270));
				variants.add("facing=north,half=top,shape=outer_right", getBlockStateVariant(outerModel, 180, null));
				variants.add("facing=north,half=top,shape=straight", getBlockStateVariant(model, 180, 270));
				variants.add("facing=south,half=bottom,shape=inner_left", getBlockStateVariant(innerModel, null, null));
				variants.add("facing=south,half=bottom,shape=inner_right", getBlockStateVariant(innerModel, null, 90));
				variants.add("facing=south,half=bottom,shape=outer_left", getBlockStateVariant(outerModel, null, null));
				variants.add("facing=south,half=bottom,shape=outer_right", getBlockStateVariant(outerModel, null, 90));
				variants.add("facing=south,half=bottom,shape=straight", getBlockStateVariant(model, null, 90));
				variants.add("facing=south,half=top,shape=inner_left", getBlockStateVariant(innerModel, 180, 90));
				variants.add("facing=south,half=top,shape=inner_right", getBlockStateVariant(innerModel, 180, 180));
				variants.add("facing=south,half=top,shape=outer_left", getBlockStateVariant(outerModel, 180, 90));
				variants.add("facing=south,half=top,shape=outer_right", getBlockStateVariant(outerModel, 180, 180));
				variants.add("facing=south,half=top,shape=straight", getBlockStateVariant(model, 180, 90));
				variants.add("facing=west,half=bottom,shape=inner_left", getBlockStateVariant(innerModel, null, 90));
				variants.add("facing=west,half=bottom,shape=inner_right", getBlockStateVariant(innerModel, null, 180));
				variants.add("facing=west,half=bottom,shape=outer_left", getBlockStateVariant(outerModel, null, 90));
				variants.add("facing=west,half=bottom,shape=outer_right", getBlockStateVariant(outerModel, null, 180));
				variants.add("facing=west,half=bottom,shape=straight", getBlockStateVariant(model, null, 180));
				variants.add("facing=west,half=top,shape=inner_left", getBlockStateVariant(innerModel, 180, 180));
				variants.add("facing=west,half=top,shape=inner_right", getBlockStateVariant(innerModel, 180, 270));
				variants.add("facing=west,half=top,shape=outer_left", getBlockStateVariant(outerModel, 180, 180));
				variants.add("facing=west,half=top,shape=outer_right", getBlockStateVariant(outerModel, 180, 270));
				variants.add("facing=west,half=top,shape=straight", getBlockStateVariant(model, 180, 180));
				
				json.add("variants", variants);
				
				return json;
			}));
			
			// BLOCK MODELS			
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + model + ".json", () -> {
				JsonObject json = new JsonObject();
				JsonObject textures = new JsonObject();

				if(isTinted) {
					json.addProperty("parent", MoreCraft.MOD_ID + ":block/stairs_tint");
					textures.addProperty("bottom", texture);
					textures.addProperty("top", texture);
					textures.addProperty("side", texture);
					textures.addProperty("tint", MoreCraft.MOD_ID + ":block/" + color + "_tint");
				}
				else {
					json.addProperty("parent", "block/stairs");
					textures.addProperty("bottom", texture);
					textures.addProperty("top", texture);
					textures.addProperty("side", texture);
				}
				
				json.add("textures", textures);
				
				return json;
			}));
			
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + innerModel + ".json", () -> {
				JsonObject json = new JsonObject();
				JsonObject textures = new JsonObject();

				if(isTinted) {
					json.addProperty("parent", MoreCraft.MOD_ID + ":block/inner_stairs_tint");			
					textures.addProperty("bottom", texture);
					textures.addProperty("top", texture);
					textures.addProperty("side", texture);
					textures.addProperty("tint", MoreCraft.MOD_ID + ":block/" + color + "_tint");
				}
				else {
					json.addProperty("parent", "block/inner_stairs");
					textures.addProperty("bottom", texture);
					textures.addProperty("top", texture);
					textures.addProperty("side", texture);
				}
				
				json.add("textures", textures);
				
				return json;
			}));
			
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + outerModel + ".json", () -> {
				JsonObject json = new JsonObject();
				JsonObject textures = new JsonObject();

				if(isTinted) {
					json.addProperty("parent", MoreCraft.MOD_ID + ":block/outer_stairs_tint");
					textures.addProperty("bottom", texture);
					textures.addProperty("top", texture);
					textures.addProperty("side", texture);
					textures.addProperty("tint", MoreCraft.MOD_ID + ":block/" + color + "_tint");
				}
				else {
					json.addProperty("parent", "block/outer_stairs");
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
