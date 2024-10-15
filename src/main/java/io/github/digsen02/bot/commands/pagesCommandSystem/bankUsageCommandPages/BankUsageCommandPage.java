package io.github.digsen02.bot.commands.pagesCommandSystem.bankUsageCommandPages;

import io.github.digsen02.bot.commands.pagesCommandSystem.PageCommandContext;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class BankUsageCommandPage extends PageCommandContext {
    public BankUsageCommandPage(ButtonInteractionEvent event) {
        buttonInteractionEvent = event;
        this.setState(new FirstPage());
    }
    public BankUsageCommandPage(SlashCommandInteractionEvent event) {
        slashCommandInteractionEvent = event;
        this.setState(new FirstPage());
    }
}
