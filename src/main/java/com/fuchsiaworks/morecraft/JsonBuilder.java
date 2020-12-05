package com.fuchsiaworks.morecraft;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.function.Consumer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonBuilder {
	public static enum EntryType {
		BOOLEAN,
		CHARACTER,
		NUMBER,
		STRING,
		ARRAY,
		OBJECT
	}
	
	public static class Entry {
		public EntryType type;
		public java.lang.Object value;
		
		public Entry(java.lang.Object value, EntryType type) {
			this.value = value;
			this.type = type;
		}
		
		public Entry(Boolean value) {
			this(value, EntryType.BOOLEAN);
		}
		
		public Boolean asBoolean() {
			return (Boolean)value;
		}
		
		public Entry(Character value) {
			this(value, EntryType.CHARACTER);
		}
		
		public Character asCharacter() {
			return (Character)value;
		}
		
		public Entry(Number value) {
			this(value, EntryType.NUMBER);
		}
		
		public Number asNumber() {
			return (Number)value;
		}
		
		public Entry(String value) {
			this(value, EntryType.STRING);
		}
		
		public String asString() {
			return (String)value;
		}
		
		public Array asArray() {
			return (Array)this;
		}
		
		public Object asObject() {
			return (Object)this;
		}
	}
	
	public static Array newArray(Consumer<Array> callback) {
		Array array = new Array();
		callback.accept(array);
		
		return array;
	}
	
	public static class Array extends Entry {
		public Array() {
			super(new ArrayList<Entry>(), EntryType.ARRAY);
		}
		
		@SuppressWarnings("unchecked")
		public ArrayList<Entry> getArrayList() {
			return (ArrayList<Entry>)value;
		}
		
		public Array add(Boolean value) {
			getArrayList().add(new Entry(value));
			
			return this;
		}
		
		public Array add(Character value) {
			getArrayList().add(new Entry(value));
			
			return this;
		}
		
		public Array add(Number value) {
			getArrayList().add(new Entry(value));
			
			return this;
		}
		
		public Array add(String value) {
			getArrayList().add(new Entry(value));
			
			return this;
		}
		
		public Array addObject(Consumer<Object> callback) {
			Object object = new Object();
			callback.accept(object);
			getArrayList().add(object);
			
			return this;
		}
		
		public Array addArray(Consumer<Array> callback) {
			Array array = new Array();
			callback.accept(array);
			getArrayList().add(array);
			
			return this;
		}
		
		public JsonArray build() {
			JsonArray array = new JsonArray();
			ArrayList<Entry> list = getArrayList();
			
			for(int i = 0; i < list.size(); i++) {
				Entry entry = list.get(i);
				
				switch(entry.type) {
				case ARRAY:
					array.add(entry.asArray().build());
					break;
				case OBJECT:
					array.add(entry.asObject().build());
					break;
				case BOOLEAN:
					array.add(entry.asBoolean());
					break;
				case CHARACTER:
					array.add(entry.asCharacter());
					break;
				case NUMBER:
					array.add(entry.asNumber());
					break;
				case STRING:
					array.add(entry.asString());
					break;
				}
			}
			
			return array;
		}
	}
	
	public static Object newObject(Consumer<Object> callback) {
		Object object = new Object();
		callback.accept(object);
		
		return object;
	}
	
	public static class Object extends Entry {
		public Object() {
			super(new LinkedHashMap<String, Entry>(), EntryType.OBJECT);
		}
		
		@SuppressWarnings("unchecked")
		public LinkedHashMap<String, Entry> getLinkedHashMap() {
			return (LinkedHashMap<String, Entry>)value;
		}
		
		public Object add(String key, Boolean value) {
			getLinkedHashMap().put(key, new Entry(value));
			
			return this;
		}
		
		public Object add(String key, Character value) {
			getLinkedHashMap().put(key, new Entry(value));
			
			return this;
		}
		
		public Object add(String key, Number value) {
			getLinkedHashMap().put(key, new Entry(value));
			
			return this;
		}
		
		public Object add(String key, String value) {
			getLinkedHashMap().put(key, new Entry(value));
			
			return this;
		}
		
		public Object addObject(String key, Consumer<Object> callback) {
			Object object = new Object();
			callback.accept(object);
			getLinkedHashMap().put(key, object);
			
			return this;
		}
		
		public Object addArray(String key, Consumer<Array> callback) {
			Array array = new Array();
			callback.accept(array);
			getLinkedHashMap().put(key, array);
			
			return this;
		}
		
		public JsonObject build() {
			JsonObject object = new JsonObject();
			LinkedHashMap<String, Entry> map = getLinkedHashMap();
			ArrayList<String> keys = new ArrayList<>(map.keySet());
			
			for(int i = 0; i < map.size(); i++) {
				String key = keys.get(i);
				Entry entry = map.get(key);
				
				switch(entry.type) {
				case ARRAY:
					object.add(key, entry.asArray().build());
					break;
				case OBJECT:
					object.add(key, entry.asObject().build());
					break;
				case BOOLEAN:
					object.addProperty(key, entry.asBoolean());
					break;
				case CHARACTER:
					object.addProperty(key, entry.asCharacter());
					break;
				case NUMBER:
					object.addProperty(key, entry.asNumber());
					break;
				case STRING:
					object.addProperty(key, entry.asString());
					break;
				}
			}
			
			return object;
		}
	}
}
