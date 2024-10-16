package io.github.digsen02.bot.commands.buttons;

import io.github.digsen02.bot.commands.factory.button.*;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;
import java.util.HashMap;
import java.util.Map;

public class AccountCreatingButton implements ButtonCommand{

    @Override
    public void execute (ButtonInteractionEvent event) {
        TextInput textInput = TextInput.create("createAccount","초기 입금할 돈을 입력하세요.", TextInputStyle.SHORT)
                .setPlaceholder("여기에 답변을 입력하세요")
                .setMinLength(1)
                .setMaxLength(100)
                .build();
        Modal modal = Modal.create("createAccount", "초기 입금할 돈을 입력하세요.")
                .addActionRow(textInput)
                .build();
        System.out.println("start AccountCreatingButton");
        event.replyModal(modal).queue();
    }
}
