package io.github.digsen02.bot.commands.slashs;

import io.github.digsen02.bot.commands.factory.slash.SlashCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class BankUsageCommand implements SlashCommand {

    private final Map<String, Integer> userPageMap = new HashMap<>();

    @Override
    public void execute(SlashCommandInteractionEvent event) {

        EmbedBuilder embed = new EmbedBuilder()
                .setAuthor("- Stock Bot -")
                .setDescription("사용할 기능을 선택하시오.")
                .setColor(Color.PINK)
                .addField("계좌 설립", "계좌를 설립합니다.", false)
                .addField("보유 계좌 확인", "권한이 부여된 계좌와 계좌의 종류들을 확인합니다.", false)
                .addField("계좌 정보 확인", "서버 내에 만들어진 자신의 계좌를 확인합니다.", false)
                //위아래 나눠야함
                .addField("입금", "타계좌에 입금을 합니다.", false)
                .addField("출금", "계좌에서 출금을 합니다. 출금 권한이 있는 계좌만 출금이 가능합니다.", false)
                .addField("예금","선택한 계좌에 입금을 합니다",false);


        event.replyEmbeds(embed.build())
                .addActionRow(
                        Button.primary("create", "계좌 설립"),
                        Button.secondary("check", "보유 계좌 확인"),
                        Button.secondary("balance", "계좌 정보 확인"),
                        //위 아래 나눠야함
                        Button.secondary("deposit", "입금"),
                        Button.secondary("withdraw", "출금")
                ).queue();
    }
}