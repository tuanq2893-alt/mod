package com.tuanmod.mixin;

import com.tuanmod.module.Module;
import com.tuanmod.module.ModuleManager;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class MixinBlock {
    @Inject(method = "shouldDrawSide", at = @At("HEAD"), cancellable = true)
    private static void shouldDrawSide(BlockState state, BlockView world, BlockPos pos, Direction side, BlockPos otherPos, CallbackInfoReturnable<Boolean> cir) {
        Module oreEsp = ModuleManager.getModule("OreESP");
        if (oreEsp != null && oreEsp.isEnabled()) {
            Block block = state.getBlock();
            if ((block == Blocks.DIAMOND_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE) && isEnabled("ShowDiamond")) {
                cir.setReturnValue(true);
                return;
            }
            if (block == Blocks.ANCIENT_DEBRIS && isEnabled("ShowAncientDebris")) {
                cir.setReturnValue(true);
                return;
            }
            if ((block == Blocks.GOLD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE || block == Blocks.NETHER_GOLD_ORE) && isEnabled("ShowGold")) {
                cir.setReturnValue(true);
                return;
            }
            if ((block == Blocks.IRON_ORE || block == Blocks.DEEPSLATE_IRON_ORE) && isEnabled("ShowIron")) {
                cir.setReturnValue(true);
                return;
            }
            if ((block == Blocks.EMERALD_ORE || block == Blocks.DEEPSLATE_EMERALD_ORE) && isEnabled("ShowEmerald")) {
                cir.setReturnValue(true);
                return;
            }
            if ((block == Blocks.LAPIS_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE) && isEnabled("ShowLapis")) {
                cir.setReturnValue(true);
                return;
            }
            if ((block == Blocks.REDSTONE_ORE || block == Blocks.DEEPSLATE_REDSTONE_ORE) && isEnabled("ShowRedstone")) {
                cir.setReturnValue(true);
                return;
            }
            if ((block == Blocks.COAL_ORE || block == Blocks.DEEPSLATE_COAL_ORE) && isEnabled("ShowCoal")) {
                cir.setReturnValue(true);
                return;
            }
            if (block instanceof OreBlock || block == Blocks.ANCIENT_DEBRIS) {
                cir.setReturnValue(false);
                return;
            }
        }
    }

    private static boolean isEnabled(String moduleName) {
        Module m = ModuleManager.getModule(moduleName);
        return m != null && m.isEnabled();
    }
}
