package util;

import java.util.UUID;

public final class AppUtil {
    public static final String FIND_BY_ID_MESSAGE = "Please, add id of wine";
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}

