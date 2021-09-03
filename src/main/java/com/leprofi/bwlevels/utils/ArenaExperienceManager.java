package com.leprofi.bwlevels.utils;

import de.marcely.bedwars.api.arena.Arena;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;

public class ArenaExperienceManager {
    private static final HashMap <Player, Integer> playerIntegerHashMap = new HashMap<>();
    private static final HashMap <Arena, Collection<Player>> arenaCollectionHashMap = new HashMap<>();

    public static void registerPlayers(Arena arena){
        arenaCollectionHashMap.put(arena, arena.getPlayers());
    }

    public static void giveArenaXP(Player player, int xp){
        if(playerIntegerHashMap.containsKey(player)){
            int currentXP = playerIntegerHashMap.get(player);
            playerIntegerHashMap.replace(player, currentXP, currentXP + xp);
        }else{
            playerIntegerHashMap.put(player, xp);
        }
    }

    public static void saveArenaXP(Arena arena){
        Collection<Player> players = arenaCollectionHashMap.get(arena);
        players.forEach(player -> {
            if(playerIntegerHashMap.containsKey(player)){
                int xp = playerIntegerHashMap.get(player);
                new LevelManager(player.getUniqueId()).addXP(xp);
            }
        });
    }

    public static void clearMaps(Arena arena){
        Collection<Player> players = arenaCollectionHashMap.get(arena);
        players.forEach(playerIntegerHashMap::remove);
        arenaCollectionHashMap.remove(arena);
    }
}
