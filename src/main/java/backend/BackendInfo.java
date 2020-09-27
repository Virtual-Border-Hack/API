package backend;


public class BackendInfo {

    public static final String KEYSPACE = "database";

    public static final String USERS = "users";

    public final class USER_COLUMNS {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String CALENDARS = "calendars";
        public static final String GROUP = "groups";
    }

    public static final String GROUP = "groups";

    public final class GROUPS {
        public static final String ID = "groupid";
        public static final String NAME = "name";
        public static final String OWNER = "owner";
        public static final String MEMBERS = "members";
        public static final String CALENDARS = "calendars";
    }

    public static final String CALENDARS = "calendars";

    public final class CALENDARS {
        public static final String NAME = "name";
        public static final String EVENTS = "events";
        public static final String ID = "id";
    }

    public static final String EVENT = "event";

    public final class EVENTS {
        public static final String NAME = "name";
        public static final String START = "start";
        public static final String END = "end";
        public static final String DATE = "date";
        public static final String ID = "id";
    }


}



