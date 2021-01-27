import com.github.aybici.Subcommand;
import com.github.aybici.SubcommandExecutor;
import org.bukkit.entity.Player;

public class ParkourAdmin {
    public static SubcommandExecutor createExecutor(){
        SubcommandExecutor executor = new SubcommandExecutor("pka");
        executor.addCommandExecutor(new Subcommand(
                "add",
                "<parkour_name>",
                "add new parkour where you stand on",
                ((commandSender, command, s, args) -> {
                    Player player  = (Player) commandSender;
                    ParkourPlugin.getInstance().getParkours().addParkour(args[0], player.getLocation());
                    player.sendMessage("Added parkour with name \""+args[0]+"\".");
                    return false;
                })
        ));

        return executor;
    }
}
