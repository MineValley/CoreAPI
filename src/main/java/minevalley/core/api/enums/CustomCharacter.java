package minevalley.core.api.enums;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CustomCharacter {

    MV('\uef00'),
    MV_BW('\uef01'),
    SUPPORT_QUESTION_MARK('\uef02'),
    HELP_QUESTION_MARK('\uef03'),
    TEAM('\uef04'),

    SUPPORT_QUESTION_MARK_TRANSPARENT('\uef05'),

    MEDICS('\uef06'),
    COPS('\uef07'),
    MAIL('\uef08'),
    DISPOSAL('\uef09'),
    HANDCUFFS('\uef10'),

    MEDICS_TRANSPARENT('\uef11'),
    COPS_TRANSPARENT('\uef12'),
    MAIL_TRANSPARENT('\uef13'),
    DISPOSAL_TRANSPARENT('\uef14'),
    HANDCUFFS_TRANSPARENT('\uef15'),

    EURO_NOTES('\uef16'),
    BELL('\uef17'),
    DRIFTING_CAR('\uef18'),
    PHONE('\uef19'),


    EMOJI_HEART('\uef20'),
    EMOJI_LAUGH('\uef21'),
    EMOJI_SMILE('\uef22'),
    EMOJI_GRIN('\uef23'),
    EMOJI_WINK('\uef24'),
    EMOJI_WINKING_WITH_TONGUE('\uef25'),
    EMOJI_KISSES('\uef26'),
    EMOJI_SHOCK('\uef27'),
    EMOJI_BIG_SHOCK('\uef28'),
    EMOJI_PAIN('\uef29'),
    EMOJI_ANNOYED('\uef30'),
    EMOJI_CRYING('\uef31'),

    PREMIUM('\uef32'),

    RADIO('\uef33'),
    SHOUT('\uef34'),
    CROSS('\uef35'),
    CHECKMARK('\uef36'),
    LOG('\uef37'),
    BUG('\uef38'),
    EYE('\uef39'),
    WRENCH('\uef40'),
    CIRCLE('\uef41'),
    HOUSE('\uef42'),

    PREMIUM_TRANSPARENT('\uef43'),

    SINGLE_WHITE_SPACE('\uef44');

    private final char c;

    @Override
    public String toString() {
        return Character.toString(c);
    }
}