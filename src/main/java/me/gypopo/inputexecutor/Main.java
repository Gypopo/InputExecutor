package me.gypopo.inputexecutor;

import me.gypopo.inputexecutor.commands.InputRequest;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

            commandMap.register("inputexecutor", new InputRequest(this));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
