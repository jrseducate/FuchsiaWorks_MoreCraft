package com.fuchsiaworks.morecraft.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public interface BlockConstructorCallback {
	public Block init(AbstractBlock.Properties properties, String id, Block referenceBlock);
}