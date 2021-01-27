import Containers.Parkours;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;

public class ParkourPlugin extends JavaPlugin {

    private Parkours parkours;
    public Parkours getParkours() {
        return parkours;
    }

    int nextID = 1;

    @Override
    public void onEnable() {
        instance = this;
        parkours = new Parkours();
        getCommand("pka").setExecutor(ParkourAdmin.createExecutor());
        getCommand("pk").setExecutor(ParkourCommand.getExecutor());
    }

    private static ParkourPlugin instance;
    public static ParkourPlugin getInstance() {
        return instance;
    }


    public void teleportToParkour(Player player, String parkourName){
        player.teleport(parkours.getParkour(parkourName).getLocation());
    }

    //For Bukkit
    public ParkourPlugin(){ }

    //For MockBukkit
    protected ParkourPlugin(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file)
    {
        super(loader, description, dataFolder, file);
    }
}
