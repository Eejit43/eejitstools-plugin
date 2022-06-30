package com.eejitstools.eejitstools.listeners;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (!event.hasChangedPosition()) return;

        Player player = event.getPlayer();

        if (player.getUniqueId().equals(UUID.fromString("02f54317-bd17-4871-95e7-d5f9d854865e"))) // Im_an_eejit
            player.spawnParticle(Particle.ASH, player.getLocation(), 10, 0.1, 0.1, 0.1);
    }
}
