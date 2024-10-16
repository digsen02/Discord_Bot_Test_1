package io.github.digsen02.bot.commands.factory.modal;

import static io.github.digsen02.bot.commands.factory.modal.ModalCommandFactory.modals;

public class ModalCommandGetModalIdTest {
    public static void getModalId(String modalId) {
        System.out.println(modalId + " in getModalId 1");
        modals.get(modalId);
        System.out.println(modalId + " in getModalId 2");
    }
}
