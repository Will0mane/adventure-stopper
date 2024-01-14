package me.will0mane.plugins.adventurestopper.bukkit.handler;

import me.will0mane.plugins.pulse.api.addon.targs.AddonConnectible;
import me.will0mane.plugins.pulse.api.communication.PulseMessage;
import me.will0mane.plugins.pulse.bukkit.addon.handler.MessageHandlerBukkit;

public class StopperHandlerBukkit extends MessageHandlerBukkit {

    public StopperHandlerBukkit(AddonConnectible addon) {
        super(addon);
    }

    @Override
    public void handle(PulseMessage adventureMessage) {
//        if (adventureMessage instanceof GlobalInformMessage) return;
//        if (adventureMessage instanceof GlobalReplyAdventureMessage replyWrapper) {
//            AdventureMessage reply = replyWrapper.getMessage();
//            System.out.println(reply.reader().readUTF());
//        }
    }
}
