package io.github.NoOne.nMLDefenses;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import java.util.HashMap;

public class DefenseManager {
    private static NMLDefenses plugin = null;

    public DefenseManager() {
        plugin = NMLDefenses.getInstance();
    }

    private static NamespacedKey makeKeyFor(DefenseType type) {
        return new NamespacedKey(plugin, DefenseType.getDefenseString(type).replaceAll(" ", ""));
    }

    public static void setDefense(ItemStack armor, DefenseType type, double amount) {
        NamespacedKey key = makeKeyFor(type);
        ItemMeta meta = armor.getItemMeta();
        assert meta != null;
        PersistentDataContainer armorContainer = meta.getPersistentDataContainer();

        armorContainer.set(key, PersistentDataType.DOUBLE, amount);
        armor.setItemMeta(meta);
    }

    public double getDefenseValue(ItemStack armor, DefenseType type) {
        NamespacedKey key = makeKeyFor(type);
        ItemMeta meta = armor.getItemMeta();
        PersistentDataContainer armorContainer = meta.getPersistentDataContainer();

        if (hasDefenseType(armor, type)) {
            return armorContainer.get(key, PersistentDataType.DOUBLE);
        }
        return -1;
    }

    public boolean hasDefenseType(ItemStack armor, DefenseType type) {
        if (armor == null) {
            return false;
        }

        NamespacedKey key = makeKeyFor(type);
        ItemMeta meta = armor.getItemMeta();
        PersistentDataContainer armorContainer = meta.getPersistentDataContainer();

        return armorContainer.has(key, PersistentDataType.DOUBLE);
    }

    public HashMap<DefenseType, Double> getAllDefenseStats(ItemStack armor) {
        HashMap<DefenseType, Double> damageStats = new HashMap<>();

        for (DefenseType type : DefenseType.values()) {
            if (hasDefenseType(armor, type)) {
                damageStats.put(type, getDefenseValue(armor, type));
            } 
        }
        return damageStats;
    }
}