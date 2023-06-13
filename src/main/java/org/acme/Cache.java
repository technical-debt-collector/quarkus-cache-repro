package org.acme;

import io.smallrye.mutiny.Uni;
import io.quarkus.cache.CacheResult;

import javax.inject.Singleton;

@Singleton
public class Cache {

    @CacheResult(cacheName = "cache", lockTimeout = 5000L)
    public Uni<String> uppercase(String input) {
        System.out.println("Invoking method (this should only appear once)");
        return Uni.createFrom().item(input.toUpperCase());
    }

}
