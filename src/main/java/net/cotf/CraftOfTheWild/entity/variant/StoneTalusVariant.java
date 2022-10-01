package net.cotf.CraftOfTheWild.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum StoneTalusVariant {
        WILD(0),
        BOX(1);

        private static final StoneTalusVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(StoneTalusVariant::getId)).toArray(StoneTalusVariant[]::new);

        private final int id;

        StoneTalusVariant(int id){
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static StoneTalusVariant byId(int id){
            return BY_ID[id % BY_ID.length];
        }
    }
