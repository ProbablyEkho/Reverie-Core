package net.probablyekho.reveriecore.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.probablyekho.reveriecore.tag.RCBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static net.minecraft.world.level.block.HugeMushroomBlock.DOWN;
import static net.minecraft.world.level.block.HugeMushroomBlock.UP;
import static net.minecraft.world.level.block.HugeMushroomBlock.NORTH;
import static net.minecraft.world.level.block.HugeMushroomBlock.EAST;
import static net.minecraft.world.level.block.HugeMushroomBlock.SOUTH;
import static net.minecraft.world.level.block.HugeMushroomBlock.WEST;

@Mixin(HugeMushroomBlock.class)
public class HugeMushroomBlockMixin {
    /**
     * @author ProbablyEkho
     * @reason Make mushroom block faces change when any other block of said type is placed facing them
     */
    @Overwrite
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter blockgetter = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        var that = (HugeMushroomBlock) (Object) this;
        System.out.println("hey");
        return that.defaultBlockState()
                .setValue(DOWN, !blockgetter.getBlockState(blockpos.below()).is(RCBlockTags.HUGE_MUSHROOM_BLOCK))
                .setValue(UP, !blockgetter.getBlockState(blockpos.above()).is(RCBlockTags.HUGE_MUSHROOM_BLOCK))
                .setValue(NORTH, !blockgetter.getBlockState(blockpos.north()).is(RCBlockTags.HUGE_MUSHROOM_BLOCK))
                .setValue(EAST, !blockgetter.getBlockState(blockpos.east()).is(RCBlockTags.HUGE_MUSHROOM_BLOCK))
                .setValue(SOUTH, !blockgetter.getBlockState(blockpos.south()).is(RCBlockTags.HUGE_MUSHROOM_BLOCK))
                .setValue(WEST, !blockgetter.getBlockState(blockpos.west()).is(RCBlockTags.HUGE_MUSHROOM_BLOCK));
    }
}
