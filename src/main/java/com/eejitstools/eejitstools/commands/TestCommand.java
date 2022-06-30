package com.eejitstools.eejitstools.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (player.hasPermission("eejitstools.test")) {
                player.sendMessage(ChatColor.DARK_GREEN + "You have permission to use this command!");
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            }
        } else {
            sender.sendMessage(ChatColor.DARK_AQUA + "Test command executed!");
        }

        return true;
    }
}
