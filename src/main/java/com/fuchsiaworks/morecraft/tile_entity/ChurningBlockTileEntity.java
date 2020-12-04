package com.fuchsiaworks.morecraft.tile_entity;

import com.fuchsiaworks.morecraft.network.Networking;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Hand;
import net.minecraftforge.fml.network.PacketDistributor;

public class ChurningBlockTileEntity extends BasicCraftingBlockTileEntity {

	public ChurningBlockTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);

		progress = 0;
	}

	public int progress;

	@Override
	public void updateCrafting(Hand hand, PlayerEntity playerEntity, ItemStack itemStack, long time) {
		super.updateCrafting(hand, playerEntity, itemStack, time);

		updateProgress(progress + 15);
	}

	@Override
	public void resetCrafting() {
		super.resetCrafting();

		updateProgress(0);
	}

	public void updateProgress(int progress) {
		this.progress = progress;

		if (!this.world.isRemote) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putInt("progress", progress);

			Networking.INSTANCE.send(PacketDistributor.ALL.noArg(),
					Networking.BasicCraftingBlockMessage(this, "update", nbt));
		}
	}

	@Override
	public String getCraftingBlockType() {
		return "churning_block";
	}

	@Override
	public void update(CompoundNBT nbtData) {
		super.update(nbtData);

		updateProgress(nbtData.getInt("progress"));
	}

}
