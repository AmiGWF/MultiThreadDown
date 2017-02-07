package com.wudu.downlibrary.util;

import java.util.List;

/**
 * author : wudu
 * time : 2016/10/19
 */
public class ListUtils {

    public static final boolean isEmpty(List list) {
        return !(list != null && list.size() > 0);
    }
}
