package com.example.songe.utils;

import lombok.Getter;

@Getter
public enum Statics {
    PAGE_SIZE(15),
    BLOCK_SIZE(8),
    DUMMY_DATA_SIZE(1000),
    EXPIRATION_TIME(1000 * 60 * 60 * 24 * 7); // 7 days

    private final int value;

    Statics(int value) {
        this.value = value;
    }

}
