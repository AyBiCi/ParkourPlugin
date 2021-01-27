package Containers;

import org.bukkit.Location;

import java.util.HashMap;

public class Parkours {
    private static HashMap<String, Parkour> parkours = new HashMap<String, Parkour>();

    public void addParkour(String name, Location location) {
        Parkour parkour = new Parkour(name, location);
        parkours.put(name, parkour);
    }

    public Parkour getParkour(String parkourName) {
        return parkours.get(parkourName);
    }
}
