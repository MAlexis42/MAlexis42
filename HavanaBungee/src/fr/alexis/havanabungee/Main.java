package fr.alexis.havanabungee;

import fr.alexis.havanabungee.listeners.ServerPing;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

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

                if(filename.equals("mysql")){
                    Configuration config = getConfig(filename);
                    config.set("mysql.host", "localhost");
                    saveConfig(config, filename);
                }

            }catch(IOException e){

                e.printStackTrace();
            }
        }
    }

    public Configuration getConfig(String fileName){
        try{

        return ConfigurationProvider.getProvider(YamlConfiguration.class).load((new File(getDataFolder(), fileName + ".yml")));
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void saveConfig(Configuration config, String fileName){
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, new File(getDataFolder(), fileName + ".yml"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
