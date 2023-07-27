package com.radimous.pausevaulttimeronentry.players;

import com.radimous.pausevaulttimeronentry.BlockPosUtils;
import com.radimous.pausevaulttimeronentry.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.UUID;


public class PlayerManager {

    private static PlayerManager instance;
    private final HashMap<UUID, BlockPos> PlayerPosMap = new HashMap<>();

    private PlayerManager() {
    }

    public static PlayerManager getInstance() {
        if (PlayerManager.instance == null) {
            PlayerManager.instance = new PlayerManager();
        }
        return PlayerManager.instance;
    }

    public void giveProtection(final Player player) {
        if (PlayerPosMap.containsKey(player.getUUID())) {
            return;
        }
        PlayerPosMap.put(player.getUUID(), player.blockPosition());

    }

    public void tryToRemovePlayer(final Player playerEntity) {
        final double maxDist = Math.pow(Config.maxDist.get(), 2);
        if (PlayerPosMap.containsKey(playerEntity.getUUID()) && BlockPosUtils.dist2DSQ(PlayerPosMap.get(playerEntity.getUUID()), playerEntity.blockPosition()) > maxDist) {
            PlayerPosMap.remove(playerEntity.getUUID());
        }
    }

    public boolean isPlayerImmune(final Player playerEntity) {
        tryToRemovePlayer(playerEntity);
        return PlayerPosMap.containsKey(playerEntity.getUUID());
    }
}
