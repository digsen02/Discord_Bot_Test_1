package io.github.digsen02.bot.bank;

import io.github.digsen02.db.DatabaseSetting;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class AccountManager {
    private DatabaseSetting DatabaseSetting = new DatabaseSetting();

    public String getAccounts(String userId, String serverId) {
        String haveAccount = DatabaseSetting.getAccountsByServerIdAndUserId(serverId, userId);
        String haveAccounts[] = haveAccount.split(":");
        haveAccount = "";
        int i = 0;
        while (haveAccounts.length > i) {
            System.out.println(haveAccounts[i]);
            haveAccount = haveAccount + haveAccounts[i] + "\n";
            i++;
        }
        System.out.println(haveAccount);
        return haveAccount;
    }

    public String getAccountDate(String userId, String serverId, String account) {
        String date[] = String.valueOf(DatabaseSetting.getTimeLine(userId, serverId, account)).split(" ");
        return date[0];
    }
}