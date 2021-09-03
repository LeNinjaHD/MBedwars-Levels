package com.leprofi.bwlevels.listener.bukkit;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class GUIClickHandler implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();

        switch (event.getView().getTitle()) {
            default:
                break;
            case "§aLevels GUI":
                //todo
                break;
        }
    }
}
