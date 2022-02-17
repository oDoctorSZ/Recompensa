package dbc.mad.recompensastp;

import dbc.mad.recompensastp.commands.CommandManager;
import dbc.mad.recompensastp.events.PlayerClickEvent;
import dbc.mad.recompensastp.manager.RewardManager;
import dbc.mad.recompensastp.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class RecompensasTP extends JavaPlugin {

    public static HashMap<String, RewardManager> usedDaily = new HashMap<>();

    public static List<RewardManager> rewardsList = new ArrayList<>();

    @Override
    public void onEnable() {
        getCommand("recompensas").setExecutor(new CommandManager());
        Bukkit.getPluginManager().registerEvents(new PlayerClickEvent(), this);

        Utils.initializeObj();
    }

    @Override
    public void onDisable() {
        usedDaily.forEach((uuid, manager) -> {
            Utils.configRewards.getConfig().set("players."+uuid+".daily", manager.getName());
            Utils.configRewards.getConfig().set("players."+uuid+".daily.used", manager.isUsed());
            Utils.configRewards.getConfig().set("players."+uuid+".daily.durantion", manager.getDuration());
            Utils.configRewards.getConfig().set("players."+uuid+".daily.reward", manager.getReward());
        });

        Utils.configRewards.saveConfig();
    }

    public static RecompensasTP getPlugin() {
        return RecompensasTP.getPlugin(RecompensasTP.class);
    }

}
