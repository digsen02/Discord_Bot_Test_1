package io.github.digsen02.bot.bank;

import io.github.digsen02.bot.commands.state.AccountCodeConnection;
import io.github.digsen02.db.DatabaseSetting;

public class AccountManager extends AccountCodeConnection {

    public String getAccounts(String userId, String serverId) {
        String haveAccount = databaseSetting.getAccountsByServerIdAndUserId(serverId, userId);
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
        String date[] = String.valueOf(databaseSetting.getTimeLine(userId, serverId, account)).split(" ");
        return date[0];
    }
}