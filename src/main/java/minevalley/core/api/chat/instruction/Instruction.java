package minevalley.core.api.chat.instruction;

import minevalley.core.api.chat.MessageReceiver;

import javax.annotation.Nonnull;

/**
 * The {@code Instruction} is a record that represents an instruction that can be sent to a {@link MessageReceiver}.
 * It is used to provide additional information about any action this instruction is associated with.
 *
 * @param id   the id of the instruction (is used to identify the instruction and should therefor be unique for each instruction but should be consistently used for the same instruction)
 * @param text the text of the instruction
 */
public record Instruction(@Nonnull String id, @Nonnull String text) {

    public Instruction {
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        if (text == null) {
            throw new IllegalArgumentException("text must not be null");
        }
        if (id.isBlank()) {
            throw new IllegalArgumentException("id must not be blank");
        }
        if (text.isBlank()) {
            throw new IllegalArgumentException("text must not be blank");
        }
    }
}