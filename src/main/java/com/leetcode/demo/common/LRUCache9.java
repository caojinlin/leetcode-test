package com.leetcode.demo.common;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 实现LRU cache
 */
public class LRUCache9 {
    LRUCacheMap lruCacheMap;

    public LRUCache9(int size) {
        lruCacheMap = new LRUCacheMap(size);
    }

    public Object get(Object key) {
        if (lruCacheMap.containsKey(key)) {
            Object value = lruCacheMap.get(key);
            //先删除，然后重新移除
            lruCacheMap.remove(key);
            lruCacheMap.put(key, value);
            return value;
        }
        return null;
    }

    public void set(Object key, Object value) {
        lruCacheMap.put(key, value);
    }

    public void entrySet() {
        Set<Map.Entry> set = lruCacheMap.entrySet();

        for (Map.Entry entry : set) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "====" + value);
        }
    }

    //缓存map
    public class LRUCacheMap extends LinkedHashMap {
        private int MAX;

        public LRUCacheMap(int max) {
            this.MAX = max;
        }

        /**
         * 复写这个方法可以将cachemap的size定义好，并且超过这个size
         * 之后再出发put 或者putall 就会将100个中比较前面的给清除掉
         *
         * @param eldest
         * @return
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX;
        }
    }

    public static void main(String[] args) {
        LRUCache9 cache = new LRUCache9(3);

        cache.set("1", "1");
        cache.set("2", "2");
        cache.set("3", "3");

        Object o = cache.get("4");
        cache.get("1");
        cache.get("2");

        //3-1-2
        //1-2-4
        cache.set("4", "4");

        cache.entrySet();

    }
}
