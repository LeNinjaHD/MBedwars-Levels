package com.leprofi.bwlevels;

import com.leprofi.bwlevels.utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("MBedwars") == null &&
         Bukkit.getPluginManager().getPlugin("MBedwars").getDescription().getVersion().startsWith("5.0")) {
            Logger.error("MBedwars was not found! Disabling Plugin!");
            getServer().getPluginManager().disablePlugin(this);
        }

    }

    @Override
    public void onDisable() {

    }
}
