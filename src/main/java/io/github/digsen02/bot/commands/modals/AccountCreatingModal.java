package io.github.digsen02.bot.commands.modals;

import io.github.digsen02.bot.commands.factory.slash.bank.AccountCreation;
import io.github.digsen02.bot.commands.factory.modal.ModalCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.modals.ModalInteraction;

import java.awt.*;
import java.util.Objects;

public class AccountCreatingModal implements ModalCommand {
    @Override
    public void execute(ModalInteraction event) {
        AccountCreation AccountCreation = new AccountCreation();
        String userId = event.getUser().getId();
        String severId = Objects.requireNonNull(event.getGuild()).getId();

        String userInputStr = Objects.requireNonNull(event.getValue("createAccount")).getAsString();
        double userInputMoney = Double.parseDouble(userInputStr);

        String account = AccountCreation.createAccount(userId ,severId ,userInputMoney);

        MessageEmbed embed = new EmbedBuilder().setAuthor("- Stock Bot -")
                .setDescription("계좌 설립 완료")
                .setColor(Color.pink)
                .addField("계좌 번호",account,false)
                .addField("보유한 금액",userInputStr,false)
                .setFooter("계좌 설립을 축하드립니다!").build();

        event.replyEmbeds(embed).setEphemeral(false).queue();
    }
}
