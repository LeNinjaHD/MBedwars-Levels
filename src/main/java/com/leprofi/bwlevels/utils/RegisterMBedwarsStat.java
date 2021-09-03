package com.leprofi.bwlevels.utils;

import com.leprofi.bwlevels.MBedwarsLevelPlugin;
import de.marcely.bedwars.api.message.Message;
import de.marcely.bedwars.api.player.PlayerStatSet;
import de.marcely.bedwars.api.player.PlayerStats;
import de.marcely.bedwars.tools.Helper;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nullable;

//TODO this

public class RegisterMBedwarsStat implements PlayerStatSet {

    public static void registerXPSet(){
        LevelManager.xpSet = new RegisterMBedwarsStat();
    }

    @Override
    public String getId(){
        return "leveladdon:experience";
    }

    @Override
    public Plugin getPlugin(){
        return plugin();
    }

    @Override
    public String getName(@Nullable CommandSender sender){
        return Message.buildByKey("LevelAddon_Stat_Experience", "Experience").done(sender); // will try to obtain it from the messages file or display "Experience" by default
    }

    @Override
    public String getDisplayedValue(PlayerStats stats){
        return Helper.get().formatNumber(getValue(stats).longValue()); // how it will be displayed in /bw stats
    }

    @Override
    public Number getValue(PlayerStats stats){
        return stats.get("leveladdon:exp").longValue();
    }

    @Override
    public void setValue(PlayerStats stats, Number num){
        stats.set("leveladdon:exp", num);
    }

    public static MBedwarsLevelPlugin plugin(){
        return MBedwarsLevelPlugin.getInstance();
    }
}
