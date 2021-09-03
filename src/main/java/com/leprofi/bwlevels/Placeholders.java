package com.leprofi.bwlevels;

import com.leprofi.bwlevels.utils.LevelManager;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

/*
 *  Class Created by LeNinjaHD at 03.09.2021
 */
public class Placeholders extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "levels";
    }

    @Override
    public @NotNull String getAuthor() {
        return "LeNinjaHD & MetallicGoat";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if(params.equalsIgnoreCase("xp")) {
            new LevelManager(player.getUniqueId()).getXP();
        }
        if(params.equalsIgnoreCase("level")) {
            new LevelManager(player.getUniqueId()).getLevel();
        }
        return null;
    }
}
