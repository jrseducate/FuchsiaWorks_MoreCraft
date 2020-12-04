package com.fuchsiaworks.morecraft.math;

public class Vector3f {
	public float x, y, z;

	public Vector3f() {
	}

	public Vector3f(float x, float y, float z) {
		set(x, y, z);
	}

	public Vector3f set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;

		return this;
	}

	public Vector3f getX() {
		return new Vector3f(x, 0, 0);
	}

	public Vector3f getY() {
		return new Vector3f(0, y, 0);
	}

	public Vector3f getZ() {
		return new Vector3f(0, 0, z);
	}

	public Vector3f getXY() {
		return new Vector3f(x, y, 0);
	}

	public Vector3f getYZ() {
		return new Vector3f(0, y, z);
	}

	public Vector3f getXZ() {
		return new Vector3f(x, 0, z);
	}

	public Vector3f get(int x, int y, int z) {
		return get(x != 0, y != 0, z != 0);
	}

	public Vector3f get(boolean x, boolean y, boolean z) {
		return getVector().set(x ? this.x : 0, y ? this.y : 0, z ? this.z : 0);
	}

	public Vector3f add(Vector3f other) {
		return getVector().set(this.x + other.x, this.y + other.y, this.z + other.z);
	}

	public Vector3f add(float x, float y, float z) {
		return getVector().set(this.x + x, this.y + y, this.z + z);
	}

	public Vector3f buffer;

	public Vector3f getVector() {
		return buffer != null ? buffer : new Vector3f();
	}

	public Vector3f bindBuffer() {
		buffer = new Vector3f();

		buffer.buffer = buffer;

		return this;
	}

	public Vector3f unbindBuffer() {
		buffer.buffer = null;

		buffer = null;

		return this;
	}
}