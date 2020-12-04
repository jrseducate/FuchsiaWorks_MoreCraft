package com.fuchsiaworks.morecraft.recipe;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class BasicCraftingBlockRecipe implements IRecipe<IInventory> {
	public static IRecipeSerializer<?> SERIALIZER;

	public ResourceLocation resourceLocation;
	public String type;
	public Ingredient ingredient;
	public List<ItemStack> results;
	public int hits;

	public BasicCraftingBlockRecipe(ResourceLocation resourceLocation, String type, Ingredient ingredient,
			List<ItemStack> results, int hits) {
		this.resourceLocation = resourceLocation;
		this.type = type;
		this.ingredient = ingredient;
		this.results = results;
		this.hits = hits;
	}

	public BasicCraftingBlockRecipe() {
		this.resourceLocation = null;
		this.type = null;
		this.ingredient = null;
		this.results = null;
		this.hits = 0;
	}

	public static class RecipeSerializer<T extends BasicCraftingBlockRecipe>
			extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {
		public BasicCraftingBlockRecipe.IFactory<T> factory;

		public RecipeSerializer(BasicCraftingBlockRecipe.IFactory<T> factory) {
			this.factory = factory;
		}

		@Override
		public T read(ResourceLocation recipeId, JsonObject json) {
			String type = JSONUtils.getString(json, "crafting_type", "chopping_block");

			JsonElement ingredientJSON = JSONUtils.isJsonArray(json, "ingredient")
					? JSONUtils.getJsonArray(json, "ingredient") : JSONUtils.getJsonObject(json, "ingredient");
			Ingredient ingredient = Ingredient.deserialize(ingredientJSON);

			List<ItemStack> results = new ArrayList<>();

			if (json.has("results") && json.get("results").isJsonArray()) {
				JsonArray resultsJson = JSONUtils.getJsonArray(json, "results");

				resultsJson.forEach((resultJson) -> {
					ItemStack result;

					if (resultJson.isJsonObject()) {
						result = ShapedRecipe.deserializeItem(resultJson.getAsJsonObject());
					} else {
						String resultString = resultJson.getAsString();
						ResourceLocation resultRS = new ResourceLocation(resultString);
						result = new ItemStack(ForgeRegistries.ITEMS.getValue(resultRS));
					}

					results.add(result);
				});
			} else {
				ItemStack result;

				if (!json.has("result")) {
					result = ItemStack.EMPTY;
				} else if (json.get("result").isJsonObject()) {
					result = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
				} else {
					String resultString = JSONUtils.getString(json, "result");
					ResourceLocation resultRS = new ResourceLocation(resultString);
					result = new ItemStack(ForgeRegistries.ITEMS.getValue(resultRS));
				}

				results.add(result);
			}

			int hits = JSONUtils.getInt(json, "hits", 5);

			return this.factory.create(recipeId, type, ingredient, results, hits);
		}

		@Override
		public T read(ResourceLocation recipeId, PacketBuffer buffer) {
			String type = buffer.readString();

			Ingredient ingredient = Ingredient.read(buffer);

			List<ItemStack> results = new ArrayList<ItemStack>();
			int size = buffer.readInt();

			for (int i = 0; i < size; i++) {
				results.add(buffer.readItemStack());
			}

			int hits = buffer.readVarInt();

			return this.factory.create(recipeId, type, ingredient, results, hits);
		}

		@Override
		public void write(PacketBuffer buffer, T recipe) {
			buffer.writeString(recipe.type);

			recipe.ingredient.write(buffer);

			buffer.writeInt(recipe.results.size());

			for (ItemStack result : recipe.results) {
				buffer.writeItemStack(result);
			}

			buffer.writeVarInt(recipe.hits);
		}
	}

	@Override
	public boolean matches(IInventory inv, World worldIn) {
		return ingredient.test(inv.getStackInSlot(0));
	}

	@Override
	public ItemStack getCraftingResult(IInventory inv) {
		return null;
	}

	public List<ItemStack> getCraftingResults(IInventory inv) {
		return results;
	}

	@Override
	public boolean canFit(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY;
	}

	@Override
	public ResourceLocation getId() {
		return resourceLocation;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return BasicCraftingBlockRecipe.SERIALIZER;
	}

	@Override
	public IRecipeType<?> getType() {
		return Recipes.BASIC_CRAFTING_BLOCK;
	}

	public interface IFactory<T extends BasicCraftingBlockRecipe> {
		T create(ResourceLocation resourceLocation, String type, Ingredient ingredient, List<ItemStack> results,
				int hits);
	}
}
