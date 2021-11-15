package eu.minevalley.core.api.database;

public interface DatabaseEntry {

    void remove();

    boolean exists();

    void changeValue(Value value);

    String getString(String column);

    Integer getInteger(String column);

    Boolean getBoolean(String column);

    Double getDouble(String column);
}