package fr.alexis.havanabungee.listeners;

import fr.alexis.havanabungee.Main;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerPing implements Listener {

    @EventHandler
    public void onPing(ProxyPingEvent e){
        ServerInfo serverInfo = Main.getInstance().getProxy().getServerInfo("lobby");
        Main.getInstance().getProxy().getConsole().sendMessage("Informations concernant le serveur: " + serverInfo.getName());
        Main.getInstance().getProxy().getConsole().sendMessage("Joueurs connectés :" + serverInfo.getPlayers().size());
        Main.getInstance().getProxy().getConsole().sendMessage("Port du serveur :" + serverInfo.getAddress().getPort());
    }
}
