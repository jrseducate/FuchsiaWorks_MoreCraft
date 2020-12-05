package com.fuchsiaworks.morecraft;

import java.util.ArrayList;

import com.fuchsiaworks.morecraft.block.ColoredBlockHelper;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator.JsonDataProvider;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;

public class TagBuilder {
	public static enum TagType {
		VANILLA_BLOCK(JsonDataGenerator.DATA_VANILLA_TAGS_BLOCK_PATH),
		VANILLA_ITEM(JsonDataGenerator.DATA_VANILLA_TAGS_ITEM_PATH),
		
		BLOCK(JsonDataGenerator.DATA_TAGS_BLOCK_PATH),
		ITEM(JsonDataGenerator.DATA_TAGS_ITEM_PATH);
		
		String path;
		
		TagType(String path) {
			this.path = path;
		}
		
		public static TagType[] BLOCK_ITEM = new TagType[] {
			BLOCK,
			ITEM
		};
		
		public static TagType[] VANILLA_BLOCK_ITEM = new TagType[] {
			VANILLA_BLOCK,
			VANILLA_ITEM
		};
	}
	
	public TagType[] types;
	public String tag;
	public boolean replace;
	public ArrayList<String> ids;
	
	public TagBuilder(String tag, TagType... types) {
		this(tag, false, types);
	}
	
	public TagBuilder(String tag, boolean replace, TagType... types) {
		this.types = types;
		this.tag = tag;
		this.replace = replace;
		
		ids = new ArrayList<>();
	}
	
	public TagBuilder add(Item item) {
		ids.add(item.getRegistryName().toString());
		
		return this;
	}
	
	public TagBuilder add(Block block) {
		ids.add(block.getRegistryName().toString());
		
		return this;
	}
	
	public TagBuilder add(ColoredBlockHelper coloredBlockHelper) {
		coloredBlockHelper.eachBlock((block, color) -> {
			ids.add(block.getRegistryName().toString());
		});
		
		return this;
	}
	
	public void generate(DataGenerator generator) {
		ArrayList<JsonDataProvider> providers = getTagDataProvider();
		
		for(int i = 0; i < providers.size(); i++) {
			providers.get(i).generate(generator);
		}
	}
	
	public ArrayList<JsonDataProvider> getTagDataProvider() {
		ArrayList<JsonDataProvider> providers = new ArrayList<>();
		
		for(int i = 0; i < types.length; i++) {
			TagType type = types[i];
			
			providers.add(new JsonDataProvider(type.path + tag + ".json", () -> {
				return JsonBuilder.newObject((json) -> {
					json.add("replace", replace);
					json.addArray("values", (values) -> {
						for(int j = 0; j < ids.size(); j++) {
							values.add(ids.get(j));
						}
					});
				}).build();
			}));
		}
		
		return providers;
	}
}
