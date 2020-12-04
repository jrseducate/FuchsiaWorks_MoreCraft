package com.fuchsiaworks.morecraft.tile_entity;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.fuchsiaworks.morecraft.network.Networking;
import com.fuchsiaworks.morecraft.recipe.BasicCraftingBlockRecipe;
import com.fuchsiaworks.morecraft.recipe.Recipes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.fml.network.PacketDistributor;

public abstract class BasicCraftingBlockTileEntity extends TileEntity implements IInventory {
	public BasicCraftingBlockTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);

		stack = ItemStack.EMPTY;
		rand = new Random();
	}

	public abstract String getCraftingBlockType();

	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = super.serializeNBT();

		if (!isEmpty()) {
			nbt.put("Stack", stack.write(new CompoundNBT()));
		}

		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		if (nbt.contains("stack")) {
			stack = ItemStack.read(nbt.getCompound("stack"));
		}

		super.deserializeNBT(nbt);
	}

	@Override
	public void clear() {
		stack = ItemStack.EMPTY;

		if (!this.world.isRemote) {
			Networking.INSTANCE.send(PacketDistributor.ALL.noArg(),
					Networking.BasicCraftingBlockMessage(this, "clear"));
		}
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		if (index != 0)
			return null;

		return stack;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		if (index != 0 || stack == null)
			return null;

		stack.shrink(count);

		return stack;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		if (index != 0)
			return null;

		ItemStack stack = this.stack;

		this.stack = ItemStack.EMPTY;

		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		if (index != 0)
			return;

		this.stack = stack;

		hits = 0;
		hitsNeeded = getHitsNeeded();
	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player) {
		return false;
	}

	public ItemStack stack;
	public int hits;
	public int hitsNeeded;
	public long lastHit;
	public Random rand;

	public boolean itemAllowed(ItemStack itemStack) {
		ItemStack tmp = stack;
		stack = itemStack;
		boolean result = getRecipe() != null;
		stack = tmp;
		return result;
	}

	public IRecipeType<BasicCraftingBlockRecipe> getRecipeType() {
		return Recipes.BASIC_CRAFTING_BLOCK;
	}

	public List<BasicCraftingBlockRecipe> getRecipes() {
		return world.getRecipeManager().getRecipes(getRecipeType(), this, world);
	}

	public BasicCraftingBlockRecipe getRecipe() {
		String type = getCraftingBlockType();
		List<BasicCraftingBlockRecipe> recipes = getRecipes();

		for (BasicCraftingBlockRecipe recipe : recipes) {
			String recipeType = recipe.type;
			if (recipeType.equals(type)) {
				return recipe;
			}
		}

		return null;
	}

	public int getHitsNeeded() {
		return 5;
	}

	public List<ItemStack> getResults() {
		BasicCraftingBlockRecipe recipe = getRecipe();

		return recipe.results.stream().map((itemStack) -> itemStack.copy()).collect(Collectors.toList());
	}

	public boolean isHoldingTool(ItemStack itemStack) {
		return true;
	}

	public boolean isHittingTop(Direction direction) {
		return direction == Direction.UP;
	}

	public boolean canBeHit(long time) {
		long canHitAfter = lastHit + 2;

		return time > canHitAfter;
	}

	public ActionResultType onPlayerLeftClick(LeftClickBlock event) {
		World world = event.getWorld();
		PlayerEntity playerEntity = event.getPlayer();
		ItemStack itemStack = playerEntity.getHeldItem(event.getHand());
		long time = world.getGameTime();
		BlockPos blockPos = event.getPos();

		if (isHoldingTool(itemStack) && isHittingTop(event.getFace())) {
			world.sendBlockBreakProgress(-1, this.getPos(), -1);

			if (world instanceof ServerWorld && !isEmpty() && canBeHit(time)) {
				updateCrafting(event.getHand(), playerEntity, itemStack, time);

				if (hits >= hitsNeeded) {
					finishCrafting(world, blockPos);
				}
			}

			return ActionResultType.CONSUME;
		}

		return ActionResultType.FAIL;
	}

	public void updateCrafting(Hand hand, PlayerEntity playerEntity, ItemStack itemStack, long time) {
		hits++;
		lastHit = time;

		particle();
	}

	public void finishCrafting(World world, BlockPos blockPos) {
		getResults().forEach((result) -> {
			world.addEntity(new ItemEntity(world, blockPos.getX() + 0.5f, blockPos.getY() + 0.7f,
					blockPos.getZ() + 0.5f, result));
		});

		resetCrafting();
	}

	public void resetCrafting() {
		clear();
	}

	public void particle() {
		if (!stack.isEmpty()) {
			if (!world.isRemote) {
				Networking.INSTANCE.send(PacketDistributor.ALL.noArg(),
						Networking.BasicCraftingBlockMessage(this, "particle"));
			} else {
				Minecraft minecraft = Minecraft.getInstance();
				ClientWorld world = minecraft.world;
				BlockPos blockPos = getPos();

				float rotationPitch = 0.0f;
				float rotationYaw = 0.0f;
				float radius = 0.5f;

				for (int i = 0; i < 16; i++) {
					Vector3d position = new Vector3d(blockPos.getX(), blockPos.getY(), blockPos.getZ()).add(
							0.5f + ((this.rand.nextFloat() - 0.5f) * radius), 0.7f,
							0.5f + ((this.rand.nextFloat() - 0.5f) * radius));

					Vector3d velocity = new Vector3d(((double) this.rand.nextFloat() - 0.5D) * 0.1D,
							Math.random() * 0.1D + 0.1D, 0.0D);
					velocity = velocity.rotatePitch(-rotationPitch * ((float) Math.PI / 180F));
					velocity = velocity.rotateYaw(-rotationYaw * ((float) Math.PI / 180F));

					world.addParticle(new ItemParticleData(ParticleTypes.ITEM, stack), position.getX(), position.getY(),
							position.getZ(), velocity.getX(), velocity.getY(), velocity.getZ());
				}
			}
		}
	}

	public void update(CompoundNBT nbtData) {
	}
}
