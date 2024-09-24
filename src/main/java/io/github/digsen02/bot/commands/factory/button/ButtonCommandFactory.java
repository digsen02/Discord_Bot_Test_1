package io.github.digsen02.bot.commands.factory.button;

import io.github.digsen02.bot.commands.buttons.*;
import java.util.HashMap;
import java.util.Map;

public class ButtonCommandFactory {
    private static final Map<String, ButtonCommand> buttons = new HashMap<>();

    static {
        buttons.put("create",new AccountCreatingButton());
    }

    public static ButtonCommand getButtonCommand(String buttonId) {
        return buttons.get(buttonId);
    }

}
