package pl.inpost.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.inpost.models.ParcelLocker;
import pl.inpost.models.ParcelLockerResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ParcelLockerApi {


    private ParcelLockerApi() {
    }

    private static final Logger logger = LoggerFactory.getLogger(ParcelLockerApi.class);

    private static final String BASE_URL = "https://api.inpost-group.com";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<ParcelLocker> fetchParcelLockers(String city) {
        Response response = RestAssured
                .given()
                .baseUri(BASE_URL)
                .queryParam("query", city)
                .when()
                .get("/geowidget/v1/points")
                .then()
                .extract().response();

        if (response.getStatusCode() != 200) {
            logger.warn("Invalid Response code: {}", response.getStatusCode());
            return Collections.emptyList();
        }

        try {

            ParcelLockerResponse parcelLockerResponse = objectMapper.readValue(
                    response.getBody().asString(), ParcelLockerResponse.class
            );
            return parcelLockerResponse.getItems();
        } catch (IOException e) {
            logger.warn("Problems with parsing: {}", e.getMessage());
            return Collections.emptyList();
        }
    }
}