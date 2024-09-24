package io.github.digsen02.bot.commands.factory.button;


import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public interface ButtonCommand {
    void execute(ButtonInteractionEvent event);
}
