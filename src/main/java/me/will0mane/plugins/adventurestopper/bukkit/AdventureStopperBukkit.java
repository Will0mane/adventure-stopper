package me.will0mane.plugins.adventurestopper.bukkit;

import me.will0mane.plugins.adventure.api.commands.lamp.LampWrapper;
import me.will0mane.plugins.adventure.api.communication.handler.AddonMessageHandler;
import me.will0mane.plugins.adventure.bukkit.addon.AdventureAddonBukkit;
import me.will0mane.plugins.adventurestopper.bukkit.handler.StopperHandlerBukkit;
import me.will0mane.plugins.adventurestopper.lamp.StopperCommandsBukkit;
import org.jetbrains.annotations.NotNull;
import revxrsal.commands.bukkit.BukkitCommandHandler;

public final class AdventureStopperBukkit extends AdventureAddonBukkit {

    private final AddonMessageHandler handler = new StopperHandlerBukkit(this);
    private LampWrapper lampWrapper;

    @Override
    public void enable() {
        lampWrapper = new LampWrapper(BukkitCommandHandler.create(this));
        lampWrapper.getHandler().register(new StopperCommandsBukkit());
    }

    @Override
    public void disable() {
    }

    @Override
    public AddonMessageHandler messageHandler() {
        return handler;
    }

    @Override
    public @NotNull LampWrapper lamp() {
        return lampWrapper;
    }
}
