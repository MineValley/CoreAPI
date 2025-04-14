package minevalley.core.api.modifiers;

import javax.annotation.Nonnull;
import java.util.Vector;

public interface TranslationModifier {

    /**
     * Set the translation
     *
     * @param translation the translation, default is (0, 0, 0)
     * @return the current instance
     */
    ScaleModifier setTranslation(@Nonnull Vector<Float> translation);

    /**
     * Update the translation.
     */
    void updateTranslation();
}
