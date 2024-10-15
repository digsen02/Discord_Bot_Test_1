package io.github.digsen02.bot.commands.modals;

import io.github.digsen02.bot.bank.AccountClassification;
import io.github.digsen02.bot.bank.AccountManager;
import io.github.digsen02.bot.bank.SavingAccount;
import io.github.digsen02.bot.commands.factory.modal.ModalCommand;
import io.github.digsen02.bot.commands.state.AccountCodeConnection;
import io.github.digsen02.db.DatabaseSetting;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.modals.ModalInteraction;

import java.awt.*;
import java.util.Objects;

public class GetBalanceModal extends AccountCodeConnection implements ModalCommand {
    @Override
    public void execute(ModalInteractionEvent event) {
        String userId = event.getUser().getId();
        String severId = Objects.requireNonNull(event.getGuild()).getId();
        String userInputAccount = Objects.requireNonNull(event.getValue("getBalance")).getAsString();

        savingAccount.setAccount(userInputAccount);
        double userHasMoney = databaseSetting.getMoneyByUseridSeverAccountNum(userId, severId, userInputAccount);
        String classification = accountClassification.classifyAccount(userInputAccount);
        String date = accountManager.getAccountDate(userId, severId, userInputAccount);

        EmbedBuilder botUsingEmbed = new EmbedBuilder();
        if (userHasMoney != -1 && classification != null && date != null) {
            MessageEmbed embed = botUsingEmbed.setAuthor("- Stock Bot -")
                    .setDescription("계좌 정보")
                    .setColor(Color.pink)
                    .addField("계좌 번호", userInputAccount, false)
                    .addField("계좌 종류", classification, false)
                    .addField("보유 금액", Double.toString(userHasMoney), false)
                    .addField("계좌 설립 일자", date, false).build();

            event.replyEmbeds(embed).setEphemeral(false)
                    .addActionRow(
                            net.dv8tion.jda.api.interactions.components.buttons.Button.primary("button:addAccountAccessRights", "계좌 접근 권한 추가"),
                            Button.primary("button:subtractAccountAccessRights", "계좌 접근 권한 삭제")
                    ).queue();
        }
    }
}
