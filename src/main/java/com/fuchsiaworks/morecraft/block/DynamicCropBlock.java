package com.fuchsiaworks.morecraft.block;

import java.util.function.Supplier;

import com.fuchsiaworks.morecraft.JsonBuilder;
import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator.JsonDataProvider;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class DynamicCropBlock extends CropsBlock {
	private static final VoxelShape[] SHAPES = new VoxelShape[] {
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D) };

	private VoxelShape[] shapes;
	private Supplier<Item> seedItem;

	public DynamicCropBlock(AbstractBlock.Properties properties, Supplier<Item> seedItem) {
		this(properties, seedItem, SHAPES);
	}

	public DynamicCropBlock(AbstractBlock.Properties properties, Supplier<Item> seedItem, VoxelShape[] shapes) {
		super(properties);

		this.seedItem = seedItem;
		this.shapes = shapes;
	}

	protected IItemProvider getSeedsItem() {
		return seedItem.get();
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return this.shapes[state.get(this.getAgeProperty())];
	}

	public String getStage(String stageIdTemplate, int stage) {
		return stageIdTemplate.replace("{stage}", Integer.toString(stage));
	}

	public void generateJson(DataGenerator generator, String stageIdTemplate) {
		generateBlockJson(generator, stageIdTemplate);
		generateBlockLootTableJson(generator);
	}

	public void generateBlockJson(DataGenerator generator, String stageIdTemplate) {
		String id = getRegistryName().getPath();

		generator.addProvider(new JsonDataProvider(JsonDataGenerator.ASSETS_BLOCKSTATES_PATH + id + ".json", () -> {
			return JsonBuilder.newObject((json) -> {
				json.addObject("variants", (variants) -> {
					for (int i = 0; i <= getMaxAge(); i++) {
						String stageId = getStage(stageIdTemplate, i);

						variants.addObject("age=" + i, (variant) -> {
							variant.add("model", MoreCraft.MOD_ID + ":block/" + stageId);
						});
					}
				});

			}).build();
		}).bind(generator));

		for (int i = 0; i <= getMaxAge(); i++) {
			final String stageId = getStage(stageIdTemplate, i);

			generator.addProvider(
					new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + stageId + ".json", () -> {
						return JsonBuilder.newObject((json) -> {
							json.add("parent", "minecraft:block/crop");
							json.addObject("textures", (textures) -> {
								textures.add("crop", MoreCraft.MOD_ID + ":block/" + stageId);
							});
						}).build();
					}).bind(generator));
		}
	}

	public void generateBlockLootTableJson(DataGenerator generator) {
		String id = getRegistryName().getPath();
		String name = MoreCraft.MOD_ID + ":" + id;
		String maxAge = Integer.toString(getMaxAge());

		generator
				.addProvider(new JsonDataProvider(JsonDataGenerator.DATA_LOOT_TABLES_BLOCKS_PATH + id + ".json", () -> {
					return JsonBuilder.newObject((json) -> {
						json.add("type", "minecraft:block");
						json.addArray("pools", (pools) -> {
							pools.addObject((pool) -> {
								pool.add("rolls", 1.0f);
								pool.addArray("entries", (entries) -> {
									entries.addObject((entry) -> {
										entry.add("type", "minecraft:alternatives");
										entry.addArray("children", (children) -> {
											children.addObject((child) -> {
												child.add("type", "minecraft:item");
												child.addArray("conditions", (conditions) -> {
													conditions.addObject((condition) -> {
														condition.add("condition", "minecraft:block_state_property");
														condition.add("block", name);
														condition.addObject("properties", (properties) -> {
															properties.add("age", maxAge);
														});
													});
												});
												child.add("name", name);
											});
											children.addObject((child) -> {
												child.add("type", "minecraft:item");
												child.add("name", name);
											});
										});
									});
								});
							});
							pools.addObject((pool) -> {
								pool.add("rolls", 1.0f);
								pool.addArray("entries", (entries) -> {
									entries.addObject((entry) -> {
										entry.add("type", "minecraft:item");
										entry.addArray("functions", (functions) -> {
											functions.addObject((function) -> {
												function.add("function", "minecraft:apply_bonus");
												function.add("enchantment", "minecraft:fortune");
												function.add("formula", "minecraft:binomial_with_bonus_count");
												function.addObject("parameters", (parameters) -> {
													parameters.add("extra", 3);
													parameters.add("probability", 0.5714286);
												});
											});
										});
										entry.add("name", name);
									});
								});
								pool.addArray("conditions", (conditions) -> {
									conditions.addObject((condition) -> {
										condition.add("condition", "minecraft:block_state_property");
										condition.add("block", name);
										condition.addObject("properties", (properties) -> {
											properties.add("age", maxAge);
										});
									});
								});
							});
						});
						json.addArray("functions", (functions) -> {
							functions.addObject((function) -> {
								function.add("function", "minecraft:explosion_decay");
							});
						});
					}).build();
				}).bind(generator));
	}

}
