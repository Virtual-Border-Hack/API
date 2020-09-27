package backend;

import com.datastax.driver.core.*;

import com.datastax.driver.core.querybuilder.QueryBuilder;

import com.google.common.reflect.TypeToken;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

import static com.datastax.driver.core.querybuilder.QueryBuilder.set;
import static java.sql.Types.NULL;

@RestController
@RequestMapping(Endpoints.API)
public class CreateCalendarsController {


    @RequestMapping(value = Endpoints.CREATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody String groupname) {
        System.out.println(groupname);
        JSONObject name = new JSONObject(groupname);
        String uuid = UUID.randomUUID().toString();
        new Connection().openConnection("localhost").connect().execute(QueryBuilder.insertInto("database", "data2").value("groupid", uuid).value("groupname", name.getString("groupname")));
        JSONObject response = new JSONObject();

        return uuid;
    }

    @PutMapping(Endpoints.UPDATE)
    public void update(@RequestBody String event) {
        String notevent = event.substring(1, event.length() - 1);
        System.out.println(notevent);
        List<String> data = new LinkedList<>();
        Map<String, List<String>> userdata = null;
        JSONObject eventDetail = new JSONObject(event);
        Session  session = new Connection().openConnection("localhost").connect();
        ResultSet response = session.execute(QueryBuilder.select().all().from("database", "data2").where(
            QueryBuilder.eq("groupid", eventDetail.getString("groupid"))));
        for(Row row: response) {
            userdata = row.getMap("user", TypeToken.of(String.class), TypeTokens.listOf(String.class));

        }
        if(userdata == null)
            userdata = new HashMap<>();
        String start = eventDetail.toString().substring(18, 41);
        String end = eventDetail.toString().substring(61, 84);
        data.add(eventDetail.getString("groupid") + " " + start + " " + end);
        userdata.put(eventDetail.getString("name"), data);
        session.execute(QueryBuilder.update(
        "database", "data2").with(set("user", userdata)).where(QueryBuilder.eq("groupid", eventDetail.getString("groupid"))));
    }
}
