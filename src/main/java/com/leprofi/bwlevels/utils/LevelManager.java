package com.leprofi.bwlevels.utils;

import com.leprofi.bwlevels.MBedwarsLevelPlugin;
import de.marcely.bedwars.api.player.PlayerDataAPI;
import de.marcely.bedwars.api.player.PlayerStatSet;
import de.marcely.bedwars.api.player.PlayerStats;

import java.util.UUID;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class LevelManager {

    private PlayerStats playerStats;
    public static PlayerStatSet xpSet = RegisterMBedwarsStat.getXPSet;

    private final int gradualIncreaseAmount = plugin().getConfig().getInt("xp-increase-rate");
    private final int baseXPAmount = plugin().getConfig().getInt("base-xp");

    public LevelManager(UUID uuid) {
        PlayerDataAPI.get().getStats(uuid, stats -> playerStats = stats);
    }

    public void addXP(Integer xp) {
        xpSet.setValue(playerStats, xpSet.getValue(playerStats).intValue() + xp);
    }

    public int getXP(){
        return xpSet.getValue(playerStats).intValue();
    }

    public void addLevels(Integer levels) {
        int xpToAdd = 0;
        int currentLevel = getLevel();

        for (int i = 0; i < levels; i++) {
            xpToAdd += getXPToNextLevel(getXP(), currentLevel);
            currentLevel++;
        }

        addXP(xpToAdd);
    }

    public int getLevel(){
        if(gradualIncreaseAmount <= 0){

            /*

            l = level
            x = amount of xp
            i = amount of increase per level
            d = amount of xp to get to level 1

            (dl + il) - i = xp

            round down

             */

            return (int) Math.floor((gradualIncreaseAmount + getXP()) / (baseXPAmount + gradualIncreaseAmount)) + 1;
        }else{
            return (int) Math.floor(getXP() / baseXPAmount) + 1;
        }
    }

    public int getXPToNextLevel(){
        int nextLevel = getLevel() + 1;
        if(gradualIncreaseAmount <= 0){
            //one level higher xp - current xp
            return (nextLevel * baseXPAmount) - getXP();
        }else {
            //one level higher xp - current xp
            return ((baseXPAmount * nextLevel) + (gradualIncreaseAmount * nextLevel) - gradualIncreaseAmount) - getXP();
        }
    }

    public int getXPOnCurrentLevel(){
        return getXP() - getXPToNextLevel(0, getLevel());
    }

    public int getLevelXPRequired(){
        return getXPToNextLevel(0, getLevel() + 1) - getXPToNextLevel(0, getLevel());
    }

    private int getXPToNextLevel(int currentXP, int currentLevel){
        int nextLevel = currentLevel + 1;
        if(gradualIncreaseAmount <= 0){
            //one level higher xp - current xp
            return (nextLevel * baseXPAmount) - currentXP;
        }else {
            //one level higher xp - current xp
            return ((baseXPAmount * nextLevel) + (gradualIncreaseAmount * nextLevel) - gradualIncreaseAmount) - currentXP;
        }
    }


    public static MBedwarsLevelPlugin plugin(){
        return MBedwarsLevelPlugin.getInstance();
    }
}
