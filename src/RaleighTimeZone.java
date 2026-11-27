import java.time.ZoneId;
import java.time.ZonedDateTime;

public class RaleighTimeZone {

    private static final ZoneId RALEIGH_ZONE =
            ZoneId.of("America/New_York");

    public static ZonedDateTime getRaleighTime(){
        return ZonedDateTime.now(RALEIGH_ZONE);
    }
}
