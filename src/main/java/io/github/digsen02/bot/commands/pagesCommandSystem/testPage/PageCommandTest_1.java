package io.github.digsen02.bot.commands.pagesCommandSystem.testPage;

import io.github.digsen02.bot.commands.pagesCommandSystem.PageCommandContext;
import io.github.digsen02.bot.commands.pagesCommandSystem.bankUsageCommandPages.FirstPage;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class PageCommandTest_1 extends PageCommandContext {
    public PageCommandTest_1(ButtonInteractionEvent event) {
        buttonInteractionEvent = event;
        this.setState(new FirstPage());
    }
    public PageCommandTest_1(SlashCommandInteractionEvent event) {
        slashCommandInteractionEvent = event;
        this.setState(new FirstPage());
    }
}
