package com.leprofi.bwlevels.listener.bw;

import com.leprofi.bwlevels.MBedwarsLevelPlugin;
import com.leprofi.bwlevels.utils.ArenaExperienceManager;
import de.marcely.bedwars.api.event.player.PlayerEarnAchievementEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class PlayerEarnAchievementListener implements Listener {

    private final int achievementXP = MBedwarsLevelPlugin.getInstance().getConfig().getInt("achievement-earned-xp");

    @EventHandler
    public void onPlayerEarnAchievement(PlayerEarnAchievementEvent event) {
        Player player = event.getPlayer();
        ArenaExperienceManager.giveArenaXP(player, achievementXP);
    }
}
