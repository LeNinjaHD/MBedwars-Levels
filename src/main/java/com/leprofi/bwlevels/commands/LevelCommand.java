package com.leprofi.bwlevels.commands;

import com.leprofi.bwlevels.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class LevelCommand implements CommandExecutor, TabCompleter {
    private static final String[] COMMANDS = { "todo" };

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0) {
                Inventory gui = Bukkit.createInventory(player, 54, ChatColor.GREEN + "Levels GUI");

                gui.setItem(13, new ItemBuilder(Material.GREEN_DYE)
                                .setName(ChatColor.GREEN + "Add XP to Player")
                                .addLoreLine(ChatColor.GREEN + "Add a specific Amount of XP Or Levels to a Player")
                                .addLoreLine("")
                                .addLoreLine(ChatColor.GRAY + "Permission: " + ChatColor.DARK_GRAY + "levels.add")
                                .addEnchant(Enchantment.DURABILITY, 1)
                                .addItemFlag(ItemFlag.HIDE_ENCHANTS)
                                .toItemStack()
                );
                player.openInventory(gui);
            } else {
                //TODO: subcommands
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        //create new array
        final List<String> completions = new ArrayList<>();
        //copy matches of first argument from list (ex: if first arg is 'm' will return just 'minecraft')
        StringUtil.copyPartialMatches(args[0], Arrays.asList(COMMANDS), completions);
        //sort the list
        Collections.sort(completions);
        return completions;
    }
}
