package com.duplicall.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description CustomLinkedHashMap
 * @Author Sean
 * @Date 2021/10/13 12:01
 * @Version 1.0
 */
public class CustomLinkedHashMap extends LinkedHashMap {
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>5;
    }
}
