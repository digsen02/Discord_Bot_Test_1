package io.github.digsen02.bot.commands.factory.slash;
import io.github.digsen02.bot.commands.slashes.TestCommand;
import io.github.digsen02.bot.commands.slashes.*;

import java.util.HashMap;
import java.util.Map;

public class SlashCommandFactory {
    private static final Map<String, SlashCommand> commands = new HashMap<>();

    static {
        commands.put("은행-사용", new BankUsageCommand());
        commands.put("봇-설정", new BotSettingCommand());
        commands.put("봇-설명", new BotDescriptionCommand());
        commands.put("test", new TestCommand());
    }


    public static SlashCommand getSlashCommand(String commandName) {
        return commands.get(commandName);
    }
}