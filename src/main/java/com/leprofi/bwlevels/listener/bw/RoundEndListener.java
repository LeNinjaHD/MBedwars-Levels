package com.leprofi.bwlevels.listener.bw;

import com.leprofi.bwlevels.MBedwarsLevelPlugin;
import com.leprofi.bwlevels.utils.ArenaExperienceManager;
import com.leprofi.bwlevels.utils.LevelManager;
import de.marcely.bedwars.api.event.arena.RoundEndEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Collection;
import java.util.List;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class RoundEndListener implements Listener {

    private final int winXP = MBedwarsLevelPlugin.getInstance().getConfig().getInt("round-end-win-xp");
    private final int loseXP = MBedwarsLevelPlugin.getInstance().getConfig().getInt("round-end-lose-xp");

    @EventHandler
    public void onRoundEnd(RoundEndEvent event) {
        Collection<Player> winners = event.getWinners();
        event.getArena().getPlayers().forEach(player -> {
            if(winners.contains(player)){
                ArenaExperienceManager.giveArenaXP(player, winXP);
            }else{
                ArenaExperienceManager.giveArenaXP(player, loseXP);
            }
        });

        ArenaExperienceManager.saveArenaXP(event.getArena());
        ArenaExperienceManager.clearMaps(event.getArena());
    }
}
