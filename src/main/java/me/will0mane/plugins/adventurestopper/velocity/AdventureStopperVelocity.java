package me.will0mane.plugins.adventurestopper.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import me.will0mane.plugins.adventurestopper.lamp.StopperCommandsVel;
import me.will0mane.plugins.adventurestopper.velocity.handler.StopperHandlerVelocity;
import me.will0mane.plugins.pulse.api.commands.lamp.LampWrapper;
import me.will0mane.plugins.pulse.api.communication.handler.AddonMessageHandler;
import me.will0mane.plugins.pulse.velocity.addon.PAddonVelocity;
import org.jetbrains.annotations.NotNull;
import revxrsal.commands.velocity.VelocityCommandHandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@Plugin(id = "adventure_stopper",
        name = "AdventureStopper",
        version = "1.0.0.0",
        url = "https://github.com/Will0mane/Adventure",
        description = "Allows to shutdown server easily",
        dependencies = { @Dependency(id = "pulse")},
        authors = {"Will0mane"})
public class AdventureStopperVelocity extends PAddonVelocity {

    private final AddonMessageHandler handler = new StopperHandlerVelocity(this);
    private LampWrapper lampWrapper;

    private final ProxyServer server;

    @Inject
    public AdventureStopperVelocity(ProxyServer server) {
        this.server = server;
    }

    @Override
    public void enable() {
        lampWrapper = new LampWrapper(VelocityCommandHandler.create(this, server));
        lampWrapper.getHandler().register(new StopperCommandsVel());
    }

    @Override
    public void disable() {
    }

    @Override
    public void stop() {
    }

    @Override
    public InputStream getResource(String s) {
        try {
            URL url = getClass().getClassLoader().getResource(s);
            if (url == null) return null;
            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            return connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
