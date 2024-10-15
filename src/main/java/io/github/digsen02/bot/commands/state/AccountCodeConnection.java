package io.github.digsen02.bot.commands.state;

import io.github.digsen02.bot.bank.AccountClassification;
import io.github.digsen02.bot.bank.AccountCreation;
import io.github.digsen02.bot.bank.AccountManager;
import io.github.digsen02.bot.bank.SavingAccount;
import io.github.digsen02.db.DatabaseSetting;

public class AccountCodeConnection {

    public DatabaseSetting databaseSetting = new DatabaseSetting();
    public AccountCreation accountCreation = new AccountCreation();
    public SavingAccount savingAccount = new SavingAccount();
    public AccountManager accountManager = new AccountManager();
    public AccountClassification accountClassification = new AccountClassification();

}
