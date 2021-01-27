package Containers;

import org.bukkit.Location;

public class Parkour {
    private String name;
    private Location location;

    public Parkour(String name, Location location){
        this.name = name;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
