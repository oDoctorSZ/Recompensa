package dbc.mad.recompensastp.commands;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RecompensasCommand {

    private Player p;
    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    Inventory inv = Bukkit.createInventory(null, 3*9, color("Rewards"));
    public void run(CommandSender sender, Command cmd,String[] args)
    {
        p = (Player) sender;
        recompensas(inv);
    }

    public void recompensas(Inventory inv) {
        createItem(new ItemStack(Material.APPLE, 1), color("Teste"), inv, 11, Arrays.asList("", color("➣ &aTP Diário: &f10.000"),
                color("➣ O TP apenas poderá ser pego de 1 em 1 dia")));

        LocalDate data = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = data.format(formatter);

        Bukkit.getServer().broadcastMessage("Time: " + formattedDate);

        p.openInventory(inv);
    }

    public void Reeecompensas(Inventory inv) {
        p.openInventory(inv);
        if (!p.hasPermission("recompensasdiarias.use")) {
            int i = 4462;
            @SuppressWarnings("deprecation")
            ItemStack item1 = new ItemStack(i, 1);
            ItemMeta meta = item1.getItemMeta();
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7[ &eTP Diário &7]"));
            ArrayList<String> lore = new ArrayList<>();
            lore.add("\n" + ChatColor.translateAlternateColorCodes('&', "➣ &aTP Diário: &f10.000"));
            lore.add(ChatColor.translateAlternateColorCodes('&', "➣ O TP apenas poderá ser pego de 1 em 1 dia"));
            meta.setLore(lore);
            item1.setItemMeta(meta);
            inv.setItem(11, item1);
        }
        if(!p.hasPermission("recompensassemanais.use")) {
            int i = 4462;
            @SuppressWarnings("deprecation")
            ItemStack item2 = new ItemStack(i, 2);
            ItemMeta meta2 = item2.getItemMeta();
            meta2.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7[ &eTP Semanal &7]"));
            ArrayList<String> lore1 = new ArrayList<>();
            lore1.add("\n" + ChatColor.translateAlternateColorCodes('&', "➣ &aTP Semanal: &f"));
            lore1.add(ChatColor.translateAlternateColorCodes('&', "➣ O TP apenas poderá ser pego novamente em 1 semana"));
            meta2.setLore(lore1);
            item2.setItemMeta(meta2);
            inv.setItem(12, item2);
        }
        if(!p.hasPermission("recompensasmensais.use")) {
            int i = 4462;
            @SuppressWarnings("deprecation")
            ItemStack item3 = new ItemStack(i, 3);
            ItemMeta meta3 = item3.getItemMeta();
            meta3.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7[ &eTP Mensal &7]"));
            ArrayList<String> lore3 = new ArrayList<>();
            lore3.add("\n" + ChatColor.translateAlternateColorCodes('&', "➣ &aTP Mensal: &f10.000"));
            lore3.add(ChatColor.translateAlternateColorCodes('&', "➣ O TP apenas poderá ser pego novamente após o periodo de 1 mês!"));
            meta3.setLore(lore3);
            item3.setItemMeta(meta3);
            inv.setItem(13, item3);
        }
        ItemStack fechar = new ItemStack(Material.REDSTONE_LAMP_ON);
        ItemMeta fecharmeta = fechar.getItemMeta();
        fecharmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cFechar"));
        fechar.setItemMeta(fecharmeta);
        inv.setItem(24, fechar);
    }

    public void createItem(ItemStack item, String name, Inventory inv, int index, List<String> lore) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        inv.setItem(index, item);
    }
}
