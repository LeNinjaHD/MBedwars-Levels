package com.leprofi.bwlevels.listener.bw;

import com.leprofi.bwlevels.MBedwarsLevelPlugin;
import com.leprofi.bwlevels.utils.LevelManager;
import de.marcely.bedwars.api.event.arena.ArenaBedBreakEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class ArenaBedBreakListener implements Listener {

    private final int bedBreakXP = MBedwarsLevelPlugin.getInstance().getConfig().getInt("break-bed-xp");

    @EventHandler
    public void onArenaBedBreak(ArenaBedBreakEvent event) {
        Player player = event.getPlayer();
        if(event.isPlayerCaused() && player != null){
            new LevelManager(player.getUniqueId()).addXP(bedBreakXP);
        }
    }
}
