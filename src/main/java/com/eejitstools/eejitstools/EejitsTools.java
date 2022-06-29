package com.eejitstools.eejitstools;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class EejitsTools extends JavaPlugin {
    Server server = getServer();
    ConsoleCommandSender console = server.getConsoleSender();

    @Override
    public void onEnable() {
        console.sendMessage(ChatColor.DARK_AQUA + "EejitsTools has been enabled!");
    }

    @Override
    public void onDisable() {
        console.sendMessage(ChatColor.DARK_AQUA + "EejitsTools has been disabled!");
    }

    @Override
    public void onLoad() {
        console.sendMessage(ChatColor.DARK_AQUA + "EejitsTools has been loaded!");
    }
}
