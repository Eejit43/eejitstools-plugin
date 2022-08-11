package com.eejitstools.eejitstools.listeners;

import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Arrays;
import java.util.Objects;

import static com.eejitstools.eejitstools.EejitsTools.getPlugin;
import static com.eejitstools.eejitstools.EejitsTools.logger;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (!event.hasChangedPosition()) return;

        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();

        FileConfiguration config = getPlugin().getConfig();

        if (!config.contains("particles." + uuid) && config.contains("particles." + uuid.replace("-", "")))
            uuid = uuid.replace("-", "");

        if (config.contains("particles." + uuid) || config.contains("particles." + uuid.replace("-", ""))) {
            String type = config.getString("particles." + uuid + ".type");
            int count = Integer.parseInt(Objects.requireNonNull(config.getString("particles." + uuid + ".count")));
            if (count <= 0) count = 1;
            assert type != null;
            if (!Arrays.toString(Particle.values()).contains(type)) {
                logger.warning("The particle type \"" + type + "\" is invalid! Please set a correct particle type.");
                return;
            }
            player.getWorld().spawnParticle(Particle.valueOf(type), player.getLocation(), count, 0.1, 0.1, 0.1);
        }
    }
}