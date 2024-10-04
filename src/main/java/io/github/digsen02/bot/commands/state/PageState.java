package io.github.digsen02.bot.commands.state;

import io.github.digsen02.bot.commands.pages.PageCommandContext;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public interface PageState {
    void handleInput(PageCommandContext context, String buttonId);

    EmbedBuilder getEmbed();  // 페이지에 표시할 임베드 메시지
    Button[] getButtons();    // 페이지에 표시할 버튼
    PageState getNextPage();  // 다음 페이지
    PageState getPreviousPage();  // 이전 페이지
}
