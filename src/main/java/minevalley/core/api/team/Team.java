package minevalley.core.api.team;

import minevalley.core.api.chat.MessageReceiver;
import minevalley.core.api.chat.instruction.Instruction;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Team extends MessageReceiver {

    void sendTeamChatMessage(@Nonnull String message) throws IllegalArgumentException;

    void sendTeamChatMessage(@Nonnull String message, @Nonnull Instruction instruction) throws IllegalArgumentException;
}
