package com.fuchsiaworks.morecraft.renderer;

import com.fuchsiaworks.morecraft.math.UV;
import com.fuchsiaworks.morecraft.math.Vector2f;
import com.fuchsiaworks.morecraft.math.Vector3f;
import com.fuchsiaworks.morecraft.tile_entity.ChurningBlockTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class ChurningBlockTileEntityRenderer<T extends TileEntity> extends TileEntityRenderer<T> {
	public ChurningBlockTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);

		progress = 0;
	}

	int progress;

	@Override
	public void render(T tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer,
			int combinedLight, int combinedOverlay) {
		ChurningBlockTileEntity churningBlockTileEntity = (ChurningBlockTileEntity) tileEntity;

		if (churningBlockTileEntity.progress > progress) {
			progress++;
		} else if (churningBlockTileEntity.progress < progress) {
			progress = churningBlockTileEntity.progress;
		}

		Minecraft minecraft = Minecraft.getInstance();
		TextureAtlasSprite sprite = minecraft.getAtlasSpriteGetter(PlayerContainer.LOCATION_BLOCKS_TEXTURE)
				.apply(new ResourceLocation("block/oak_planks"));
		IVertexBuilder renderer = buffer.getBuffer(RenderType.getSolid());

		float bobbing = (float) (((Math.sin((progress * 0.2f) + (Math.PI * 1.5f)) + 1) / 2) * 0.35f);
		Vector3f size = new Vector3f(0.15f, 0.9f, 0.15f);
		Vector3f position = new Vector3f(0.5f - (size.x / 2), 0.7f - bobbing, 0.5f - (size.z / 2));
		UV uv = new UV(sprite);

		matrixStack.push();

		renderCube(renderer, matrixStack, position, size, uv);

		matrixStack.pop();
	}

	public void renderCube(IVertexBuilder renderer, MatrixStack stack, Vector3f position, Vector3f size, UV uv) {
		position.bindBuffer();
		size.bindBuffer();
		uv.bindBuffer();

		// XZ Y-
		add(renderer, stack, position.add(size.get(0, 0, 0)), uv.get(0, 0));
		add(renderer, stack, position.add(size.get(1, 0, 0)), uv.get(0, 1));
		add(renderer, stack, position.add(size.get(1, 0, 1)), uv.get(1, 1));
		add(renderer, stack, position.add(size.get(0, 0, 1)), uv.get(1, 0));

		// XZ Y+
		add(renderer, stack, position.add(size.get(0, 1, 0)), uv.get(0, 0));
		add(renderer, stack, position.add(size.get(0, 1, 1)), uv.get(0, 1));
		add(renderer, stack, position.add(size.get(1, 1, 1)), uv.get(1, 1));
		add(renderer, stack, position.add(size.get(1, 1, 0)), uv.get(1, 0));

		// YZ X-
		add(renderer, stack, position.add(size.get(0, 0, 0)), uv.get(0, 0));
		add(renderer, stack, position.add(size.get(0, 0, 1)), uv.get(1, 0));
		add(renderer, stack, position.add(size.get(0, 1, 1)), uv.get(1, 1));
		add(renderer, stack, position.add(size.get(0, 1, 0)), uv.get(0, 1));

		// YZ X+
		add(renderer, stack, position.add(size.get(1, 0, 0)), uv.get(0, 0));
		add(renderer, stack, position.add(size.get(1, 1, 0)), uv.get(0, 1));
		add(renderer, stack, position.add(size.get(1, 1, 1)), uv.get(1, 1));
		add(renderer, stack, position.add(size.get(1, 0, 1)), uv.get(1, 0));

		// XY Z-
		add(renderer, stack, position.add(size.get(0, 0, 0)), uv.get(0, 0));
		add(renderer, stack, position.add(size.get(0, 1, 0)), uv.get(0, 1));
		add(renderer, stack, position.add(size.get(1, 1, 0)), uv.get(1, 1));
		add(renderer, stack, position.add(size.get(1, 0, 0)), uv.get(1, 0));

		// XY Z+
		add(renderer, stack, position.add(size.get(0, 0, 1)), uv.get(0, 0));
		add(renderer, stack, position.add(size.get(1, 0, 1)), uv.get(1, 0));
		add(renderer, stack, position.add(size.get(1, 1, 1)), uv.get(1, 1));
		add(renderer, stack, position.add(size.get(0, 1, 1)), uv.get(0, 1));

		uv.unbindBuffer();
		size.unbindBuffer();
		position.unbindBuffer();
	}

	public void add(IVertexBuilder renderer, MatrixStack stack, Vector3f position, Vector2f uv) {
		renderer.pos(stack.getLast().getMatrix(), position.x, position.y, position.z).color(1.0f, 1.0f, 1.0f, 1.0f)
				.tex(uv.x, uv.y).lightmap(0, 240).normal(1, 0, 0).endVertex();
	}

	// Minecraft.getInstance().getBlockRendererDispatcher().renderBlock(...)
}
