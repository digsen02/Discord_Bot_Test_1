package io.github.digsen02.bot.commands.pagesCommandSystem;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class PageCommandManager {
    private static PageCommandContext cachedContext;

    public static PageCommandContext getContext(ButtonInteractionEvent event) {
        if (cachedContext == null) {
            cachedContext = new PageCommandContext(event);
        } else {
            cachedContext.updateEvent(event);
        }
        return cachedContext;
    }

    public static void updateContext(PageCommandContext context) {
        cachedContext = context;
    }

    public static void resetContext() {
        cachedContext = null;
    }
}