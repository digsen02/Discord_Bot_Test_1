package io.github.digsen02.bot.commands.pagesCommandSystem.testPage;

import io.github.digsen02.bot.commands.pagesCommandSystem.PageCommandContext;
import io.github.digsen02.bot.commands.state.PageState;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class LastPage implements PageState {
    @Override
    public void handleInput(PageCommandContext context, String buttonId) {
        if ("next".equals(buttonId)) {
            context.setState(getNextPage());
        }
    }

    @Override
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor("Test")
                .setTitle("Test")
                .setDescription("Test")
                .setFooter("Last Page");
        return embed;
    }

    @Override
    public Button[] getButtons() {
        return new Button[] {
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
