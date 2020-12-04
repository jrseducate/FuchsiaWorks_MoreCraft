package com.fuchsiaworks.morecraft.tile_entity;

import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.block.Blocks;
import com.fuchsiaworks.morecraft.renderer.ChoppingBlockTileEntityRenderer;
import com.fuchsiaworks.morecraft.renderer.ChurningBlockTileEntityRenderer;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class TileEntities {
	public static TileEntityType<?> CHOPPING_BLOCK;
	public static TileEntityType<?> CHURNING_BLOCK;

	public static void doClientStuff(FMLClientSetupEvent event) {
		ClientRegistry.bindTileEntityRenderer(CHOPPING_BLOCK, (i) -> new ChoppingBlockTileEntityRenderer<>(i));
		ClientRegistry.bindTileEntityRenderer(CHURNING_BLOCK, (i) -> new ChurningBlockTileEntityRenderer<>(i));
	}

	public static void RegisterTileEntities(Register<TileEntityType<?>> tileEntityRegistryEvent) {
		CHOPPING_BLOCK = TileEntityType.Builder
				.create(() -> new ChoppingBlockTileEntity(CHOPPING_BLOCK), Blocks.CHOPPING_BLOCK).build(null)
				.setRegistryName(MoreCraft.MOD_ID, "chopping_block");
		tileEntityRegistryEvent.getRegistry().register(CHOPPING_BLOCK);

		CHURNING_BLOCK = TileEntityType.Builder
				.create(() -> new ChurningBlockTileEntity(CHURNING_BLOCK), Blocks.CHURNING_BLOCK).build(null)
				.setRegistryName(MoreCraft.MOD_ID, "churning_block");
		tileEntityRegistryEvent.getRegistry().register(CHURNING_BLOCK);
	}

	public static void onPlayerLeftClickBasicCraftingBlock(PlayerInteractEvent.LeftClickBlock event) {
		World world = event.getWorld();
		TileEntity tileEntity = world.getTileEntity(event.getPos());

		if (tileEntity instanceof BasicCraftingBlockTileEntity) {
			BasicCraftingBlockTileEntity basicCraftingBlockTileEntity = (BasicCraftingBlockTileEntity) tileEntity;

			if (basicCraftingBlockTileEntity.onPlayerLeftClick(event) == ActionResultType.CONSUME) {
				event.setCanceled(true);
				event.setCancellationResult(ActionResultType.CONSUME);
			}
		}
	}
}
