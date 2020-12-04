package com.fuchsiaworks.morecraft.renderer;

import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.entity.WarlockEntity;
import com.fuchsiaworks.morecraft.entity.WarlockHeldItemLayer;
import com.fuchsiaworks.morecraft.entity.WarlockModel;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class WarlockRenderer extends MobRenderer<WarlockEntity, WarlockModel<WarlockEntity>> {
	private static final ResourceLocation WARLOCK_TEXTURES = new ResourceLocation(MoreCraft.MOD_ID,
			"textures/entity/warlock.png");

	public WarlockRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new WarlockModel<>(0.0F), 0.5F);
		this.addLayer(new WarlockHeldItemLayer<>(this));
	}

	@Override
	public void render(WarlockEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		this.entityModel.func_205074_a(!entityIn.getHeldItemMainhand().isEmpty());
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	/**
	 * Returns the location of an entity's texture.
	 */
	@Override
	public ResourceLocation getEntityTexture(WarlockEntity entity) {
		return WARLOCK_TEXTURES;
	}

	@Override
	protected void preRenderCallback(WarlockEntity entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		matrixStackIn.scale(0.9375F, 0.9375F, 0.9375F);
	}
}
