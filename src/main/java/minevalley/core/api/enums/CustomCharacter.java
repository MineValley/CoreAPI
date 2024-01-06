package minevalley.core.api.enums;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CustomCharacter {

    /*
    https://www.ssec.wisc.edu/~tomw/java/unicode.html#x3040
     */

    MV('ぐ'),
    MV_BW('け'),
    SUPPORT_QUESTION_MARK('げ'),
    HELP_QUESTION_MARK('こ'),

    MEDICS('だ'),
    COPS('ち'),
    MAIL('ぢ'),
    DISPOSAL('っ'),
    HANDCUFFS('つ'),

    EURO_NOTES('ば'),
    BELL('ぱ'),
    DRIFTING_CAR('ひ'),


    EMOJI_HEART('む'),
    EMOJI_LAUGH('め'),
    EMOJI_SMILE('も'),
    EMOJI_GRIN('ゃ'),
    EMOJI_WINK('や'),
    EMOJI_WINKING_WITH_TONGUE('ゅ'),
    EMOJI_KISSES('ゆ'),
    EMOJI_SHOCK('ょ'),
    EMOJI_BIG_SHOCK('よ'),
    EMOJI_PAIN('ら'),
    EMOJI_ANNOYED('り'),
    EMOJI_CRYING('る'),

    PREMIUM('ゐ');


    private final char c;

    @Override
    public String toString() {
        return Character.toString(c);
    }
}