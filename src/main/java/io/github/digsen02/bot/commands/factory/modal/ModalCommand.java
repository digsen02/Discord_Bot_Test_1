package io.github.digsen02.bot.commands.factory.modal;


import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.interactions.modals.ModalInteraction;

public interface ModalCommand {
    void execute(ModalInteractionEvent event);
}
