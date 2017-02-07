package com.wudu.downlibrary.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * author : wudu
 * time : 2016/10/19
 */
public class IOCloseUtils {

    public static final void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            synchronized (IOCloseUtils.class) {
                closeable.close();
            }
        }
    }
}
