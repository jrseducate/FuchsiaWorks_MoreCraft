package com.fuchsiaworks.morecraft.data_gen;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;

import com.fuchsiaworks.morecraft.JsonBuilder;
import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.block.Blocks;
import com.fuchsiaworks.morecraft.item.Items;
import com.fuchsiaworks.morecraft.recipe.Recipes;
import com.fuchsiaworks.morecraft.tag.Tags;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

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
			return JsonBuilder.newObject((json) -> {
				if (prefix == "item") {
					json.add("parent", "minecraft:item/generated");
					json.addObject("textures", (textures) -> {
						textures.add("layer0", MoreCraft.MOD_ID + ":" + prefix + "/" + id);
					});
				} else {
					json.add("parent", MoreCraft.MOD_ID + ":" + prefix + "/" + id);
				}
			}).build();
		}).generate(generator);
	}

	public static void generateItemModelJson(DataGenerator generator, Item item) {
		generateItemModelJson(generator, item, "item");
	}

	public static void generateBlockItemModelJson(DataGenerator generator, Item item) {
		generateItemModelJson(generator, item, "block");
	}

	public static void generateBasicCraftingBlockRecipe(DataGenerator generator, String name, String craftingType,
			ItemStack inputItem, List<ItemStack> resultItems, int hits) {
		new JsonDataGenerator.JsonDataProvider(DATA_RECIPES_PATH + name + ".json", () -> {
			return JsonBuilder.newObject((json) -> {
				json.add("type", MoreCraft.MOD_ID + ":basic_crafting_block");
				json.add("crafting_type", craftingType);
				json.addObject("ingredient", (ingredient) -> {
					ingredient.add("item", inputItem.getItem().getRegistryName().toString());
					ingredient.add("count", inputItem.getCount());
				});
				json.addArray("results", (results) -> {
					for (ItemStack resultItem : resultItems) {
						results.addObject((result) -> {
							result.add("item", resultItem.getItem().getRegistryName().toString());
							result.add("count", resultItem.getCount());
						});
					}
				});
				json.add("hits", hits);
			}).build();
		}).generate(generator);
		;
	}

	public static void onGatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();

		Blocks.onGatherJsonData(generator);
		Items.onGatherJsonData(generator);
		Tags.onGatherJsonData(generator);
		Recipes.onGatherJsonData(generator);
	}
}
