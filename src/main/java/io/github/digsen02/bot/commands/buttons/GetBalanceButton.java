package io.github.digsen02.bot.commands.buttons;

import io.github.digsen02.bot.commands.factory.button.ButtonCommand;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

public class GetBalanceButton implements ButtonCommand {

    @Override
    public void execute (ButtonInteractionEvent event) {
        TextInput textInput = TextInput.create("getBalance","확인할 계좌 번호를 입력하세요.", TextInputStyle.SHORT)
                .setPlaceholder("여기에 답변을 입력하세요")
                .setMinLength(1)
                .setMaxLength(100)
                .build();

        Modal modal = Modal.create("getBalance", "확인할 계좌 번호를 입력하세요.")
                .addActionRow(textInput)
                .build();

        event.replyModal(modal).queue();
    }

}
