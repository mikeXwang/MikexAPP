package com.mikexapp.mikex.mikexapp.utils;

/**
 * Created by mike on 16-8-27.
 */

public class ConstantsUtils {
    /**
     * the type of app launching mode
     *
     * 0:start apps with packageName
     * 1:start apps with filePath
     * 2:start apps with newPath(url)
     * 3:we left for future
     */
    public static final int START_TYPE_PACKAGE_NAME = 0;
    public static final int START_TYPE_FILE_PATH = 1;
    public static final int START_TYPE_NET_PATH = 2;
    public static final int START_TYPE_UNKNOWN = 3;

    /**
     * key of all map
     *
     */

    public static final String START_TYPE = "startType";

}
