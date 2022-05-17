package net.prolieum.antifwcrossbow;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Antifwcrossbow extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().info("Ready!");

        Bukkit.getPluginManager().registerEvents(new OnPlayerInteract(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info("Shutdown!");
    }
}
