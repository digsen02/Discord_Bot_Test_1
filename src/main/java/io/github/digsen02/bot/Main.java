package io.github.digsen02.bot;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.digsen02.bot.commands.factory.button.ButtonCommand;
import io.github.digsen02.bot.commands.factory.button.ButtonCommandFactory;
import io.github.digsen02.bot.commands.factory.modal.ModalCommand;
import io.github.digsen02.bot.commands.factory.modal.ModalCommandFactory;
import io.github.digsen02.bot.commands.factory.slash.SlashCommand;
import io.github.digsen02.bot.commands.factory.slash.SlashCommandFactory;
import io.github.digsen02.db.DatabaseConnection;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;


public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        DatabaseConnection.getInstance().getConnection();

        JDA jda = createJDAInstance(dotenv);
        registerCommands(jda);

        jda.addEventListener(new CommandListener());
    }

    private static JDA createJDAInstance(Dotenv dotenv) {
        return JDABuilder.createDefault(dotenv.get("TOKEN"))
                .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS)
                .setActivity(Activity.playing("은행 테스트_3"))
                .build();
    }

    private static void registerCommands(JDA jda) {
        CommandListUpdateAction commands = jda.updateCommands();

        commands.addCommands(
                Commands.slash("은행-사용", "은행 기능들을 사용 할 수 있는 창이 뜹니다."),
                Commands.slash("봇-설정", "봇을 설정 할 수 있는 창이 뜹니다."),
                Commands.slash("봇-설명", "봇을 설명 해주는 창이 뜹니다."),
                Commands.slash("test", "여러 테스트 기능 입니다.")
        ).queue();
    }

}

class CommandListener extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent event) {
        String commandName = event.getName();
        SlashCommand slashCommand = SlashCommandFactory.getSlashCommand(commandName);
        if (slashCommand != null) {
            slashCommand.execute(event);
        }
    }
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        String buttonId = event.getComponentId();
        ButtonCommand buttonCommand = ButtonCommandFactory.getButtonCommand(buttonId);
        if (buttonCommand != null) {
            buttonCommand.execute(event);
        }
    }
    @Override
    public void onModalInteraction(ModalInteractionEvent event) {
        String modalId = event.getModalId();
        System.out.println("0 modalId: " + modalId);
        ModalCommand modalCommand = ModalCommandFactory.getModalCommand(modalId);
        if (modalCommand != null) {
            modalCommand.execute(event);

        }
    }
}