package com.eejitstools.eejitstools.util;

import org.bukkit.entity.Player;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

import static com.eejitstools.eejitstools.EejitsTools.getPlugin;
import static com.eejitstools.eejitstools.EejitsTools.logger;

public class LogEmbed {

    /**
     * Sends an embed to the "discord-webhook-url" config value
     *
     * @param message The message to send to Discord
     */
    public static void logDiscordEmbed(String message) {
        logDiscordEmbed(message, new Color(17, 34, 51), null, false);
    }

    /**
     * Sends an embed to the "discord-webhook-url" config value
     *
     * @param message The message to send to Discord
     * @param color   The color of the embed
     */
    public static void logDiscordEmbed(String message, Color color) {
        logDiscordEmbed(message, color, null, false);
    }

    /**
     * Sends an embed to the "discord-webhook-url" config value
     *
     * @param message The message to send to Discord
     * @param color   The color of the embed
     * @param player  The player referenced in the embed (for footer)
     */
    public static void logDiscordEmbed(String message, Color color, Player player) {
        logDiscordEmbed(message, color, player, false);
    }

    /**
     * Sends an embed to the "discord-webhook-url" config value
     *
     * @param message The message to send to Discord
     * @param player  The player referenced in the embed (for footer)
     */
    public static void logDiscordEmbed(String message, Player player) {
        logDiscordEmbed(message, new Color(17, 34, 51), player, false);
    }

    /**
     * Sends an embed to the "discord-webhook-url" config value
     *
     * @param message   The message to send to Discord
     * @param color     The color of the embed
     * @param player    The player referenced in the embed (for footer)
     * @param thumbnail Whether to include the player's avatar as the thumbnail in the embed (requires player)
     */
    public static void logDiscordEmbed(String message, Color color, Player player, boolean thumbnail) {
        String webhookUrl = getPlugin().getConfig().getString("discord-webhook-url");
        String serverName = getPlugin().getConfig().getString("server-name");

        if (webhookUrl != null && webhookUrl.matches("^https?://(?:ptb\\.|canary\\.)?discord\\.com/api(?:/v\\d{1,2})?/webhooks/(\\d{17,19})\\/(?:[\\w-]{68}|[\\w-]{24})$")) {
            DiscordWebhook webhook = new DiscordWebhook(webhookUrl);

            DiscordWebhook.EmbedObject embed = new DiscordWebhook.EmbedObject();
            embed.setTitle(serverName != null ? serverName : "Minecraft Server");
            embed.setDescription(message);
            embed.setColor(color);
            if (player != null && thumbnail)
                embed.setThumbnail("https://minotar.net/armor/bust/" + player.getUniqueId().toString().replaceAll("-", ""));
            if (player != null)
                embed.setFooter(player.getName(), "https://minotar.net/helm/" + player.getUniqueId().toString().replaceAll("-", "") + "/64");

            webhook.addEmbed(embed);

            try {
                webhook.execute();
            } catch (IOException error) {
                logger.severe(Arrays.toString(error.getStackTrace()));
            }
        }
    }
}