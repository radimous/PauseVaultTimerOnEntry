package com.radimous.pausevaulttimeronentry.event;

import com.radimous.pausevaulttimeronentry.Config;
import com.radimous.pausevaulttimeronentry.players.PlayerManager;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void onChangeDim(final PlayerEvent.PlayerChangedDimensionEvent event) {
        if (Config.pauseVaultTimer.get() && event.getTo().location().getNamespace().equals("the_vault")) {
            PlayerManager.getInstance().giveProtection(event.getPlayer());
        }
    }
}
