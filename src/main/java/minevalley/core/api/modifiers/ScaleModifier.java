package minevalley.core.api.modifiers;

import javax.annotation.Nonnull;
import java.util.Vector;

public interface ScaleModifier {

    /**
     * Set the scale
     *
     * @param scale the scale, default is (1.0, 1.0, 1.0)
     * @return the current instance
     */
    ScaleModifier setScale(@Nonnull Vector<Float> scale);

    /**
     * Update the scale.
     */
    void updateScale();
}
