package io.github.digsen02.bot.commands.pages;

import io.github.digsen02.bot.commands.pages.pages.FirstPage;
import io.github.digsen02.bot.commands.pages.pages.LastPage;
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

    public void setState(PageState state) {
        this.state = state;
    }

    public void handleInput(String buttonId) {
        switch (buttonId) {
            case "next" -> {
                if (!(state instanceof LastPage)) {
                    this.state = state.getNextPage();
                }
            }
            case "previous" -> {
                if (!(state instanceof FirstPage)) {
                    this.state = state.getPreviousPage();
                }
            }
            default -> System.err.println("Invalid button ID: " + buttonId);
        }
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