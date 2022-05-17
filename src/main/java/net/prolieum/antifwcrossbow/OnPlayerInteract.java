package net.prolieum.antifwcrossbow;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;

import java.util.Objects;

public class OnPlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE) return;

        ItemStack itemStack = player.getInventory().getItemInMainHand();
        ItemStack offhand = player.getInventory().getItemInOffHand();

        if (itemStack.getType() == Material.CROSSBOW & offhand.getType() == Material.FIREWORK_ROCKET) {
            if (((CrossbowMeta) Objects.requireNonNull(itemStack.getItemMeta())).getChargedProjectiles().size() > 0) return;
            event.setCancelled(true);
            player.sendMessage("§cUsing fireworks in crossbows is disabled.");
        } else if (offhand.getType() == Material.CROSSBOW && itemStack.getType() == Material.FIREWORK_ROCKET) {
            if (((CrossbowMeta) Objects.requireNonNull(offhand.getItemMeta())).getChargedProjectiles().size() > 0) return;
            event.setCancelled(true);
            player.sendMessage("§cUsing fireworks in crossbows is disabled.");
        }
    }
}
