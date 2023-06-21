package me.gypopo.inputexecutor.commands;

import me.gypopo.inputexecutor.Main;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class InputRequest extends BukkitCommand {

    private final Main plugin;

    public InputRequest(Main plugin) {
        super("inputrequest");
        this.description = "Requests input from the given player and executes a command";
        this.usageMessage = "/inputrequest player:<player> request:'<request>' command:'<completeCommand>'";
        this.setAliases(Collections.singletonList("input"));

        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        try {
            String cmd = String.join(" ", args);

            Player p = Bukkit.getPlayer(cmd.split("player:")[1].split(" ")[0]);
            if (!p.isOnline()) {
                sender.sendMessage(ChatColor.RED + "Player not found or not online.");
                return true;
            }

            new AnvilGUI.Builder()
                    .onClick((i, state) -> {
                        if (!state.getText().isEmpty())
                            this.executeCommand(p, this.getString(cmd.split("command:")[1])
                                    .replace("%player%", p.getName())
                                    .replace("%input%", ChatColor.translateAlternateColorCodes('&', state.getText())));
                        return Collections.singletonList(AnvilGUI.ResponseAction.close());
                    })
                    .text(" ")
                    .itemLeft(new ItemStack(Material.PAPER))
                    .title(this.getString(cmd.split("request:")[1]))
                    .plugin(this.plugin)
                    .open(p);

            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            sender.sendMessage(ChatColor.RED + "Invalid command syntax. Example: /inputrequest player:<player> request:'<request>' command:'<completeCommand>'");
            return false;
        }
    }

    private String getString(String s) {
        return s.split("'")[1].split("'")[0];
    }

    private void executeCommand(Player p, String s) {
        if (s.startsWith("p:")) {
            Bukkit.dispatchCommand(p, s.substring(2));
        } else {
            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), s);
        }
    }
}
