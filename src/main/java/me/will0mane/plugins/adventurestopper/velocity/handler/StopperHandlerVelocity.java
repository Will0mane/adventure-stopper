package me.will0mane.plugins.adventurestopper.velocity.handler;


import me.will0mane.plugins.pulse.api.addon.targs.AddonConnectible;
import me.will0mane.plugins.pulse.api.communication.PulseMessage;
import me.will0mane.plugins.pulse.velocity.addon.handler.MessageHandlerVelocity;

public class StopperHandlerVelocity extends MessageHandlerVelocity {

    public StopperHandlerVelocity(AddonConnectible addon) {
        super(addon);
    }

    @Override
    public void handle(PulseMessage adventureMessage) {
//        if (adventureMessage instanceof GlobalInformMessage) return;
//        if (adventureMessage instanceof BaseAdventureMessage message) {
//            ReplyAdventureMessage = new ReplyAdventureMessage(message);
//            GlobalTarget target = (GlobalTarget) replyAdventureMessage.getTarget();
//            target.specifyAddon("AdventureStopper");
//            message.reply(new ReplyAdventureMessage(message).writeUTF("this is received"));
//        }
//    }
    }
}
