package backend;

import com.datastax.driver.core.*;

public class Connection {

    public Cluster openConnection(String ip) {
        return new Cluster.Builder()
                .addContactPoints(ip)
                .withPort(9042)
                .withQueryOptions(
                        (new QueryOptions())
                                .setRefreshNodeIntervalMillis(0)
                                .setRefreshNodeListIntervalMillis(0)
                                .setRefreshSchemaIntervalMillis(0))
                .withoutJMXReporting()
                .build();
    }
}
