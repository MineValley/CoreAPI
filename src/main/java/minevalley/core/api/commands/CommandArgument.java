package minevalley.core.api.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

/**
 * A command argument is a branch in the command tree that requests and requires an input by the user.
 *
 * @param <T> the type of the argument
 */
@Getter
@AllArgsConstructor
@SuppressWarnings("unused")
public abstract class CommandArgument<T> implements CommandBuilder {

    /**
     * The name of the argument.
     */
    private final String name;

    /**
     * The type of the argument.
     */
    private final ArgumentType<T> type;

    /**
     * Sets suggestions for this specific argument.
     *
     * @param provider the provider to use for suggestions
     * @return this
     * @throws IllegalArgumentException if the provider is null
     */
    @Nonnull
    @Contract("_ -> this")
    public abstract CommandArgument<T> suggests(@Nonnull BiFunction<Context, SuggestionsBuilder, CompletableFuture<Suggestions>> provider) throws IllegalArgumentException;
}