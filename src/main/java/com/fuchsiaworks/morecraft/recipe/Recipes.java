package com.fuchsiaworks.morecraft.recipe;

import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.Utils;
import com.fuchsiaworks.morecraft.block.Blocks;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;
import com.fuchsiaworks.morecraft.item.Items;
import com.fuchsiaworks.morecraft.tag.Tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;

public class Recipes {
	public static IRecipeType<BasicCraftingBlockRecipe> BASIC_CRAFTING_BLOCK = register("basic_crafting_block");

	public static void RegisterRecipes(final RegistryEvent.Register<IRecipeSerializer<?>> recipeRegistryEvent) {
		recipeRegistryEvent.getRegistry()
				.register(BasicCraftingBlockRecipe.SERIALIZER = new BasicCraftingBlockRecipe.RecipeSerializer<>(
						BasicCraftingBlockRecipe::new)
								.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "basic_crafting_block")));
	}

	static <T extends IRecipe<?>> IRecipeType<T> register(final String key) {
		return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(MoreCraft.MOD_ID, key),
				new IRecipeType<T>() {
					public String toString() {
						return key;
					}
				});
	}

	public static void generateChoppingBlockRecipe(DataGenerator generator, String name, ItemStack inputItem, int hits,
			ItemStack... resultItems) {
		JsonDataGenerator.generateBasicCraftingBlockRecipe(generator, name, "chopping_block", inputItem,
				Utils.ToList(resultItems), hits);
	}

	public static void generateChoppingBlockRecipe(DataGenerator generator, Item inputItem, int inputCount, Item result,
			int resultCount, int hits) {
		String type = "chopping_block";
		JsonDataGenerator.generateBasicCraftingBlockRecipe(generator,
				inputItem.getRegistryName().getPath() + "_" + type, type, new ItemStack(inputItem, inputCount),
				Utils.ToList(new ItemStack(result, resultCount)), hits);
	}

	public static void generateChurningBlockRecipe(DataGenerator generator, String name, ItemStack inputItem, int hits,
			ItemStack... resultItems) {
		JsonDataGenerator.generateBasicCraftingBlockRecipe(generator, name, "churning_block", inputItem,
				Utils.ToList(resultItems), hits);
	}

	public static void generateChurningBlockRecipe(DataGenerator generator, ItemStack inputItem, int hits,
			ItemStack... resultItems) {
		String type = "churning_block";
		JsonDataGenerator.generateBasicCraftingBlockRecipe(generator,
				inputItem.getItem().getRegistryName().getPath() + "_" + type, type, inputItem,
				Utils.ToList(resultItems), hits);
	}

	public static void onGatherJsonData(DataGenerator generator) {
		Blocks.COLORED_ACACIA_PLANKS.generateRecipesJson(generator, Tags.ACACIA_PLANKS);
		Blocks.COLORED_ACACIA_SLAB.generateRecipesJson(generator, Tags.ACACIA_SLAB, Blocks.COLORED_ACACIA_PLANKS);
		Blocks.COLORED_ACACIA_STAIRS.generateRecipesJson(generator, Tags.ACACIA_STAIRS, Blocks.COLORED_ACACIA_PLANKS);
		// Blocks.COLORED_ACACIA_DOOR.generateRecipesJson(generator,
		// Tags.ACACIA_DOOR, Blocks.COLORED_ACACIA_PLANKS);
		Blocks.COLORED_ACACIA_FENCE.generateRecipesJson(generator, Tags.ACACIA_FENCE, Blocks.COLORED_ACACIA_PLANKS);
		Blocks.COLORED_ACACIA_TRAPDOOR.generateRecipesJson(generator, Tags.ACACIA_TRAPDOOR,
				Blocks.COLORED_ACACIA_PLANKS);

		Blocks.COLORED_BIRCH_PLANKS.generateRecipesJson(generator, Tags.BIRCH_PLANKS);
		Blocks.COLORED_BIRCH_SLAB.generateRecipesJson(generator, Tags.BIRCH_SLAB, Blocks.COLORED_BIRCH_PLANKS);
		Blocks.COLORED_BIRCH_STAIRS.generateRecipesJson(generator, Tags.BIRCH_STAIRS, Blocks.COLORED_BIRCH_PLANKS);
		// Blocks.COLORED_BIRCH_DOOR.generateRecipesJson(generator,
		// Tags.BIRCH_DOOR, Blocks.COLORED_BIRCH_PLANKS);
		Blocks.COLORED_BIRCH_FENCE.generateRecipesJson(generator, Tags.BIRCH_FENCE, Blocks.COLORED_BIRCH_PLANKS);
		Blocks.COLORED_BIRCH_TRAPDOOR.generateRecipesJson(generator, Tags.BIRCH_TRAPDOOR, Blocks.COLORED_BIRCH_PLANKS);

		Blocks.COLORED_DARK_OAK_PLANKS.generateRecipesJson(generator, Tags.DARK_OAK_PLANKS);
		Blocks.COLORED_DARK_OAK_SLAB.generateRecipesJson(generator, Tags.DARK_OAK_SLAB, Blocks.COLORED_DARK_OAK_PLANKS);
		Blocks.COLORED_DARK_OAK_STAIRS.generateRecipesJson(generator, Tags.DARK_OAK_STAIRS,
				Blocks.COLORED_DARK_OAK_PLANKS);
		// Blocks.COLORED_DARK_OAK_DOOR.generateRecipesJson(generator,
		// Tags.DARK_OAK_DOOR, Blocks.COLORED_DARK_OAK_PLANKS);
		Blocks.COLORED_DARK_OAK_FENCE.generateRecipesJson(generator, Tags.DARK_OAK_FENCE,
				Blocks.COLORED_DARK_OAK_PLANKS);
		Blocks.COLORED_DARK_OAK_TRAPDOOR.generateRecipesJson(generator, Tags.DARK_OAK_TRAPDOOR,
				Blocks.COLORED_DARK_OAK_PLANKS);

		Blocks.COLORED_JUNGLE_PLANKS.generateRecipesJson(generator, Tags.JUNGLE_PLANKS);
		Blocks.COLORED_JUNGLE_SLAB.generateRecipesJson(generator, Tags.JUNGLE_SLAB, Blocks.COLORED_JUNGLE_PLANKS);
		Blocks.COLORED_JUNGLE_STAIRS.generateRecipesJson(generator, Tags.JUNGLE_STAIRS, Blocks.COLORED_JUNGLE_PLANKS);
		// Blocks.COLORED_JUNGLE_DOOR.generateRecipesJson(generator,
		// Tags.JUNGLE_DOOR, Blocks.COLORED_JUNGLE_PLANKS);
		Blocks.COLORED_JUNGLE_FENCE.generateRecipesJson(generator, Tags.JUNGLE_FENCE, Blocks.COLORED_JUNGLE_PLANKS);
		Blocks.COLORED_JUNGLE_TRAPDOOR.generateRecipesJson(generator, Tags.JUNGLE_TRAPDOOR,
				Blocks.COLORED_JUNGLE_PLANKS);

		Blocks.COLORED_OAK_PLANKS.generateRecipesJson(generator, Tags.OAK_PLANKS);
		Blocks.COLORED_OAK_SLAB.generateRecipesJson(generator, Tags.OAK_SLAB, Blocks.COLORED_OAK_PLANKS);
		Blocks.COLORED_OAK_STAIRS.generateRecipesJson(generator, Tags.OAK_STAIRS, Blocks.COLORED_OAK_PLANKS);
		// Blocks.COLORED_OAK_DOOR.generateRecipesJson(generator, Tags.OAK_DOOR,
		// Blocks.COLORED_OAK_PLANKS);
		Blocks.COLORED_OAK_FENCE.generateRecipesJson(generator, Tags.OAK_FENCE, Blocks.COLORED_OAK_PLANKS);
		Blocks.COLORED_OAK_TRAPDOOR.generateRecipesJson(generator, Tags.OAK_TRAPDOOR, Blocks.COLORED_OAK_PLANKS);

		Blocks.COLORED_SPRUCE_PLANKS.generateRecipesJson(generator, Tags.SPRUCE_PLANKS);
		Blocks.COLORED_SPRUCE_SLAB.generateRecipesJson(generator, Tags.SPRUCE_SLAB, Blocks.COLORED_SPRUCE_SLAB);
		Blocks.COLORED_SPRUCE_STAIRS.generateRecipesJson(generator, Tags.SPRUCE_STAIRS, Blocks.COLORED_SPRUCE_SLAB);
		// Blocks.COLORED_SPRUCE_DOOR.generateRecipesJson(generator,
		// Tags.SPRUCE_DOOR, Blocks.COLORED_SPRUCE_SLAB);
		Blocks.COLORED_SPRUCE_FENCE.generateRecipesJson(generator, Tags.SPRUCE_FENCE, Blocks.COLORED_SPRUCE_SLAB);
		Blocks.COLORED_SPRUCE_TRAPDOOR.generateRecipesJson(generator, Tags.SPRUCE_TRAPDOOR, Blocks.COLORED_SPRUCE_SLAB);

		Blocks.COLORED_CRIMSON_PLANKS.generateRecipesJson(generator, Tags.CRIMSON_PLANKS);
		Blocks.COLORED_CRIMSON_SLAB.generateRecipesJson(generator, Tags.CRIMSON_SLAB, Blocks.COLORED_CRIMSON_PLANKS);
		Blocks.COLORED_CRIMSON_STAIRS.generateRecipesJson(generator, Tags.CRIMSON_STAIRS,
				Blocks.COLORED_CRIMSON_PLANKS);
		// Blocks.COLORED_CRIMSON_DOOR.generateRecipesJson(generator,
		// Tags.CRIMSON_DOOR, Blocks.COLORED_CRIMSON_PLANKS);
		Blocks.COLORED_CRIMSON_FENCE.generateRecipesJson(generator, Tags.CRIMSON_FENCE, Blocks.COLORED_CRIMSON_PLANKS);
		Blocks.COLORED_CRIMSON_TRAPDOOR.generateRecipesJson(generator, Tags.CRIMSON_TRAPDOOR,
				Blocks.COLORED_CRIMSON_PLANKS);

		Blocks.COLORED_WARPED_PLANKS.generateRecipesJson(generator, Tags.WARPED_PLANKS);
		Blocks.COLORED_WARPED_SLAB.generateRecipesJson(generator, Tags.WARPED_SLAB, Blocks.COLORED_WARPED_PLANKS);
		Blocks.COLORED_WARPED_STAIRS.generateRecipesJson(generator, Tags.WARPED_STAIRS, Blocks.COLORED_WARPED_PLANKS);
		// Blocks.COLORED_WARPED_DOOR.generateRecipesJson(generator,
		// Tags.WARPED_DOOR, Blocks.COLORED_WARPED_PLANKS);
		Blocks.COLORED_WARPED_FENCE.generateRecipesJson(generator, Tags.WARPED_FENCE, Blocks.COLORED_WARPED_PLANKS);
		Blocks.COLORED_WARPED_TRAPDOOR.generateRecipesJson(generator, Tags.WARPED_TRAPDOOR,
				Blocks.COLORED_WARPED_PLANKS);

		generateChoppingBlockRecipe(generator, Items.REFERENCE_BEEF, 1, Items.BEEF_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_CHICKEN, 1, Items.CHICKEN_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_COD, 1, Items.COD_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_MUTTON, 1, Items.MUTTON_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_PORKCHOP, 1, Items.PORKCHOP_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_RABBIT, 1, Items.RABBIT_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_SALMON, 1, Items.SALMON_DICED, 4, 5);

		generateChoppingBlockRecipe(generator, Items.REFERENCE_BEETROOT, 1, Items.BEETROOT_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_CARROT, 1, Items.CARROT_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_POTATO, 1, Items.POTATO_DICED, 4, 5);

		generateChoppingBlockRecipe(generator, Items.REFERENCE_COOKED_BEEF, 1, Items.COOKED_BEEF_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_COOKED_CHICKEN, 1, Items.COOKED_CHICKEN_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_COOKED_COD, 1, Items.COOKED_COD_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_COOKED_MUTTON, 1, Items.COOKED_MUTTON_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_COOKED_PORKCHOP, 1, Items.COOKED_PORKCHOP_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_COOKED_RABBIT, 1, Items.COOKED_RABBIT_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_COOKED_SALMON, 1, Items.COOKED_SALMON_DICED, 4, 5);

		generateChoppingBlockRecipe(generator, Items.COOKED_BEETROOT, 1, Items.COOKED_BEETROOT_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.COOKED_CARROT, 1, Items.COOKED_CARROT_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.REFERENCE_BAKED_POTATO, 1, Items.BAKED_POTATO_DICED, 4, 5);

		generateChoppingBlockRecipe(generator, Items.CROP_ONION, 1, Items.CROP_ONION_DICED, 4, 5);
		generateChoppingBlockRecipe(generator, Items.CROP_BROCCOLI, 1, Items.CROP_BROCCOLI_DICED, 4, 5);

		generateChurningBlockRecipe(generator, new ItemStack(Items.REFERENCE_MILK_BUCKET), 5,
				new ItemStack(Items.BUTTER, 2), new ItemStack(Items.REFERENCE_BUCKET));
	}
}
