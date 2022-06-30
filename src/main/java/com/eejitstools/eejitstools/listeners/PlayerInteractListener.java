package com.eejitstools.eejitstools.listeners;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static com.eejitstools.eejitstools.EejitsTools.getPlugin;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item != null && (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            String itemId = NBTEditor.getString(item, "id");
            if (itemId == null) return;

            player.sendMessage(ChatColor.DARK_AQUA + "The item's ID is " + ChatColor.GRAY + itemId + ChatColor.DARK_AQUA + "!");

            switch (itemId) {
                case "TEST_ITEM":
                    player.sendMessage(ChatColor.BLUE + "You clicked with the test item!");
                    break;
                default:
                    getPlugin().getServer().getConsoleSender().sendMessage(ChatColor.GRAY + player.displayName().toString() + ChatColor.RESET + " clicked with an item with an unknown ID! (" + ChatColor.GRAY + itemId + ")");
                    break;
            }
        }
    }
}
