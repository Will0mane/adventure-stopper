package me.will0mane.plugins.adventurestopper.lamp;

import me.will0mane.plugins.adventure.api.plugin.Adventure;
import me.will0mane.plugins.adventure.bukkit.commands.CommandUserBukkit;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Flag;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.BukkitCommandActor;
import revxrsal.commands.bukkit.annotation.CommandPermission;

@Command("advstop")
@CommandPermission("adventure.stopper")
public class StopperCommandsBukkit {

    private final Adventure adventure = Adventure.instance();
    private final StopperUtils utils = new StopperUtils(adventure);

    @Subcommand("now")
    @CommandPermission("adventure.stopper.now")
    public void now(BukkitCommandActor actor, long credentials, @Default("ALL") @Flag String server) {
        utils.nowUtils(new CommandUserBukkit(actor), server, credentials);
    }

    @Subcommand("after")
    @CommandPermission("adventure.stopper.after")
    public void after(BukkitCommandActor actor, long credentials, long ticks, @Default("ALL") @Flag String server) {
        utils.afterUtils(new CommandUserBukkit(actor), server, credentials, ticks);
    }

}
