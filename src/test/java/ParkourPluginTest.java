import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ParkourPluginTest {

    ServerMock server;
    PlayerMock player;
    World world;

    @BeforeEach
    public void setUp()
    {
        server = MockBukkit.mock();
        MockBukkit.load(ParkourPlugin.class);
        world = server.addSimpleWorld("world");
        player = server.addPlayer();
    }
    @AfterEach
    public void tearDown()
    {
        MockBukkit.unmock();
    }

    @Test
    public void superTest() {
        player.teleport(new Location(world, 100, 5, 20));
        player.performCommand("pka add parkourname");
        assertEquals(player.nextMessage(), "Added parkour with name \"parkourname\".");
        player.teleport(new Location(world, 0, 0, 0));
        player.performCommand("pk parkourname");
        assertEquals("Teleported to parkour \"parkourname\".", player.nextMessage());
        player.assertTeleported(new Location(world, 100, 5, 20), 1);

        //Stand green and red wool for begin and end of a parkour
        world.getBlockAt(new Location(world, 110, 5, 22)).setType(Material.GREEN_WOOL);
        world.getBlockAt(new Location(world, 200, 10, 40)).setType(Material.RED_WOOL);

        player.teleport(new Location(world, 110, 7, 22));
    }

}
