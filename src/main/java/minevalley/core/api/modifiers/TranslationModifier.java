package minevalley.core.api.modifiers;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.Vector;

@SuppressWarnings("unused")
public interface TranslationModifier<T extends TranslationModifier<T>> {

    /**
     * Set the translation
     *
     * @param translation the translation, default is (0, 0, 0)
     * @return this
     * @throws IllegalArgumentException if the translation is null
     */
    @Nonnull
    @Contract("_ -> this")
    T setTranslation(@Nonnull Vector<Float> translation) throws IllegalArgumentException;

    /**
     * Update the translation.
     */
    void updateTranslation();
}
