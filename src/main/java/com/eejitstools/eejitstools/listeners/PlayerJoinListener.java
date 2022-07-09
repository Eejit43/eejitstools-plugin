package com.eejitstools.eejitstools.listeners;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.awt.*;

import static com.eejitstools.eejitstools.util.LogEmbed.logDiscordEmbed;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Component component = Component.text(ChatColor.DARK_AQUA + "Welcome to the server, " + player.getName() + "!");
        event.joinMessage(component);

        logDiscordEmbed("Player `" + player.getName() + "` has joined the server!" + " (" + player.getServer().getOnlinePlayers().size() + "/" + player.getServer().getMaxPlayers() + ")", new Color(1, 102, 0), player, true);
    }
}
