package io.github.digsen02.bot.commands.factory.slash.bank;

import io.github.digsen02.db.DatabaseSetting;

import java.sql.Timestamp;
import java.util.Random;

public class AccountCreation {
    DatabaseSetting DatabaseSetting = new DatabaseSetting();

    public String createAccount(String userId, String serverId, double money) {
        String account = generateRandomAccountNumber("simple"); //입력값 변동
        DatabaseSetting.setAccount(userId, serverId, account, money);
        DatabaseSetting.setTimeLine(userId, serverId, "make:account", getCurrentTimestamp(), money, account);
        return account;
    }

    private String generateRandomAccountNumber(String accountType) {
        Random rand = new Random();
        int min = 0;
        int max = 10000;
        int randomNum = rand.nextInt((max - min) + 1) + min;

        switch (accountType) {
            case "simple":
                return "0310" + "-" + "8734" + "-" + randomNum + "-" + DatabaseSetting.getMaxCount();
            case "stock":
                return "0310" + "-" + "3245" + "-" + randomNum + "-" + DatabaseSetting.getMaxCount();
        }
        return null;
    }

    private Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}