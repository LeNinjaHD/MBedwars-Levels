package com.leprofi.bwlevels.listener.bw;

import de.marcely.bedwars.api.event.player.PlayerEarnAchievementEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class PlayerEarnAchievementListener implements Listener {
    @EventHandler
    public void onPlayerEarnAchievement(PlayerEarnAchievementEvent event) {
        Player player = event.getPlayer();
        //TODO
    }
}
