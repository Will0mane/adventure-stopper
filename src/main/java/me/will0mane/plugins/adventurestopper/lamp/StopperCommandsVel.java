package me.will0mane.plugins.adventurestopper.lamp;

import me.will0mane.plugins.adventure.api.plugin.Adventure;
import me.will0mane.plugins.adventure.velocity.commands.CommandUserVelocity;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Flag;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.velocity.VelocityCommandActor;
import revxrsal.commands.velocity.annotation.CommandPermission;

@Command("advstop")
@CommandPermission("adventure.stopper")
public class StopperCommandsVel {

    private final Adventure adventure = Adventure.instance();
    private final StopperUtils utils = new StopperUtils(adventure);

    @Subcommand("now")
    @CommandPermission("adventure.stopper.now")
    public void now(VelocityCommandActor actor, long credentials, @Default("ALL") @Flag String server) {
        utils.nowUtils(new CommandUserVelocity(actor), server, credentials);
    }

    @Subcommand("after")
    @CommandPermission("adventure.stopper.after")
    public void after(VelocityCommandActor actor, long credentials, long ticks, @Default("ALL") @Flag String server) {
        utils.afterUtils(new CommandUserVelocity(actor), server, credentials, ticks);
    }

}
