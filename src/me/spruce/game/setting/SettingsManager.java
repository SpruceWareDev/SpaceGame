package me.spruce.game.setting;

import me.spruce.game.Loop;

import java.util.concurrent.CopyOnWriteArrayList;

public class SettingsManager {

    public CopyOnWriteArrayList<Setting<?>> settings;

    public SettingsManager(Loop loop){
        settings = new CopyOnWriteArrayList<>();

        addSetting(new Setting<>("Trails", true));
        addSetting(new Setting<>("Invincible", false));
    }

    public void addSetting(Setting<?> setting){
        this.settings.add(setting);
    }

    public CopyOnWriteArrayList<Setting<?>> getSettings() {
        return settings;
    }

    public Setting<?> getSettingByName(String name) {
        return getSettings().stream()
                .filter(setting -> setting.name.equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }
}
