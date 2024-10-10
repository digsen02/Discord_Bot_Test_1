package io.github.digsen02.bot.commands.slashes;

import io.github.digsen02.bot.commands.factory.slash.SlashCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.Color;

public class BotDescriptionCommand implements SlashCommand {
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder embed = new EmbedBuilder()
                .setAuthor("- Stock Bot Description -")
                .setDescription("Stock Bot에 대한 설명입니다.")
                .setColor(Color.GREEN)
                .addField("기능", "계좌 관리, 주식 거래 시뮬레이션 등을 제공합니다.", false)
                .addField("사용 방법", "'/은행-사용' 명령어로 시작할 수 있습니다.", false)
                .addField("개발자", "이 봇은 digsen02에 의해 개발되었습니다.", false);

        event.replyEmbeds(embed.build()).queue();
    }
}