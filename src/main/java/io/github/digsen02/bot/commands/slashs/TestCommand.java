package io.github.digsen02.bot.commands.slashs;

import io.github.digsen02.bot.commands.factory.slash.SlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

public class TestCommand implements SlashCommand {
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        TextInput textInput = TextInput.create("test", "유저의 아이디를 입력하시오.", TextInputStyle.SHORT)
                .setPlaceholder("여기에 답변을 입력하세요")
                .setMinLength(1)
                .setMaxLength(100)
                .build();

        Modal modal = Modal.create("test", "유저의 아이디를 입력하시오.")
                .addActionRow(textInput)
                .build();

        event.replyModal(modal).queue();
    }
}