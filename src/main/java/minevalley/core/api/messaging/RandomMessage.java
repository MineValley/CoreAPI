package minevalley.core.api.messaging;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("unused")
public record RandomMessage(@Nonnull WeightedMessage... messages) {

    public RandomMessage(@Nonnull String... messages) {
        this(Arrays.stream(messages).map(s -> new WeightedMessage(s, 1)).toArray(WeightedMessage[]::new));
    }

    private static final Random RANDOM = new Random();

    public String getRandomMessage() throws IllegalStateException {
        if (messages.length == 0) {
            throw new IllegalStateException("No messages available to choose from.");
        }
        return messages[RANDOM.nextInt()].message;
    }

    public record WeightedMessage(@Nonnull String message, @Nonnegative int weight) {
    }
}