package com.leprofi.bwlevels;

import com.leprofi.bwlevels.utils.Logger;
import com.leprofi.bwlevels.utils.Metrics;
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
public class MBedwarsLevelPlugin extends JavaPlugin {

    private static MBedwarsLevelPlugin instance;

    @Override
    public void onEnable() {

        instance = this;

        try{
            Class.forName("de.marcely.bedwars.api.GameAPI");
        }catch(ClassNotFoundException e){
            Logger.error("MBedwars was not found! Disabling Plugin..");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        loadConfig();

        PluginDescriptionFile pdf = this.getDescription();

        Logger.info("========== [ MBedWars-Levels ] ==========");
        Logger.info("Created By: " + pdf.getAuthors());
        Logger.info("Version: " + pdf.getVersion());
        Logger.info("========== [ MBedWars-Levels ] ==========");

        int pluginId = 12681;
        Metrics metrics = new Metrics(this, pluginId);

        new LevelAddon(this).register();
    }

    @Override
    public void onDisable() {

    }

    public static MBedwarsLevelPlugin getInstance(){
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
