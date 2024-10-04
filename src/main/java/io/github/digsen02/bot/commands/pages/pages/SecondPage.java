package io.github.digsen02.bot.commands.pages.pages;

import io.github.digsen02.bot.commands.pages.PageCommandContext;
import io.github.digsen02.bot.commands.state.PageState;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;

public class SecondPage implements PageState {
    @Override
    public void handleInput(PageCommandContext context, String buttonId) {
        if ("next".equals(buttonId)) {
            context.setState(new LastPage());
        } else if ("previous".equals(buttonId)) {
            context.setState(new FirstPage());
        }
    }

    @Override
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Color.PINK);
        embed.setDescription("이것은 두번째 페이지입니다.")
                .addField("정보", "여기에 두번째 페이지 정보가 표시됩니다.", false);
        return embed;
    }

    @Override
    public Button[] getButtons() {
        return new Button[]{
                Button.secondary("next","다음페이지").withDisabled(false),
                Button.secondary("previous", "이전 페이지").withDisabled(false),
        };
    }

    @Override
    public PageState getNextPage() {
        return new LastPage();
    }

    @Override
    public PageState getPreviousPage() {
        return new FirstPage();
    }
}
