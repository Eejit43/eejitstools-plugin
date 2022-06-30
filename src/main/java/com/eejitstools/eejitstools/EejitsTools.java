package com.eejitstools.eejitstools;

import com.eejitstools.eejitstools.commands.SetIDCommand;
import com.eejitstools.eejitstools.commands.TestCommand;
import com.eejitstools.eejitstools.listeners.PlayerInteractListener;
import com.eejitstools.eejitstools.listeners.PlayerJoinListener;
import com.eejitstools.eejitstools.listeners.PlayerMoveListener;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

/**
 * The main class of the plugin
 * @author Eejit
 */
public final class EejitsTools extends JavaPlugin implements Listener {
    public static EejitsTools plugin;
    Server server = getServer();
    ConsoleCommandSender console = server.getConsoleSender();

    public static EejitsTools getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        console.sendMessage(ChatColor.DARK_AQUA + "EejitsTools has been enabled!");

        server.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        server.getPluginManager().registerEvents(new PlayerInteractListener(), this);
        server.getPluginManager().registerEvents(new PlayerMoveListener(), this);
        Objects.requireNonNull(getCommand("test")).setExecutor(new TestCommand());
        Objects.requireNonNull(getCommand("setid")).setExecutor(new SetIDCommand());

        plugin = this;
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
