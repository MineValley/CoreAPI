package minevalley.core.api.team;

import minevalley.core.api.audio.SoundReceiver;
import minevalley.core.api.messaging.MessageReceiver;
import minevalley.core.api.messaging.instruction.Instruction;
import net.kyori.adventure.text.ComponentLike;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Team extends MessageReceiver, SoundReceiver {

    /**
     * Send a message to the team chat.
     *
     * @param message The message to send.
     * @throws IllegalArgumentException If the message is null.
     */
    void sendTeamChatMessage(@Nonnull String message) throws IllegalArgumentException;

    /**
     * Send a message to the team chat.
     *
     * @param message     The message to send.
     * @param instruction The instruction to send.
     * @throws IllegalArgumentException If the message or instruction is null.
     */
    void sendTeamChatMessage(@Nonnull String message, @Nonnull Instruction instruction) throws IllegalArgumentException;

    /**
     * Send a message to the team chat.
     *
     * @param message the message to send
     * @throws IllegalArgumentException if the message is null
     */
    void sendTeamChatMessage(@Nonnull ComponentLike message) throws IllegalArgumentException;

    /**
     * Sends a message to the team chat.
     *
     * @param message     the message to send
     * @param instruction the instruction to send
     * @throws IllegalArgumentException if the message or instruction is null
     */
    void sendTeamChatMessage(@Nonnull ComponentLike message, @Nonnull Instruction instruction) throws IllegalArgumentException;
}
