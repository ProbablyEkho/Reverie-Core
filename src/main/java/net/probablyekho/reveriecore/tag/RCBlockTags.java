package net.probablyekho.reveriecore.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class RCBlockTags {
    public static final TagKey<Block> HUGE_MUSHROOM_BLOCK = create();

    private static TagKey<Block> create() {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("reveriecore", "huge_mushroom_blocks"));
    }
}
