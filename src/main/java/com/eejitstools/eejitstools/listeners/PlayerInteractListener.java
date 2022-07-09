package com.eejitstools.eejitstools.listeners;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

import static com.eejitstools.eejitstools.EejitsTools.getPlugin;
import static com.eejitstools.eejitstools.EejitsTools.logger;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item != null && (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            NamespacedKey key = new NamespacedKey(getPlugin(), "id");
            ItemMeta itemMeta = item.getItemMeta();
            PersistentDataContainer tagContainer = itemMeta.getPersistentDataContainer();

            if (tagContainer.has(key, PersistentDataType.STRING)) {
                String id = tagContainer.get(key, PersistentDataType.STRING);
                player.sendMessage(ChatColor.DARK_AQUA + "The item's ID is " + ChatColor.GRAY + id + ChatColor.DARK_AQUA + "!");

                switch (Objects.requireNonNull(id)) {
                    case "TEST_ITEM":
                        event.setCancelled(true);
                        player.sendMessage(ChatColor.BLUE + "You clicked with the test item!");
                        break;
                    default:
                        logger.info(player.getName() + " clicked with an item with an unknown ID! (" + id + ")");
                        break;
                }
            }
        }
    }
}
