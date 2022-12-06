package minevalley.core.api.vehicles;

import minevalley.core.api.User;
import minevalley.core.api.economy.BankAccount;

public interface Repentance {

    User getOfficer();

    String getMessage();

    long getTimestamp();

    long getTowDate();

    void pay(BankAccount bankAccount);
}