package io.github.digsen02.bot.commands.pages;

import io.github.digsen02.bot.commands.slashs.bankUsageCommandPages.FirstPage;
import io.github.digsen02.bot.commands.state.PageState;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class PageCommandContext {
    private PageState state;
    private ButtonInteractionEvent buttonInteractionEvent;
    private SlashCommandInteractionEvent slashCommandInteractionEvent;

    public PageCommandContext(ButtonInteractionEvent event) {
        this.buttonInteractionEvent = event;
        this.state = new FirstPage();
    }

    public PageCommandContext(SlashCommandInteractionEvent event) {
        this.slashCommandInteractionEvent = event;
        this.state = new FirstPage();
    }

    public void updateEvent(ButtonInteractionEvent event) {
        this.buttonInteractionEvent = event;
    }

    public void setState(PageState state) {
        this.state = state;
    }

    public void handleInput(String buttonId) {
        if ("next".equals(buttonId)) {
            PageState nextPage = state.getNextPage();
            if (nextPage != null) {
                this.state = nextPage;
            }
        } else if ("previous".equals(buttonId)) {
            PageState previousPage = state.getPreviousPage();
            if (previousPage != null) {
                this.state = previousPage;
            }
        }
        updateMessage();
    }

    public void updateMessage() {
        if (buttonInteractionEvent != null) {
            buttonInteractionEvent.editMessageEmbeds(state.getEmbed().build())
                    .setActionRow(state.getButtons())
                    .queue();
        } else if (slashCommandInteractionEvent != null) {
            slashCommandInteractionEvent.replyEmbeds(state.getEmbed().build())
                    .addActionRow(state.getButtons())
                    .queue();
        }
    }
}