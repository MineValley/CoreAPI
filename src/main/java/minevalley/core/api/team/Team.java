package minevalley.core.api.team;

import minevalley.core.api.audio.SoundReceiver;
import minevalley.core.api.messaging.MessageReceiver;
import minevalley.core.api.messaging.instruction.Instruction;
import minevalley.core.api.users.TeamMember;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

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

    /**
     * Gets a stream of all users that are currently in team service.
     *
     * @return team members
     */
    @Nonnull
    @Contract(pure = true)
    Stream<TeamMember> getTeamMembers();

    /**
     * Gets a stream of all users that are currently in team service and vanished.
     *
     * @return vanished team members
     */
    @Nonnull
    @Contract(pure = true)
    Stream<TeamMember> getVanishedTeamMembers();

    /**
     * Gets a stream of all users that are currently in team and support service.
     *
     * @return team members in support service
     */
    @Nonnull
    @Contract(pure = true)
    Stream<TeamMember> getTeamMembersInSupportService();
}
