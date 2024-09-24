package io.github.digsen02.bot.commands.factory.slash.bank;

public class SavingAccount {
    private String account;

    public SavingAccount(String account) {
        this.account = account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }
}