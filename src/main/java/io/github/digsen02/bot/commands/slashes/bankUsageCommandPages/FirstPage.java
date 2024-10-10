package io.github.digsen02.bot.commands.slashes.bankUsageCommandPages;

import io.github.digsen02.bot.commands.pagesCommandSystem.PageCommandContext;
import io.github.digsen02.bot.commands.state.PageState;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;

public class FirstPage implements PageState {
    @Override
    public void handleInput(PageCommandContext context, String buttonId) {
        if ("next".equals(buttonId)) {
            context.setState(getNextPage());
        }
    }

    @Override
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor("- Stock Bot -")
                .setDescription("사용할 기능을 선택하시오.")
                .setColor(Color.PINK)
                .addField("계좌 설립", "계좌를 설립합니다.", false)
                .addField("보유 계좌 확인", "권한이 부여된 계좌와 계좌의 종류들을 확인합니다.", false)
                .addField("계좌 정보 확인", "서버 내에 만들어진 자신의 계좌를 확인합니다.", false);
        return embed;
    }

    @Override
    public Button[] getButtons() {
        return new Button[] {
                Button.primary("next", "다음 페이지").withDisabled(false),
                Button.secondary("create", "계좌 설립"),
                Button.secondary("check", "보유 계좌 확인"),
                Button.secondary("balance", "계좌 정보 확인")
        };
    }

    @Override
    public PageState getNextPage() {
        return new LastPage();
    }

    @Override
    public PageState getPreviousPage() {
        return null;
    }
}