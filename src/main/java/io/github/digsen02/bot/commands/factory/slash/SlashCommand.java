package io.github.digsen02.bot.commands.factory.slash;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public interface SlashCommand {
    void execute(SlashCommandInteractionEvent event);

}
