package com.fuchsiaworks.morecraft.block;

import com.fuchsiaworks.morecraft.item.Items;
import com.fuchsiaworks.morecraft.tile_entity.ChurningBlockTileEntity;
import com.fuchsiaworks.morecraft.tile_entity.TileEntities;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.shapes.VoxelShape;

public class ChurningBlock extends BasicCraftingBlock {

	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);

	public ChurningBlock(Properties properties) {
		super(properties);
	}

	@Override
	public VoxelShape getBlockShape() {
		return SHAPE;
	}

	@Override
	public Item getBlockItem() {
		return Items.CHURNING_BLOCK;
	}

	@Override
	public TileEntity getBlockTileEntity() {
		return new ChurningBlockTileEntity(TileEntities.CHURNING_BLOCK);
	}

}
