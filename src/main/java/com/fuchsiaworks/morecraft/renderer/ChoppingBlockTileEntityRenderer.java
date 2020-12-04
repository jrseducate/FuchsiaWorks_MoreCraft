package com.fuchsiaworks.morecraft.renderer;

import com.fuchsiaworks.morecraft.tile_entity.ChoppingBlockTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ChoppingBlockTileEntityRenderer<T extends TileEntity> extends TileEntityRenderer<T> {
	public static class ItemEntityNoHover extends ItemEntity {
		public ItemEntityNoHover(World worldIn, double x, double y, double z, ItemStack stack) {
			super(worldIn, x, y, z, stack);
		}

		@OnlyIn(Dist.CLIENT)
		public float func_234272_a_(float p_234272_1_) {
			return 0.0f;
		}
	}

	ItemEntity itemEntity = null;

	public ChoppingBlockTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(T tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer,
			int combinedLight, int combinedOverlay) {
		ChoppingBlockTileEntity choppingBlockTileEntity = (ChoppingBlockTileEntity) tileEntity;

		World world = tileEntity.getWorld();
		BlockPos blockPos = tileEntity.getPos();
		Vector3d position = new Vector3d(blockPos.getX(), blockPos.getY(), blockPos.getZ());

		if ((itemEntity == null)
				|| itemEntity.getItem().getItem() != choppingBlockTileEntity.getStackInSlot(0).getItem()) {
			itemEntity = new ItemEntityNoHover(world, position.x, position.y, position.z,
					choppingBlockTileEntity.getStackInSlot(0));
		}

		if (itemEntity != null) {
			Minecraft minecraft = Minecraft.getInstance();
			EntityRendererManager renderManager = minecraft.getRenderManager();

			matrixStack.push();

			matrixStack.translate(0.5D, 0.8D + (Math.sin(minecraft.world.getGameTime() * 0.35f) * 0.025f), 0.2D);
			matrixStack.rotate(new Quaternion(90.0f, 0.0f, 0.0f, true));
			renderManager.renderEntityStatic(itemEntity, 0.0f, 0.0f, 0.0f, 0.0F, 0.0f, matrixStack, buffer,
					combinedLight);

			matrixStack.pop();
		}
	}
}
