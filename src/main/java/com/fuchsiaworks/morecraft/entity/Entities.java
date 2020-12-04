package com.fuchsiaworks.morecraft.entity;

import com.fuchsiaworks.morecraft.MoreCraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class Entities {

	@SuppressWarnings("unchecked")
	public static EntityType<WarlockEntity> WARLOCK = (EntityType<WarlockEntity>) EntityType.Builder
			.<WarlockEntity>create(WarlockEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F).func_233606_a_(8)
			.build("warlock").setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "warlock"));

	public static void doClientStuff(FMLClientSetupEvent event) {
		Minecraft minecraft = Minecraft.getInstance();
		EntityRendererManager manager = minecraft.getRenderManager();

//		manager.register(WARLOCK, new WarlockRenderer(manager));
	}

	public static void RegisterEntities(Register<EntityType<?>> entityRegistryEvent) {
//		GlobalEntityTypeAttributes.put(WARLOCK, WarlockEntity.getEntityAttributes().func_233813_a_());
//		entityRegistryEvent.getRegistry().register(WARLOCK);
	}

}
