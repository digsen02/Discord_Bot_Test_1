package io.github.digsen02.bot.commands.pages.pages;

import io.github.digsen02.bot.commands.pages.PageCommandContext;
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
        embed.setColor(Color.PINK);
        embed.setDescription("이것은 첫 번째 페이지입니다.")
                .addField("정보", "여기에 첫 페이지 정보가 표시됩니다.", false);
        return embed;
    }

    @Override
    public Button[] getButtons() {
        return new Button[] {
                Button.secondary("next", "다음 페이지").withDisabled(false)
        };
    }

    @Override
    public PageState getNextPage() {
        return new SecondPage();
    }

    @Override
    public PageState getPreviousPage() {
        // 첫 페이지에서는 이전 페이지가 없으므로 null 반환
        return null;
    }
}