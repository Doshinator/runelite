package net.runelite.client.plugins.goblin;


import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("goblin")

public interface GoblinConfig extends Config{

    @ConfigItem(
            position = 1,
            keyName = "highlightGoblins",
            name = "Highlight Goblins",
            description = "Highlights Goblins"
    )
    default boolean highlightGoblins() { return false;}

    @ConfigItem(
            position = 2,
            keyName = "drawHighlight",
            name = "Draw highlight around NPC",
            description = "Click to display name on top of Goblins"
    )
    default boolean drawHighlight() {return false;}
}