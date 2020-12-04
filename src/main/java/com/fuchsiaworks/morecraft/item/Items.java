package com.fuchsiaworks.morecraft.item;

import com.fuchsiaworks.morecraft.MoreCraft;
import com.fuchsiaworks.morecraft.block.Blocks;
import com.fuchsiaworks.morecraft.data_gen.ImageDataGenerator;
import com.fuchsiaworks.morecraft.data_gen.ImageDataGenerator.ImagePixel;
import com.fuchsiaworks.morecraft.data_gen.JsonDataGenerator;

import net.minecraft.block.BlockState;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.data.DataGenerator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.LogicalSide;

public class Items {
	public static Item GLASS_SLAB = new BlockItem(Blocks.GLASS_SLAB,
			new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "glass_slab"));

	public static Item GLASS_STAIRS = new BlockItem(Blocks.GLASS_STAIRS,
			new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "glass_stairs"));

	public static Item CHOPPING_BLOCK = new BlockItem(Blocks.CHOPPING_BLOCK,
			new Item.Properties().group(ItemGroup.MISC))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "chopping_block"));

	public static Item CHURNING_BLOCK = new BlockItem(Blocks.CHURNING_BLOCK,
			new Item.Properties().group(ItemGroup.MISC))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "churning_block"));

	public static Item CHOPPING_KNIFE = new SwordItem(ItemTier.WOOD, 3, -0.2F,
			new Item.Properties().maxDamage(256).group(ItemGroup.COMBAT))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "chopping_knife"));
	
	public static Item REFERENCE_BUCKET = net.minecraft.item.Items.BUCKET;
	public static Item REFERENCE_MILK_BUCKET = net.minecraft.item.Items.MILK_BUCKET;
	public static Item REFERENCE_BEEF = net.minecraft.item.Items.BEEF;
	public static Item REFERENCE_CHICKEN = net.minecraft.item.Items.CHICKEN;
	public static Item REFERENCE_COD = net.minecraft.item.Items.COD;
	public static Item REFERENCE_PORKCHOP = net.minecraft.item.Items.PORKCHOP;
	public static Item REFERENCE_MUTTON = net.minecraft.item.Items.MUTTON;
	public static Item REFERENCE_RABBIT = net.minecraft.item.Items.RABBIT;
	public static Item REFERENCE_SALMON = net.minecraft.item.Items.SALMON;
	public static Item REFERENCE_BEETROOT = net.minecraft.item.Items.BEETROOT;
	public static Item REFERENCE_CARROT = net.minecraft.item.Items.CARROT;
	public static Item REFERENCE_POTATO = net.minecraft.item.Items.POTATO;
	public static Item REFERENCE_COOKED_BEEF = net.minecraft.item.Items.COOKED_BEEF;
	public static Item REFERENCE_COOKED_CHICKEN = net.minecraft.item.Items.COOKED_CHICKEN;
	public static Item REFERENCE_COOKED_COD = net.minecraft.item.Items.COOKED_COD;
	public static Item REFERENCE_COOKED_MUTTON = net.minecraft.item.Items.COOKED_MUTTON;
	public static Item REFERENCE_COOKED_PORKCHOP = net.minecraft.item.Items.COOKED_PORKCHOP;
	public static Item REFERENCE_COOKED_RABBIT = net.minecraft.item.Items.COOKED_RABBIT;
	public static Item REFERENCE_COOKED_SALMON = net.minecraft.item.Items.COOKED_SALMON;
	public static Item REFERENCE_BAKED_POTATO = net.minecraft.item.Items.BAKED_POTATO;

	public static Item CROP_ONION = new BlockItem(Blocks.CROP_ONION,
			new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.0f).build()))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "crop_onion"));

	public static Item CROP_BROCCOLI = new BlockItem(Blocks.CROP_BROCCOLI,
			new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.0f).build()))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "crop_broccoli"));

	public static Item CROP_RICE = new BlockItem(Blocks.CROP_RICE,
			new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.0f).build()))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "crop_rice"));

	public static Item COOKED_EGG = new Item(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(16)
			.food(new Food.Builder().hunger(1).saturation(0.1f).build()))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "cooked_egg"));

	public static Item COOKED_CARROT = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetCookedFood(REFERENCE_CARROT)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "cooked_carrot"));

	public static Item COOKED_BEETROOT = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetCookedFood(REFERENCE_BEETROOT)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "cooked_beetroot"));

	public static Item BUTTER = new Item(new Item.Properties().group(ItemGroup.FOOD).food(MakeFood(2, 0.4f)))
			.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "butter"));

	public static Item BEEF_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_BEEF)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "beef_diced"));

	public static Item CHICKEN_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_CHICKEN)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "chicken_diced"));

	public static Item COD_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_COD)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "cod_diced"));

	public static Item MUTTON_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_MUTTON)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "mutton_diced"));

	public static Item PORKCHOP_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_PORKCHOP)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "porkchop_diced"));

	public static Item RABBIT_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_RABBIT)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "rabbit_diced"));

	public static Item SALMON_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_SALMON)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "salmon_diced"));

	public static Item BEETROOT_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_BEETROOT)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "beetroot_diced"));

	public static Item CARROT_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_CARROT)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "carrot_diced"));

	public static Item POTATO_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_POTATO)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "potato_diced"));

	public static Item COOKED_BEEF_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_COOKED_BEEF)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "cooked_beef_diced"));

	public static Item COOKED_CHICKEN_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_COOKED_CHICKEN)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "cooked_chicken_diced"));

	public static Item COOKED_COD_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_COOKED_COD)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "cooked_cod_diced"));

	public static Item COOKED_MUTTON_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_COOKED_MUTTON)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "cooked_mutton_diced"));

	public static Item COOKED_PORKCHOP_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_COOKED_PORKCHOP)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "cooked_porkchop_diced"));

	public static Item COOKED_RABBIT_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_COOKED_RABBIT)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "cooked_rabbit_diced"));

	public static Item COOKED_SALMON_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_COOKED_SALMON)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "cooked_salmon_diced"));

	public static Item COOKED_BEETROOT_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(COOKED_BEETROOT)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "cooked_beetroot_diced"));

	public static Item COOKED_CARROT_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(COOKED_CARROT)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "cooked_carrot_diced"));

	public static Item BAKED_POTATO_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(REFERENCE_BAKED_POTATO)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "baked_potato_diced"));

	public static Item CROP_ONION_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(CROP_ONION)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "crop_onion_diced"));

	public static Item CROP_BROCCOLI_DICED = new Item(
			new Item.Properties().group(ItemGroup.FOOD).food(GetDicedFood(CROP_BROCCOLI)))
					.setRegistryName(new ResourceLocation(MoreCraft.MOD_ID, "crop_broccoli_diced"));
	
	public static void RegisterItems(final RegistryEvent.Register<Item> itemRegistryEvent) {
		itemRegistryEvent.getRegistry().register(CHOPPING_KNIFE);

		itemRegistryEvent.getRegistry().register(CROP_ONION);
		itemRegistryEvent.getRegistry().register(CROP_BROCCOLI);
		itemRegistryEvent.getRegistry().register(CROP_RICE);

		itemRegistryEvent.getRegistry().register(COOKED_EGG);
		itemRegistryEvent.getRegistry().register(COOKED_CARROT);
		itemRegistryEvent.getRegistry().register(COOKED_BEETROOT);

		itemRegistryEvent.getRegistry().register(BUTTER);

		itemRegistryEvent.getRegistry().register(BEEF_DICED);
		itemRegistryEvent.getRegistry().register(CHICKEN_DICED);
		itemRegistryEvent.getRegistry().register(COD_DICED);
		itemRegistryEvent.getRegistry().register(MUTTON_DICED);
		itemRegistryEvent.getRegistry().register(PORKCHOP_DICED);
		itemRegistryEvent.getRegistry().register(RABBIT_DICED);
		itemRegistryEvent.getRegistry().register(SALMON_DICED);
		itemRegistryEvent.getRegistry().register(BEETROOT_DICED);
		itemRegistryEvent.getRegistry().register(CARROT_DICED);
		itemRegistryEvent.getRegistry().register(POTATO_DICED);
		itemRegistryEvent.getRegistry().register(COOKED_BEEF_DICED);
		itemRegistryEvent.getRegistry().register(COOKED_CHICKEN_DICED);
		itemRegistryEvent.getRegistry().register(COOKED_COD_DICED);
		itemRegistryEvent.getRegistry().register(COOKED_MUTTON_DICED);
		itemRegistryEvent.getRegistry().register(COOKED_PORKCHOP_DICED);
		itemRegistryEvent.getRegistry().register(COOKED_RABBIT_DICED);
		itemRegistryEvent.getRegistry().register(COOKED_SALMON_DICED);
		itemRegistryEvent.getRegistry().register(COOKED_BEETROOT_DICED);
		itemRegistryEvent.getRegistry().register(COOKED_CARROT_DICED);
		itemRegistryEvent.getRegistry().register(BAKED_POTATO_DICED);
		itemRegistryEvent.getRegistry().register(CROP_ONION_DICED);
		itemRegistryEvent.getRegistry().register(CROP_BROCCOLI_DICED);

		itemRegistryEvent.getRegistry().register(GLASS_SLAB);
		itemRegistryEvent.getRegistry().register(GLASS_STAIRS);

		itemRegistryEvent.getRegistry().register(CHOPPING_BLOCK);
		itemRegistryEvent.getRegistry().register(CHURNING_BLOCK);

		Blocks.COLORED_GLASS_SLAB.registerItems(itemRegistryEvent);
		Blocks.COLORED_GLASS_STAIRS.registerItems(itemRegistryEvent);

		Blocks.COLORED_ACACIA_PLANKS.registerItems(itemRegistryEvent);
		Blocks.COLORED_ACACIA_SLAB.registerItems(itemRegistryEvent);
		Blocks.COLORED_ACACIA_STAIRS.registerItems(itemRegistryEvent);
//		Blocks.COLORED_ACACIA_DOOR.registerItems(itemRegistryEvent);

		Blocks.COLORED_BIRCH_PLANKS.registerItems(itemRegistryEvent);
		Blocks.COLORED_BIRCH_SLAB.registerItems(itemRegistryEvent);
		Blocks.COLORED_BIRCH_STAIRS.registerItems(itemRegistryEvent);
//		Blocks.COLORED_BIRCH_DOOR.registerItems(itemRegistryEvent);

		Blocks.COLORED_DARK_OAK_PLANKS.registerItems(itemRegistryEvent);
		Blocks.COLORED_DARK_OAK_SLAB.registerItems(itemRegistryEvent);
		Blocks.COLORED_DARK_OAK_STAIRS.registerItems(itemRegistryEvent);
//		Blocks.COLORED_DARK_OAK_DOOR.registerItems(itemRegistryEvent);

		Blocks.COLORED_JUNGLE_PLANKS.registerItems(itemRegistryEvent);
		Blocks.COLORED_JUNGLE_SLAB.registerItems(itemRegistryEvent);
		Blocks.COLORED_JUNGLE_STAIRS.registerItems(itemRegistryEvent);
//		Blocks.COLORED_JUNGLE_DOOR.registerItems(itemRegistryEvent);

		Blocks.COLORED_OAK_PLANKS.registerItems(itemRegistryEvent);
		Blocks.COLORED_OAK_SLAB.registerItems(itemRegistryEvent);
		Blocks.COLORED_OAK_STAIRS.registerItems(itemRegistryEvent);
//		Blocks.COLORED_OAK_DOOR.registerItems(itemRegistryEvent);

		Blocks.COLORED_SPRUCE_PLANKS.registerItems(itemRegistryEvent);
		Blocks.COLORED_SPRUCE_SLAB.registerItems(itemRegistryEvent);
		Blocks.COLORED_SPRUCE_STAIRS.registerItems(itemRegistryEvent);
//		Blocks.COLORED_SPRUCE_DOOR.registerItems(itemRegistryEvent);

		Blocks.COLORED_CRIMSON_PLANKS.registerItems(itemRegistryEvent);
		Blocks.COLORED_CRIMSON_SLAB.registerItems(itemRegistryEvent);
		Blocks.COLORED_CRIMSON_STAIRS.registerItems(itemRegistryEvent);
//		Blocks.COLORED_CRIMSON_DOOR.registerItems(itemRegistryEvent);

		Blocks.COLORED_WARPED_PLANKS.registerItems(itemRegistryEvent);
		Blocks.COLORED_WARPED_SLAB.registerItems(itemRegistryEvent);
		Blocks.COLORED_WARPED_STAIRS.registerItems(itemRegistryEvent);
//		Blocks.COLORED_WARPED_DOOR.registerItems(itemRegistryEvent);
	}

	public static Food GetCookedFood(Item itemFood) {
		Food food = itemFood.getFood();

		int hunger = (int) Math.ceil(food.getHealing() * 2.25f);
		float saturation = food.getSaturation() * 3.0f;

		return MakeFood(hunger, saturation);
	}

	public static Food MakeFood(int hunger, float saturation) {
		return new Food.Builder().hunger(hunger).saturation(saturation).build();
	}

	public static Food GetDicedFood(Item itemFood) {
		Food food = itemFood.getFood();

		int hunger = (int) Math.max(Math.ceil(food.getHealing() * 0.3f), 1);
		float saturation = food.getSaturation() * 0.3f;

		return MakeFood(hunger, saturation);
	}

	public static void onPlayerInteractEgg(PlayerInteractEvent event) {
		if (event.isCanceled())
			return;

		PlayerEntity player = event.getPlayer();
		ItemStack stack = player.getHeldItem(event.getHand());
		World world = player.world;
		BlockPos blockPos = event.getPos();
		BlockState blockState = world.getBlockState(blockPos);

		if (player.isSneaking() || stack == null || stack.getItem() != net.minecraft.item.Items.EGG
				|| blockState == null) {
			return;
		}

		ActionResultType result = blockState.onBlockActivated(world, player, Hand.MAIN_HAND,
				new BlockRayTraceResult(player.getLookVec(), event.getFace(), blockPos, false));

		if (result == ActionResultType.CONSUME || result == ActionResultType.SUCCESS) {
			event.setCanceled(true);
			event.setCancellationResult(ActionResultType.CONSUME);

			if (event.getSide() == LogicalSide.CLIENT) {
				ClientPlayerEntity clientPlayer = (ClientPlayerEntity) player;
				clientPlayer.swingArm(event.getHand());
			}
		}
	}

	public static void onGatherJsonData(DataGenerator generator) {
		JsonDataGenerator.generateBlockItemModelJson(generator, GLASS_SLAB);
		JsonDataGenerator.generateBlockItemModelJson(generator, GLASS_STAIRS);

		JsonDataGenerator.generateBlockItemModelJson(generator, CHOPPING_BLOCK);
		JsonDataGenerator.generateBlockItemModelJson(generator, CHURNING_BLOCK);
		
		JsonDataGenerator.generateItemModelJson(generator, CHOPPING_KNIFE);

		JsonDataGenerator.generateItemModelJson(generator, CROP_ONION);
		JsonDataGenerator.generateItemModelJson(generator, CROP_BROCCOLI);
		JsonDataGenerator.generateItemModelJson(generator, CROP_RICE);
		JsonDataGenerator.generateItemModelJson(generator, COOKED_EGG);
		JsonDataGenerator.generateItemModelJson(generator, COOKED_CARROT);
		JsonDataGenerator.generateItemModelJson(generator, COOKED_BEETROOT);
		JsonDataGenerator.generateItemModelJson(generator, BUTTER);
		
		JsonDataGenerator.generateItemModelJson(generator, BEEF_DICED);
		JsonDataGenerator.generateItemModelJson(generator, CHICKEN_DICED);
		JsonDataGenerator.generateItemModelJson(generator, COD_DICED);
		JsonDataGenerator.generateItemModelJson(generator, MUTTON_DICED);
		JsonDataGenerator.generateItemModelJson(generator, PORKCHOP_DICED);
		JsonDataGenerator.generateItemModelJson(generator, RABBIT_DICED);
		JsonDataGenerator.generateItemModelJson(generator, SALMON_DICED);
		JsonDataGenerator.generateItemModelJson(generator, BEETROOT_DICED);
		JsonDataGenerator.generateItemModelJson(generator, CARROT_DICED);
		JsonDataGenerator.generateItemModelJson(generator, POTATO_DICED);
		JsonDataGenerator.generateItemModelJson(generator, COOKED_BEEF_DICED);
		JsonDataGenerator.generateItemModelJson(generator, COOKED_CHICKEN_DICED);
		JsonDataGenerator.generateItemModelJson(generator, COOKED_COD_DICED);
		JsonDataGenerator.generateItemModelJson(generator, COOKED_MUTTON_DICED);
		JsonDataGenerator.generateItemModelJson(generator, COOKED_PORKCHOP_DICED);
		JsonDataGenerator.generateItemModelJson(generator, COOKED_RABBIT_DICED);
		JsonDataGenerator.generateItemModelJson(generator, COOKED_SALMON_DICED);
		JsonDataGenerator.generateItemModelJson(generator, COOKED_BEETROOT_DICED);
		JsonDataGenerator.generateItemModelJson(generator, COOKED_CARROT_DICED);
		JsonDataGenerator.generateItemModelJson(generator, BAKED_POTATO_DICED);
		JsonDataGenerator.generateItemModelJson(generator, CROP_ONION_DICED);
		JsonDataGenerator.generateItemModelJson(generator, CROP_BROCCOLI_DICED);
		
		Blocks.COLORED_GLASS_SLAB.generateItemsJson(generator);
		Blocks.COLORED_GLASS_STAIRS.generateItemsJson(generator);

		Blocks.COLORED_ACACIA_PLANKS.generateItemsJson(generator);
		Blocks.COLORED_ACACIA_SLAB.generateItemsJson(generator);
		Blocks.COLORED_ACACIA_STAIRS.generateItemsJson(generator);

		Blocks.COLORED_BIRCH_PLANKS.generateItemsJson(generator);
		Blocks.COLORED_BIRCH_SLAB.generateItemsJson(generator);
		Blocks.COLORED_BIRCH_STAIRS.generateItemsJson(generator);

		Blocks.COLORED_DARK_OAK_PLANKS.generateItemsJson(generator);
		Blocks.COLORED_DARK_OAK_SLAB.generateItemsJson(generator);
		Blocks.COLORED_DARK_OAK_STAIRS.generateItemsJson(generator);

		Blocks.COLORED_JUNGLE_PLANKS.generateItemsJson(generator);
		Blocks.COLORED_JUNGLE_SLAB.generateItemsJson(generator);
		Blocks.COLORED_JUNGLE_STAIRS.generateItemsJson(generator);

		Blocks.COLORED_OAK_PLANKS.generateItemsJson(generator);
		Blocks.COLORED_OAK_SLAB.generateItemsJson(generator);
		Blocks.COLORED_OAK_STAIRS.generateItemsJson(generator);

		Blocks.COLORED_SPRUCE_PLANKS.generateItemsJson(generator);
		Blocks.COLORED_SPRUCE_SLAB.generateItemsJson(generator);
		Blocks.COLORED_SPRUCE_STAIRS.generateItemsJson(generator);

		Blocks.COLORED_CRIMSON_PLANKS.generateItemsJson(generator);
		Blocks.COLORED_CRIMSON_SLAB.generateItemsJson(generator);
		Blocks.COLORED_CRIMSON_STAIRS.generateItemsJson(generator);

		Blocks.COLORED_WARPED_PLANKS.generateItemsJson(generator);
		Blocks.COLORED_WARPED_SLAB.generateItemsJson(generator);
		Blocks.COLORED_WARPED_STAIRS.generateItemsJson(generator);
	}
	
	public static void onGatherImageData(DataGenerator generator) {
		//BEEF_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.BEEF_DICED,
			new ImagePixel(71, 10, 6),
			new ImagePixel(123, 23, 19),
			new ImagePixel(224, 62, 53)
		);

		//CHICKEN_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.CHICKEN_DICED,
			new ImagePixel(134, 82, 69),
			new ImagePixel(193, 146, 128),
			new ImagePixel(242, 201, 189)
		);

		//COD_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.COD_DICED,
			new ImagePixel(107, 68, 43),
			new ImagePixel(152, 109, 78),
			new ImagePixel(214, 197, 173)
		);

		//MUTTON_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.MUTTON_DICED,
			new ImagePixel(71, 10, 6),
			new ImagePixel(209, 46, 38),
			new ImagePixel(232, 138, 130)
		);

		//PORKCHOP_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.PORKCHOP_DICED,
			new ImagePixel(81, 38, 38),
			new ImagePixel(239, 112, 112),
			new ImagePixel(255, 173, 173)
		);

		//RABBIT_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.RABBIT_DICED,
			new ImagePixel(134, 82, 69),
			new ImagePixel(184, 132, 115),
			new ImagePixel(254, 229, 210)
		);

		//SALMON_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.SALMON_DICED,
			new ImagePixel(27, 42, 38),
			new ImagePixel(114, 53, 48),
			new ImagePixel(144, 41, 40)
		);

		//BEETROOT_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.BEETROOT_DICED,
			new ImagePixel(91, 29, 23),
			new ImagePixel(164, 39, 44),
			new ImagePixel(192, 114, 121)
		);

		//CARROT_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.CARROT_DICED,
			new ImagePixel(117, 48, 2),
			new ImagePixel(211, 106, 13),
			new ImagePixel(255, 193, 119)
		);

		//POTATO_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.POTATO_DICED,
			new ImagePixel(109, 55, 1),
			new ImagePixel(157, 119, 46),
			new ImagePixel(248, 208, 134)
		);

		//COOKED_BEEF_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.COOKED_BEEF_DICED,
			new ImagePixel(42, 22, 13),
			new ImagePixel(63, 33, 22),
			new ImagePixel(124, 72, 53)
		);

		//COOKED_CHICKEN_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.COOKED_CHICKEN_DICED,
			new ImagePixel(90, 44, 16),
			new ImagePixel(205, 125, 74),
			new ImagePixel(230, 190, 164)
		);

		//COOKED_COD_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.COOKED_COD_DICED,
			new ImagePixel(152, 109, 78),
			new ImagePixel(207, 184, 140),
			new ImagePixel(226, 229, 198)
		);

		//COOKED_MUTTON_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.COOKED_MUTTON_DICED,
			new ImagePixel(42, 22, 13),
			new ImagePixel(124, 64, 47),
			new ImagePixel(163, 112, 90)
		);

		//COOKED_PORKCHOP_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.COOKED_PORKCHOP_DICED,
			new ImagePixel(95, 79, 39),
			new ImagePixel(153, 121, 66),
			new ImagePixel(226, 211, 172)
		);

		//COOKED_RABBIT_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.COOKED_RABBIT_DICED,
			new ImagePixel(89, 45, 20),
			new ImagePixel(169, 95, 50),
			new ImagePixel(231, 191, 162)
		);

		//COOKED_SALMON_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.COOKED_SALMON_DICED,
			new ImagePixel(27, 42, 38),
			new ImagePixel(115, 61, 32),
			new ImagePixel(223, 125, 83)
		);

		//COOKED_BEETROOT_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.COOKED_BEETROOT_DICED,
			new ImagePixel(68, 15, 10),
			new ImagePixel(112, 43, 44),
			new ImagePixel(126, 32, 36)
		);

		//COOKED_CARROT_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.COOKED_CARROT_DICED,
			new ImagePixel(117, 40, 2),
			new ImagePixel(189, 89, 0),
			new ImagePixel(220, 114, 21)
		);

		//BAKED_POTATO_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.BAKED_POTATO_DICED,
			new ImagePixel(109, 55, 1),
			new ImagePixel(157, 119, 46),
			new ImagePixel(240, 205, 90)
		);

		//CROP_ONION_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.CROP_ONION_DICED,
			new ImagePixel(137, 38, 105),
			new ImagePixel(229, 192, 179),
			new ImagePixel(245, 230, 209)
		);

		//CROP_BROCCOLI_DICED
		ImageDataGenerator.generateItemImage(generator, ImageDataGenerator.IMAGE_TEMPLATE_DICED_FOOD, Items.CROP_BROCCOLI_DICED,
			new ImagePixel(28, 81, 31),
			new ImagePixel(34, 143, 38),
			new ImagePixel(85, 174, 89)
		);
	}
}
