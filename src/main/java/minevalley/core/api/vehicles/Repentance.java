package minevalley.core.api.vehicles;

import minevalley.core.api.users.User;

public interface Repentance {

    User getOfficer();

    String getMessage();

    long getTimestamp();

    long getTowDate();
}