package io.github.NoOne.nMLDefenses;

import org.bukkit.plugin.java.JavaPlugin;

public final class NMLDefenses extends JavaPlugin {
    private static NMLDefenses nmlDefenses;
    private DefenseLore defenseLore;

    @Override
    public void onEnable() {
        nmlDefenses = this;
    }

    public static NMLDefenses getInstance() {
        return nmlDefenses;
    }

    public DefenseLore getDefenseLore() {
        return defenseLore;
    }
}
