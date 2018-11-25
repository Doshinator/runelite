package net.runelite.client.plugins.goblin;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;

import com.google.common.graph.Graph;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.npchighlight.NpcIndicatorsConfig;
import net.runelite.client.plugins.npchighlight.NpcSceneOverlay;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class GoblinOverlay extends Overlay{

    private final Client client;
    private final GoblinConfig config;
    private final GoblinPlugin plugin;

    @Inject
    GoblinOverlay(Client client, GoblinConfig config, GoblinPlugin plugin){
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);

    }

    @Override
    public Dimension render(Graphics2D graphics){
        if(config.drawHighlight()){
            for(NPC npc : client.getNpcs()){
                if ("Flesh Crawler".equals(npc.getName())){
                    renderNPC(graphics, npc);
                }
            }
        }

        return null;
    }

    private void renderNPC(Graphics2D graphics, NPC npc){
        Polygon poly = npc.getConvexHull();
        renderPoly(graphics, poly);
    }
    private void renderPoly(Graphics2D graphics, Polygon polygon){
        if(polygon != null){
            graphics.setColor(Color.cyan);
            graphics.setStroke(new BasicStroke(1));
            graphics.draw(polygon);
        }
    }

}