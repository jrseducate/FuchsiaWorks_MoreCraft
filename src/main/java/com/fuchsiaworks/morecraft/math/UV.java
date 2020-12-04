package com.fuchsiaworks.morecraft.math;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class UV {
	public float uMin;
	public float vMin;
	public float uMax;
	public float vMax;

	public UV(float uMin, float vMin, float uMax, float vMax) {
		this.uMin = uMin;
		this.vMin = vMin;
		this.uMax = uMax;
		this.vMax = vMax;
	}

	public UV(TextureAtlasSprite sprite) {
		this(sprite.getMinU(), sprite.getMinV(), sprite.getMaxU(), sprite.getMaxV());
	}

	public Vector2f getUVMin() {
		return getVector().set(uMin, vMin);
	}

	public Vector2f getUVMax() {
		return getVector().set(uMax, vMax);
	}

	public Vector2f getUMinVMax() {
		return getVector().set(uMin, vMax);
	}

	public Vector2f getUMaxVMin() {
		return getVector().set(uMax, vMin);
	}

	public Vector2f get(int uMax, int vMax) {
		return get(uMax != 0, vMax != 0);
	}

	public Vector2f get(boolean uMax, boolean vMax) {
		if (!uMax && !vMax)
			return getUVMin();

		if (!uMax && vMax)
			return getUMinVMax();

		if (uMax && !vMax)
			return getUMaxVMin();

		return getUVMax();
	}

	public Vector2f buffer;

	public Vector2f getVector() {
		return buffer != null ? buffer : new Vector2f();
	}

	public UV bindBuffer() {
		buffer = new Vector2f();

		buffer.buffer = buffer;

		return this;
	}

	public UV unbindBuffer() {
		buffer.buffer = null;

		buffer = null;

		return this;
	}
}