package kz.iitu.itse1909r.nugmanova.Configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.cache.CacheManager;

class CacheConfigTest {
    CacheConfig cacheConfig = new CacheConfig();

    @Test
    void testCacheManager() {
        CacheManager result = cacheConfig.cacheManager();
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme