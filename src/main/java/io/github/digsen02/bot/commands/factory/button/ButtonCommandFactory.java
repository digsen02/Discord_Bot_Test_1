package io.github.digsen02.bot.commands.factory.button;

import io.github.digsen02.bot.commands.buttons.AccountCreatingButton;
import io.github.digsen02.bot.commands.buttons.GetBalanceButton;
import io.github.digsen02.bot.commands.buttons.pageButtons.NextButton;
import io.github.digsen02.bot.commands.buttons.pageButtons.PreviousButton;

import java.util.HashMap;
import java.util.Map;

public class ButtonCommandFactory {
    private static final Map<String, ButtonCommand> buttons = new HashMap<>();
    static {
        buttons.put("create", new AccountCreatingButton());
        buttons.put("balance",new GetBalanceButton());
        buttons.put("next", new NextButton());
        buttons.put("previous", new PreviousButton());
    }
    public static ButtonCommand getButtonCommand(String buttonId) {
        return buttons.get(buttonId);
    }

}

