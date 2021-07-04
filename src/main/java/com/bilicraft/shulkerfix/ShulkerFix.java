package com.bilicraft.shulkerfix;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ShulkerFix extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler(ignoreCancelled = true)
    public void shulkerTarget(EntityTargetEvent event) {
        processTargetEvent(event);
    }

    @EventHandler(ignoreCancelled = true)
    public void shulkerTarget(EntityTargetLivingEntityEvent event) {
        processTargetEvent(event);
    }

    private void processTargetEvent(EntityTargetEvent event) {
        if (event.getTarget() == null) {
            return;
        }
        if (event.getEntity().getType() == EntityType.SHULKER && event.getTarget().getType() == EntityType.SHULKER) {
            event.setCancelled(true);
        }
    }
}
