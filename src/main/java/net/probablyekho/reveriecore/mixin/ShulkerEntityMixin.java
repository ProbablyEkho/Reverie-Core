package net.probablyekho.reveriecore.mixin;

import net.minecraft.world.entity.monster.Shulker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Shulker.class)
public abstract class ShulkerEntityMixin {
    @Inject(
            method = "teleportSomewhere",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void noShulkerTeleport(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
