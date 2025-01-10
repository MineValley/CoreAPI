package minevalley.core.api.team;

import minevalley.core.api.chat.MessageReceiver;
import minevalley.core.api.chat.instruction.Instruction;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Team extends MessageReceiver {

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
}
