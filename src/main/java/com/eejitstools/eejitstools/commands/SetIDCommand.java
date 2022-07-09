package com.eejitstools.eejitstools.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import static com.eejitstools.eejitstools.EejitsTools.getPlugin;

public class SetIDCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            ItemStack activeItem = player.getInventory().getItemInMainHand();
            if (player.hasPermission("eejitstools.set-id")) {
                if (activeItem.getType() == Material.AIR) {
                    player.sendMessage(ChatColor.RED + "You must be holding an item!");
                } else {
                    if (args.length == 1) {
                        String id = args[0].toUpperCase();
                        NamespacedKey key = new NamespacedKey(getPlugin(), "id");
                        ItemMeta itemMeta = activeItem.getItemMeta();
                        itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, id);
                        activeItem.setItemMeta(itemMeta);
                        player.getInventory().setItemInMainHand(activeItem);
                        player.sendMessage(ChatColor.DARK_AQUA + "The item's ID has been set to " + ChatColor.GRAY + id + ChatColor.DARK_AQUA + "!");
                    } else if (args.length > 1) {
                        player.sendMessage(ChatColor.RED + "The ID must be a single word!");
                    } else {
                        player.sendMessage(ChatColor.RED + "Must specify an ID to set to!\nUsage: /setid <id>");
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "This command can only be used by a player!");
        }

        return true;
    }
}
