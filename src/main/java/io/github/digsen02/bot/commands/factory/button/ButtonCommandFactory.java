package io.github.digsen02.bot.commands.factory.button;

import io.github.digsen02.bot.commands.buttons.AccountCreatingButton;
import io.github.digsen02.bot.commands.buttons.NextButton;
import io.github.digsen02.bot.commands.buttons.PreviousButton;

import java.util.HashMap;
import java.util.Map;

public class ButtonCommandFactory {
    private static final Map<String, ButtonCommand> buttons = new HashMap<>();
    //명령어
    static {
        buttons.put("create", new AccountCreatingButton());
        buttons.put("next", new NextButton());
        buttons.put("previous", new PreviousButton());
    }
    public static ButtonCommand getButtonCommand(String buttonId) {
        return buttons.get(buttonId);
    }

}

