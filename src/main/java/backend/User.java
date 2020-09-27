package backend;

public class User {

    /*@PostMapping(Endpoints.USER)
    void createUser(String name){
        new Connection().openConnection(Endpoints.IP).connect().execute(QueryBuilder.insertInto(BackendInfo.KEYSPACE, BackendInfo.USERS).value("uuid", UUID.randomUUID().toString()).value("name", name));
    }

    @GetMapping(Endpoints.USER)
    String getUser(String userUUUID){
        Session session = new Connection().openConnection(Endpoints.IP).connect();
        //session.execute(QueryBuilder.select().all().from(BackendInfo.KEYSPACE, BackendInfo.USERS).where(QueryBuilder.eq(BackendInfo.Events.)))
    }

    @DeleteMapping(Endpoints.USER)
    void deleteUser(String userUUID){
        //new Connection().openConnection(Endpoints.IP).connect().execute(QueryBuilder.);
    }*/
}
