package com.leprofi.bwlevels;

import com.leprofi.bwlevels.utils.LevelManager;
import de.marcely.bedwars.api.message.Message;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

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
            return String.valueOf(levelManager(player.getUniqueId()).getXP());
        }
        if(params.equalsIgnoreCase("level")) {
            return String.valueOf(levelManager(player.getUniqueId()).getLevel());
        }
        if(params.equalsIgnoreCase("level-formatted")) {
            String placeholder = plugin().getConfig().getString("xp-formatted-placeholder");
            return Message.build(placeholder).placeholder("xp", levelManager(player.getUniqueId()).getLevel()).done();
        }
        if(params.equalsIgnoreCase("level-progress")) {
            String placeholder = plugin().getConfig().getString("level-progress");
            return Message.build(placeholder)
                    .placeholder("level-xp", levelManager(player.getUniqueId()).getXPOnCurrentLevel())
                    .placeholder("level-xp-required", levelManager(player.getUniqueId()).getLevelXPRequired())
                    .done();
        }
        return null;
    }

    private static LevelManager levelManager(UUID uuid){
        return new LevelManager(uuid);
    }

    private static MBedwarsLevelPlugin plugin(){
        return MBedwarsLevelPlugin.getInstance();
    }
}
