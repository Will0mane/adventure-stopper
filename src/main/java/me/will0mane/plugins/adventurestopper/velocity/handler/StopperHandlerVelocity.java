package me.will0mane.plugins.adventurestopper.velocity.handler;

import me.will0mane.plugins.adventure.api.addon.targs.AddonConnectible;
import me.will0mane.plugins.adventure.api.communication.AdventureMessage;
import me.will0mane.plugins.adventure.velocity.addon.handler.MessageHandlerVelocity;

public class StopperHandlerVelocity extends MessageHandlerVelocity {

    public StopperHandlerVelocity(AddonConnectible addon) {
        super(addon);
    }

    @Override
    public void handle(AdventureMessage adventureMessage) {
//        if (adventureMessage instanceof GlobalInformMessage) return;
//        if (adventureMessage instanceof BaseAdventureMessage message) {
//            ReplyAdventureMessage replyAdventureMessage = new ReplyAdventureMessage(message);
//            GlobalTarget target = (GlobalTarget) replyAdventureMessage.getTarget();
//            target.specifyAddon("AdventureStopper");
//            message.reply(new ReplyAdventureMessage(message).writeUTF("this is received"));
//        }
//    }
    }
}
