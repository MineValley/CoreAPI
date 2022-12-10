package minevalley.core.api.vehicles;

import minevalley.core.api.User;

public interface Repentance {

    User getOfficer();

    String getMessage();

    long getTimestamp();

    long getTowDate();
}