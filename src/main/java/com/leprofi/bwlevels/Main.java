package com.leprofi.bwlevels;

import com.leprofi.bwlevels.utils.Logger;
import jdk.internal.org.jline.utils.Log;
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
        Logger.info("========== [ MBedWars-Levels ] ==========");
        Logger.info("made by the MetallicGoat & LeNinjaHD");
        Logger.info("v1.0");
        Logger.info("========== [ MBedWars-Levels ] ==========");
    }

    @Override
    public void onDisable() {

    }
}
