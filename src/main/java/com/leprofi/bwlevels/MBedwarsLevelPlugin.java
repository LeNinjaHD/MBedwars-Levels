package com.leprofi.bwlevels;

import com.leprofi.bwlevels.listener.bw.*;
import com.leprofi.bwlevels.utils.ConfigUpdater;
import com.leprofi.bwlevels.utils.Logger;
import com.leprofi.bwlevels.utils.Metrics;
import com.leprofi.bwlevels.utils.RegisterMBedwarsStat;
import de.marcely.bedwars.api.BedwarsAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
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
            //Works for 5.0+ because class doesn't exist in 4.0
            Class.forName("de.marcely.bedwars.api.GameAPI");
        }catch(ClassNotFoundException e){
            Logger.error("MBedwars was not found, or is outdated! Disabling Plugin..");
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

        BedwarsAPI.onReady(() -> {
            //Load papi Placeholders after Registered
            RegisterMBedwarsStat.registerXPSet();
        });

        PluginManager pl = Bukkit.getPluginManager();
        pl.registerEvents(new ArenaBedBreakListener(), this);
        pl.registerEvents(new PlayerEarnAchievementListener(), this);
        pl.registerEvents(new PlayerKillPlayerListener(), this);
        pl.registerEvents(new RoundEndListener(), this);
        pl.registerEvents(new TeamEliminateListener(), this);
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
