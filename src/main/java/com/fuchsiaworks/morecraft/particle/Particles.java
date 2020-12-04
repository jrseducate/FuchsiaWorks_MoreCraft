package com.fuchsiaworks.morecraft.particle;

import com.fuchsiaworks.morecraft.MoreCraft;

import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;

public class Particles {

	public static BasicParticleType WARLOCK = (BasicParticleType) new BasicParticleType(false)
			.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "warlock"));

	public static void RegisterParticles(Register<ParticleType<?>> particleRegistryEvent) {
		// particleRegistryEvent.getRegistry().register(WARLOCK);
	}

}
