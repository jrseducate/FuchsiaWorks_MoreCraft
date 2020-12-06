package com.fuchsiaworks.morecraft;

import java.util.ArrayList;

import com.google.common.base.Supplier;

public class Utils {
	@SafeVarargs
	public static <T> ArrayList<T> ToList(T... items) {
		ArrayList<T> list = new ArrayList<>();

		for (int i = 0; i < items.length; i++) {
			list.add(items[i]);
		}

		return list;
	}

	public static <T> T Init(Supplier<T> callback) {
		return callback.get();
	}
}
