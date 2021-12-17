package fr.alexis.havanabungee;

import fr.alexis.havanabungee.listeners.ServerPing;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        getProxy().getConsole().sendMessage("Le plugin marche parfaitement !");
        getProxy().getPluginManager().registerListener(this, new ServerPing());
    }

    @Override
    public void onDisable() {
        getProxy().getConsole().sendMessage("Le plugin s'arrete correctement");
    }

    public static Main getInstance(){
        return instance;
    }
}
