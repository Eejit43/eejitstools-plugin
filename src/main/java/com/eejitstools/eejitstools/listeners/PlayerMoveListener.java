package com.eejitstools.eejitstools.listeners;

import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static com.eejitstools.eejitstools.EejitsTools.getPlugin;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (!event.hasChangedPosition()) return;

        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();

        FileConfiguration config = getPlugin().getConfig();

        if (config.getStringList("particles").contains(uuid)) {
            player.getWorld().spawnParticle(Particle.valueOf(config.getString("particles." + uuid + ".type")), player.getLocation(), 10, 0.1, 0.1, 0.1);
        }
    }
}