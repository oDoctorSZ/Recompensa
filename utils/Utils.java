package dbc.mad.recompensastp.utils;

import dbc.mad.recompensastp.RecompensasTP;
import dbc.mad.recompensastp.config.ConfigRewards;
import dbc.mad.recompensastp.reward.Daily;

import java.util.Set;

public class Utils {

    public static ConfigRewards configRewards;

    public static void initializeObj() {

        configRewards = new ConfigRewards(RecompensasTP.getPlugin(), "register.yml");
        configRewards.saveConfig();

        try {
                Set<String> players = configRewards.getSection("players").getKeys(false);

                players.forEach(uuid -> {

                String name = configRewards.getConfig().getString("players."+uuid+".daily");
                boolean used = configRewards.getConfig().getBoolean("players."+uuid+".daily.used");
                String duration = configRewards.getConfig().getString("players."+uuid+".daily.duration");
                int reward = configRewards.getConfig().getInt("players."+uuid+".daily.reward");

                RecompensasTP.usedDaily.put(uuid, new Daily(name, used, duration, reward));

            });

        } catch (Exception x) {}


    }



}
