package io.github.NoOne.nMLDefenses;

import org.bukkit.ChatColor;

public enum DefenseType {
    EVASION,
    DEFENSE,
    OVERHEALTH,
    PHYSICALRESIST,
    FIRERESIST,
    COLDRESIST,
    EARTHRESIST,
    LIGHTNINGRESIST,
    AIRRESIST,
    LIGHTRESIST,
    DARKRESIST;

    public static String getDefenseString(DefenseType type) {
        switch (type) {
            case EVASION -> {
                return "Evasion";
            }
            case DEFENSE -> {
                return "Defense";
            }
            case OVERHEALTH -> {
                return "Overhealth";
            }
            case PHYSICALRESIST -> {
                return "Physical Resist";
            }
            case FIRERESIST -> {
                return "Fire Resist";
            }
            case COLDRESIST -> {
                return "Cold Resist";
            }
            case EARTHRESIST -> {
                return "Earth Resist";
            }
            case LIGHTNINGRESIST -> {
                return "Lightning Resist";
            }
            case AIRRESIST -> {
                return "Air Resist";
            }
            case LIGHTRESIST -> {
                return "Light Resist";
            }
            case DARKRESIST -> {
                return "Dark Resist";
            }
            default -> { return null; }
        }
    }

    public static ChatColor getDefenseColor(DefenseType type) {
        ChatColor color = null;

        switch (type) {
            case EVASION, LIGHTRESIST -> color = ChatColor.WHITE;
            case DEFENSE -> color = ChatColor.GREEN;
            case OVERHEALTH -> color = ChatColor.DARK_BLUE;
            case PHYSICALRESIST -> color = ChatColor.DARK_RED;
            case FIRERESIST -> color = ChatColor.RED;
            case COLDRESIST -> color = ChatColor.AQUA;
            case EARTHRESIST -> color = ChatColor.DARK_GREEN;
            case LIGHTNINGRESIST -> color = ChatColor.YELLOW;
            case AIRRESIST -> color = ChatColor.GRAY;
            case DARKRESIST -> color = ChatColor.DARK_PURPLE;
        }

        return color;
    }
}
