package com.eejitstools.eejitstools.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static com.eejitstools.eejitstools.util.LogEmbed.logDiscordEmbed;

public class PlayerDeathListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        Component originalDeathMessage = event.deathMessage();

        if (originalDeathMessage != null) {
            String deathMessage = PlainTextComponentSerializer.plainText().serialize(originalDeathMessage);

            logDiscordEmbed(deathMessage, player);
        }
    }
}
