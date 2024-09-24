package io.github.digsen02.bot.commands.factory.modal;

import io.github.digsen02.bot.commands.modals.AccountCreatingModal;

import java.util.HashMap;
import java.util.Map;

public class ModalCommandFactory {
    private static final Map<String, ModalCommand> modals = new HashMap<>();

    static {
        modals.put("createAccount", new AccountCreatingModal());
    }

    public static ModalCommand getModalCommand(String modalId) {
        return modals.get(modalId);
    }

}
