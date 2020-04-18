package com.ray.common.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Marie
 * @date 2020/4/18 11:55 PM
 **/
public class IOUtils {
    /**
     * 关闭连接
     *
     * @param closeable
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {

        }
    }
}
