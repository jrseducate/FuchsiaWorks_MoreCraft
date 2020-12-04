package com.fuchsiaworks.morecraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fuchsiaworks.morecraft.block.Blocks;
import com.fuchsiaworks.morecraft.data_gen.ImageDataGenerator;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;
import com.fuchsiaworks.morecraft.entity.Entities;
import com.fuchsiaworks.morecraft.item.Items;
import com.fuchsiaworks.morecraft.network.Networking;
import com.fuchsiaworks.morecraft.particle.Particles;
import com.fuchsiaworks.morecraft.recipe.Recipes;
import com.fuchsiaworks.morecraft.sound.Sounds;
import com.fuchsiaworks.morecraft.tile_entity.TileEntities;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoreCraft.MOD_ID)
public class MoreCraft {
	public static final String MOD_ID = "fuchsiaworks_morecraft";

	// Directly reference a log4j logger.
	public static final Logger LOGGER = LogManager.getLogger();

	public MoreCraft() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		modEventBus.addListener(this::enqueueIMC);
		modEventBus.addListener(this::processIMC);

		modEventBus.addListener(this::doCommonStuff);
		modEventBus.addListener(this::doClientStuff);

		modEventBus.addListener(this::onGatherData);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {

	}

	private void processIMC(final InterModProcessEvent event) {

	}

	private void doCommonStuff(final FMLCommonSetupEvent event) {
		Networking.Register();
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		Blocks.doClientStuff(event);
		TileEntities.doClientStuff(event);
		Entities.doClientStuff(event);
	}

	private void onGatherData(final GatherDataEvent event) {
		JsonDataGenerator.onGatherData(event);
		ImageDataGenerator.onGatherData(event);
	}

	// You can use EventBusSubscriber to automatically subscribe events on the
	// contained class (this is subscribing to the MOD
	// Event bus for receiving Registry Events)
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
			LOGGER.info("Registering Blocks");

			Blocks.RegisterBlocks(blockRegistryEvent);
		}

		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
			LOGGER.info("Registering Items");

			Items.RegisterItems(itemRegistryEvent);
		}

		@SubscribeEvent
		public static void onTileEntitiesRegistry(RegistryEvent.Register<TileEntityType<?>> tileEntityRegistryEvent) {
			LOGGER.info("Registering Tile Entity Types");

			TileEntities.RegisterTileEntities(tileEntityRegistryEvent);
		}

		@SubscribeEvent
		public static void onRecipesRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> recipeRegistryEvent) {
			LOGGER.info("Registering Recipe Types");

			Recipes.RegisterRecipes(recipeRegistryEvent);
		}

		@SubscribeEvent
		public static void onEntitiesRegistry(final RegistryEvent.Register<EntityType<?>> entityRegistryEvent) {
			LOGGER.info("Registering Entities");

			Entities.RegisterEntities(entityRegistryEvent);
		}

		@SubscribeEvent
		public static void onSoundRegistry(final RegistryEvent.Register<SoundEvent> soundRegistryEvent) {
			LOGGER.info("Registering Sounds");

			Sounds.RegisterSounds(soundRegistryEvent);
		}

		@SubscribeEvent
		public static void onParticleRegistry(final RegistryEvent.Register<ParticleType<?>> particleRegistryEvent) {
			LOGGER.info("Registering Particles");

			Particles.RegisterParticles(particleRegistryEvent);
		}

	}

	// Event bus for receiving Game Events)
	@Mod.EventBusSubscriber()
	public static class GameEvents {

		@SubscribeEvent
		public static void doServerStuff(FMLServerStartingEvent event) {

		}

		@SubscribeEvent
		public static void onPlayerRightClickItem(PlayerInteractEvent.RightClickItem event) {
			Items.onPlayerInteractEgg(event);
		}

		@SubscribeEvent
		public static void onPlayerLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
			TileEntities.onPlayerLeftClickBasicCraftingBlock(event);
		}

		@SubscribeEvent
		public static void onBiomeLoading(BiomeLoadingEvent event) {
			if (event.getCategory() == Category.SWAMP) {
				// Register Entity Spawners
				// func_242575_a(Entity Classification, new Spawners(Entity
				// Type, Spawn Chance Weight, Minimum Spawned, Maximum Spawned))
				event.getSpawns().func_242575_a(EntityClassification.MONSTER, new Spawners(Entities.WARLOCK, 1, 1, 1));
			}
		}

	}
}
