package io.github.digsen02.bot.commands.slashes.bankUsageCommandPages;

import io.github.digsen02.bot.commands.pagesCommandSystem.PageCommandContext;
import io.github.digsen02.bot.commands.state.PageState;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;

public class LastPage implements PageState {
    @Override
    public void handleInput(PageCommandContext context, String buttonId) {
        if ("previous".equals(buttonId)) {
            context.setState(getPreviousPage());
        }
    }

    @Override
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor("- Stock Bot -")
                .setDescription("사용할 기능을 선택하시오.")
                .setColor(Color.PINK)
                .addField("입금", "타계좌에 입금을 합니다.", false)
                .addField("출금", "계좌에서 출금을 합니다. 출금 권한이 있는 계좌만 출금이 가능합니다.", false)
                .addField("예금","선택한 계좌에 입금을 합니다",false);
        return embed;
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                Button.secondary("deposit", "입금"),
                Button.secondary("withdraw", "출금"),
                Button.secondary("테스트","예금"),
                Button.primary("previous", "이전 페이지").withDisabled(false),
        };
    }

    @Override
    public PageState getNextPage() {
        return null;
    }

    @Override
    public PageState getPreviousPage() {
        return new FirstPage();
    }
}