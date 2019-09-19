package com.produce_module.listener;

import java.util.UUID;

public class UUIDKit {
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
