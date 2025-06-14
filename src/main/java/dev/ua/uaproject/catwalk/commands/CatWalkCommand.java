package dev.ua.uaproject.catwalk.commands;

import dev.ua.uaproject.catwalk.CatWalkMain;
import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.ChatColor.*;

public class CatWalkCommand implements CommandExecutor, TabCompleter {

    private final CatWalkMain main;

    public CatWalkCommand(CatWalkMain main) {
        this.main = main;

        PluginCommand pluginCommand = main.getCommand("catwalk");
        if (pluginCommand != null) {
            pluginCommand.setTabCompleter(this);
            pluginCommand.setExecutor(this);
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (!commandSender.hasPermission("catwalk.admin")) {
            commandSender.sendMessage(String.format("%s[%sCatWalk%s] %sYou do not have the permission to do that!", DARK_GRAY, BLUE, DARK_GRAY, AQUA));
            return false;
        }

        if (args.length == 1) {
            switch (args[0]) {
                case "reload":
                    main.reload();
                    commandSender.sendMessage(String.format("%s[%sCatWalk%s] %sCatWalk reloaded!", DARK_GRAY, BLUE, DARK_GRAY, AQUA));
                    break;
                case "info":
                    String version = main.getDescription().getVersion();
                    String website = main.getDescription().getWebsite();
                    String authors = String.join(", ", main.getDescription().getAuthors());
                    commandSender.sendMessage(String.format("%sCatWalk Plugin Information:\n%sVersion: %s%s\n%sWebsite: %s%s\n%sAuthors: %s%s",
                            BLUE, BLUE, AQUA, version, BLUE, AQUA, website, BLUE, AQUA, authors));
                    break;
                default:
                    commandSender.sendMessage(String.format("%s[%sCatWalk%s] %sUnknown Command.", DARK_GRAY, BLUE, DARK_GRAY, AQUA));
                    return false;
            }
            return true;
        }
        return false;
    }

    @Override
    @Nullable
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (!commandSender.hasPermission("catwalk.admin")) {
            return null;
        }
        ArrayList<String> completions = new ArrayList<>();
        if (args.length == 0 || (args.length == 1 && args[0].isEmpty())) {
            completions.add("reload");
            completions.add("info");
        }
        return completions;
    }
}
