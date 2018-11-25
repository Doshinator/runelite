package net.runelite.client.plugins.goblin;


import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.PlayerLootReceived;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
// import net.runelite.client.plugins.playerscraper.PlayerScraperConfig;
import net.runelite.client.plugins.attackstyles.AttackStylesConfig;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import java.util.concurrent.ScheduledExecutorService;


@PluginDescriptor(
        name = "Goblin Highlighter",
        description = "Highlights goblin",
        tags = {"goblin"}
)

@Slf4j
public class GoblinPlugin extends Plugin{
    @Inject
    @Nullable
    private Client client;

    @Inject
    private GoblinConfig config;

    @Inject
    private GoblinOverlay GoblinOverlay;

    @Inject
    private OverlayManager overlayManager;

    @Provides
    GoblinConfig provideConfig(ConfigManager configManager){
        return configManager.getConfig(GoblinConfig.class);
    }


    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(GoblinOverlay);
    }
    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(GoblinOverlay);
    }


    //    @Subscribe
//    public void onGameTick(GameTick t){
//        config.goblinConfig();
//    }

}

