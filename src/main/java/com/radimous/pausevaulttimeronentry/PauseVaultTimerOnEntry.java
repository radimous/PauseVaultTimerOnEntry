package com.radimous.pausevaulttimeronentry;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod("pausevaulttimeronentry")
public class PauseVaultTimerOnEntry {

    public PauseVaultTimerOnEntry() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SPEC, "pausevaulttimeronentry-server.toml");
    }

}

