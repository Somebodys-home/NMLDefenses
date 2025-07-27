package io.github.NoOne.nMLDefenses;

import org.bukkit.plugin.java.JavaPlugin;

public final class NMLDefenses extends JavaPlugin {
    private static NMLDefenses nmlDefenses;
    private DefenseLore defenseLore;
    private DefenseManager defenseManager;

    @Override
    public void onEnable() {
        nmlDefenses = this;
        defenseLore = new DefenseLore();
        defenseManager = new DefenseManager();
    }

    public static NMLDefenses getInstance() {
        return nmlDefenses;
    }

    public DefenseLore getDefenseLore() {
        return defenseLore;
    }

    public DefenseManager getDefenseManager() {
        return defenseManager;
    }
}
