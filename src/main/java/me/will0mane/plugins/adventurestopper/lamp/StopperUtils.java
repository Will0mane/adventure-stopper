package me.will0mane.plugins.adventurestopper.lamp;

import me.will0mane.lib.uranus.worker.Worker;
import me.will0mane.plugins.adventure.api.addon.targs.external.GlobalTarget;
import me.will0mane.plugins.adventure.api.commands.lamp.sender.CommandUser;
import me.will0mane.plugins.adventure.api.communication.method.MessageMethod;
import me.will0mane.plugins.adventure.api.modules.secure.credentials.Credential;
import me.will0mane.plugins.adventure.api.plugin.Adventure;
import me.will0mane.plugins.adventure.commons.communication.defaults.BaseAdventureMessage;

public class StopperUtils {

    private final Adventure adventure;
    private final Worker<?> worker;

    public StopperUtils(Adventure adventure) {
        this.adventure = adventure;

        worker = adventure.workerFactory().craft();
    }

    public void nowUtils(CommandUser user, String server, String credentials) {
        stop(user, server, Credential.of(credentials));
    }

    public void afterUtils(CommandUser user, String server, String credentials, long time) {
        user.message("Server will stop in " + time + " ticks...");

        worker.later(workerTaskWorker -> {
            stop(user, server, Credential.of(credentials));
        }, time);
    }

    private void stop(CommandUser player, String server, Credential credential) {
        player.message("Sending shutdown message...");
        adventure.instanceManager().shutdown(server, credential);
    }

    public void sendTest(CommandUser user, String server) {
        adventure.messageHandler().send(new BaseAdventureMessage(adventure.getGlobalAddress(), GlobalTarget.of(server + "#" + "AdventureStopper"), "stopper", "main", MessageMethod.GET));
        user.message("Sending msg!");
    }

}
