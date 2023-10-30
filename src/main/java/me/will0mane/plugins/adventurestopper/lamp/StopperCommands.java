package me.will0mane.plugins.adventurestopper.lamp;

import me.will0mane.lib.uranus.worker.Worker;
import me.will0mane.lib.uranus.worker.task.WorkerTask;
import me.will0mane.plugins.adventure.api.modules.secure.credentials.Credential;
import me.will0mane.plugins.adventure.api.plugin.Adventure;
import org.bukkit.entity.Player;
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
    public void now(BukkitCommandActor actor, long credentials, @Default("all") @Flag String server) {
        Player player = actor.requirePlayer();
        stop(player, server, Credential.of(credentials));
    }

    @Subcommand("after")
    @CommandPermission("adventure.stopper.after")
    public void after(BukkitCommandActor actor, long credentials, long ticks, @Default("all") @Flag String server) {
        Player player = actor.requirePlayer();
        player.sendMessage("Server will stop in " + ticks + " ticks...");

        worker.later(workerTaskWorker -> {
            stop(player, server, Credential.of(credentials));
        }, ticks);
    }

    private void stop(Player player, String server, Credential credential) {
        player.sendMessage("Sending shutdown message...");
        adventure.instanceManager().shutdown(server, credential);
    }

}
