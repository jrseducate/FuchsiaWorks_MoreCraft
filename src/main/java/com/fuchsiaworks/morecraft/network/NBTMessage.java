package com.fuchsiaworks.morecraft.network;

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.fuchsiaworks.morecraft.MoreCraft;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class NBTMessage {

	public static final BiConsumer<NBTMessage, PacketBuffer> ENCODER = new BiConsumer<NBTMessage, PacketBuffer>() {
		@Override
		public void accept(NBTMessage t, PacketBuffer u) {
			u.writeString(t.type);
			u.writeCompoundTag(t.nbt);
		}
	};
	public static final Function<PacketBuffer, NBTMessage> DECODER = new Function<PacketBuffer, NBTMessage>() {
		@Override
		public NBTMessage apply(PacketBuffer t) {
			return new NBTMessage(t.readString(), t.readCompoundTag());
		}
	};
	public static final BiConsumer<NBTMessage, Supplier<NetworkEvent.Context>> CONSUMER = new BiConsumer<NBTMessage, Supplier<Context>>() {
		@Override
		public void accept(NBTMessage t, Supplier<Context> u) {
			Handle(t.type, t.nbt, u.get());
		}
	};
	public static HashMap<String, Handler> HANDLERS = new HashMap<>();

	public static void RegisterHandler(String type, Handler handler) {
		if (HANDLERS.containsKey(type)) {
			MoreCraft.LOGGER.error("Handler type [" + type + "] is already in use!");
			// System.exit(0);
		}

		HANDLERS.put(type, handler);
	}

	public static Handler GetHandler(String type) {
		if (!HANDLERS.containsKey(type)) {
			MoreCraft.LOGGER.error("Handler type [" + type + "] hasn't been registered!");
			// System.exit(0);
		}

		return HANDLERS.get(type);
	}

	public static void Handle(String type, CompoundNBT nbt, Context context) {
		Handler handler = GetHandler(type);

		if (context.getDirection() == NetworkDirection.PLAY_TO_CLIENT) {
			handler.HandleClient(nbt, context);
		} else if (context.getDirection() == NetworkDirection.PLAY_TO_SERVER) {
			handler.HandleServer(nbt, context);
		} else {
			MoreCraft.LOGGER.error("NBTMessage Direction [" + context.getDirection() + "] unexpected!");
			// System.exit(0);
		}
	}

	public interface Handler {
		default void HandleServer(CompoundNBT nbt, Context context) {

		}

		default void HandleClient(CompoundNBT nbt, Context context) {

		}
	}

	public String type;
	public CompoundNBT nbt;

	public NBTMessage(String type, CompoundNBT nbt) {
		this.type = type;
		this.nbt = nbt;
	}
}
