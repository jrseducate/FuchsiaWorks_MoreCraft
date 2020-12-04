package com.fuchsiaworks.morecraft.network;

import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.network.NBTMessage.Handler;
import com.fuchsiaworks.morecraft.tile_entity.BasicCraftingBlockTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class Networking {
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(MoreCraft.MOD_ID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static void Register() {
		RegisterMessages();
		RegisterMessageHandlers();
	}

	public static void RegisterMessages() {
		INSTANCE.registerMessage(0, NBTMessage.class, NBTMessage.ENCODER, NBTMessage.DECODER, NBTMessage.CONSUMER);
	}

	public static NBTMessage BasicCraftingBlockMessage(BasicCraftingBlockTileEntity basicCraftingBlockTileEntity,
			String action) {
		return BasicCraftingBlockMessage(basicCraftingBlockTileEntity, action, new CompoundNBT());
	}

	public static NBTMessage BasicCraftingBlockMessage(BasicCraftingBlockTileEntity basicCraftingBlockTileEntity,
			String action, CompoundNBT nbtData) {
		BlockPos blockPos = basicCraftingBlockTileEntity.getPos();
		CompoundNBT nbt = new CompoundNBT();

		nbt.putInt("pos_x", blockPos.getX());
		nbt.putInt("pos_y", blockPos.getY());
		nbt.putInt("pos_z", blockPos.getZ());

		nbt.putString("action", action);

		nbt.put("nbt", nbtData);

		return new NBTMessage("basic_crafting_block", nbt);
	}

	public static void RegisterBasicCraftingBlockMessage() {
		NBTMessage.RegisterHandler("basic_crafting_block", new Handler() {
			@Override
			public void HandleClient(CompoundNBT nbt, Context context) {
				BlockPos blockPos = new BlockPos(nbt.getInt("pos_x"), nbt.getInt("pos_y"), nbt.getInt("pos_z"));
				String action = nbt.getString("action");
				Minecraft minecraft = Minecraft.getInstance();
				World world = minecraft.world;
				TileEntity tileEntity = world.getTileEntity(blockPos);
				BasicCraftingBlockTileEntity basicCraftingBlockTileEntity = (BasicCraftingBlockTileEntity) tileEntity;

				CompoundNBT nbtData = nbt.getCompound("nbt");

				switch (action) {
				case "clear":
					basicCraftingBlockTileEntity.clear();
				case "particle":
					basicCraftingBlockTileEntity.particle();
				case "update":
					basicCraftingBlockTileEntity.update(nbtData);
				}
			}
		});
	}

	public static void RegisterMessageHandlers() {
		RegisterBasicCraftingBlockMessage();
	}
}
