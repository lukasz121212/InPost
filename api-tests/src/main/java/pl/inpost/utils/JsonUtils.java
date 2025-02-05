package pl.inpost.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.inpost.models.ParcelLocker;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

public class JsonUtils {

    private JsonUtils() {
    }

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    public static void saveParcelLockersToFile(List<ParcelLocker> lockers, String city) {
        try {
            String fileName = "target/parcellockers." + city.toLowerCase() + ".json";
            objectMapper.writeValue(new File(fileName), lockers);
            logger.info("Saved data to file: {}", fileName);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to save data to file: " + city, e);
        }
    }
}
