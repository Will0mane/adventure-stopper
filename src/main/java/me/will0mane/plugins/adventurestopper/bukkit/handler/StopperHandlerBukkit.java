package me.will0mane.plugins.adventurestopper.bukkit.handler;

import me.will0mane.plugins.adventure.api.addon.targs.AddonConnectible;
import me.will0mane.plugins.adventure.api.communication.AdventureMessage;
import me.will0mane.plugins.adventure.bukkit.addon.handler.MessageHandlerBukkit;

public class StopperHandlerBukkit extends MessageHandlerBukkit {

    public StopperHandlerBukkit(AddonConnectible addon) {
        super(addon);
    }

    @Override
    public void handle(AdventureMessage adventureMessage) {
//        if (adventureMessage instanceof GlobalInformMessage) return;
//        if (adventureMessage instanceof GlobalReplyAdventureMessage replyWrapper) {
//            AdventureMessage reply = replyWrapper.getMessage();
//            System.out.println(reply.reader().readUTF());
//        }
    }
}
