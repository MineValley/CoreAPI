package eu.minevalley.core.api.virtual.npc;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("unused")
public class NPCAnimation {

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public enum Type {

        LEAVE_BED(0),
        CRITICAL_EFFECT(1),
        MAGIC_CRITICAL_EFFECT(2);

        private final int id;
    }

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Swing {

        @Getter
        @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
        public enum Hand {

            MAIN_HAND(0),
            OFF_HAND(1);

            private final int id;
        }

        @Getter
        @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
        public enum Type {

            NONE(0),
            WHACK(1),
            STAB(2);

            private final int id;
        }
    }
}