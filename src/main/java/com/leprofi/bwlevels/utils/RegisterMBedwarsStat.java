package com.leprofi.bwlevels.utils;

import com.leprofi.bwlevels.MBedwarsLevelPlugin;
import de.marcely.bedwars.api.message.Message;
import de.marcely.bedwars.api.player.PlayerStatSet;
import de.marcely.bedwars.api.player.PlayerStats;
import de.marcely.bedwars.tools.Helper;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nullable;

public class RegisterMBedwarsStat {

    public static PlayerStatSet getXPSet;
    public static PlayerStatSet getLevelSet;

    public static void registerXPSet(){
        getXPSet = new registerXPSet();
    }

    public static void registerLevelSet(){
        getLevelSet = new registerLevelSet();
    }

    private static MBedwarsLevelPlugin plugin(){
        return MBedwarsLevelPlugin.getInstance();
    }

    private static class registerXPSet implements PlayerStatSet{
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
            return stats.get("leveladdon:xp").longValue();
        }

        @Override
        public void setValue(PlayerStats stats, Number num){
            stats.set("leveladdon:xp", num);
        }
    }

    private static class registerLevelSet implements PlayerStatSet{

        @Override
        public String getId(){
            return "leveladdon:levels";
        }

        @Override
        public Plugin getPlugin(){
            return plugin();
        }

        @Override
        public String getName(@Nullable CommandSender sender){
            return Message.buildByKey("LevelAddon_Stat_Levels", "Levels").done(sender); // will try to obtain it from the messages file or display "Experience" by default
        }

        @Override
        public String getDisplayedValue(PlayerStats stats){
            return Helper.get().formatNumber(getValue(stats).longValue()); // how it will be displayed in /bw stats
        }

        @Override
        public Number getValue(PlayerStats stats){
            return stats.get("leveladdon:levels").longValue();
        }

        @Override
        public void setValue(PlayerStats stats, Number num){
            stats.set("leveladdon:levels", num);
        }
    }
}
