package com.eejitstools.eejitstools.listeners;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

import static com.eejitstools.eejitstools.util.LogEmbed.logDiscordEmbed;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Component component = Component.text(ChatColor.DARK_AQUA + "See you later, " + player.getName() + "!");
        event.quitMessage(component);

        logDiscordEmbed("Player `" + player.getName() + "` has left the server!" + " (" + player.getServer().getOnlinePlayers().size() + "/" + player.getServer().getMaxPlayers() + ")", new Color(121, 23, 23), player, true);
    }
}
