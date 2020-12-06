package com.fuchsiaworks.morecraft.block;

import java.util.ArrayList;
import java.util.List;

import com.fuchsiaworks.morecraft.JsonBuilder;
import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator.JsonDataProvider;

import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.data.DataGenerator;

public class ColoredFenceBlockHelper extends ColoredBlockHelper {

	public ColoredFenceBlockHelper(String idTemplate, Properties properties) {
		this(idTemplate, properties, FenceBlock.class);
	}

	public ColoredFenceBlockHelper(String idTemplate, Properties properties, Class<? extends FenceBlock> classObj) {
		super(idTemplate, properties, classObj);
	}

	@Override
	public List<JsonDataProvider> getBlockDataProviders() {
		List<JsonDataProvider> dataProviders = new ArrayList<JsonDataProvider>();

		eachBlock((block, color) -> {
			String id = block.getRegistryName().getPath();
			String texture = getTexture(color);

			String postModel = id + "_post";
			String sideModel = id + "_side";
			String inventoryModel = id + "_inventory";

			String postModelParent = getPostModelParent();
			String sideModelParent = getSideModelParent();
			String inventoryModelParent = getInventoryModelParent();

			// BLOCKSTATES
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_BLOCKSTATES_PATH + id + ".json", () -> {
				return JsonBuilder.newObject((json) -> {
					json.addArray("multipart", (multipart) -> {
						multipart.addObject((part) -> {
							part.addObject("apply", (apply) -> {
								apply.add("model", MoreCraft.MOD_ID + ":block/" + id + "_post");
							});
						});
						multipart.addObject((part) -> {
							part.addObject("when", (when) -> {
								when.add("north", true);
							});
							part.addObject("apply", (apply) -> {
								apply.add("model", MoreCraft.MOD_ID + ":block/" + id + "_side");
								apply.add("uvlock", true);
							});
						});
						multipart.addObject((part) -> {
							part.addObject("when", (when) -> {
								when.add("east", true);
							});
							part.addObject("apply", (apply) -> {
								apply.add("model", MoreCraft.MOD_ID + ":block/" + id + "_side");
								apply.add("y", 90);
								apply.add("uvlock", true);
							});
						});
						multipart.addObject((part) -> {
							part.addObject("when", (when) -> {
								when.add("south", true);
							});
							part.addObject("apply", (apply) -> {
								apply.add("model", MoreCraft.MOD_ID + ":block/" + id + "_side");
								apply.add("y", 180);
								apply.add("uvlock", true);
							});
						});
						multipart.addObject((part) -> {
							part.addObject("when", (when) -> {
								when.add("west", true);
							});
							part.addObject("apply", (apply) -> {
								apply.add("model", MoreCraft.MOD_ID + ":block/" + id + "_side");
								apply.add("y", 270);
								apply.add("uvlock", true);
							});
						});
					});
				}).build();
			}));

			// BLOCK MODELS
			dataProviders
					.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + postModel + ".json", () -> {
						return JsonBuilder.newObject((json) -> {
							if (postModelParent != null) {
								json.add("parent", postModelParent);
							} else if (isTinted) {
								json.add("parent", MoreCraft.MOD_ID + ":block/fence_post_tint");
							} else {
								json.add("parent", "block/fence");
							}

							json.addObject("textures", (textures) -> {
								textures.add("texture", texture);

								if (isTinted) {
									textures.add("tint", getTint(color));
								}
							});
						}).build();
					}));
			dataProviders
					.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + sideModel + ".json", () -> {
						return JsonBuilder.newObject((json) -> {
							if (sideModelParent != null) {
								json.add("parent", sideModelParent);
							} else if (isTinted) {
								json.add("parent", MoreCraft.MOD_ID + ":block/fence_side_tint");
							} else {
								json.add("parent", "block/fence");
							}

							json.addObject("textures", (textures) -> {
								textures.add("texture", texture);

								if (isTinted) {
									textures.add("tint", getTint(color));
								}
							});
						}).build();
					}));
			dataProviders.add(
					new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + inventoryModel + ".json", () -> {
						return JsonBuilder.newObject((json) -> {
							if (inventoryModelParent != null) {
								json.add("parent", inventoryModelParent);
							} else if (isTinted) {
								json.add("parent", MoreCraft.MOD_ID + ":block/fence_inventory_tint");
							} else {
								json.add("parent", "block/fence_inventory");
							}

							json.addObject("textures", (textures) -> {
								textures.add("texture", texture);

								if (isTinted) {
									textures.add("tint", getTint(color));
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
			String inventoryModel = id + "_inventory";

			// ITEM MODELS
			dataProviders.add(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_ITEM_PATH + id + ".json", () -> {
				return JsonBuilder.newObject((json) -> {
					json.add("parent", MoreCraft.MOD_ID + ":block/" + inventoryModel);
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
			String stickIngredientName = net.minecraft.item.Items.STICK.getRegistryName().toString();

			providers.add(
					new JsonDataProvider(JsonDataGenerator.DATA_RECIPES_PATH + id + "_crafting_shaped.json", () -> {
						return JsonBuilder.newObject((json) -> {
							json.add("type", "minecraft:crafting_shaped");
							json.addArray("pattern", (pattern) -> {
								pattern.add("xyx");
								pattern.add("xyx");
							});
							json.addObject("key", (key) -> {
								key.addObject("x", (x) -> {
									x.add("item", blockIngredientName);
								});
								key.addObject("y", (y) -> {
									y.add("item", stickIngredientName);
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

	String postModelParent;

	public ColoredFenceBlockHelper setPostModelParent(String postModelParent) {
		this.postModelParent = postModelParent;

		return this;
	}

	public String getPostModelParent() {
		if (postModelParent != null) {
			return parseTemplate(postModelParent);
		}

		return null;
	}

	String sideModelParent;

	public ColoredFenceBlockHelper setSideModelParent(String sideModelParent) {
		this.sideModelParent = sideModelParent;

		return this;
	}

	public String getSideModelParent() {
		if (sideModelParent != null) {
			return parseTemplate(sideModelParent);
		}

		return null;
	}

	String inventoryModelParent;

	public ColoredFenceBlockHelper setInventoryModelParent(String inventoryModelParent) {
		this.inventoryModelParent = inventoryModelParent;

		return this;
	}

	public String getInventoryModelParent() {
		if (inventoryModelParent != null) {
			return parseTemplate(inventoryModelParent);
		}

		return null;
	}
}
