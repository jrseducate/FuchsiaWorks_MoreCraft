package com.fuchsiaworks.morecraft.tag;

import com.fuchsiaworks.morecraft.TagBuilder;
import com.fuchsiaworks.morecraft.block.Blocks;

import net.minecraft.data.DataGenerator;

public class Tags {
	public static String REFERENCE_PLANKS = "planks";
	public static String REFERENCE_WOODEN_FENCES = "wooden_fences";
	public static String REFERENCE_FENCES = "fences";

	public static String ACACIA_PLANKS = "acacia_planks";
	public static String ACACIA_SLAB = "acacia_slab";
	public static String ACACIA_STAIRS = "acacia_stairs";
	public static String ACACIA_DOOR = "acacia_door";
	public static String ACACIA_FENCE = "acacia_fence";
	public static String ACACIA_TRAPDOOR = "acacia_trapdoor";

	public static String BIRCH_PLANKS = "birch_planks";
	public static String BIRCH_SLAB = "birch_slab";
	public static String BIRCH_STAIRS = "birch_stairs";
	public static String BIRCH_DOOR = "birch_door";
	public static String BIRCH_FENCE = "birch_fence";
	public static String BIRCH_TRAPDOOR = "birch_trapdoor";

	public static String DARK_OAK_PLANKS = "dark_oak_planks";
	public static String DARK_OAK_SLAB = "dark_oak_slab";
	public static String DARK_OAK_STAIRS = "dark_oak_stairs";
	public static String DARK_OAK_DOOR = "dark_oak_door";
	public static String DARK_OAK_FENCE = "dark_oak_fence";
	public static String DARK_OAK_TRAPDOOR = "dark_oak_trapdoor";

	public static String JUNGLE_PLANKS = "jungle_planks";
	public static String JUNGLE_SLAB = "jungle_slab";
	public static String JUNGLE_STAIRS = "jungle_stairs";
	public static String JUNGLE_DOOR = "jungle_door";
	public static String JUNGLE_FENCE = "jungle_fence";
	public static String JUNGLE_TRAPDOOR = "jungle_trapdoor";

	public static String OAK_PLANKS = "oak_planks";
	public static String OAK_SLAB = "oak_slab";
	public static String OAK_STAIRS = "oak_stairs";
	public static String OAK_DOOR = "oak_door";
	public static String OAK_FENCE = "oak_fence";
	public static String OAK_TRAPDOOR = "oak_trapdoor";

	public static String SPRUCE_PLANKS = "spruce_planks";
	public static String SPRUCE_SLAB = "spruce_slab";
	public static String SPRUCE_STAIRS = "spruce_stairs";
	public static String SPRUCE_DOOR = "spruce_door";
	public static String SPRUCE_FENCE = "spruce_fence";
	public static String SPRUCE_TRAPDOOR = "spruce_trapdoor";

	public static String CRIMSON_PLANKS = "crimson_planks";
	public static String CRIMSON_SLAB = "crimson_slab";
	public static String CRIMSON_STAIRS = "crimson_stairs";
	public static String CRIMSON_DOOR = "crimson_door";
	public static String CRIMSON_FENCE = "crimson_fence";
	public static String CRIMSON_TRAPDOOR = "crimson_trapdoor";

	public static String WARPED_PLANKS = "warped_planks";
	public static String WARPED_SLAB = "warped_slab";
	public static String WARPED_STAIRS = "warped_stairs";
	public static String WARPED_DOOR = "warped_door";
	public static String WARPED_FENCE = "warped_fence";
	public static String WARPED_TRAPDOOR = "warped_trapdoor";

