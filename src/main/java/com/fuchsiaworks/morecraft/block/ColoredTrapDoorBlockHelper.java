package com.fuchsiaworks.morecraft.block;

import java.util.ArrayList;
import java.util.List;

import com.fuchsiaworks.morecraft.JsonBuilder;
import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator.JsonDataProvider;

import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.data.DataGenerator;

public class ColoredTrapDoorBlockHelper extends ColoredBlockHelper {

	public ColoredTrapDoorBlockHelper(String idTemplate, Properties properties) {
		this(idTemplate, properties, TrapDoorBlock.class);
	}

	public ColoredTrapDoorBlockHelper(String idTemplate, Properties properties,
			Class<? extends TrapDoorBlock> classObj) {
		super(idTemplate, properties, false, classObj);
	}

	public String tintFaceTemplate;

	public ColoredBlockHelper setTintFace(String tintTemplate) {
		this.tintFaceTemplate = tintTemplate;

		return this;
	}

	public String getTintFace(String color) {
		String tintReference = tintFaceTemplate;

		if (tintReference == null) {
			tintReference = tintTemplate;
		}

		return parseTemplate(tintReference, color);
	}

	@Override
	public List<JsonDataProvider> getBlockDataProviders() {
		List<JsonDataProvider> dataProviders = new ArrayList<JsonDataProvider>();

		eachBlock((block, color) -> {
			String id = block.getRegistryName().getPath();
			String texture = getTexture(color);
			String bottomModel = id + "_bottom";
			String topModel = id + "_top";
			String openModel = id + "_open";

			// BLOCKSTATES
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_BLOCKSTATES_PATH + id + ".json", () -> {
				return JsonBuilder.newObject((json) -> {
					json.addObject("variants", (variants) -> {
						variants.addObject("facing=east,half=bottom,open=false",
								getBlockStateVariant(bottomModel, null, 90));
						variants.addObject("facing=east,half=bottom,open=true",
								getBlockStateVariant(openModel, null, 90));
						variants.addObject("facing=east,half=top,open=false", getBlockStateVariant(topModel, null, 90));
						variants.addObject("facing=east,half=top,open=true", getBlockStateVariant(openModel, 180, 270));
						variants.addObject("facing=north,half=bottom,open=false",
								getBlockStateVariant(bottomModel, null, null));
						variants.addObject("facing=north,half=bottom,open=true",
								getBlockStateVariant(openModel, null, null));
						variants.addObject("facing=north,half=top,open=false",
								getBlockStateVariant(topModel, null, null));
						variants.addObject("facing=north,half=top,open=true",
								getBlockStateVariant(openModel, 180, 180));
						variants.addObject("facing=south,half=bottom,open=false",
								getBlockStateVariant(bottomModel, null, 180));
						variants.addObject("facing=south,half=bottom,open=true",
								getBlockStateVariant(openModel, null, 180));
						variants.addObject("facing=south,half=top,open=false",
								getBlockStateVariant(topModel, null, 180));
						variants.addObject("facing=south,half=top,open=true", getBlockStateVariant(openModel, 180, 0));
						variants.addObject("facing=west,half=bottom,open=false",
								getBlockStateVariant(bottomModel, null, 270));
						variants.addObject("facing=west,half=bottom,open=true",
								getBlockStateVariant(openModel, null, 270));
						variants.addObject("facing=west,half=top,open=false",
								getBlockStateVariant(topModel, null, 270));
						variants.addObject("facing=west,half=top,open=true", getBlockStateVariant(openModel, 180, 90));
					});
				}).build();
			}));

			// BLOCK MODELS
			dataProviders.add(
					new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + bottomModel + ".json", () -> {
						return JsonBuilder.newObject((json) -> {
							if (isTinted) {
								json.add("parent", MoreCraft.MOD_ID + ":block/trapdoor_bottom_tint");
							} else {
								json.add("parent", "block/template_orientable_trapdoor_bottom");
							}

							json.addObject("textures", (textures) -> {
								textures.add("texture", texture);

								if (isTinted) {
									textures.add("tintSide", getTint(color));
									textures.add("tintFace", getTintFace(color));
								}
							});
						}).build();
					}));
			dataProviders
					.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + topModel + ".json", () -> {
						return JsonBuilder.newObject((json) -> {
							if (isTinted) {
								json.add("parent", MoreCraft.MOD_ID + ":block/trapdoor_top_tint");
							} else {
								json.add("parent", "block/template_orientable_trapdoor_top");
							}

							json.addObject("textures", (textures) -> {
								textures.add("texture", texture);

								if (isTinted) {
									textures.add("tintSide", getTint(color));
									textures.add("tintFace", getTintFace(color));
								}
							});
						}).build();
					}));
			dataProviders
					.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + openModel + ".json", () -> {
						return JsonBuilder.newObject((json) -> {
							if (isTinted) {
								json.add("parent", MoreCraft.MOD_ID + ":block/trapdoor_open_tint");
							} else {
								json.add("parent", "block/template_orientable_trapdoor_open");
							}

							json.addObject("textures", (textures) -> {
								textures.add("texture", texture);

								if (isTinted) {
									textures.add("tintSide", getTint(color));
									textures.add("tintFace", getTintFace(color));
								}
							});
						}).build();
					}));
		});

		return dataProviders;
	}

	@Override
	public List<JsonDataProvider> getItemDataProviders() {
		List<JsonDataProvider> dataProviders = new ArrayList<JsonDataProvider>();

		eachItem((item, color) -> {
			String id = item.getRegistryName().getPath();
			String bottomModel = id + "_bottom";

			// ITEM MODELS
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_ITEM_PATH + id + ".json", () -> {
				return JsonBuilder.newObject((json) -> {
					json.add("parent", MoreCraft.MOD_ID + ":block/" + bottomModel);
				}).build();
			}));
		});

		return dataProviders;
	}

	public void generateRecipesJson(DataGenerator generator, String dyedIngredientTag,
			ColoredBlockHelper coloredBlocks) {
		List<JsonDataProvider> assetGenerators = getRecipeDataProviders(dyedIngredientTag, coloredBlocks);

		for (JsonDataProvider assetGenerator : assetGenerators) {
			assetGenerator.generate(generator);
		}
	}

	public List<JsonDataProvider> getRecipeDataProviders(String dyedIngredientTag, ColoredBlockHelper coloredBlocks) {
		List<JsonDataProvider> providers = super.getRecipeDataProviders(dyedIngredientTag);

		eachBlock((block, color) -> {
			String id = block.getRegistryName().getPath();
			Block blockIngredient = coloredBlocks.getBlock(color);
			String blockIngredientName = blockIngredient.getRegistryName().toString();

			providers.add(
					new JsonDataProvider(JsonDataGenerator.DATA_RECIPES_PATH + id + "_crafting_shaped.json", () -> {
						return JsonBuilder.newObject((json) -> {
							json.add("type", "minecraft:crafting_shaped");
							json.addArray("pattern", (pattern) -> {
								pattern.add("xxx");
								pattern.add("xxx");
							});
							json.addObject("key", (key) -> {
								key.addObject("x", (x) -> {
									x.add("item", blockIngredientName);
								});
							});
							json.addObject("result", (result) -> {
								result.add("item", MoreCraft.MOD_ID + ":" + id);
								result.add("count", 2);
							});
						}).build();
					}));
		});

		return providers;
	}
}
