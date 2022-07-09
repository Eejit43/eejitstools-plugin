package com.eejitstools.eejitstools.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static com.eejitstools.eejitstools.EejitsTools.getPlugin;

public class ReloadConfigCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (player.hasPermission("eejitstools.reloadconfig")) {
                getPlugin().reloadConfig();
                player.sendMessage(ChatColor.DARK_GREEN + "Reloaded the EejitsTools config file!");
            } else {
                player.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            }
        } else {
            getPlugin().reloadConfig();
            sender.sendMessage(ChatColor.DARK_GREEN + "Reloaded the EejitsTools config file!");
        }

        return true;
    }
}
