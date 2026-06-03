package eu.minevalley.core.api.virtual;

import eu.minevalley.core.api.virtual.modifier.*;

public interface Interaction extends InteractionModifier<Interaction>, LocationModifier<Interaction>,
        RotationModifier<Interaction>, ScaleModifier<Interaction>, VisibilityModifier<Interaction>,
        TranslationModifier<Interaction> {
}
