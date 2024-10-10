package io.github.digsen02.bot.commands.pagesCommandSystem.bankUsageCommandPages;

import io.github.digsen02.bot.commands.pagesCommandSystem.PageCommandContext;
import io.github.digsen02.bot.commands.pagesCommandSystem.testPage.FirstPage;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class PageCommandTest extends PageCommandContext {
    public PageCommandTest(ButtonInteractionEvent event) {
        buttonInteractionEvent = event;
        this.setState(new FirstPage());
    }
    public PageCommandTest(SlashCommandInteractionEvent event) {
        slashCommandInteractionEvent = event;
        this.setState(new FirstPage());
    }
}
