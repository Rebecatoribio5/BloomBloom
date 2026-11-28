import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SunriseSunset {

    // 1. Raleigh, North Carolina coordinates
    private static final double RALEIGH_LATITUDE = 35.7796;
    private static final double RALEIGH_LONGITUDE = -78.6382;

    private static final HttpClient CLIENT =
            HttpClient.newHttpClient();

    // 2. Request actual sunrise and sunset times
    public static SunTimes getTimes(LocalDate date)
            throws IOException, InterruptedException {

        String url = "https://api.sunrise-sunset.org/v2"
                + "?lat=" + RALEIGH_LATITUDE
                + "&lng=" + RALEIGH_LONGITUDE
                + "&date=" + date;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new IOException("Sunrise API request failed: "
                    + response.statusCode());
        }

        JsonObject json = JsonParser.parseString(
                response.body()
        ).getAsJsonObject();

        if (json.has("error")) {
            throw new IOException(
                    json.get("message").getAsString()
            );
        }

        // 3. Convert API times into LocalTime
        LocalTime sunrise = OffsetDateTime.parse(
                json.get("sunrise").getAsString()
        ).toLocalTime();

        LocalTime sunset = OffsetDateTime.parse(
                json.get("sunset").getAsString()
        ).toLocalTime();

        return new SunTimes(sunrise, sunset);
    }

    // Stores the two returned times
    public static class SunTimes {

        private final LocalTime sunrise;
        private final LocalTime sunset;

        public SunTimes(LocalTime sunrise, LocalTime sunset) {
            this.sunrise = sunrise;
            this.sunset = sunset;
        }

        public LocalTime getSunrise() {
            return sunrise;
        }

        public LocalTime getSunset() {
            return sunset;
        }
    }
}