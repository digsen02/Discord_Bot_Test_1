package io.github.digsen02.bot.commands.slashes;

import io.github.digsen02.bot.commands.factory.slash.SlashCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;

public class BotSettingCommand implements SlashCommand {
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder embed = new EmbedBuilder()
                .setAuthor("- Stock Bot Settings -")
                .setDescription("봇 설정 메뉴입니다.")
                .setColor(Color.BLUE)
                .addField("현재 설정 확인", "현재 봇의 설정을 확인합니다.", false)
                .addField("권한 설정", "봇 사용 권한을 설정합니다.", false);

        event.replyEmbeds(embed.build()).queue();
    }
}
