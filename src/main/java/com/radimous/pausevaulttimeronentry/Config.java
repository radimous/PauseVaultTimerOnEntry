package com.radimous.pausevaulttimeronentry;


import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static ForgeConfigSpec SPEC;
    public static ForgeConfigSpec.IntValue maxDist;
    public static ForgeConfigSpec.BooleanValue pauseVaultTimer;

    static {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        SERVER_BUILDER.comment("How many block does player have to move to start the timer, default: 20 (20 is enough to move freely in first room)");
        maxDist = SERVER_BUILDER.defineInRange("maxDistance", 20, 1, 200);

        SERVER_BUILDER.comment("Pauses vault timer when you enter vault, default: true");
        pauseVaultTimer = SERVER_BUILDER.define("pauseVaultTimer", true);

        SPEC = SERVER_BUILDER.build();
    }


}
