package eu.minevalley.core.api.phone;

public interface Call {

    void end();

    void sendTitle();

    Phone getCaller();

    Phone getPartner();
}