package net.probablyekho.reveriecore.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
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
import static net.minecraft.world.level.block.PipeBlock.PROPERTY_BY_DIRECTION;

@Mixin(HugeMushroomBlock.class)
public class HugeMushroomBlockMixin extends Block {
    public HugeMushroomBlockMixin(Properties properties) {
        super(properties);
    }

    /**
     * @author ProbablyEkho
     * @reason Make mushroom block faces change when any other block of said type is placed facing them
     */
    @Overwrite
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        var that = (HugeMushroomBlock) (Object) this;
        BlockGetter blockgetter = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        return that.defaultBlockState()
                .setValue(DOWN, !blockgetter.getBlockState(blockpos.below()).is(RCBlockTags.HUGE_MUSHROOM_BLOCK))
                .setValue(UP, !blockgetter.getBlockState(blockpos.above()).is(RCBlockTags.HUGE_MUSHROOM_BLOCK))
                .setValue(NORTH, !blockgetter.getBlockState(blockpos.north()).is(RCBlockTags.HUGE_MUSHROOM_BLOCK))
                .setValue(EAST, !blockgetter.getBlockState(blockpos.east()).is(RCBlockTags.HUGE_MUSHROOM_BLOCK))
                .setValue(SOUTH, !blockgetter.getBlockState(blockpos.south()).is(RCBlockTags.HUGE_MUSHROOM_BLOCK))
                .setValue(WEST, !blockgetter.getBlockState(blockpos.west()).is(RCBlockTags.HUGE_MUSHROOM_BLOCK));
    }

    /**
     * @author ProbablyEkho
     * @reason Make mushroom block faces change when any other block of said type is placed facing them
     */

    @Overwrite
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return facingState.is(RCBlockTags.HUGE_MUSHROOM_BLOCK)
                ? state.setValue(PROPERTY_BY_DIRECTION.get(facing), Boolean.FALSE)
                : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }
}
