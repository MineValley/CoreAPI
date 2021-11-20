package minevalley.core.api.helpers;

public interface RabbitHelper {

    void basicPublish(String queue, String key, String json);
}