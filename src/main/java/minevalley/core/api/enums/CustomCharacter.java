package minevalley.core.api.enums;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CustomCharacter {

    /*
    https://www.ssec.wisc.edu/~tomw/java/unicode.html#x3040
    https://en.wikipedia.org/wiki/List_of_Unicode_characters#East_Asian_writing_systems
     */

    MV('ぐ'),
    MV_BW('け'),
    SUPPORT_QUESTION_MARK('げ'),
    HELP_QUESTION_MARK('こ'),
    TEAM('ご'),

    SUPPORT_QUESTION_MARK_TRANSPARENT('ヱ'),

    MEDICS('だ'),
    COPS('ち'),
    MAIL('ぢ'),
    DISPOSAL('っ'),
    HANDCUFFS('つ'),

    MEDICS_TRANSPARENT('ム'),
    COPS_TRANSPARENT('メ'),
    MAIL_TRANSPARENT('モ'),
    DISPOSAL_TRANSPARENT('ャ'),
    HANDCUFFS_TRANSPARENT('ヤ'),

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

    PREMIUM('ゐ'),

    RADIO('゠'),
    SHOUT('ァ'),
    CROSS('ア'),
    CHECKMARK('ィ'),
    LOG('イ'),
    BUG('ゥ'),
    EYE('ウ'),
    WRENCH('ェ'),
    CIRCLE('エ'),
    HOUSE('ォ'),

    PREMIUM_TRANSPARENT('ヰ'),

    SINGLE_WHITE_SPACE('₶');

    private final char c;

    @Override
    public String toString() {
        return Character.toString(c);
    }
}