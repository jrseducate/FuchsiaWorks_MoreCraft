package com.fuchsiaworks.morecraft.data_gen;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;

import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.block.Blocks;
import com.fuchsiaworks.morecraft.item.Items;
import com.fuchsiaworks.morecraft.recipe.Recipes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

public class JsonDataGenerator extends BaseDataGenerator {

	public static class JsonDataProvider implements IDataProvider {

		public DataGenerator generator;
		public String filePath;
		public Supplier<JsonElement> jsonSupplier;

		public JsonDataProvider(String filePath, Supplier<JsonElement> jsonSupplier) {
			this.filePath = filePath;
			this.jsonSupplier = jsonSupplier;
		}

		public JsonDataProvider bind(DataGenerator generator) {
			this.generator = generator;

			return this;
		}
		
		public void generate(DataGenerator generator) {
			generator.addProvider(bind(generator));
		}

		@Override
		public String getName() {
			return filePath;
		}

		@Override
		public void act(DirectoryCache cache) throws IOException {
			Path path = generator.getOutputFolder().resolve(filePath);

			Gson gson = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();

			IDataProvider.save(gson, cache, jsonSupplier.get(), path);
		}
	}
	
	public static void generateItemModelJson(DataGenerator generator, Item item, String prefix) {
		String id = item.getRegistryName().getPath();
		
		new JsonDataProvider(JsonDataGenerator.ASSETS_MODELS_ITEM_PATH + id + ".json", () -> {
			JsonObject json = new JsonObject();
			
			if(prefix == "item") {
				JsonObject textures = new JsonObject();
				
				json.addProperty("parent", "minecraft:item/generated");
				
				textures.addProperty("layer0", MoreCraft.MOD_ID + ":" + prefix + "/" + id);
				
				json.add("textures", textures);
			}
			else {
				json.addProperty("parent", MoreCraft.MOD_ID + ":" + prefix + "/" + id);
			}
			
			return json;
		}).generate(generator);
	}
	
	public static void generateItemModelJson(DataGenerator generator, Item item) {
		generateItemModelJson(generator, item, "item");
	}
	
	public static void generateBlockItemModelJson(DataGenerator generator, Item item) {
		generateItemModelJson(generator, item, "block");
	}
	
	public static void generateBasicCraftingBlockRecipe(DataGenerator generator, String name, String craftingType, ItemStack inputItem, List<ItemStack> resultItems, int hits) {
		new JsonDataGenerator.JsonDataProvider(DATA_RECIPES_PATH + name + ".json", () -> {
			JsonObject json = new JsonObject();
			JsonObject ingredient = new JsonObject();
			JsonArray results = new JsonArray();
			
			json.addProperty("type", MoreCraft.MOD_ID + ":basic_crafting_block");
			json.addProperty("crafting_type", craftingType);
			
			ingredient.addProperty("item", inputItem.getItem().getRegistryName().toString());
			ingredient.addProperty("count", inputItem.getCount());
			
			json.add("ingredient", ingredient);
			
			for(ItemStack resultItem : resultItems) {
				JsonObject result = new JsonObject();
				
				result.addProperty("item", resultItem.getItem().getRegistryName().toString());
				result.addProperty("count", resultItem.getCount());
				
				results.add(result);
			}
			
			json.add("results", results);
			json.addProperty("hits", hits);
			
			return json;
		}).generate(generator);;
	}

	public static void onGatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();

		Blocks.onGatherJsonData(generator);
		Items.onGatherJsonData(generator);
		Recipes.onGatherJsonData(generator);
	}
}
