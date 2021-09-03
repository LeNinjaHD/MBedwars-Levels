package com.leprofi.bwlevels.utils;

import de.marcely.bedwars.api.player.PlayerDataAPI;
import de.marcely.bedwars.api.player.PlayerStatSet;
import de.marcely.bedwars.api.player.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class LevelManager {

    private final PlayerStats playerStats;
    public static PlayerStatSet xpSet;

    private int gradualIncreaseAmount;
    private int levelOneXP;

    public LevelManager(String uuid) {
        playerStats = PlayerDataAPI.get().getStatsNow(UUID.fromString(uuid)).get();
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

            return (int) Math.floor((gradualIncreaseAmount + getXP()) / (levelOneXP + gradualIncreaseAmount));
        }else{

            return (int) Math.floor(getXP() / levelOneXP);
        }
    }

    public int getXPToNextLevel(int currentXP, int currentLevel){
        int nextLevel = currentLevel + 1;
        if(gradualIncreaseAmount <= 0){
            //one level higher xp - current xp
            return (nextLevel * levelOneXP) - getXP();
        }else {
            //one level higher xp - current xp
            return ((levelOneXP * nextLevel) + (gradualIncreaseAmount * nextLevel) - gradualIncreaseAmount) - currentXP;
        }
    }
}
