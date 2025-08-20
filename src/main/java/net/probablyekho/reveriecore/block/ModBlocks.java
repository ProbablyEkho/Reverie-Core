package net.probablyekho.reveriecore.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.probablyekho.reveriecore.ReverieCore;
import net.probablyekho.reveriecore.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ReverieCore.MODID);

    public static final DeferredBlock<Block> COBBLED_ANDESITE = registerBlock("cobbled_andesite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2f, 6f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> COBBLED_DIORITE = registerBlock("cobbled_diorite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2f, 6f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> COBBLED_GRANITE = registerBlock("cobbled_granite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2f, 6f).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> COBBLED_ANDESITE_SLAB = registerBlock("cobbled_andesite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2f, 6f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> COBBLED_DIORITE_SLAB = registerBlock("cobbled_diorite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2f, 6f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> COBBLED_GRANITE_SLAB = registerBlock("cobbled_granite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2f, 6f).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> COBBLED_ANDESITE_WALL = registerBlock("cobbled_andesite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2f, 6f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> COBBLED_DIORITE_WALL = registerBlock("cobbled_diorite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2f, 6f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> COBBLED_GRANITE_WALL = registerBlock("cobbled_granite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2f, 6f).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> COBBLED_ANDESITE_STAIRS = registerBlock("cobbled_andesite_stairs",
            () -> new StairBlock(ModBlocks.COBBLED_ANDESITE.get().defaultBlockState(),BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2f, 6f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> COBBLED_DIORITE_STAIRS = registerBlock("cobbled_diorite_stairs",
            () -> new StairBlock(ModBlocks.COBBLED_DIORITE.get().defaultBlockState(),BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2f, 6f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> COBBLED_GRANITE_STAIRS = registerBlock("cobbled_granite_stairs",
            () -> new StairBlock(ModBlocks.COBBLED_GRANITE.get().defaultBlockState(),BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2f, 6f).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> RED_MUSHROOM_CAP = registerBlock("red_mushroom_cap",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(0.2F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
            )
    );
    public static final DeferredBlock<Block> BROWN_MUSHROOM_CAP = registerBlock("brown_mushroom_cap",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(0.2F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
            )
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
