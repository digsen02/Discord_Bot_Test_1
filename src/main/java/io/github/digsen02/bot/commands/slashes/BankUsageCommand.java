package io.github.digsen02.bot.commands.slashes;

import io.github.digsen02.bot.commands.factory.slash.SlashCommand;
import io.github.digsen02.bot.commands.pagesCommandSystem.PageCommandContext;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class BankUsageCommand implements SlashCommand {
    @Override
    public void execute(SlashCommandInteractionEvent event) {
            PageCommandContext context = new PageCommandContext(event);
            context.updateMessage();

    }
}