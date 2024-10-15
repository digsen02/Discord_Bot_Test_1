package io.github.digsen02.bot.commands.pagesCommandSystem;

import io.github.digsen02.bot.commands.pagesCommandSystem.bankUsageCommandPages.BankUsageCommandPage;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class PageCommandManager {
    private static PageCommandContext cachedContext;

    public static PageCommandContext getContext(ButtonInteractionEvent event) {
        if (cachedContext == null) {
            cachedContext = new BankUsageCommandPage(event);
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