package io.github.digsen02.bot.commands.buttons.pageButtons;

import io.github.digsen02.bot.commands.factory.button.ButtonCommand;
import io.github.digsen02.bot.commands.pagesCommandSystem.PageCommandContext;
import io.github.digsen02.bot.commands.pagesCommandSystem.PageCommandManager;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class NextButton implements ButtonCommand {
    @Override
    public void execute(ButtonInteractionEvent event) {
        PageCommandContext context = PageCommandManager.getContext(event);
        context.handleInput(event.getComponentId());
        PageCommandManager.updateContext(context);
    }
}