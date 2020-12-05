package com.fuchsiaworks.morecraft.block;

import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.TagBuilder;
import com.fuchsiaworks.morecraft.item.Items;

import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class Blocks {
	public static Block REFERENCE_GLASS = net.minecraft.block.Blocks.GLASS;

	public static Block REFERENCE_ACACIA_PLANKS = net.minecraft.block.Blocks.ACACIA_PLANKS;
	public static Block REFERENCE_ACACIA_SLAB = net.minecraft.block.Blocks.ACACIA_SLAB;
	public static Block REFERENCE_ACACIA_STAIRS = net.minecraft.block.Blocks.ACACIA_STAIRS;
	public static Block REFERENCE_ACACIA_DOOR = net.minecraft.block.Blocks.ACACIA_DOOR;

	public static Block REFERENCE_BIRCH_PLANKS = net.minecraft.block.Blocks.BIRCH_PLANKS;
	public static Block REFERENCE_BIRCH_SLAB = net.minecraft.block.Blocks.BIRCH_SLAB;
	public static Block REFERENCE_BIRCH_STAIRS = net.minecraft.block.Blocks.BIRCH_STAIRS;
	public static Block REFERENCE_BIRCH_DOOR = net.minecraft.block.Blocks.BIRCH_DOOR;

	public static Block REFERENCE_DARK_OAK_PLANKS = net.minecraft.block.Blocks.DARK_OAK_PLANKS;
	public static Block REFERENCE_DARK_OAK_SLAB = net.minecraft.block.Blocks.DARK_OAK_SLAB;
	public static Block REFERENCE_DARK_OAK_STAIRS = net.minecraft.block.Blocks.DARK_OAK_STAIRS;
	public static Block REFERENCE_DARK_OAK_DOOR = net.minecraft.block.Blocks.DARK_OAK_DOOR;

	public static Block REFERENCE_JUNGLE_PLANKS = net.minecraft.block.Blocks.JUNGLE_PLANKS;
	public static Block REFERENCE_JUNGLE_SLAB = net.minecraft.block.Blocks.JUNGLE_SLAB;
	public static Block REFERENCE_JUNGLE_STAIRS = net.minecraft.block.Blocks.JUNGLE_STAIRS;
	public static Block REFERENCE_JUNGLE_DOOR = net.minecraft.block.Blocks.JUNGLE_DOOR;

	public static Block REFERENCE_OAK_PLANKS = net.minecraft.block.Blocks.OAK_PLANKS;
	public static Block REFERENCE_OAK_SLAB = net.minecraft.block.Blocks.OAK_SLAB;
	public static Block REFERENCE_OAK_STAIRS = net.minecraft.block.Blocks.OAK_STAIRS;
	public static Block REFERENCE_OAK_DOOR = net.minecraft.block.Blocks.OAK_DOOR;

	public static Block REFERENCE_SPRUCE_PLANKS = net.minecraft.block.Blocks.SPRUCE_PLANKS;
	public static Block REFERENCE_SPRUCE_SLAB = net.minecraft.block.Blocks.SPRUCE_SLAB;
	public static Block REFERENCE_SPRUCE_STAIRS = net.minecraft.block.Blocks.SPRUCE_STAIRS;
	public static Block REFERENCE_SPRUCE_DOOR = net.minecraft.block.Blocks.SPRUCE_DOOR;

	public static Block REFERENCE_CRIMSON_PLANKS = net.minecraft.block.Blocks.field_235344_mC_;
	public static Block REFERENCE_CRIMSON_SLAB = net.minecraft.block.Blocks.field_235346_mE_;
	public static Block REFERENCE_CRIMSON_STAIRS = net.minecraft.block.Blocks.field_235356_mO_;
	public static Block REFERENCE_CRIMSON_DOOR = net.minecraft.block.Blocks.field_235360_mS_;

	public static Block REFERENCE_WARPED_PLANKS = net.minecraft.block.Blocks.field_235345_mD_;
	public static Block REFERENCE_WARPED_SLAB = net.minecraft.block.Blocks.field_235347_mF_;
	public static Block REFERENCE_WARPED_STAIRS = net.minecraft.block.Blocks.field_235357_mP_;
	public static Block REFERENCE_WARPED_DOOR = net.minecraft.block.Blocks.field_235361_mT_;

	public static DynamicCropBlock CROP_ONION = (DynamicCropBlock)new DynamicCropBlock(Properties.create(Material.PLANTS).doesNotBlockMovement()
			.tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP), () -> Items.CROP_ONION)
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "crop_onion"));
	public static DynamicCropBlock CROP_BROCCOLI = (DynamicCropBlock)new DynamicCropBlock(Properties.create(Material.PLANTS).doesNotBlockMovement()
			.tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP), () -> Items.CROP_BROCCOLI)
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "crop_broccoli"));
	public static DynamicCropBlock CROP_RICE = (DynamicCropBlock)new DynamicCropBlock(Properties.create(Material.PLANTS).doesNotBlockMovement()
			.tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP), () -> Items.CROP_RICE)
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "crop_rice"));

	public static Block GLASS_SLAB = new GlassSlabBlock(Properties.from(REFERENCE_GLASS))
			.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "glass_slab"));
	public static Block GLASS_STAIRS = new GlassStairsBlock(() -> REFERENCE_GLASS.getDefaultState(),
			Properties.from(REFERENCE_GLASS)).setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "glass_stairs"));

	public static Block CHOPPING_BLOCK = new ChoppingBlock(
			Properties.create(Material.WOOD).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "chopping_block"));

	public static Block CHURNING_BLOCK = new ChurningBlock(
			Properties.create(Material.WOOD).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "churning_block"));

	public static ColoredSlabBlockHelper COLORED_GLASS_SLAB = new ColoredSlabBlockHelper("{color}_stained_glass_slab",
			Properties.from(REFERENCE_GLASS), GlassSlabBlock.class);
	public static ColoredBlockHelper COLORED_GLASS_STAIRS = new ColoredStairBlockHelper("{color}_stained_glass_stairs",
			Properties.from(REFERENCE_GLASS), REFERENCE_GLASS.getDefaultState(), GlassStairsBlock.class);

	public static ColoredBlockHelper COLORED_ACACIA_PLANKS = new ColoredBlockHelper("acacia_planks_{color}_tinted",
			Properties.from(REFERENCE_ACACIA_PLANKS));
	public static ColoredSlabBlockHelper COLORED_ACACIA_SLAB = new ColoredSlabBlockHelper(
			"acacia_planks_{color}_tinted_slab", Properties.from(REFERENCE_ACACIA_SLAB));
	public static ColoredStairBlockHelper COLORED_ACACIA_STAIRS = new ColoredStairBlockHelper(
			"acacia_planks_{color}_tinted_stairs", Properties.from(REFERENCE_ACACIA_STAIRS),
			REFERENCE_ACACIA_STAIRS.getDefaultState());
	public static ColoredBlockHelper COLORED_ACACIA_DOOR = new ColoredBlockHelper("acacia_planks_{color}_tinted_door",
			Properties.from(REFERENCE_ACACIA_DOOR), DoorBlock.class);

	public static ColoredBlockHelper COLORED_BIRCH_PLANKS = new ColoredBlockHelper("birch_planks_{color}_tinted",
			Properties.from(REFERENCE_BIRCH_PLANKS));
	public static ColoredSlabBlockHelper COLORED_BIRCH_SLAB = new ColoredSlabBlockHelper(
			"birch_planks_{color}_tinted_slab", Properties.from(REFERENCE_BIRCH_SLAB));
	public static ColoredStairBlockHelper COLORED_BIRCH_STAIRS = new ColoredStairBlockHelper(
			"birch_planks_{color}_tinted_stairs", Properties.from(REFERENCE_BIRCH_STAIRS),
			REFERENCE_BIRCH_STAIRS.getDefaultState());
	public static ColoredBlockHelper COLORED_BIRCH_DOOR = new ColoredBlockHelper("birch_planks_{color}_tinted_door",
			Properties.from(REFERENCE_BIRCH_DOOR), DoorBlock.class);

	public static ColoredBlockHelper COLORED_DARK_OAK_PLANKS = new ColoredBlockHelper("dark_oak_planks_{color}_tinted",
			Properties.from(REFERENCE_DARK_OAK_PLANKS));
	public static ColoredSlabBlockHelper COLORED_DARK_OAK_SLAB = new ColoredSlabBlockHelper(
			"dark_oak_planks_{color}_tinted_slab", Properties.from(REFERENCE_DARK_OAK_SLAB));
	public static ColoredStairBlockHelper COLORED_DARK_OAK_STAIRS = new ColoredStairBlockHelper(
			"dark_oak_planks_{color}_tinted_stairs", Properties.from(REFERENCE_DARK_OAK_STAIRS),
			REFERENCE_DARK_OAK_STAIRS.getDefaultState());
	public static ColoredBlockHelper COLORED_DARK_OAK_DOOR = new ColoredBlockHelper(
			"dark_oak_planks_{color}_tinted_door", Properties.from(REFERENCE_DARK_OAK_DOOR), DoorBlock.class);

	public static ColoredBlockHelper COLORED_JUNGLE_PLANKS = new ColoredBlockHelper("jungle_planks_{color}_tinted",
			Properties.from(REFERENCE_JUNGLE_PLANKS));
	public static ColoredSlabBlockHelper COLORED_JUNGLE_SLAB = new ColoredSlabBlockHelper(
			"jungle_planks_{color}_tinted_slab", Properties.from(REFERENCE_JUNGLE_SLAB));
	public static ColoredStairBlockHelper COLORED_JUNGLE_STAIRS = new ColoredStairBlockHelper(
			"jungle_planks_{color}_tinted_stairs", Properties.from(REFERENCE_JUNGLE_STAIRS),
			REFERENCE_JUNGLE_STAIRS.getDefaultState());
	public static ColoredBlockHelper COLORED_JUNGLE_DOOR = new ColoredBlockHelper("jungle_planks_{color}_tinted_door",
			Properties.from(REFERENCE_JUNGLE_DOOR), DoorBlock.class);

	public static ColoredBlockHelper COLORED_OAK_PLANKS = new ColoredBlockHelper("oak_planks_{color}_tinted",
			Properties.from(REFERENCE_OAK_PLANKS));
	public static ColoredSlabBlockHelper COLORED_OAK_SLAB = new ColoredSlabBlockHelper("oak_planks_{color}_tinted_slab",
			Properties.from(REFERENCE_OAK_SLAB));
	public static ColoredStairBlockHelper COLORED_OAK_STAIRS = new ColoredStairBlockHelper(
			"oak_planks_{color}_tinted_stairs", Properties.from(REFERENCE_OAK_STAIRS),
			REFERENCE_OAK_STAIRS.getDefaultState());
	public static ColoredBlockHelper COLORED_OAK_DOOR = new ColoredBlockHelper("oak_planks_{color}_tinted_door",
			Properties.from(REFERENCE_OAK_DOOR), DoorBlock.class);

	public static ColoredBlockHelper COLORED_SPRUCE_PLANKS = new ColoredBlockHelper("spruce_planks_{color}_tinted",
			Properties.from(REFERENCE_SPRUCE_PLANKS));
	public static ColoredSlabBlockHelper COLORED_SPRUCE_SLAB = new ColoredSlabBlockHelper(
			"spruce_planks_{color}_tinted_slab", Properties.from(REFERENCE_SPRUCE_SLAB));
	public static ColoredStairBlockHelper COLORED_SPRUCE_STAIRS = new ColoredStairBlockHelper(
			"spruce_planks_{color}_tinted_stairs", Properties.from(REFERENCE_SPRUCE_STAIRS),
			REFERENCE_SPRUCE_STAIRS.getDefaultState());
	public static ColoredBlockHelper COLORED_SPRUCE_DOOR = new ColoredBlockHelper("spruce_planks_{color}_tinted_door",
			Properties.from(REFERENCE_SPRUCE_DOOR), DoorBlock.class);

	public static ColoredBlockHelper COLORED_CRIMSON_PLANKS = new ColoredBlockHelper("crimson_planks_{color}_tinted",
			Properties.from(REFERENCE_CRIMSON_PLANKS));
	public static ColoredSlabBlockHelper COLORED_CRIMSON_SLAB = new ColoredSlabBlockHelper(
			"crimson_planks_{color}_tinted_slab", Properties.from(REFERENCE_CRIMSON_SLAB));
	public static ColoredStairBlockHelper COLORED_CRIMSON_STAIRS = new ColoredStairBlockHelper(
			"crimson_planks_{color}_tinted_stairs", Properties.from(REFERENCE_CRIMSON_STAIRS),
			REFERENCE_CRIMSON_STAIRS.getDefaultState());
	public static ColoredBlockHelper COLORED_CRIMSON_DOOR = new ColoredBlockHelper("crimson_planks_{color}_tinted_door",
			Properties.from(REFERENCE_CRIMSON_DOOR), DoorBlock.class);

	public static ColoredBlockHelper COLORED_WARPED_PLANKS = new ColoredBlockHelper("warped_planks_{color}_tinted",
			Properties.from(REFERENCE_WARPED_PLANKS));
	public static ColoredSlabBlockHelper COLORED_WARPED_SLAB = new ColoredSlabBlockHelper(
			"warped_planks_{color}_tinted_slab", Properties.from(REFERENCE_WARPED_SLAB));
	public static ColoredStairBlockHelper COLORED_WARPED_STAIRS = new ColoredStairBlockHelper(
			"warped_planks_{color}_tinted_stairs", Properties.from(REFERENCE_WARPED_STAIRS),
			REFERENCE_WARPED_STAIRS.getDefaultState());
	public static ColoredBlockHelper COLORED_WARPED_DOOR = new ColoredBlockHelper("warped_planks_{color}_tinted_door",
			Properties.from(REFERENCE_WARPED_DOOR), DoorBlock.class);

	public static void RegisterBlocks(final RegistryEvent.Register<Block> blockRegistryEvent) {
		blockRegistryEvent.getRegistry().register(CROP_ONION);
		blockRegistryEvent.getRegistry().register(CROP_BROCCOLI);
		blockRegistryEvent.getRegistry().register(CROP_RICE);

		blockRegistryEvent.getRegistry().register(GLASS_SLAB);
		blockRegistryEvent.getRegistry().register(GLASS_STAIRS);

		blockRegistryEvent.getRegistry().register(CHOPPING_BLOCK);
		blockRegistryEvent.getRegistry().register(CHURNING_BLOCK);

		COLORED_GLASS_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_GLASS_STAIRS.registerBlocks(blockRegistryEvent);

		COLORED_ACACIA_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_ACACIA_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_ACACIA_STAIRS.registerBlocks(blockRegistryEvent);
//		COLORED_ACACIA_DOOR.registerBlocks(blockRegistryEvent);

		COLORED_BIRCH_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_BIRCH_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_BIRCH_STAIRS.registerBlocks(blockRegistryEvent);
//		COLORED_BIRCH_DOOR.registerBlocks(blockRegistryEvent);

		COLORED_DARK_OAK_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_DARK_OAK_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_DARK_OAK_STAIRS.registerBlocks(blockRegistryEvent);
//		COLORED_DARK_OAK_DOOR.registerBlocks(blockRegistryEvent);

		COLORED_JUNGLE_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_JUNGLE_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_JUNGLE_STAIRS.registerBlocks(blockRegistryEvent);
//		COLORED_JUNGLE_DOOR.registerBlocks(blockRegistryEvent);

		COLORED_OAK_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_OAK_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_OAK_STAIRS.registerBlocks(blockRegistryEvent);
//		COLORED_OAK_DOOR.registerBlocks(blockRegistryEvent);

		COLORED_SPRUCE_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_SPRUCE_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_SPRUCE_STAIRS.registerBlocks(blockRegistryEvent);
//		COLORED_SPRUCE_DOOR.registerBlocks(blockRegistryEvent);

		COLORED_CRIMSON_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_CRIMSON_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_CRIMSON_STAIRS.registerBlocks(blockRegistryEvent);
//		COLORED_CRIMSON_DOOR.registerBlocks(blockRegistryEvent);

		COLORED_WARPED_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_WARPED_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_WARPED_STAIRS.registerBlocks(blockRegistryEvent);
//		COLORED_WARPED_DOOR.registerBlocks(blockRegistryEvent);
	}

	public static void doClientStuff(FMLClientSetupEvent event) {
		BindRenderLayers();
	}

	public static void BindRenderLayers() {
		RenderTypeLookup.setRenderLayer(CROP_ONION, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(CROP_BROCCOLI, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(CROP_RICE, RenderType.getTranslucent());

		RenderTypeLookup.setRenderLayer(GLASS_SLAB, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(GLASS_STAIRS, RenderType.getTranslucent());

		COLORED_GLASS_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_GLASS_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_ACACIA_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_ACACIA_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_ACACIA_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
//		COLORED_ACACIA_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_BIRCH_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_BIRCH_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_BIRCH_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
//		COLORED_BIRCH_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_DARK_OAK_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_DARK_OAK_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_DARK_OAK_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
//		COLORED_DARK_OAK_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_JUNGLE_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_JUNGLE_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_JUNGLE_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
//		COLORED_JUNGLE_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_OAK_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_OAK_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_OAK_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
//		COLORED_OAK_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_SPRUCE_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_SPRUCE_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_SPRUCE_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
//		COLORED_SPRUCE_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_CRIMSON_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_CRIMSON_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_CRIMSON_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
//		COLORED_CRIMSON_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_WARPED_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_WARPED_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_WARPED_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
//		COLORED_WARPED_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());
	}
	
	public static void onGatherJsonData(DataGenerator generator) {
		CROP_ONION.generateJson(generator, "crop_onion_stage{stage}");
		CROP_BROCCOLI.generateJson(generator, "crop_broccoli_stage{stage}");
		CROP_RICE.generateJson(generator, "crop_rice_stage{stage}");
		
		COLORED_GLASS_SLAB.setDoubleModel("minecraft:block/{color}_stained_glass")
				.setTexture("minecraft:block/{color}_stained_glass").asNonTinted().generateBlocksJson(generator);
		COLORED_GLASS_STAIRS.setTexture("minecraft:block/{color}_stained_glass").asNonTinted().generateBlocksJson(generator);

		COLORED_ACACIA_PLANKS.setTexture("minecraft:block/acacia_planks").generateBlocksJson(generator);
		COLORED_ACACIA_SLAB.setDoubleModel(COLORED_ACACIA_PLANKS.idTemplate)
				.setTexture(COLORED_ACACIA_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_ACACIA_STAIRS.setTexture(COLORED_ACACIA_PLANKS.textureIdTemplate).generateBlocksJson(generator);

		COLORED_BIRCH_PLANKS.setTexture("minecraft:block/birch_planks").generateBlocksJson(generator);
		COLORED_BIRCH_SLAB.setDoubleModel(COLORED_BIRCH_PLANKS.idTemplate)
				.setTexture(COLORED_BIRCH_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_BIRCH_STAIRS.setTexture(COLORED_BIRCH_PLANKS.textureIdTemplate).generateBlocksJson(generator);

		COLORED_DARK_OAK_PLANKS.setTexture("minecraft:block/dark_oak_planks").generateBlocksJson(generator);
		COLORED_DARK_OAK_SLAB.setDoubleModel(COLORED_DARK_OAK_PLANKS.idTemplate)
				.setTexture(COLORED_DARK_OAK_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_DARK_OAK_STAIRS.setTexture(COLORED_DARK_OAK_PLANKS.textureIdTemplate).generateBlocksJson(generator);

		COLORED_JUNGLE_PLANKS.setTexture("minecraft:block/jungle_planks").generateBlocksJson(generator);
		COLORED_JUNGLE_SLAB.setDoubleModel(COLORED_JUNGLE_PLANKS.idTemplate)
				.setTexture(COLORED_JUNGLE_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_JUNGLE_STAIRS.setTexture(COLORED_JUNGLE_SLAB.textureIdTemplate).generateBlocksJson(generator);

		COLORED_OAK_PLANKS.setTexture("minecraft:block/oak_planks").generateBlocksJson(generator);
		COLORED_OAK_SLAB.setDoubleModel(COLORED_OAK_PLANKS.idTemplate).setTexture(COLORED_OAK_PLANKS.textureIdTemplate)
				.generateBlocksJson(generator);
		COLORED_OAK_STAIRS.setTexture(COLORED_OAK_PLANKS.textureIdTemplate).generateBlocksJson(generator);

		COLORED_SPRUCE_PLANKS.setTexture("minecraft:block/spruce_planks").generateBlocksJson(generator);
		COLORED_SPRUCE_SLAB.setDoubleModel(COLORED_SPRUCE_PLANKS.idTemplate)
				.setTexture(COLORED_SPRUCE_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_SPRUCE_STAIRS.setTexture(COLORED_SPRUCE_PLANKS.textureIdTemplate).generateBlocksJson(generator);

		COLORED_CRIMSON_PLANKS.setTexture("minecraft:block/crimson_planks").generateBlocksJson(generator);
		COLORED_CRIMSON_SLAB.setDoubleModel(COLORED_CRIMSON_PLANKS.idTemplate)
				.setTexture(COLORED_CRIMSON_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_CRIMSON_STAIRS.setTexture(COLORED_CRIMSON_PLANKS.textureIdTemplate).generateBlocksJson(generator);

		COLORED_WARPED_PLANKS.setTexture("minecraft:block/warped_planks").generateBlocksJson(generator);
		COLORED_WARPED_SLAB.setDoubleModel(COLORED_WARPED_PLANKS.idTemplate)
				.setTexture(COLORED_WARPED_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_WARPED_STAIRS.setTexture(COLORED_WARPED_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		
		TagBuilder tagBuilder = new TagBuilder("planks", TagBuilder.TagType.VANILLA_BLOCK_ITEM);
		tagBuilder.add(COLORED_ACACIA_PLANKS);
		tagBuilder.add(COLORED_BIRCH_PLANKS);
		tagBuilder.add(COLORED_DARK_OAK_PLANKS);
		tagBuilder.add(COLORED_JUNGLE_PLANKS);
		tagBuilder.add(COLORED_OAK_PLANKS);
		tagBuilder.add(COLORED_SPRUCE_PLANKS);
		tagBuilder.add(COLORED_CRIMSON_PLANKS);
		tagBuilder.add(COLORED_WARPED_PLANKS);
		tagBuilder.generate(generator);
		
		
		tagBuilder = new TagBuilder("acacia_planks", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_ACACIA_PLANKS);
		tagBuilder.add(COLORED_ACACIA_PLANKS);
		tagBuilder.generate(generator);
		
		tagBuilder = new TagBuilder("acacia_slab", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_ACACIA_SLAB);
		tagBuilder.add(COLORED_ACACIA_SLAB);
		tagBuilder.generate(generator);
		
		tagBuilder = new TagBuilder("acacia_stairs", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_ACACIA_STAIRS);
		tagBuilder.add(COLORED_ACACIA_STAIRS);
		tagBuilder.generate(generator);
		
		
		tagBuilder = new TagBuilder("birch_planks", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_BIRCH_PLANKS);
		tagBuilder.add(COLORED_BIRCH_PLANKS);
		tagBuilder.generate(generator);
		
		tagBuilder = new TagBuilder("birch_slab", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_BIRCH_SLAB);
		tagBuilder.add(COLORED_BIRCH_SLAB);
		tagBuilder.generate(generator);
		
		tagBuilder = new TagBuilder("birch_stairs", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_BIRCH_STAIRS);
		tagBuilder.add(COLORED_BIRCH_STAIRS);
		tagBuilder.generate(generator);
		
		
		tagBuilder = new TagBuilder("dark_oak_planks", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_DARK_OAK_PLANKS);
		tagBuilder.add(COLORED_DARK_OAK_PLANKS);
		tagBuilder.generate(generator);
		
		tagBuilder = new TagBuilder("dark_oak_slab", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_DARK_OAK_SLAB);
		tagBuilder.add(COLORED_DARK_OAK_SLAB);
		tagBuilder.generate(generator);
		
		tagBuilder = new TagBuilder("dark_oak_stairs", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_DARK_OAK_STAIRS);
		tagBuilder.add(COLORED_DARK_OAK_STAIRS);
		tagBuilder.generate(generator);
		
		
		tagBuilder = new TagBuilder("jungle_planks", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_JUNGLE_PLANKS);
		tagBuilder.add(COLORED_JUNGLE_PLANKS);
		tagBuilder.generate(generator);
		
		tagBuilder = new TagBuilder("jungle_slab", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_JUNGLE_SLAB);
		tagBuilder.add(COLORED_JUNGLE_SLAB);
		tagBuilder.generate(generator);
		
		tagBuilder = new TagBuilder("jungle_stairs", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_JUNGLE_STAIRS);
		tagBuilder.add(COLORED_JUNGLE_STAIRS);
		tagBuilder.generate(generator);
		
		
		tagBuilder = new TagBuilder("oak_planks", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_OAK_PLANKS);
		tagBuilder.add(COLORED_OAK_PLANKS);
		tagBuilder.generate(generator);
		
		tagBuilder = new TagBuilder("oak_slab", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_OAK_SLAB);
		tagBuilder.add(COLORED_OAK_SLAB);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder("oak_stairs", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_OAK_STAIRS);
		tagBuilder.add(COLORED_OAK_STAIRS);
		tagBuilder.generate(generator);
		
		
		tagBuilder = new TagBuilder("spruce_planks", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_SPRUCE_PLANKS);
		tagBuilder.add(COLORED_SPRUCE_PLANKS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder("spruce_slab", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_SPRUCE_SLAB);
		tagBuilder.add(COLORED_SPRUCE_SLAB);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder("spruce_stairs", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_SPRUCE_STAIRS);
		tagBuilder.add(COLORED_SPRUCE_STAIRS);
		tagBuilder.generate(generator);
		
		
		tagBuilder = new TagBuilder("crimson_planks", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_CRIMSON_PLANKS);
		tagBuilder.add(COLORED_CRIMSON_PLANKS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder("crimson_slab", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_CRIMSON_SLAB);
		tagBuilder.add(COLORED_CRIMSON_SLAB);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder("crimson_stairs", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(REFERENCE_CRIMSON_STAIRS);
		tagBuilder.add(COLORED_CRIMSON_STAIRS);
		tagBuilder.generate(generator);
		
		
		tagBuilder = new TagBuilder("warped_planks", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_WARPED_PLANKS);
		tagBuilder.add(COLORED_WARPED_PLANKS);
		tagBuilder.generate(generator);
		
		tagBuilder = new TagBuilder("warped_slab", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_WARPED_SLAB);
		tagBuilder.add(COLORED_WARPED_SLAB);
		tagBuilder.generate(generator);
		
		tagBuilder = new TagBuilder("warped_stairs", TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_WARPED_STAIRS);
		tagBuilder.add(COLORED_WARPED_STAIRS);
		tagBuilder.generate(generator);
	}

	public static void onGatherImageData(DataGenerator generator) {

	}

}
