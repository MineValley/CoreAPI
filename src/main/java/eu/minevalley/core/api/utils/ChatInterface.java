package eu.minevalley.core.api.utils;

import java.util.function.Consumer;

public interface ChatInterface {

    Consumer<String> getCallback();
}