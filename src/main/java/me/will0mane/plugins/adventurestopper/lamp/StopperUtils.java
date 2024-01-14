package me.will0mane.plugins.adventurestopper.lamp;

import me.will0mane.plugins.pulse.api.addon.targs.external.GlobalTarget;
import me.will0mane.plugins.pulse.api.commands.lamp.sender.CommandUser;
import me.will0mane.plugins.pulse.api.communication.method.MessageMethod;
import me.will0mane.plugins.pulse.api.modules.secure.credentials.Credential;
import me.will0mane.plugins.pulse.api.modules.uranus.worker.Worker;
import me.will0mane.plugins.pulse.api.plugin.Pulse;
import me.will0mane.plugins.pulse.commons.communication.defaults.BasePulseMessage;

public class StopperUtils {

    private final Pulse adventure;
    private final Worker<?> worker;

    public StopperUtils(Pulse adventure) {
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
        adventure.messageHandler().send(new BasePulseMessage(adventure.getGlobalAddress(), GlobalTarget.of(server + "#" + "AdventureStopper"), "stopper", MessageMethod.GET));
        user.message("Sending msg!");
    }

}
