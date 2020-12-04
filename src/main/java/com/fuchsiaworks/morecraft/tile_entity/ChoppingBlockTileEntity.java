package com.fuchsiaworks.morecraft.tile_entity;

import com.fuchsiaworks.morecraft.item.Items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Hand;

public class ChoppingBlockTileEntity extends BasicCraftingBlockTileEntity {

	public ChoppingBlockTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	@Override
	public boolean isHoldingTool(ItemStack itemStack) {
		return itemStack.getItem() == Items.CHOPPING_KNIFE;
	}

	@Override
	public void updateCrafting(Hand hand, PlayerEntity playerEntity, ItemStack itemStack, long time) {
		super.updateCrafting(hand, playerEntity, itemStack, time);

		itemStack.damageItem(1, playerEntity, (p) -> {
			p.sendBreakAnimation(hand);
		});
	}

	@Override
	public String getCraftingBlockType() {
		return "chopping_block";
	}
}
