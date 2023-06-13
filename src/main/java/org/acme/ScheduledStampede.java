package org.acme;

import io.quarkus.scheduler.Scheduled;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@ApplicationScoped
public class ScheduledStampede {

    @Inject
    @RestClient
    HelloClient client;

    @Scheduled(every = "5s", concurrentExecution = Scheduled.ConcurrentExecution.SKIP)
    public Uni<Void> letLooseStampede() {
        var unis = new ArrayList<Uni<Response>>();
        for (int i = 0; i < 50; i++) {
            unis.add(client.hello("Hello"));
        }
        return Uni.combine().all().unis(unis).discardItems().invoke(d -> System.out.println("Done"));
    }

}
