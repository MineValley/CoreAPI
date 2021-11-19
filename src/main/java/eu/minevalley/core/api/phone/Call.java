package eu.minevalley.core.api.phone;

public interface Call {

    void end();

    Phone getCaller();

    Phone getPartner();
}