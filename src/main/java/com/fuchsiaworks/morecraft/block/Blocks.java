package com.fuchsiaworks.morecraft.block;

import com.fuchsiaworks.morecraft.MoreCraft;
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
	public static Block REFERENCE_ACACIA_FENCE = net.minecraft.block.Blocks.ACACIA_FENCE;
	public static Block REFERENCE_ACACIA_TRAPDOOR = net.minecraft.block.Blocks.ACACIA_TRAPDOOR;

	public static Block REFERENCE_BIRCH_PLANKS = net.minecraft.block.Blocks.BIRCH_PLANKS;
	public static Block REFERENCE_BIRCH_SLAB = net.minecraft.block.Blocks.BIRCH_SLAB;
	public static Block REFERENCE_BIRCH_STAIRS = net.minecraft.block.Blocks.BIRCH_STAIRS;
	public static Block REFERENCE_BIRCH_DOOR = net.minecraft.block.Blocks.BIRCH_DOOR;
	public static Block REFERENCE_BIRCH_FENCE = net.minecraft.block.Blocks.BIRCH_FENCE;
	public static Block REFERENCE_BIRCH_TRAPDOOR = net.minecraft.block.Blocks.BIRCH_TRAPDOOR;

	public static Block REFERENCE_DARK_OAK_PLANKS = net.minecraft.block.Blocks.DARK_OAK_PLANKS;
	public static Block REFERENCE_DARK_OAK_SLAB = net.minecraft.block.Blocks.DARK_OAK_SLAB;
	public static Block REFERENCE_DARK_OAK_STAIRS = net.minecraft.block.Blocks.DARK_OAK_STAIRS;
	public static Block REFERENCE_DARK_OAK_DOOR = net.minecraft.block.Blocks.DARK_OAK_DOOR;
	public static Block REFERENCE_DARK_OAK_FENCE = net.minecraft.block.Blocks.DARK_OAK_FENCE;
	public static Block REFERENCE_DARK_OAK_TRAPDOOR = net.minecraft.block.Blocks.DARK_OAK_TRAPDOOR;

	public static Block REFERENCE_JUNGLE_PLANKS = net.minecraft.block.Blocks.JUNGLE_PLANKS;
	public static Block REFERENCE_JUNGLE_SLAB = net.minecraft.block.Blocks.JUNGLE_SLAB;
	public static Block REFERENCE_JUNGLE_STAIRS = net.minecraft.block.Blocks.JUNGLE_STAIRS;
	public static Block REFERENCE_JUNGLE_DOOR = net.minecraft.block.Blocks.JUNGLE_DOOR;
	public static Block REFERENCE_JUNGLE_FENCE = net.minecraft.block.Blocks.JUNGLE_FENCE;
	public static Block REFERENCE_JUNGLE_TRAPDOOR = net.minecraft.block.Blocks.JUNGLE_TRAPDOOR;

	public static Block REFERENCE_OAK_PLANKS = net.minecraft.block.Blocks.OAK_PLANKS;
	public static Block REFERENCE_OAK_SLAB = net.minecraft.block.Blocks.OAK_SLAB;
	public static Block REFERENCE_OAK_STAIRS = net.minecraft.block.Blocks.OAK_STAIRS;
	public static Block REFERENCE_OAK_DOOR = net.minecraft.block.Blocks.OAK_DOOR;
	public static Block REFERENCE_OAK_FENCE = net.minecraft.block.Blocks.OAK_FENCE;
	public static Block REFERENCE_OAK_TRAPDOOR = net.minecraft.block.Blocks.OAK_TRAPDOOR;

	public static Block REFERENCE_SPRUCE_PLANKS = net.minecraft.block.Blocks.SPRUCE_PLANKS;
	public static Block REFERENCE_SPRUCE_SLAB = net.minecraft.block.Blocks.SPRUCE_SLAB;
	public static Block REFERENCE_SPRUCE_STAIRS = net.minecraft.block.Blocks.SPRUCE_STAIRS;
	public static Block REFERENCE_SPRUCE_DOOR = net.minecraft.block.Blocks.SPRUCE_DOOR;
	public static Block REFERENCE_SPRUCE_FENCE = net.minecraft.block.Blocks.SPRUCE_FENCE;
	public static Block REFERENCE_SPRUCE_TRAPDOOR = net.minecraft.block.Blocks.SPRUCE_TRAPDOOR;

	public static Block REFERENCE_CRIMSON_PLANKS = net.minecraft.block.Blocks.field_235344_mC_;
	public static Block REFERENCE_CRIMSON_SLAB = net.minecraft.block.Blocks.field_235346_mE_;
	public static Block REFERENCE_CRIMSON_STAIRS = net.minecraft.block.Blocks.field_235356_mO_;
	public static Block REFERENCE_CRIMSON_DOOR = net.minecraft.block.Blocks.field_235360_mS_;
	public static Block REFERENCE_CRIMSON_FENCE = net.minecraft.block.Blocks.field_235350_mI_;
	public static Block REFERENCE_CRIMSON_TRAPDOOR = net.minecraft.block.Blocks.field_235352_mK_;

	public static Block REFERENCE_WARPED_PLANKS = net.minecraft.block.Blocks.field_235345_mD_;
	public static Block REFERENCE_WARPED_SLAB = net.minecraft.block.Blocks.field_235347_mF_;
	public static Block REFERENCE_WARPED_STAIRS = net.minecraft.block.Blocks.field_235357_mP_;
	public static Block REFERENCE_WARPED_DOOR = net.minecraft.block.Blocks.field_235361_mT_;
	public static Block REFERENCE_WARPED_FENCE = net.minecraft.block.Blocks.field_235351_mJ_;
	public static Block REFERENCE_WARPED_TRAPDOOR = net.minecraft.block.Blocks.field_235353_mL_;

	public static ChoppingBlock CHOPPING_BLOCK;
	public static ChurningBlock CHURNING_BLOCK;

	public static DynamicCropBlock CROP_ONION;
	public static DynamicCropBlock CROP_BROCCOLI;
	public static DynamicCropBlock CROP_RICE;

	public static GlassSlabBlock GLASS_SLAB;
	public static GlassStairsBlock GLASS_STAIRS;
	public static GlassDoorBlock GLASS_DOOR;
	public static GlassFenceBlock GLASS_FENCE;
	public static GlassTrapDoorBlock GLASS_TRAPDOOR;

	public static ColoredSlabBlockHelper COLORED_GLASS_SLAB;
	public static ColoredBlockHelper COLORED_GLASS_STAIRS;
	public static ColoredBlockHelper COLORED_GLASS_DOOR;
	public static ColoredFenceBlockHelper COLORED_GLASS_FENCE;
	public static ColoredTrapDoorBlockHelper COLORED_GLASS_TRAPDOOR;

	public static ColoredBlockHelper COLORED_ACACIA_PLANKS;
	public static ColoredSlabBlockHelper COLORED_ACACIA_SLAB;
	public static ColoredStairBlockHelper COLORED_ACACIA_STAIRS;
	public static ColoredBlockHelper COLORED_ACACIA_DOOR;
	public static ColoredFenceBlockHelper COLORED_ACACIA_FENCE;
	public static ColoredTrapDoorBlockHelper COLORED_ACACIA_TRAPDOOR;

	public static ColoredBlockHelper COLORED_BIRCH_PLANKS;
	public static ColoredSlabBlockHelper COLORED_BIRCH_SLAB;
	public static ColoredStairBlockHelper COLORED_BIRCH_STAIRS;
	public static ColoredBlockHelper COLORED_BIRCH_DOOR;
	public static ColoredFenceBlockHelper COLORED_BIRCH_FENCE;
	public static ColoredTrapDoorBlockHelper COLORED_BIRCH_TRAPDOOR;

	public static ColoredBlockHelper COLORED_DARK_OAK_PLANKS;
	public static ColoredSlabBlockHelper COLORED_DARK_OAK_SLAB;
	public static ColoredStairBlockHelper COLORED_DARK_OAK_STAIRS;
	public static ColoredBlockHelper COLORED_DARK_OAK_DOOR;
	public static ColoredFenceBlockHelper COLORED_DARK_OAK_FENCE;
	public static ColoredTrapDoorBlockHelper COLORED_DARK_OAK_TRAPDOOR;

	public static ColoredBlockHelper COLORED_JUNGLE_PLANKS;
	public static ColoredSlabBlockHelper COLORED_JUNGLE_SLAB;
	public static ColoredStairBlockHelper COLORED_JUNGLE_STAIRS;
	public static ColoredBlockHelper COLORED_JUNGLE_DOOR;
	public static ColoredFenceBlockHelper COLORED_JUNGLE_FENCE;
	public static ColoredTrapDoorBlockHelper COLORED_JUNGLE_TRAPDOOR;

	public static ColoredBlockHelper COLORED_OAK_PLANKS;
	public static ColoredSlabBlockHelper COLORED_OAK_SLAB;
	public static ColoredStairBlockHelper COLORED_OAK_STAIRS;
	public static ColoredBlockHelper COLORED_OAK_DOOR;
	public static ColoredFenceBlockHelper COLORED_OAK_FENCE;
	public static ColoredTrapDoorBlockHelper COLORED_OAK_TRAPDOOR;

	public static ColoredBlockHelper COLORED_SPRUCE_PLANKS;
	public static ColoredSlabBlockHelper COLORED_SPRUCE_SLAB;
	public static ColoredStairBlockHelper COLORED_SPRUCE_STAIRS;
	public static ColoredBlockHelper COLORED_SPRUCE_DOOR;
	public static ColoredFenceBlockHelper COLORED_SPRUCE_FENCE;
	public static ColoredTrapDoorBlockHelper COLORED_SPRUCE_TRAPDOOR;

	public static ColoredBlockHelper COLORED_CRIMSON_PLANKS;
	public static ColoredSlabBlockHelper COLORED_CRIMSON_SLAB;
	public static ColoredStairBlockHelper COLORED_CRIMSON_STAIRS;
	public static ColoredBlockHelper COLORED_CRIMSON_DOOR;
	public static ColoredFenceBlockHelper COLORED_CRIMSON_FENCE;
	public static ColoredTrapDoorBlockHelper COLORED_CRIMSON_TRAPDOOR;

	public static ColoredBlockHelper COLORED_WARPED_PLANKS;
	public static ColoredSlabBlockHelper COLORED_WARPED_SLAB;
	public static ColoredStairBlockHelper COLORED_WARPED_STAIRS;
	public static ColoredBlockHelper COLORED_WARPED_DOOR;
	public static ColoredFenceBlockHelper COLORED_WARPED_FENCE;
	public static ColoredTrapDoorBlockHelper COLORED_WARPED_TRAPDOOR;

	public static void InitBlocks() {

		CHOPPING_BLOCK = (ChoppingBlock) new ChoppingBlock(
				Properties.create(Material.WOOD).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE))
						.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "chopping_block"));
		CHURNING_BLOCK = (ChurningBlock) new ChurningBlock(
				Properties.create(Material.WOOD).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE))
						.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "churning_block"));

		CROP_ONION = (DynamicCropBlock) new DynamicCropBlock(Properties.create(Material.PLANTS).doesNotBlockMovement()
				.tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP), () -> Items.CROP_ONION)
						.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "crop_onion"));
		CROP_BROCCOLI = (DynamicCropBlock) new DynamicCropBlock(Properties.create(Material.PLANTS)
				.doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP),
				() -> Items.CROP_BROCCOLI).setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "crop_broccoli"));
		CROP_RICE = (DynamicCropBlock) new DynamicCropBlock(Properties.create(Material.PLANTS).doesNotBlockMovement()
				.tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP), () -> Items.CROP_RICE)
						.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "crop_rice"));

		GLASS_SLAB = (GlassSlabBlock) new GlassSlabBlock(Properties.from(REFERENCE_GLASS))
				.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "glass_slab"));
		GLASS_STAIRS = (GlassStairsBlock) new GlassStairsBlock(() -> REFERENCE_GLASS.getDefaultState(),
				Properties.from(REFERENCE_GLASS))
						.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "glass_stairs"));
		GLASS_DOOR = (GlassDoorBlock) new GlassDoorBlock(Properties.from(REFERENCE_GLASS))
				.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "glass_door"));
		GLASS_FENCE = (GlassFenceBlock) new GlassFenceBlock(Properties.from(REFERENCE_GLASS))
				.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "glass_fence"));
		GLASS_TRAPDOOR = (GlassTrapDoorBlock) new GlassTrapDoorBlock(Properties.from(REFERENCE_GLASS))
				.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "glass_trapdoor"));

		COLORED_GLASS_SLAB = new ColoredSlabBlockHelper("{color}_stained_glass_slab", Properties.from(REFERENCE_GLASS),
				GlassSlabBlock.class);
		COLORED_GLASS_STAIRS = new ColoredStairBlockHelper("{color}_stained_glass_stairs",
				Properties.from(REFERENCE_GLASS), REFERENCE_GLASS.getDefaultState(), GlassStairsBlock.class);
		COLORED_GLASS_DOOR = new ColoredBlockHelper("{color}_stained_glass_door", Properties.from(REFERENCE_GLASS),
				DoorBlock.class);
		COLORED_GLASS_FENCE = new ColoredFenceBlockHelper("{color}_stained_glass_fence",
				Properties.from(REFERENCE_GLASS));
		COLORED_GLASS_TRAPDOOR = new ColoredTrapDoorBlockHelper("{color}_stained_glass_trapdoor",
				Properties.from(REFERENCE_GLASS));

		COLORED_ACACIA_PLANKS = new ColoredBlockHelper("acacia_planks_{color}_tinted",
				Properties.from(REFERENCE_ACACIA_PLANKS));
		COLORED_ACACIA_SLAB = new ColoredSlabBlockHelper("acacia_planks_{color}_tinted_slab",
				Properties.from(REFERENCE_ACACIA_SLAB));
		COLORED_ACACIA_STAIRS = new ColoredStairBlockHelper("acacia_planks_{color}_tinted_stairs",
				Properties.from(REFERENCE_ACACIA_STAIRS), REFERENCE_ACACIA_STAIRS.getDefaultState());
		COLORED_ACACIA_DOOR = new ColoredBlockHelper("acacia_planks_{color}_tinted_door",
				Properties.from(REFERENCE_ACACIA_DOOR), DoorBlock.class);
		COLORED_ACACIA_FENCE = new ColoredFenceBlockHelper("acacia_planks_{color}_tinted_fence",
				Properties.from(REFERENCE_ACACIA_FENCE));
		COLORED_ACACIA_TRAPDOOR = new ColoredTrapDoorBlockHelper("acacia_planks_{color}_tinted_trapdoor",
				Properties.from(REFERENCE_ACACIA_TRAPDOOR));

		COLORED_BIRCH_PLANKS = new ColoredBlockHelper("birch_planks_{color}_tinted",
				Properties.from(REFERENCE_BIRCH_PLANKS));
		COLORED_BIRCH_SLAB = new ColoredSlabBlockHelper("birch_planks_{color}_tinted_slab",
				Properties.from(REFERENCE_BIRCH_SLAB));
		COLORED_BIRCH_STAIRS = new ColoredStairBlockHelper("birch_planks_{color}_tinted_stairs",
				Properties.from(REFERENCE_BIRCH_STAIRS), REFERENCE_BIRCH_STAIRS.getDefaultState());
		COLORED_BIRCH_DOOR = new ColoredBlockHelper("birch_planks_{color}_tinted_door",
				Properties.from(REFERENCE_BIRCH_DOOR), DoorBlock.class);
		COLORED_BIRCH_FENCE = new ColoredFenceBlockHelper("birch_planks_{color}_tinted_fence",
				Properties.from(REFERENCE_BIRCH_FENCE));
		COLORED_BIRCH_TRAPDOOR = new ColoredTrapDoorBlockHelper("birch_planks_{color}_tinted_trapdoor",
				Properties.from(REFERENCE_BIRCH_TRAPDOOR));

		COLORED_DARK_OAK_PLANKS = new ColoredBlockHelper("dark_oak_planks_{color}_tinted",
				Properties.from(REFERENCE_DARK_OAK_PLANKS));
		COLORED_DARK_OAK_SLAB = new ColoredSlabBlockHelper("dark_oak_planks_{color}_tinted_slab",
				Properties.from(REFERENCE_DARK_OAK_SLAB));
		COLORED_DARK_OAK_STAIRS = new ColoredStairBlockHelper("dark_oak_planks_{color}_tinted_stairs",
				Properties.from(REFERENCE_DARK_OAK_STAIRS), REFERENCE_DARK_OAK_STAIRS.getDefaultState());
		COLORED_DARK_OAK_DOOR = new ColoredBlockHelper("dark_oak_planks_{color}_tinted_door",
				Properties.from(REFERENCE_DARK_OAK_DOOR), DoorBlock.class);
		COLORED_DARK_OAK_FENCE = new ColoredFenceBlockHelper("dark_oak_planks_{color}_tinted_fence",
				Properties.from(REFERENCE_DARK_OAK_FENCE));
		COLORED_DARK_OAK_TRAPDOOR = new ColoredTrapDoorBlockHelper("dark_oak_planks_{color}_tinted_trapdoor",
				Properties.from(REFERENCE_DARK_OAK_TRAPDOOR));

		COLORED_JUNGLE_PLANKS = new ColoredBlockHelper("jungle_planks_{color}_tinted",
				Properties.from(REFERENCE_JUNGLE_PLANKS));
		COLORED_JUNGLE_SLAB = new ColoredSlabBlockHelper("jungle_planks_{color}_tinted_slab",
				Properties.from(REFERENCE_JUNGLE_SLAB));
		COLORED_JUNGLE_STAIRS = new ColoredStairBlockHelper("jungle_planks_{color}_tinted_stairs",
				Properties.from(REFERENCE_JUNGLE_STAIRS), REFERENCE_JUNGLE_STAIRS.getDefaultState());
		COLORED_JUNGLE_DOOR = new ColoredBlockHelper("jungle_planks_{color}_tinted_door",
				Properties.from(REFERENCE_JUNGLE_DOOR), DoorBlock.class);
		COLORED_JUNGLE_FENCE = new ColoredFenceBlockHelper("jungle_planks_{color}_tinted_fence",
				Properties.from(REFERENCE_JUNGLE_FENCE));
		COLORED_JUNGLE_TRAPDOOR = new ColoredTrapDoorBlockHelper("jungle_planks_{color}_tinted_trapdoor",
				Properties.from(REFERENCE_JUNGLE_TRAPDOOR));

		COLORED_OAK_PLANKS = new ColoredBlockHelper("oak_planks_{color}_tinted", Properties.from(REFERENCE_OAK_PLANKS));
		COLORED_OAK_SLAB = new ColoredSlabBlockHelper("oak_planks_{color}_tinted_slab",
				Properties.from(REFERENCE_OAK_SLAB));
		COLORED_OAK_STAIRS = new ColoredStairBlockHelper("oak_planks_{color}_tinted_stairs",
				Properties.from(REFERENCE_OAK_STAIRS), REFERENCE_OAK_STAIRS.getDefaultState());
		COLORED_OAK_DOOR = new ColoredBlockHelper("oak_planks_{color}_tinted_door", Properties.from(REFERENCE_OAK_DOOR),
				DoorBlock.class);
		COLORED_OAK_FENCE = new ColoredFenceBlockHelper("oak_planks_{color}_tinted_fence",
				Properties.from(REFERENCE_OAK_FENCE));
		COLORED_OAK_TRAPDOOR = new ColoredTrapDoorBlockHelper("oak_planks_{color}_tinted_trapdoor",
				Properties.from(REFERENCE_OAK_TRAPDOOR));

		COLORED_SPRUCE_PLANKS = new ColoredBlockHelper("spruce_planks_{color}_tinted",
				Properties.from(REFERENCE_SPRUCE_PLANKS));
		COLORED_SPRUCE_SLAB = new ColoredSlabBlockHelper("spruce_planks_{color}_tinted_slab",
				Properties.from(REFERENCE_SPRUCE_SLAB));
		COLORED_SPRUCE_STAIRS = new ColoredStairBlockHelper("spruce_planks_{color}_tinted_stairs",
				Properties.from(REFERENCE_SPRUCE_STAIRS), REFERENCE_SPRUCE_STAIRS.getDefaultState());
		COLORED_SPRUCE_DOOR = new ColoredBlockHelper("spruce_planks_{color}_tinted_door",
				Properties.from(REFERENCE_SPRUCE_DOOR), DoorBlock.class);
		COLORED_SPRUCE_FENCE = new ColoredFenceBlockHelper("spruce_planks_{color}_tinted_fence",
				Properties.from(REFERENCE_SPRUCE_FENCE));
		COLORED_SPRUCE_TRAPDOOR = new ColoredTrapDoorBlockHelper("spruce_planks_{color}_tinted_trapdoor",
				Properties.from(REFERENCE_SPRUCE_TRAPDOOR));

		COLORED_CRIMSON_PLANKS = new ColoredBlockHelper("crimson_planks_{color}_tinted",
				Properties.from(REFERENCE_CRIMSON_PLANKS));
		COLORED_CRIMSON_SLAB = new ColoredSlabBlockHelper("crimson_planks_{color}_tinted_slab",
				Properties.from(REFERENCE_CRIMSON_SLAB));
		COLORED_CRIMSON_STAIRS = new ColoredStairBlockHelper("crimson_planks_{color}_tinted_stairs",
				Properties.from(REFERENCE_CRIMSON_STAIRS), REFERENCE_CRIMSON_STAIRS.getDefaultState());
		COLORED_CRIMSON_DOOR = new ColoredBlockHelper("crimson_planks_{color}_tinted_door",
				Properties.from(REFERENCE_CRIMSON_DOOR), DoorBlock.class);
		COLORED_CRIMSON_FENCE = new ColoredFenceBlockHelper("crimson_planks_{color}_tinted_fence",
				Properties.from(REFERENCE_CRIMSON_FENCE));
		COLORED_CRIMSON_TRAPDOOR = new ColoredTrapDoorBlockHelper("crimson_planks_{color}_tinted_trapdoor",
				Properties.from(REFERENCE_CRIMSON_TRAPDOOR));

		COLORED_WARPED_PLANKS = new ColoredBlockHelper("warped_planks_{color}_tinted",
				Properties.from(REFERENCE_WARPED_PLANKS));
		COLORED_WARPED_SLAB = new ColoredSlabBlockHelper("warped_planks_{color}_tinted_slab",
				Properties.from(REFERENCE_WARPED_SLAB));
		COLORED_WARPED_STAIRS = new ColoredStairBlockHelper("warped_planks_{color}_tinted_stairs",
				Properties.from(REFERENCE_WARPED_STAIRS), REFERENCE_WARPED_STAIRS.getDefaultState());
		COLORED_WARPED_DOOR = new ColoredBlockHelper("warped_planks_{color}_tinted_door",
				Properties.from(REFERENCE_WARPED_DOOR), DoorBlock.class);
		COLORED_WARPED_FENCE = new ColoredFenceBlockHelper("warped_planks_{color}_tinted_fence",
				Properties.from(REFERENCE_WARPED_FENCE));
		COLORED_WARPED_TRAPDOOR = new ColoredTrapDoorBlockHelper("warped_planks_{color}_tinted_trapdoor",
				Properties.from(REFERENCE_WARPED_TRAPDOOR));
	}

	public static void RegisterBlocks(final RegistryEvent.Register<Block> blockRegistryEvent) {
		blockRegistryEvent.getRegistry().register(CROP_ONION);
		blockRegistryEvent.getRegistry().register(CROP_BROCCOLI);
		blockRegistryEvent.getRegistry().register(CROP_RICE);

		blockRegistryEvent.getRegistry().register(CHOPPING_BLOCK);
		blockRegistryEvent.getRegistry().register(CHURNING_BLOCK);

		blockRegistryEvent.getRegistry().register(GLASS_SLAB);
		blockRegistryEvent.getRegistry().register(GLASS_STAIRS);
		// blockRegistryEvent.getRegistry().register(GLASS_DOOR);
		blockRegistryEvent.getRegistry().register(GLASS_FENCE);
		blockRegistryEvent.getRegistry().register(GLASS_TRAPDOOR);

		COLORED_GLASS_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_GLASS_STAIRS.registerBlocks(blockRegistryEvent);
		// COLORED_GLASS_DOOR.registerBlocks(blockRegistryEvent);
		COLORED_GLASS_FENCE.registerBlocks(blockRegistryEvent);
		COLORED_GLASS_TRAPDOOR.registerBlocks(blockRegistryEvent);

		COLORED_ACACIA_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_ACACIA_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_ACACIA_STAIRS.registerBlocks(blockRegistryEvent);
		// COLORED_ACACIA_DOOR.registerBlocks(blockRegistryEvent);
		COLORED_ACACIA_FENCE.registerBlocks(blockRegistryEvent);
		COLORED_ACACIA_TRAPDOOR.registerBlocks(blockRegistryEvent);

		COLORED_BIRCH_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_BIRCH_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_BIRCH_STAIRS.registerBlocks(blockRegistryEvent);
		// COLORED_BIRCH_DOOR.registerBlocks(blockRegistryEvent);
		COLORED_BIRCH_FENCE.registerBlocks(blockRegistryEvent);
		COLORED_BIRCH_TRAPDOOR.registerBlocks(blockRegistryEvent);

		COLORED_DARK_OAK_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_DARK_OAK_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_DARK_OAK_STAIRS.registerBlocks(blockRegistryEvent);
		// COLORED_DARK_OAK_DOOR.registerBlocks(blockRegistryEvent);
		COLORED_DARK_OAK_FENCE.registerBlocks(blockRegistryEvent);
		COLORED_DARK_OAK_TRAPDOOR.registerBlocks(blockRegistryEvent);

		COLORED_JUNGLE_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_JUNGLE_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_JUNGLE_STAIRS.registerBlocks(blockRegistryEvent);
		// COLORED_JUNGLE_DOOR.registerBlocks(blockRegistryEvent);
		COLORED_JUNGLE_FENCE.registerBlocks(blockRegistryEvent);
		COLORED_JUNGLE_TRAPDOOR.registerBlocks(blockRegistryEvent);

		COLORED_OAK_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_OAK_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_OAK_STAIRS.registerBlocks(blockRegistryEvent);
		// COLORED_OAK_DOOR.registerBlocks(blockRegistryEvent);
		COLORED_OAK_FENCE.registerBlocks(blockRegistryEvent);
		COLORED_OAK_TRAPDOOR.registerBlocks(blockRegistryEvent);

		COLORED_SPRUCE_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_SPRUCE_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_SPRUCE_STAIRS.registerBlocks(blockRegistryEvent);
		// COLORED_SPRUCE_DOOR.registerBlocks(blockRegistryEvent);
		COLORED_SPRUCE_FENCE.registerBlocks(blockRegistryEvent);
		COLORED_SPRUCE_TRAPDOOR.registerBlocks(blockRegistryEvent);

		COLORED_CRIMSON_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_CRIMSON_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_CRIMSON_STAIRS.registerBlocks(blockRegistryEvent);
		// COLORED_CRIMSON_DOOR.registerBlocks(blockRegistryEvent);
		COLORED_CRIMSON_FENCE.registerBlocks(blockRegistryEvent);
		COLORED_CRIMSON_TRAPDOOR.registerBlocks(blockRegistryEvent);

		COLORED_WARPED_PLANKS.registerBlocks(blockRegistryEvent);
		COLORED_WARPED_SLAB.registerBlocks(blockRegistryEvent);
		COLORED_WARPED_STAIRS.registerBlocks(blockRegistryEvent);
		// COLORED_WARPED_DOOR.registerBlocks(blockRegistryEvent);
		COLORED_WARPED_FENCE.registerBlocks(blockRegistryEvent);
		COLORED_WARPED_TRAPDOOR.registerBlocks(blockRegistryEvent);
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
		RenderTypeLookup.setRenderLayer(GLASS_DOOR, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(GLASS_FENCE, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(GLASS_TRAPDOOR, RenderType.getTranslucent());

		COLORED_GLASS_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_GLASS_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
		// COLORED_GLASS_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_GLASS_FENCE.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_GLASS_TRAPDOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_ACACIA_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_ACACIA_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_ACACIA_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
		// COLORED_ACACIA_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_ACACIA_FENCE.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_ACACIA_TRAPDOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_BIRCH_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_BIRCH_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_BIRCH_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
		// COLORED_BIRCH_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_BIRCH_FENCE.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_BIRCH_TRAPDOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_DARK_OAK_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_DARK_OAK_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_DARK_OAK_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
		// COLORED_DARK_OAK_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_DARK_OAK_FENCE.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_DARK_OAK_TRAPDOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_JUNGLE_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_JUNGLE_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_JUNGLE_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
		// COLORED_JUNGLE_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_JUNGLE_FENCE.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_JUNGLE_TRAPDOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_OAK_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_OAK_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_OAK_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
		// COLORED_OAK_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_OAK_FENCE.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_OAK_TRAPDOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_SPRUCE_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_SPRUCE_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_SPRUCE_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
		// COLORED_SPRUCE_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_SPRUCE_FENCE.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_SPRUCE_TRAPDOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_CRIMSON_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_CRIMSON_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_CRIMSON_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
		// COLORED_CRIMSON_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_CRIMSON_FENCE.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_CRIMSON_TRAPDOOR.bindBlockRenderLayers(RenderType.getTranslucent());

		COLORED_WARPED_PLANKS.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_WARPED_SLAB.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_WARPED_STAIRS.bindBlockRenderLayers(RenderType.getTranslucent());
		// COLORED_WARPED_DOOR.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_WARPED_FENCE.bindBlockRenderLayers(RenderType.getTranslucent());
		COLORED_WARPED_TRAPDOOR.bindBlockRenderLayers(RenderType.getTranslucent());
	}

	public static void onGatherJsonData(DataGenerator generator) {
		CROP_ONION.generateJson(generator, "crop_onion_stage{stage}");
		CROP_BROCCOLI.generateJson(generator, "crop_broccoli_stage{stage}");
		CROP_RICE.generateJson(generator, "crop_rice_stage{stage}");

		String coloredGlassTextureIdTemplate = "minecraft:block/{color}_stained_glass";
		COLORED_GLASS_SLAB.setDoubleModel("minecraft:block/{color}_stained_glass")
				.setTexture(coloredGlassTextureIdTemplate).asNonTinted().generateBlocksJson(generator);
		COLORED_GLASS_STAIRS.setTexture(coloredGlassTextureIdTemplate).asNonTinted().generateBlocksJson(generator);
		// COLORED_GLASS_DOOR.setTexture(coloredGlassTextureIdTemplate).asNonTinted().generateBlocksJson(generator);
		COLORED_GLASS_FENCE.setPostModelParent("glass_fence_post").setSideModelParent("glass_fence_side")
				.setInventoryModelParent("glass_fence_inventory").setTexture(coloredGlassTextureIdTemplate)
				.asNonTinted().generateBlocksJson(generator);
		COLORED_GLASS_TRAPDOOR.setTexture(coloredGlassTextureIdTemplate).asNonTinted().generateBlocksJson(generator);

		COLORED_ACACIA_PLANKS.setTexture("minecraft:block/acacia_planks").generateBlocksJson(generator);
		COLORED_ACACIA_SLAB.setDoubleModel(COLORED_ACACIA_PLANKS.idTemplate)
				.setTexture(COLORED_ACACIA_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_ACACIA_STAIRS.setTexture(COLORED_ACACIA_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		// COLORED_ACACIA_DOOR.setTexture(COLORED_ACACIA_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_ACACIA_FENCE.setTexture(COLORED_ACACIA_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_ACACIA_TRAPDOOR.setTexture("minecraft:block/acacia_trapdoor").setTint("acacia_trapdoor_tint_{color}")
				.generateBlocksJson(generator);

		COLORED_BIRCH_PLANKS.setTexture("minecraft:block/birch_planks").generateBlocksJson(generator);
		COLORED_BIRCH_SLAB.setDoubleModel(COLORED_BIRCH_PLANKS.idTemplate)
				.setTexture(COLORED_BIRCH_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_BIRCH_STAIRS.setTexture(COLORED_BIRCH_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		// COLORED_BIRCH_DOOR.setTexture(COLORED_BIRCH_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_BIRCH_FENCE.setTexture(COLORED_BIRCH_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_BIRCH_TRAPDOOR.setTexture("minecraft:block/birch_trapdoor").generateBlocksJson(generator);

		COLORED_DARK_OAK_PLANKS.setTexture("minecraft:block/dark_oak_planks").generateBlocksJson(generator);
		COLORED_DARK_OAK_SLAB.setDoubleModel(COLORED_DARK_OAK_PLANKS.idTemplate)
				.setTexture(COLORED_DARK_OAK_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_DARK_OAK_STAIRS.setTexture(COLORED_DARK_OAK_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		// COLORED_DARK_OAK_DOOR.setTexture(COLORED_DARK_OAK_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_DARK_OAK_FENCE.setTexture(COLORED_DARK_OAK_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_DARK_OAK_TRAPDOOR.setTexture("minecraft:block/dark_oak_trapdoor").generateBlocksJson(generator);

		COLORED_JUNGLE_PLANKS.setTexture("minecraft:block/jungle_planks").generateBlocksJson(generator);
		COLORED_JUNGLE_SLAB.setDoubleModel(COLORED_JUNGLE_PLANKS.idTemplate)
				.setTexture(COLORED_JUNGLE_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_JUNGLE_STAIRS.setTexture(COLORED_JUNGLE_SLAB.textureIdTemplate).generateBlocksJson(generator);
		// COLORED_JUNGLE_DOOR.setTexture(COLORED_JUNGLE_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_JUNGLE_FENCE.setTexture(COLORED_JUNGLE_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_JUNGLE_TRAPDOOR.setTexture("minecraft:block/jungle_trapdoor").setTint("jungle_trapdoor_tint_{color}")
				.generateBlocksJson(generator);

		COLORED_OAK_PLANKS.setTexture("minecraft:block/oak_planks").generateBlocksJson(generator);
		COLORED_OAK_SLAB.setDoubleModel(COLORED_OAK_PLANKS.idTemplate).setTexture(COLORED_OAK_PLANKS.textureIdTemplate)
				.generateBlocksJson(generator);
		COLORED_OAK_STAIRS.setTexture(COLORED_OAK_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		// COLORED_OAK_DOOR.setTexture(COLORED_OAK_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_OAK_FENCE.setTexture(COLORED_OAK_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_OAK_TRAPDOOR.setTexture("minecraft:block/oak_trapdoor").setTint("oak_trapdoor_tint_{color}")
				.generateBlocksJson(generator);

		COLORED_SPRUCE_PLANKS.setTexture("minecraft:block/spruce_planks").generateBlocksJson(generator);
		COLORED_SPRUCE_SLAB.setDoubleModel(COLORED_SPRUCE_PLANKS.idTemplate)
				.setTexture(COLORED_SPRUCE_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_SPRUCE_STAIRS.setTexture(COLORED_SPRUCE_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		// COLORED_SPRUCE_DOOR.setTexture(COLORED_SPRUCE_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_SPRUCE_FENCE.setTexture(COLORED_SPRUCE_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_SPRUCE_TRAPDOOR.setTexture("minecraft:block/spruce_trapdoor").generateBlocksJson(generator);

		COLORED_CRIMSON_PLANKS.setTexture("minecraft:block/crimson_planks").generateBlocksJson(generator);
		COLORED_CRIMSON_SLAB.setDoubleModel(COLORED_CRIMSON_PLANKS.idTemplate)
				.setTexture(COLORED_CRIMSON_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_CRIMSON_STAIRS.setTexture(COLORED_CRIMSON_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		// COLORED_CRIMSON_DOOR.setTexture(COLORED_CRIMSON_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_CRIMSON_FENCE.setTexture(COLORED_CRIMSON_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_CRIMSON_TRAPDOOR.setTexture("minecraft:block/crimson_trapdoor").setTint("crimson_trapdoor_tint_{color}")
				.generateBlocksJson(generator);

		COLORED_WARPED_PLANKS.setTexture("minecraft:block/warped_planks").generateBlocksJson(generator);
		COLORED_WARPED_SLAB.setDoubleModel(COLORED_WARPED_PLANKS.idTemplate)
				.setTexture(COLORED_WARPED_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_WARPED_STAIRS.setTexture(COLORED_WARPED_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		// COLORED_WARPED_DOOR.setTexture(COLORED_WARPED_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_WARPED_FENCE.setTexture(COLORED_WARPED_PLANKS.textureIdTemplate).generateBlocksJson(generator);
		COLORED_WARPED_TRAPDOOR.setTexture("minecraft:block/warped_trapdoor").setTint("warped_trapdoor_tint_{color}")
				.generateBlocksJson(generator);
	}

	public static void onGatherImageData(DataGenerator generator) {

	}

}
