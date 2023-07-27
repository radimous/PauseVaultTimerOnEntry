package com.radimous.pausevaulttimeronentry.mixins;

import com.radimous.pausevaulttimeronentry.players.PlayerManager;
import iskallia.vault.core.vault.player.Listener;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(value = Listener.class, remap = false)
public abstract class ListenerMixin {
    @Shadow
    public abstract Optional<ServerPlayer> getPlayer();

    @Inject(method = "isOnline", at = @At("HEAD"), cancellable = true)
    private void playerOfflineIfImmune(CallbackInfoReturnable<Boolean> cir) {
        this.getPlayer().ifPresent(player -> {
            if (PlayerManager.getInstance().isPlayerImmune(player)) {
                cir.setReturnValue(false);
            }
        });
    }
}
