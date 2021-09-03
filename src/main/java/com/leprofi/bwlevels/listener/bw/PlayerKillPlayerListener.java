package com.leprofi.bwlevels.listener.bw;

import de.marcely.bedwars.api.BedwarsAPI;
import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.arena.Team;
import de.marcely.bedwars.api.event.player.PlayerKillPlayerEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class PlayerKillPlayerListener implements Listener {
    @EventHandler
    public void onPlayerKillPlayer(PlayerKillPlayerEvent event) {
        Player killer = event.getDamaged(); // Give points to this guy
        Player deadGuy = event.getPlayer();

        Arena arena = event.getArena();
        Team teamOfDeadGuy = arena.getPlayerTeam(deadGuy);

        if(arena.isBedDestroyed(teamOfDeadGuy)){
            //TODO final kill
        }else{
            //TODO regular kill
        }
    }
}
