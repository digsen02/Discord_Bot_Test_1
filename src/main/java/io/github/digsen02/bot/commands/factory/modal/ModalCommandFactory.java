package io.github.digsen02.bot.commands.factory.modal;

import io.github.digsen02.bot.commands.modals.AccountCreatingModal;
import io.github.digsen02.bot.commands.modals.GetBalanceModal;

import java.util.HashMap;
import java.util.Map;

public class ModalCommandFactory {
    static final Map<String, ModalCommand> modals = new HashMap<>();

    static {
        modals.put("createAccount", new AccountCreatingModal());
        modals.put("getBalance", new GetBalanceModal());
    }
    public static ModalCommand getModalCommand(String modalId) {
        System.out.println("1 modalId: " + modalId);
        System.out.println("2 modalId: " + modalId);
        System.out.println("3 modalId: " + modalId);
        return modals.get(modalId);
    }
}
