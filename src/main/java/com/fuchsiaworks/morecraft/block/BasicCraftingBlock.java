package com.fuchsiaworks.morecraft.block;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.fuchsiaworks.morecraft.tile_entity.BasicCraftingBlockTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public abstract class BasicCraftingBlock extends Block {

	public BasicCraftingBlock(Properties properties) {
		super(properties);
	}

	public abstract VoxelShape getBlockShape();

	public abstract Item getBlockItem();

	public abstract TileEntity getBlockTileEntity();

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return getBlockShape();
	}

	public List<ItemStack> getDrops(TileEntity tileEntity) {
		List<ItemStack> result = new ArrayList<>();

		if (tileEntity instanceof BasicCraftingBlockTileEntity) {
			BasicCraftingBlockTileEntity basicCraftingBlockTileEntity = (BasicCraftingBlockTileEntity) tileEntity;

			if (!basicCraftingBlockTileEntity.isEmpty()) {
				result.add(basicCraftingBlockTileEntity.getStackInSlot(0));
			}
		}

		result.add(new ItemStack(getBlockItem()));

		return result;
	}

	@Override
	public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state,
			@Nullable TileEntity te, ItemStack stack) {
		player.addStat(Stats.BLOCK_MINED.get(this));
		player.addExhaustion(0.005F);
		spawnDrops(worldIn, pos, state, te, stack);
	}

	public void spawnDrops(World worldIn, BlockPos pos, BlockState state, TileEntity te, ItemStack stack) {
		getDrops(te).forEach((drop) -> {
			spawnAsEntity(worldIn, pos, drop);
		});
		state.spawnAdditionalDrops((ServerWorld) worldIn, pos, stack);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return getBlockTileEntity();
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		BasicCraftingBlockTileEntity basicCraftingBlockTileEntity = (BasicCraftingBlockTileEntity) tileEntity;

		ItemStack itemStack = player.getHeldItem(handIn);
		ItemStack itemStackInSlot = basicCraftingBlockTileEntity.getStackInSlot(0);

		if (basicCraftingBlockTileEntity.isEmpty()) {
			if (!itemStack.isEmpty() && basicCraftingBlockTileEntity.itemAllowed(itemStack)) {
				ItemStack newItemStack = new ItemStack(itemStack.getItem());
				itemStack.shrink(1);

				basicCraftingBlockTileEntity.setInventorySlotContents(0, newItemStack);
			}
		} else if (itemStack.isEmpty()) {
			player.setHeldItem(handIn, basicCraftingBlockTileEntity.getStackInSlot(0));
			basicCraftingBlockTileEntity.resetCrafting();
		} else if (itemStackInSlot.getItem() == itemStack.getItem()
				&& itemStack.getCount() < itemStack.getMaxStackSize()) {
			itemStack.grow(1);
			basicCraftingBlockTileEntity.resetCrafting();
		}

		return ActionResultType.CONSUME;
	}
}