	public static void onGatherJsonData(DataGenerator generator) {
		TagBuilder tagBuilder = new TagBuilder(REFERENCE_PLANKS, TagBuilder.TagType.VANILLA_BLOCK_ITEM);
		tagBuilder.add(Blocks.COLORED_ACACIA_PLANKS);
		tagBuilder.add(Blocks.COLORED_BIRCH_PLANKS);
		tagBuilder.add(Blocks.COLORED_DARK_OAK_PLANKS);
		tagBuilder.add(Blocks.COLORED_JUNGLE_PLANKS);
		tagBuilder.add(Blocks.COLORED_OAK_PLANKS);
		tagBuilder.add(Blocks.COLORED_SPRUCE_PLANKS);
		tagBuilder.add(Blocks.COLORED_CRIMSON_PLANKS);
		tagBuilder.add(Blocks.COLORED_WARPED_PLANKS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(REFERENCE_WOODEN_FENCES, TagBuilder.TagType.VANILLA_BLOCK_ITEM);
		tagBuilder.add(Blocks.COLORED_ACACIA_FENCE);
		tagBuilder.add(Blocks.COLORED_BIRCH_FENCE);
		tagBuilder.add(Blocks.COLORED_DARK_OAK_FENCE);
		tagBuilder.add(Blocks.COLORED_JUNGLE_FENCE);
		tagBuilder.add(Blocks.COLORED_OAK_FENCE);
		tagBuilder.add(Blocks.COLORED_SPRUCE_FENCE);
		tagBuilder.add(Blocks.COLORED_CRIMSON_FENCE);
		tagBuilder.add(Blocks.COLORED_WARPED_FENCE);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(REFERENCE_FENCES, TagBuilder.TagType.VANILLA_BLOCK_ITEM);
		tagBuilder.add(Blocks.GLASS_FENCE);
		tagBuilder.add(Blocks.COLORED_GLASS_FENCE);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(ACACIA_PLANKS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_ACACIA_PLANKS);
		tagBuilder.add(Blocks.COLORED_ACACIA_PLANKS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(ACACIA_SLAB, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_ACACIA_SLAB);
		tagBuilder.add(Blocks.COLORED_ACACIA_SLAB);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(ACACIA_STAIRS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_ACACIA_STAIRS);
		tagBuilder.add(Blocks.COLORED_ACACIA_STAIRS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(ACACIA_DOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_ACACIA_DOOR);
		tagBuilder.add(Blocks.COLORED_ACACIA_DOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(ACACIA_FENCE, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_ACACIA_FENCE);
		tagBuilder.add(Blocks.COLORED_ACACIA_FENCE);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(ACACIA_TRAPDOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_ACACIA_TRAPDOOR);
		tagBuilder.add(Blocks.COLORED_ACACIA_TRAPDOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(BIRCH_PLANKS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_BIRCH_PLANKS);
		tagBuilder.add(Blocks.COLORED_BIRCH_PLANKS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(BIRCH_SLAB, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_BIRCH_SLAB);
		tagBuilder.add(Blocks.COLORED_BIRCH_SLAB);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(BIRCH_STAIRS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_BIRCH_STAIRS);
		tagBuilder.add(Blocks.COLORED_BIRCH_STAIRS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(BIRCH_DOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_BIRCH_DOOR);
		tagBuilder.add(Blocks.COLORED_BIRCH_DOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(BIRCH_FENCE, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_BIRCH_FENCE);
		tagBuilder.add(Blocks.COLORED_BIRCH_FENCE);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(BIRCH_TRAPDOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_BIRCH_TRAPDOOR);
		tagBuilder.add(Blocks.COLORED_BIRCH_TRAPDOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(DARK_OAK_PLANKS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_DARK_OAK_PLANKS);
		tagBuilder.add(Blocks.COLORED_DARK_OAK_PLANKS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(DARK_OAK_SLAB, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_DARK_OAK_SLAB);
		tagBuilder.add(Blocks.COLORED_DARK_OAK_SLAB);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(DARK_OAK_STAIRS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_DARK_OAK_STAIRS);
		tagBuilder.add(Blocks.COLORED_DARK_OAK_STAIRS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(DARK_OAK_DOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_DARK_OAK_DOOR);
		tagBuilder.add(Blocks.COLORED_DARK_OAK_DOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(DARK_OAK_FENCE, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_DARK_OAK_FENCE);
		tagBuilder.add(Blocks.COLORED_DARK_OAK_FENCE);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(DARK_OAK_TRAPDOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_DARK_OAK_TRAPDOOR);
		tagBuilder.add(Blocks.COLORED_DARK_OAK_TRAPDOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(JUNGLE_PLANKS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_JUNGLE_PLANKS);
		tagBuilder.add(Blocks.COLORED_JUNGLE_PLANKS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(JUNGLE_SLAB, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_JUNGLE_SLAB);
		tagBuilder.add(Blocks.COLORED_JUNGLE_SLAB);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(JUNGLE_STAIRS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_JUNGLE_STAIRS);
		tagBuilder.add(Blocks.COLORED_JUNGLE_STAIRS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(JUNGLE_DOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_JUNGLE_DOOR);
		tagBuilder.add(Blocks.COLORED_JUNGLE_DOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(JUNGLE_FENCE, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_JUNGLE_FENCE);
		tagBuilder.add(Blocks.COLORED_JUNGLE_FENCE);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(JUNGLE_TRAPDOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_JUNGLE_TRAPDOOR);
		tagBuilder.add(Blocks.COLORED_JUNGLE_TRAPDOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(OAK_PLANKS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_OAK_PLANKS);
		tagBuilder.add(Blocks.COLORED_OAK_PLANKS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(OAK_SLAB, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_OAK_SLAB);
		tagBuilder.add(Blocks.COLORED_OAK_SLAB);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(OAK_STAIRS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_OAK_STAIRS);
		tagBuilder.add(Blocks.COLORED_OAK_STAIRS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(OAK_DOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_OAK_DOOR);
		tagBuilder.add(Blocks.COLORED_OAK_DOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(OAK_FENCE, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_OAK_FENCE);
		tagBuilder.add(Blocks.COLORED_OAK_FENCE);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(OAK_TRAPDOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_OAK_TRAPDOOR);
		tagBuilder.add(Blocks.COLORED_OAK_TRAPDOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(SPRUCE_PLANKS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_SPRUCE_PLANKS);
		tagBuilder.add(Blocks.COLORED_SPRUCE_PLANKS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(SPRUCE_SLAB, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_SPRUCE_SLAB);
		tagBuilder.add(Blocks.COLORED_SPRUCE_SLAB);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(SPRUCE_STAIRS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_SPRUCE_STAIRS);
		tagBuilder.add(Blocks.COLORED_SPRUCE_STAIRS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(SPRUCE_DOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_SPRUCE_DOOR);
		tagBuilder.add(Blocks.COLORED_SPRUCE_DOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(SPRUCE_FENCE, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_SPRUCE_FENCE);
		tagBuilder.add(Blocks.COLORED_SPRUCE_FENCE);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(SPRUCE_TRAPDOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_SPRUCE_TRAPDOOR);
		tagBuilder.add(Blocks.COLORED_SPRUCE_TRAPDOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(CRIMSON_PLANKS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_CRIMSON_PLANKS);
		tagBuilder.add(Blocks.COLORED_CRIMSON_PLANKS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(CRIMSON_SLAB, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_CRIMSON_SLAB);
		tagBuilder.add(Blocks.COLORED_CRIMSON_SLAB);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(CRIMSON_STAIRS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_CRIMSON_STAIRS);
		tagBuilder.add(Blocks.COLORED_CRIMSON_STAIRS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(CRIMSON_DOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_CRIMSON_DOOR);
		tagBuilder.add(Blocks.COLORED_CRIMSON_DOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(CRIMSON_FENCE, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_CRIMSON_FENCE);
		tagBuilder.add(Blocks.COLORED_CRIMSON_FENCE);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(CRIMSON_TRAPDOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_CRIMSON_TRAPDOOR);
		tagBuilder.add(Blocks.COLORED_CRIMSON_TRAPDOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(WARPED_PLANKS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_WARPED_PLANKS);
		tagBuilder.add(Blocks.COLORED_WARPED_PLANKS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(WARPED_SLAB, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_WARPED_SLAB);
		tagBuilder.add(Blocks.COLORED_WARPED_SLAB);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(WARPED_STAIRS, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_WARPED_STAIRS);
		tagBuilder.add(Blocks.COLORED_WARPED_STAIRS);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(WARPED_DOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_WARPED_DOOR);
		tagBuilder.add(Blocks.COLORED_WARPED_DOOR);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(WARPED_FENCE, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_WARPED_FENCE);
		tagBuilder.add(Blocks.COLORED_WARPED_FENCE);
		tagBuilder.generate(generator);

		tagBuilder = new TagBuilder(WARPED_TRAPDOOR, TagBuilder.TagType.BLOCK_ITEM);
		tagBuilder.add(Blocks.REFERENCE_WARPED_TRAPDOOR);
		tagBuilder.add(Blocks.COLORED_WARPED_TRAPDOOR);
		tagBuilder.generate(generator);
	}
}
