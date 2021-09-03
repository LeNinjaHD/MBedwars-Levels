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

    private Player player;
    private final PlayerStats playerStats;
    public static PlayerStatSet xpSet;

    private int gradualIncreaseAmount;
    private int levelOneXP;

    public LevelManager(String uuid) {
        player = Bukkit.getPlayer(uuid);
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
        int currentLevel = getLevel() + 1;

        //for loop
        xpToAdd += getXPToNextLevel(getXP(), currentLevel);
        currentLevel++;


        addXP(xpToAdd);
    }

    public int getLevel(){
        if(gradualIncreaseAmount <= 0){

            /*

            l = level
            xp = amount of xp
            i = amount of increase per level
            d = amount of xp to get to level 1

            (dx + ix) - i = xp
            round down

             */

            return 1;
        }else{
            /*
            xp / amount of xp per level
            Round down
             */

            return 0;
        }
    }

    public int getXPToNextLevel(int currentXP, int currentLevel){
        int nextLevel = currentLevel + 1;
        return (getXPToLevel(nextLevel)) - currentXP;
    }

    private int getXPToLevel(int level){
        return (levelOneXP * level) + (gradualIncreaseAmount * level) - gradualIncreaseAmount;
    }
}
