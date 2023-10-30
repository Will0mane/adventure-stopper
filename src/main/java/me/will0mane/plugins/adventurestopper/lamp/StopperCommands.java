package me.will0mane.plugins.adventurestopper.lamp;

import me.will0mane.lib.uranus.worker.Worker;
import me.will0mane.lib.uranus.worker.task.WorkerTask;
import me.will0mane.plugins.adventure.api.modules.secure.credentials.Credential;
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
public class StopperCommands {

    private final Adventure adventure = Adventure.instance();
    private final Worker<WorkerTask> worker;

    public StopperCommands() {
        worker = adventure.workerFactory().craft();
    }

    @Subcommand("now")
    @CommandPermission("adventure.stopper.now")
    public void now(BukkitCommandActor actor, long credentials, @Default("ALL") @Flag String server) {
        stop(new CommandUserBukkit(actor), server, Credential.of(credentials));
    }

    @Subcommand("after")
    @CommandPermission("adventure.stopper.after")
    public void after(BukkitCommandActor actor, long credentials, long ticks, @Default("ALL") @Flag String server) {
        CommandUserBukkit bukkit = new CommandUserBukkit(actor);
        bukkit.message("Server will stop in " + ticks + " ticks...");

        worker.later(workerTaskWorker -> {
            stop(bukkit, server, Credential.of(credentials));
        }, ticks);
    }

    private void stop(CommandUserBukkit player, String server, Credential credential) {
        player.message("Sending shutdown message...");
        adventure.instanceManager().shutdown(server, credential);
    }

}
