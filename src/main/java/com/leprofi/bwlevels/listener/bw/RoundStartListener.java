package com.leprofi.bwlevels.listener.bw;

import com.leprofi.bwlevels.utils.ArenaExperienceManager;
import de.marcely.bedwars.api.event.arena.RoundStartEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class RoundStartListener implements Listener {

    @EventHandler
    public void onRoundStart(RoundStartEvent e){
        ArenaExperienceManager.registerPlayers(e.getArena());
    }
}
