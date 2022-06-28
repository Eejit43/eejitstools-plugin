package com.eejitstools.eejitstools;

import org.bukkit.plugin.java.JavaPlugin;

public final class EejitsTools extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("EejitsTools has been enabled!");

    }

    @Override
    public void onDisable() {
        getLogger().info("EejitsTools has been disabled!");
    }

    @Override
    public void onLoad() {
        getLogger().info("EejitsTools has been loaded!");
    }
}
