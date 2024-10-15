package io.github.digsen02.bot.commands.modals;

import io.github.digsen02.bot.bank.AccountCreation;
import io.github.digsen02.bot.commands.factory.modal.ModalCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;

import java.awt.*;
import java.util.Objects;

public class AccountCreatingModal implements ModalCommand {

    @Override
    public void execute(ModalInteractionEvent event) {
        System.out.println("d");
        AccountCreation accountCreation = new AccountCreation();
        System.out.println("dd");
        String userId = event.getUser().getId();
        System.out.println("ddd");
        String severId = Objects.requireNonNull(event.getGuild()).getId();
        System.out.println("dddd");
        String userInputStr = Objects.requireNonNull(event.getValue("createAccount")).getAsString();
        System.out.println("ddddd");
        double userInputMoney = Double.parseDouble(userInputStr);
        System.out.println("dddddd");
        String account = accountCreation.createAccount(userId ,severId ,userInputMoney);
        System.out.println("ddddddd");

        MessageEmbed embed = new EmbedBuilder().setAuthor("- Stock Bot -")
                .setDescription("계좌 설립 완료")
                .setColor(Color.pink)
                .addField("계좌 번호",account,false)
                .addField("보유한 금액",userInputStr,false)
                .setFooter("계좌 설립을 축하드립니다!").build();
        System.out.println("dddddddd");
        event.replyEmbeds(embed).setEphemeral(false).queue();
    }
}
