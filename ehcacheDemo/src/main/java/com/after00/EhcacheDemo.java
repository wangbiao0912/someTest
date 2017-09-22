package com.after00;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

public class EhcacheDemo {
  public static void main(String[] args) throws Exception {
    // Create a cache manager
    final CacheManager cacheManager = new CacheManager();

    // create the cache called "helloworld"
    final Cache cache = cacheManager.getCache("helloworld");

    // create a key to map the data to
    final String key = "greeting";

    // Create a data element
    final Element putGreeting = new Element(key, "Hello, World!");

    // Put the element into the data store
    cache.put(putGreeting);

    // Retrieve the data element
    final Element getGreeting = cache.get(key);

    // Print the value
    System.out.println(getGreeting.getObjectValue());
  }
}
