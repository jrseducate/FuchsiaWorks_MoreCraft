package com.fuchsiaworks.morecraft.block;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.fuchsiaworks.morecraft.JsonBuilder;
import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator.JsonDataProvider;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.data.DataGenerator;

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
				return JsonBuilder.newObject((json) -> {
					json.addObject("variants", (variants) -> {
						variants.addObject("facing=east,half=bottom,shape=inner_left",
								getBlockStateVariant(innerModel, null, 270));
						variants.addObject("facing=east,half=bottom,shape=inner_right",
								getBlockStateVariant(innerModel, null, null));
						variants.addObject("facing=east,half=bottom,shape=outer_left",
								getBlockStateVariant(outerModel, null, 270));
						variants.addObject("facing=east,half=bottom,shape=outer_right",
								getBlockStateVariant(outerModel, null, null));
						variants.addObject("facing=east,half=bottom,shape=straight",
								getBlockStateVariant(model, null, null));
						variants.addObject("facing=east,half=top,shape=inner_left",
								getBlockStateVariant(innerModel, 180, null));
						variants.addObject("facing=east,half=top,shape=inner_right",
								getBlockStateVariant(innerModel, 180, 90));
						variants.addObject("facing=east,half=top,shape=outer_left",
								getBlockStateVariant(outerModel, 180, null));
						variants.addObject("facing=east,half=top,shape=outer_right",
								getBlockStateVariant(outerModel, 180, 90));
						variants.addObject("facing=east,half=top,shape=straight",
								getBlockStateVariant(model, 180, null));
						variants.addObject("facing=north,half=bottom,shape=inner_left",
								getBlockStateVariant(innerModel, null, 180));
						variants.addObject("facing=north,half=bottom,shape=inner_right",
								getBlockStateVariant(innerModel, null, 270));
						variants.addObject("facing=north,half=bottom,shape=outer_left",
								getBlockStateVariant(outerModel, null, 180));
						variants.addObject("facing=north,half=bottom,shape=outer_right",
								getBlockStateVariant(outerModel, null, 270));
						variants.addObject("facing=north,half=bottom,shape=straight",
								getBlockStateVariant(model, null, 270));
						variants.addObject("facing=north,half=top,shape=inner_left",
								getBlockStateVariant(innerModel, 180, 270));
						variants.addObject("facing=north,half=top,shape=inner_right",
								getBlockStateVariant(innerModel, 180, null));
						variants.addObject("facing=north,half=top,shape=outer_left",
								getBlockStateVariant(outerModel, 180, 270));
						variants.addObject("facing=north,half=top,shape=outer_right",
								getBlockStateVariant(outerModel, 180, null));
						variants.addObject("facing=north,half=top,shape=straight",
								getBlockStateVariant(model, 180, 270));
						variants.addObject("facing=south,half=bottom,shape=inner_left",
								getBlockStateVariant(innerModel, null, null));
						variants.addObject("facing=south,half=bottom,shape=inner_right",
								getBlockStateVariant(innerModel, null, 90));
						variants.addObject("facing=south,half=bottom,shape=outer_left",
								getBlockStateVariant(outerModel, null, null));
						variants.addObject("facing=south,half=bottom,shape=outer_right",
								getBlockStateVariant(outerModel, null, 90));
						variants.addObject("facing=south,half=bottom,shape=straight",
								getBlockStateVariant(model, null, 90));
						variants.addObject("facing=south,half=top,shape=inner_left",
								getBlockStateVariant(innerModel, 180, 90));
						variants.addObject("facing=south,half=top,shape=inner_right",
								getBlockStateVariant(innerModel, 180, 180));
						variants.addObject("facing=south,half=top,shape=outer_left",
								getBlockStateVariant(outerModel, 180, 90));
						variants.addObject("facing=south,half=top,shape=outer_right",
								getBlockStateVariant(outerModel, 180, 180));
						variants.addObject("facing=south,half=top,shape=straight",
								getBlockStateVariant(model, 180, 90));
						variants.addObject("facing=west,half=bottom,shape=inner_left",
								getBlockStateVariant(innerModel, null, 90));
						variants.addObject("facing=west,half=bottom,shape=inner_right",
								getBlockStateVariant(innerModel, null, 180));
						variants.addObject("facing=west,half=bottom,shape=outer_left",
								getBlockStateVariant(outerModel, null, 90));
						variants.addObject("facing=west,half=bottom,shape=outer_right",
								getBlockStateVariant(outerModel, null, 180));
						variants.addObject("facing=west,half=bottom,shape=straight",
								getBlockStateVariant(model, null, 180));
						variants.addObject("facing=west,half=top,shape=inner_left",
								getBlockStateVariant(innerModel, 180, 180));
						variants.addObject("facing=west,half=top,shape=inner_right",
								getBlockStateVariant(innerModel, 180, 270));
						variants.addObject("facing=west,half=top,shape=outer_left",
								getBlockStateVariant(outerModel, 180, 180));
						variants.addObject("facing=west,half=top,shape=outer_right",
								getBlockStateVariant(outerModel, 180, 270));
						variants.addObject("facing=west,half=top,shape=straight",
								getBlockStateVariant(model, 180, 180));
					});
				}).build();
			}));

			// BLOCK MODELS
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + model + ".json", () -> {
				return JsonBuilder.newObject((json) -> {
					if (isTinted) {
						json.add("parent", MoreCraft.MOD_ID + ":block/stairs_tint");
					} else {
						json.add("parent", "block/stairs");
					}

					json.addObject("textures", (textures) -> {
						textures.add("bottom", texture);
						textures.add("top", texture);
						textures.add("side", texture);

						if (isTinted) {
							textures.add("tint", getTint(color));
						}
					});
				}).build();
			}));

			dataProviders
					.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + innerModel + ".json", () -> {
						return JsonBuilder.newObject((json) -> {
							if (isTinted) {
								json.add("parent", MoreCraft.MOD_ID + ":block/inner_stairs_tint");
							} else {
								json.add("parent", "block/inner_stairs");
							}

							json.addObject("textures", (textures) -> {
								textures.add("bottom", texture);
								textures.add("top", texture);
								textures.add("side", texture);

								if (isTinted) {
									textures.add("tint", getTint(color));
								}
							});
						}).build();
					}));

			dataProviders
					.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + outerModel + ".json", () -> {
						return JsonBuilder.newObject((json) -> {
							if (isTinted) {
								json.add("parent", MoreCraft.MOD_ID + ":block/outer_stairs_tint");
							} else {
								json.add("parent", "block/outer_stairs");
							}

							json.addObject("textures", (textures) -> {
								textures.add("bottom", texture);
								textures.add("top", texture);
								textures.add("side", texture);

								if (isTinted) {
									textures.add("tint", getTint(color));
								}
							});
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
					new JsonDataProvider(JsonDataGenerator.DATA_RECIPES_PATH + id + "_crafting_shaped_1.json", () -> {
						return JsonBuilder.newObject((json) -> {
							json.add("type", "minecraft:crafting_shaped");
							json.addArray("pattern", (pattern) -> {
								pattern.add("x  ");
								pattern.add("xx ");
								pattern.add("xxx");
							});
							json.addObject("key", (key) -> {
								key.addObject("x", (x) -> {
									x.add("item", blockIngredientName);
								});
							});
							json.addObject("result", (result) -> {
								result.add("item", MoreCraft.MOD_ID + ":" + id);
								result.add("count", 4);
							});
						}).build();
					}));

			providers.add(
					new JsonDataProvider(JsonDataGenerator.DATA_RECIPES_PATH + id + "_crafting_shaped_2.json", () -> {
						return JsonBuilder.newObject((json) -> {
							json.add("type", "minecraft:crafting_shaped");
							json.addArray("pattern", (pattern) -> {
								pattern.add("  x");
								pattern.add(" xx");
								pattern.add("xxx");
							});
							json.addObject("key", (key) -> {
								key.addObject("x", (x) -> {
									x.add("item", blockIngredientName);
								});
							});
							json.addObject("result", (result) -> {
								result.add("item", MoreCraft.MOD_ID + ":" + id);
								result.add("count", 4);
							});
						}).build();
					}));
		});

		return providers;
	}
}
