package com.eejitstools.eejitstools;

import com.eejitstools.eejitstools.commands.ReloadConfigCommand;
import com.eejitstools.eejitstools.commands.SetIDCommand;
import com.eejitstools.eejitstools.listeners.*;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.Objects;
import java.util.logging.Logger;

import static com.eejitstools.eejitstools.util.LogEmbed.logDiscordEmbed;

/**
 * The main class of the plugin
 *
 * @author Eejit
 */
public final class EejitsTools extends JavaPlugin implements Listener {
    public static Logger logger;
    private static EejitsTools plugin;
    Server server = getServer();
    ConsoleCommandSender coloredConsole = server.getConsoleSender();

    public static EejitsTools getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        logger = getLogger();
        plugin = this;

        logger.info("EejitsTools has been enabled!");

        // Register events
        server.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        server.getPluginManager().registerEvents(new PlayerQuitListener(), this);
        server.getPluginManager().registerEvents(new PlayerInteractListener(), this);
        server.getPluginManager().registerEvents(new PlayerMoveListener(), this);
        server.getPluginManager().registerEvents(new PlayerDeathListener(), this);
        server.getPluginManager().registerEvents(new PlayerChatListener(), this);

        // Register commands
        Objects.requireNonNull(getCommand("setid")).setExecutor(new SetIDCommand());
        Objects.requireNonNull(getCommand("reloadconfig")).setExecutor(new ReloadConfigCommand());

        // Save/update config
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();

        // Check if "discord-webhook-url" is valid
        String webhookUrl = getConfig().getString("discord-webhook-url");
        if (webhookUrl != null && !webhookUrl.equalsIgnoreCase("none") && !webhookUrl.matches("^https?://(?:ptb\\.|canary\\.)?discord\\.com/api(?:/v\\d{1,2})?/webhooks/(\\d{17,19})\\/(?:[\\w-]{68}|[\\w-]{24})$")) {
            logger.warning("The Discord webhook URL is invalid! Please set a correct URL or change it to \"none\".");
        }

        // Send message to Discord
        logDiscordEmbed("Logger plugin enabled!", new Color(1, 102, 0));
    }

    @Override
    public void onDisable() {
        logger.info("EejitsTools has been disabled!");
        logDiscordEmbed("Logger plugin disabled!", new Color(121, 23, 23));
    }

    @Override
    public void onLoad() {
        getLogger().info("EejitsTools has been loaded!");
    }
}
