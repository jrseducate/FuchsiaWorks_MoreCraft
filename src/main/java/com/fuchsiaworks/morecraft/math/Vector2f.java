package com.fuchsiaworks.morecraft.math;

public class Vector2f {
	public float x, y;

	public Vector2f() {
	}

	public Vector2f(float x, float y) {
		set(x, y);
	}

	public Vector2f set(float x, float y) {
		this.x = x;
		this.y = y;

		return this;
	}

	public Vector2f add(float x, float y) {
		return getVector().set(this.x + x, this.y + y);
	}

	public Vector2f scale(float x, float y) {
		return getVector().set(this.x * x, this.y * y);
	}

	public Vector2f buffer;

	public Vector2f getVector() {
		return buffer != null ? buffer : new Vector2f();
	}

	public Vector2f bindBuffer() {
		buffer = new Vector2f();

		buffer.buffer = buffer;

		return this;
	}

	public Vector2f unbindBuffer() {
		buffer.buffer = null;

		buffer = null;

		return this;
	}
}