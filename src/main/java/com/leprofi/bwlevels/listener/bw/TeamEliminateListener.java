package com.leprofi.bwlevels.listener.bw;

import com.leprofi.bwlevels.MBedwarsLevelPlugin;
import de.marcely.bedwars.api.event.arena.TeamEliminateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class TeamEliminateListener implements Listener {

    private final int XP = MBedwarsLevelPlugin.getInstance().getConfig().getInt("");

    @EventHandler
    public void onTeamEliminate(TeamEliminateEvent event) {
        // I dont think we need this event
    }
}
