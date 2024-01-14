package me.will0mane.plugins.adventurestopper.lamp;

import me.will0mane.plugins.pulse.api.plugin.Pulse;
import me.will0mane.plugins.pulse.velocity.commands.CommandUserVelocity;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Flag;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;
import revxrsal.commands.velocity.VelocityCommandActor;

@Command("advstop")
@CommandPermission("adventure.stopper")
public class StopperCommandsVel {

    private final Pulse adventure = Pulse.instance();
    private final StopperUtils utils = new StopperUtils(adventure);

    @Subcommand("now")
    @CommandPermission("adventure.stopper.now")
    public void now(VelocityCommandActor actor, String credentials, @Default("ALL") @Flag String server) {
        utils.nowUtils(new CommandUserVelocity(actor), server, credentials);
    }

    @Subcommand("after")
    @CommandPermission("adventure.stopper.after")
    public void after(VelocityCommandActor actor, String credentials, long ticks, @Default("ALL") @Flag String server) {
        utils.afterUtils(new CommandUserVelocity(actor), server, credentials, ticks);
    }

//    @Subcommand("replytest")
//    public void replyTest(VelocityCommandActor actor, String server) {
//        utils.sendTest(new CommandUserVelocity(actor), server);
//    }

}
