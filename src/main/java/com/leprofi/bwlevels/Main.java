package com.leprofi.bwlevels;

import com.leprofi.bwlevels.utils.Logger;
import com.tchristofferson.configupdater.ConfigUpdater;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {

        instance = this;

        if (Bukkit.getPluginManager().getPlugin("MBedwars") == null &&
         Bukkit.getPluginManager().getPlugin("MBedwars").getDescription().getVersion().startsWith("5.0")) {
            Logger.error("MBedwars was not found or it is outdated! Disabling Plugin!");
            getServer().getPluginManager().disablePlugin(this);
        }

        loadConfig();

        PluginDescriptionFile pdf = this.getDescription();

        Logger.info("========== [ MBedWars-Levels ] ==========");
        Logger.info("Created By: " + pdf.getAuthors());
        Logger.info("Version: " + pdf.getVersion());
        Logger.info("========== [ MBedWars-Levels ] ==========");
    }

    @Override
    public void onDisable() {

    }

    public static Main getInstance(){
        return instance;
    }

    private void loadConfig(){
        saveDefaultConfig();
        File configFile = new File(getDataFolder(), "config.yml");

        try {
            ConfigUpdater.update(this, "config.yml", configFile, Collections.singletonList("Nothing-Here"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        reloadConfig();
    }
}
