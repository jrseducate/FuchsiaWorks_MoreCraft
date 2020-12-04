package com.fuchsiaworks.morecraft.block;

import com.fuchsiaworks.morecraft.item.Items;
import com.fuchsiaworks.morecraft.tile_entity.ChoppingBlockTileEntity;
import com.fuchsiaworks.morecraft.tile_entity.TileEntities;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.shapes.VoxelShape;

public class ChoppingBlock extends BasicCraftingBlock {

	protected static final VoxelShape SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 12.0D, 15.0D);

	public ChoppingBlock(Properties properties) {
		super(properties);
	}

	@Override
	public VoxelShape getBlockShape() {
		return SHAPE;
	}

	@Override
	public Item getBlockItem() {
		return Items.CHOPPING_BLOCK;
	}

	@Override
	public TileEntity getBlockTileEntity() {
		return new ChoppingBlockTileEntity(TileEntities.CHOPPING_BLOCK);
	}

}
