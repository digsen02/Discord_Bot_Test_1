package io.github.digsen02.bot.commands.buttons;

import io.github.digsen02.bot.commands.factory.button.ButtonCommand;
import io.github.digsen02.bot.commands.pages.PageCommandContext;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class PreviousButton implements ButtonCommand {
    @Override
    public void execute(ButtonInteractionEvent event) {
        PageCommandContext context = new PageCommandContext(event);
        context.handleInput(event.getComponentId());
        context.updateMessage();
    }
}
