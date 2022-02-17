package dbc.mad.recompensastp.events;

import dbc.mad.recompensastp.RecompensasTP;
import dbc.mad.recompensastp.config.ConfigRewards;
import dbc.mad.recompensastp.reward.Daily;
import dbc.mad.recompensastp.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PlayerClickEvent implements Listener {

    public static ConfigRewards configRewards;

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (e.getWhoClicked() instanceof Player) {
            Player player = (Player) e.getWhoClicked();

            if (e.getInventory().getName().equals("Rewards")) {
                e.setCancelled(true);

                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Teste")) {

                    LocalDate data = LocalDate.now();

                    LocalDate dataDaily = LocalDate.now().plusDays(1);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                    String formattedDateDaily = dataDaily.format(formatter);
                    String formattedDate = data.format(formatter);

                    if (RecompensasTP.usedDaily.containsKey(player.getUniqueId().toString())) {

                        if (formattedDateDaily.equals(formattedDate)) {
                            player.sendMessage("Pd pegar dnv");
                        } else {
                            player.sendMessage("N pd pegar dnv");
                        }

                    } else {
                        RecompensasTP.usedDaily.put(player.getUniqueId().toString(), new Daily("daily", true, formattedDateDaily, 10000));
                    }


                    //Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "jrmctp add " + RecompensasTP.usedDaily.get(player.getUniqueId().toString()).getReward() + " " + player.getDisplayName());
                    player.closeInventory();
                }

            }

        }

    }

}