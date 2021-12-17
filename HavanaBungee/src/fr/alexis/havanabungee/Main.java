package fr.alexis.havanabungee;

import fr.alexis.havanabungee.listeners.ServerPing;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Main extends Plugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        getProxy().getConsole().sendMessage("Le plugin marche parfaitement !");
        getProxy().getPluginManager().registerListener(this, new ServerPing());
        createFile("config");
        createFile("mysql");
    }

    @Override
    public void onDisable() {
        getProxy().getConsole().sendMessage("Le plugin s'arrete correctement");
    }

    public static Main getInstance(){
        return instance;
    }

    private void createFile (String filename) {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        File file = new File(getDataFolder(), filename + ".yml");

        if (!file.exists()) {
            try {

                file.createNewFile();

            }catch(IOException e){

                e.printStackTrace();
            }
        }
    }
}
