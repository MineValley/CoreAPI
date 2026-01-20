package minevalley.core.api.modifiers;

import org.bukkit.util.Vector;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface TranslationModifier<T extends TranslationModifier<T>> {

    /**
     * Set the translation
     *
     * @param x x translation
     * @param y y translation
     * @param z z translation
     * @return the current instance
     */
    @Nonnull
    @Contract("_, _, _ -> this")
    T setTranslation(float x, float y, float z);

    /**
     * Set the translation
     *
     * @param translation the translation, default is (x: 0, y: 0, z: 0)
     * @return this
     * @throws IllegalArgumentException if the translation is null
     */
    @Nonnull
    @Contract("_ -> this")
    T setTranslation(@Nonnull Vector translation) throws IllegalArgumentException;

    /**
     * Update the translation.
     */
    void updateTranslation();
}
