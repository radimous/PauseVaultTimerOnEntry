package com.radimous.pausevaulttimeronentry;

import net.minecraft.core.BlockPos;

public abstract class BlockPosUtils {

    public static int dist2DSQ(final BlockPos a, final BlockPos b) {
        final int xDiff = a.getX() - b.getX();
        final int zDiff = a.getZ() - b.getZ();

        return xDiff * xDiff + zDiff * zDiff;
    }
}
