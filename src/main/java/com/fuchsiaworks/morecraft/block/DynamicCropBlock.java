package com.fuchsiaworks.morecraft.block;

import java.util.function.Supplier;

import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator.JsonDataProvider;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
			JsonObject json = new JsonObject();
			JsonObject variants = new JsonObject();

			for(int i = 0; i <= getMaxAge(); i++) {
				JsonObject variant = new JsonObject();
				String stageId = getStage(stageIdTemplate, i);
				
				variant.addProperty("model", MoreCraft.MOD_ID + ":block/" + stageId);
				
				variants.add("age=" + i, variant);
			}
			
			json.add("variants", variants);
			
			return json;
		}).bind(generator));


		for(int i = 0; i <= getMaxAge(); i++) {
			final String stageId = getStage(stageIdTemplate, i);
			
			generator.addProvider(new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_BLOCK_PATH + stageId + ".json", () -> {
				JsonObject json = new JsonObject();
				JsonObject textures = new JsonObject();
				
				json.addProperty("parent", "minecraft:block/crop");
				
				textures.addProperty("crop", MoreCraft.MOD_ID + ":block/" + stageId);
				
				json.add("textures", textures);
			
				return json;
			}).bind(generator));
		}
	}
	
	public void generateBlockLootTableJson(DataGenerator generator) {
		String id = getRegistryName().getPath();
		String name = MoreCraft.MOD_ID + ":" + id;
		
		generator.addProvider(new JsonDataProvider(JsonDataGenerator.DATA_LOOT_TABLES_BLOCKS_PATH + id + ".json", () -> {
			JsonObject json = new JsonObject();
			JsonArray pools = new JsonArray();
			
			JsonObject pool1 = new JsonObject();
			JsonArray pool1Entries = new JsonArray();
			JsonObject pool1Entry = new JsonObject();
			JsonArray pool1EntryChildren = new JsonArray();
			JsonObject pool1EntryChild1 = new JsonObject();
			JsonArray pool1EntryChild1Conditions = new JsonArray();
			JsonObject pool1EntryChild1Condition = new JsonObject();
			JsonObject pool1EntryChild1ConditionProperties = new JsonObject();
			JsonObject pool1EntryChild2 = new JsonObject();
			
			JsonObject pool2 = new JsonObject();
			JsonArray pool2Entries = new JsonArray();
			JsonObject pool2Entry = new JsonObject();
			JsonArray pool2EntryFunctions = new JsonArray();
			JsonObject pool2EntryFunction = new JsonObject();
			JsonObject pool2EntryFunctionParameters = new JsonObject();
			JsonArray pool2EntryChildConditions = new JsonArray();
			JsonObject pool2EntryChildCondition = new JsonObject();
			JsonObject pool2EntryChildConditionProperties = new JsonObject();
			
			JsonArray functions = new JsonArray();
			JsonObject function = new JsonObject();

			json.addProperty("type", "minecraft:block");
			
			pool1.addProperty("rolls", 1.0f);
			
			pool1Entry.addProperty("type", "minecraft:alternatives");
			
			pool1EntryChild1.addProperty("type", "minecraft:item");
			
			pool1EntryChild1Condition.addProperty("condition", "minecraft:block_state_property");
			pool1EntryChild1Condition.addProperty("block", name);
			pool1EntryChild1ConditionProperties.addProperty("age", Integer.toString(getMaxAge()));
			pool1EntryChild1Condition.add("properties", pool1EntryChild1ConditionProperties);
			
			pool1EntryChild1Conditions.add(pool1EntryChild1Condition);
			pool1EntryChild1.add("conditions", pool1EntryChild1Conditions);

			pool1EntryChild1.addProperty("name", name);
			
			pool1EntryChildren.add(pool1EntryChild1);
			
			pool1EntryChild2.addProperty("type", "minecraft:item");
			pool1EntryChild2.addProperty("name", name);
			
			pool1EntryChildren.add(pool1EntryChild2);
			
			pool1Entry.add("children", pool1EntryChildren);
			pool1Entries.add(pool1Entry);

			pool1.add("entries", pool1Entries);
			
			pools.add(pool1);

			
			pool2.addProperty("rolls", 1.0f);
			
			pool2Entry.addProperty("type", "minecraft:item");
			
			pool2EntryFunction.addProperty("function", "minecraft:apply_bonus");
			pool2EntryFunction.addProperty("enchantment", "minecraft:fortune");
			pool2EntryFunction.addProperty("formula", "minecraft:binomial_with_bonus_count");
			
			pool2EntryFunctionParameters.addProperty("extra", 3);
			pool2EntryFunctionParameters.addProperty("probability", 0.5714286);

			pool2EntryFunction.add("parameters", pool2EntryFunctionParameters);
			
			pool2EntryFunctions.add(pool2EntryFunction);
			pool2Entry.add("functions", pool2EntryFunctions);
			pool2Entry.addProperty("name", name);
			pool2Entries.add(pool2Entry);

			pool2.add("entries", pool2Entries);

			pool2EntryChildCondition.addProperty("condition", "minecraft:block_state_property");
			pool2EntryChildCondition.addProperty("block", name);
			pool2EntryChildConditionProperties.addProperty("age", Integer.toString(getMaxAge()));
			pool2EntryChildCondition.add("properties", pool2EntryChildConditionProperties);
			
			pool2EntryChildConditions.add(pool2EntryChildCondition);
			
			pool2.add("conditions", pool2EntryChildConditions);
			
			pools.add(pool2);
			
			json.add("pools", pools);
			
			function.addProperty("function", "minecraft:explosion_decay");
			functions.add(function);
			
			json.add("functions", functions);
			
			return json;
		}).bind(generator));
	}

}
