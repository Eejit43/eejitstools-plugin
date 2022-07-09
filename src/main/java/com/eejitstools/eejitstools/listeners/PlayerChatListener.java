package com.eejitstools.eejitstools.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import static com.eejitstools.eejitstools.util.LogEmbed.logDiscordEmbed;

public class PlayerChatListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerMessage(AsyncChatEvent event) {
        String message = PlainTextComponentSerializer.plainText().serialize(event.originalMessage());
        Player player = event.getPlayer();

        logDiscordEmbed("`" + player.getName() + "`: " + message, player);
    }
}
