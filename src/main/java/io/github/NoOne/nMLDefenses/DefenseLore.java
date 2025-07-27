package io.github.NoOne.nMLDefenses;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DefenseLore {
    public static void updateLoreWithElementalDefense(ItemStack armor, ItemMeta meta) {
        DefenseManager defenseManager = new DefenseManager();
        List<String> originalLore = meta.hasLore() ? new ArrayList<>(meta.getLore()) : new ArrayList<>();
        List<String> damageLore = new ArrayList<>();
        HashMap<DefenseType, Double> defenseStats = defenseManager.getAllDefenseStats(armor);

        defenseStats.entrySet().stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue())) // Descending sort
                .forEachOrdered(entry -> {
                    double value = entry.getValue();
                    int valueInt = (int) value;
                    damageLore.add(DefenseType.getDefenseColor(entry.getKey()) + "+ " + valueInt + " " + DefenseType.getDefenseString(entry.getKey()));
                });

        originalLore.addAll(damageLore);
        meta.setLore(originalLore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        armor.setItemMeta(meta);
    }

}
