package com.fuchsiaworks.morecraft.recipe;

import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.Utils;
import com.fuchsiaworks.morecraft.block.Blocks;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;
import com.fuchsiaworks.morecraft.item.Items;

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
	
	public static void generateChoppingBlockRecipe(DataGenerator generator, String name, ItemStack inputItem, int hits, ItemStack... resultItems) {
		JsonDataGenerator.generateBasicCraftingBlockRecipe(generator, name, "chopping_block", inputItem, Utils.ToList(resultItems), hits);
	}
	
	public static void generateChoppingBlockRecipe(DataGenerator generator, Item inputItem, int inputCount, Item result, int resultCount, int hits) {
		String type = "chopping_block";
		JsonDataGenerator.generateBasicCraftingBlockRecipe(generator, inputItem.getRegistryName().getPath() + "_" + type, type, new ItemStack(inputItem, inputCount), Utils.ToList(new ItemStack(result, resultCount)), hits);
	}
	
	public static void generateChurningBlockRecipe(DataGenerator generator, String name, ItemStack inputItem, int hits, ItemStack... resultItems) {
		JsonDataGenerator.generateBasicCraftingBlockRecipe(generator, name, "churning_block", inputItem, Utils.ToList(resultItems), hits);
	}
	
	public static void generateChurningBlockRecipe(DataGenerator generator, ItemStack inputItem, int hits, ItemStack... resultItems) {
		String type = "churning_block";
		JsonDataGenerator.generateBasicCraftingBlockRecipe(generator, inputItem.getItem().getRegistryName().getPath() + "_" + type, type, inputItem, Utils.ToList(resultItems), hits);
	}
	
	public static void onGatherJsonData(DataGenerator generator) {
		Blocks.COLORED_ACACIA_PLANKS.generateRecipesJson(generator, "acacia_planks");
		Blocks.COLORED_ACACIA_SLAB.generateRecipesJson(generator, "acacia_slab", Blocks.COLORED_ACACIA_PLANKS);
		Blocks.COLORED_ACACIA_STAIRS.generateRecipesJson(generator, "acacia_stairs", Blocks.COLORED_ACACIA_PLANKS);
//		Blocks.COLORED_ACACIA_DOOR.generateRecipesJson(generator, "acacia_door", Blocks.COLORED_ACACIA_PLANKS);

		Blocks.COLORED_BIRCH_PLANKS.generateRecipesJson(generator, "birch_planks");
		Blocks.COLORED_BIRCH_SLAB.generateRecipesJson(generator, "birch_slab", Blocks.COLORED_BIRCH_PLANKS);
		Blocks.COLORED_BIRCH_STAIRS.generateRecipesJson(generator, "birch_stairs", Blocks.COLORED_BIRCH_PLANKS);
//		Blocks.COLORED_BIRCH_DOOR.generateRecipesJson(generator, "birch_door", Blocks.COLORED_BIRCH_PLANKS);

		Blocks.COLORED_DARK_OAK_PLANKS.generateRecipesJson(generator, "dark_oak_planks");
		Blocks.COLORED_DARK_OAK_SLAB.generateRecipesJson(generator, "dark_oak_slab", Blocks.COLORED_DARK_OAK_PLANKS);
		Blocks.COLORED_DARK_OAK_STAIRS.generateRecipesJson(generator, "dark_oak_stairs", Blocks.COLORED_DARK_OAK_PLANKS);
//		Blocks.COLORED_DARK_OAK_DOOR.generateRecipesJson(generator, "dark_oak_door", Blocks.COLORED_DARK_OAK_PLANKS);

		Blocks.COLORED_JUNGLE_PLANKS.generateRecipesJson(generator, "jungle_planks");
		Blocks.COLORED_JUNGLE_SLAB.generateRecipesJson(generator, "jungle_slab", Blocks.COLORED_JUNGLE_PLANKS);
		Blocks.COLORED_JUNGLE_STAIRS.generateRecipesJson(generator, "jungle_stairs", Blocks.COLORED_JUNGLE_PLANKS);
//		Blocks.COLORED_JUNGLE_DOOR.generateRecipesJson(generator, "jungle_door", Blocks.COLORED_JUNGLE_PLANKS);

		Blocks.COLORED_OAK_PLANKS.generateRecipesJson(generator, "oak_planks");
		Blocks.COLORED_OAK_SLAB.generateRecipesJson(generator, "oak_slab", Blocks.COLORED_OAK_PLANKS);
		Blocks.COLORED_OAK_STAIRS.generateRecipesJson(generator, "oak_stairs", Blocks.COLORED_OAK_PLANKS);
//		Blocks.COLORED_OAK_DOOR.generateRecipesJson(generator, "oak_door", Blocks.COLORED_OAK_PLANKS);

		Blocks.COLORED_SPRUCE_PLANKS.generateRecipesJson(generator, "spruce_planks");
		Blocks.COLORED_SPRUCE_SLAB.generateRecipesJson(generator, "spruce_slab", Blocks.COLORED_SPRUCE_SLAB);
		Blocks.COLORED_SPRUCE_STAIRS.generateRecipesJson(generator, "spruce_stairs", Blocks.COLORED_SPRUCE_SLAB);
//		Blocks.COLORED_SPRUCE_DOOR.generateRecipesJson(generator, "spruce_door", Blocks.COLORED_SPRUCE_SLAB);

		Blocks.COLORED_CRIMSON_PLANKS.generateRecipesJson(generator, "crimson_planks");
		Blocks.COLORED_CRIMSON_SLAB.generateRecipesJson(generator, "crimson_slab", Blocks.COLORED_CRIMSON_PLANKS);
		Blocks.COLORED_CRIMSON_STAIRS.generateRecipesJson(generator, "crimson_stairs", Blocks.COLORED_CRIMSON_PLANKS);
//		Blocks.COLORED_CRIMSON_DOOR.generateRecipesJson(generator, "crimson_door", Blocks.COLORED_CRIMSON_PLANKS);

		Blocks.COLORED_WARPED_PLANKS.generateRecipesJson(generator, "warped_planks");
		Blocks.COLORED_WARPED_SLAB.generateRecipesJson(generator, "warped_slab", Blocks.COLORED_WARPED_PLANKS);
		Blocks.COLORED_WARPED_STAIRS.generateRecipesJson(generator, "warped_stairs", Blocks.COLORED_WARPED_PLANKS);
//		Blocks.COLORED_WARPED_DOOR.generateRecipesJson(generator, "warped_door", Blocks.COLORED_WARPED_PLANKS);
		
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
		
		generateChurningBlockRecipe(generator, new ItemStack(Items.REFERENCE_MILK_BUCKET), 5, new ItemStack(Items.BUTTER, 2), new ItemStack(Items.REFERENCE_BUCKET));
	}
}
