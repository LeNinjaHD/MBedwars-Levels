package com.leprofi.bwlevels.listener.bw;

import de.marcely.bedwars.api.event.arena.ArenaBedBreakEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class ArenaBedBreakListener implements Listener {
    @EventHandler
    public void onArenaBedBreak(ArenaBedBreakEvent event) {
        if(event.isPlayerCaused()){
            Player player = event.getPlayer();
            //TODO
        }
    }
}
