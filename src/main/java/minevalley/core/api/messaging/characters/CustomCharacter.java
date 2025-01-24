package minevalley.core.api.messaging.characters;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CustomCharacter {

    EMOJI_HEART('\ue000'),
    EMOJI_LAUGH('\ue001'),
    EMOJI_SMILE('\ue002'),
    EMOJI_GRIN('\ue003'),
    EMOJI_WINK('\ue004'),
    EMOJI_WINKING_WITH_TONGUE('\ue005'),
    EMOJI_KISSES('\ue006'),
    EMOJI_SHOCK('\ue007'),
    EMOJI_BIG_SHOCK('\ue008'),
    EMOJI_PAIN('\ue009'),
    EMOJI_ANNOYED('\ue010'),
    EMOJI_CRYING('\ue011'),

    RADIO('\uea00'),
    SHOUT('\uea01'),
    EXCLAMATION_MARK('\uea02'),
    CROSS('\uea03'),
    CHECKMARK('\uea04'),
    LOG('\uea05'),
    INPUT('\uea06'),
    BUG('\uea07'),
    EYE('\uea08'),
    WRENCH('\uea09'),
    CIRCLE('\uea10'),
    HOUSE('\uea11'),
    EURO_NOTES('\uea12'),
    DRIFTING_CAR('\uea13'),
    NPC('\uea14'),

    BELL('\ueb00'),
    PHONE('\ueb01'),

    MV('\uec00'),
    MV_BW('\uec01'),

    HELP_QUESTION_MARK('\ued00'),
    TEAM('\ued01'),

    MEDICS('\uee00'),
    COPS('\uee01'),
    MAIL('\uee02'),
    DISPOSAL('\uee03'),
    HANDCUFFS('\uee04'),
    PREMIUM('\uee05'),
    SUPPORT_QUESTION_MARK('\uee06'),

    MEDICS_TRANSPARENT('\uef00'),
    COPS_TRANSPARENT('\uef01'),
    MAIL_TRANSPARENT('\uef02'),
    DISPOSAL_TRANSPARENT('\uef03'),
    HANDCUFFS_TRANSPARENT('\uef04'),
    PREMIUM_TRANSPARENT('\uef05'),
    SUPPORT_QUESTION_MARK_TRANSPARENT('\uef06'),

    SINGLE_WHITE_SPACE('\ueeee');

    private final char c;

    @SuppressWarnings("unused")
    public char getChar() {
        return c;
    }

    @Override
    public String toString() {
        return Character.toString(c);
    }
}