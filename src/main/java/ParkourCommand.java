import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class ParkourCommand {
    public static CommandExecutor getExecutor(){
        return ((commandSender, command, s, args) -> {
            Player player  = (Player) commandSender;
            try {
                ParkourPlugin.getInstance().teleportToParkour(player, args[0]);
                player.sendMessage("Teleported to parkour \""+args[0]+"\".");
            }
            catch(Exception exception) {
                player.sendMessage(exception.getMessage());
            }
            return false;
        });
    }
}
