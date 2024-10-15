package io.github.digsen02.bot.bank;

import io.github.digsen02.bot.commands.state.AccountCodeConnection;
import io.github.digsen02.db.DatabaseSetting;

import java.sql.Timestamp;
import java.util.Random;

public class AccountCreation {
    DatabaseSetting dbSetting;
    public String createAccount(String userId, String serverId, double money) {
        String account = generateRandomAccountNumber("simple"); //입력값 변동
        dbSetting.setAccount(userId, serverId, account, money);
        dbSetting.setTimeLine(userId, serverId, "make:account", getCurrentTimestamp(), money, account);
        return account;
    }

    private String generateRandomAccountNumber(String accountType) {
        Random rand = new Random();
        int min = 0;
        int max = 10000;
        int randomNum = rand.nextInt((max - min) + 1) + min;

        switch (accountType) {
            case "simple":
                return "0310" + "-" + "8734" + "-" + randomNum + "-" + dbSetting.getMaxCount();
            case "stock":
                return "0310" + "-" + "3245" + "-" + randomNum + "-" + dbSetting.getMaxCount();
        }
        return null;
    }

    private Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}