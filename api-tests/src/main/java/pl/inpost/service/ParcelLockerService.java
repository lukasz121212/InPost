package pl.inpost.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.inpost.models.ParcelLocker;

import java.util.List;

public class ParcelLockerService {

    private ParcelLockerService() {
    }

    private static final Logger logger = LoggerFactory.getLogger(ParcelLockerService.class);

    public static List<ParcelLocker> filterParcelLockers(List<ParcelLocker> lockers) {
        if (lockers == null || lockers.isEmpty()) {
            logger.warn("No data to filter");
            return List.of();
        }

        return lockers.stream()
                .map(locker -> new ParcelLocker(
                        locker.getName(),
                        locker.getAddressDetails(),
                        locker.getLocation()
                ))
                .toList();
    }
}
