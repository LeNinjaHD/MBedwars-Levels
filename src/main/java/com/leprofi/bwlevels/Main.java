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
        if (Bukkit.getPluginManager().getPlugin("MBedwars") == null) {
            Logger.error("MBedwars was not Found! Disabling Plugin!");
            getServer().getPluginManager().disablePlugin(this);
        }

    }

    @Override
    public void onDisable() {

    }
}
