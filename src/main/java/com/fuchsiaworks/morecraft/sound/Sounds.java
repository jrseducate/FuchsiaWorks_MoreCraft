package com.fuchsiaworks.morecraft.sound;

import com.fuchsiaworks.morecraft.MoreCraft;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent.Register;

public class Sounds {

	public static SoundEvent ENTITY_WARLOCK_AMBIENT = new SoundEvent(
			new ResourceLocation(MoreCraft.MOD_ID, "entity.warlock.ambient"))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "entity.warlock.ambient"));
	public static SoundEvent ENTITY_WARLOCK_CELEBRATE = new SoundEvent(
			new ResourceLocation(MoreCraft.MOD_ID, "entity.warlock.celebrate"))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "entity.warlock.celebrate"));
	public static SoundEvent ENTITY_WARLOCK_DEATH = new SoundEvent(
			new ResourceLocation(MoreCraft.MOD_ID, "entity.warlock.death"))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "entity.warlock.death"));
	public static SoundEvent ENTITY_WARLOCK_DRINK = new SoundEvent(
			new ResourceLocation(MoreCraft.MOD_ID, "entity.warlock.drink"))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "entity.warlock.drink"));
	public static SoundEvent ENTITY_WARLOCK_HURT = new SoundEvent(
			new ResourceLocation(MoreCraft.MOD_ID, "entity.warlock.hurt"))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "entity.warlock.hurt"));
	public static SoundEvent ENTITY_WARLOCK_THROW = new SoundEvent(
			new ResourceLocation(MoreCraft.MOD_ID, "entity.warlock.throw"))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "entity.warlock.throw"));

	public static void RegisterSounds(Register<SoundEvent> soundRegistryEvent) {
//		soundRegistryEvent.getRegistry().register(ENTITY_WARLOCK_AMBIENT);
//		soundRegistryEvent.getRegistry().register(ENTITY_WARLOCK_CELEBRATE);
//		soundRegistryEvent.getRegistry().register(ENTITY_WARLOCK_DEATH);
//		soundRegistryEvent.getRegistry().register(ENTITY_WARLOCK_DRINK);
//		soundRegistryEvent.getRegistry().register(ENTITY_WARLOCK_HURT);
//		soundRegistryEvent.getRegistry().register(ENTITY_WARLOCK_THROW);
	}

}
