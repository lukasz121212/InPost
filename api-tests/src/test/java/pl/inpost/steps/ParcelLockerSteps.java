package pl.inpost.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pl.inpost.api.ParcelLockerApi;
import pl.inpost.models.ParcelLocker;
import pl.inpost.service.ParcelLockerService;
import pl.inpost.utils.JsonUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ParcelLockerSteps {

    private List<ParcelLocker> lockers;

    @When("user sends request for parcel search with {string} parameter")
    public void userSendsRequestForParcelSearch(String city) {
        lockers = ParcelLockerApi.fetchParcelLockers(city);
    }

    @Then("response returns data")
    public void responseReturnsData() {
        lockers = ParcelLockerService.filterParcelLockers(lockers);
        assertThat(lockers)
                .as("Parcel locker list is empty")
                .isNotEmpty();
    }

    @Then("json file for {string} is saved and present")
    public void jsonFileIsSavedAndPresent(String city) {
        String fileName = "target/parcellockers." + city.toLowerCase() + ".json";

        JsonUtils.saveParcelLockersToFile(lockers, city);

        Path filePath = Path.of(fileName);
        assertThat(Files.exists(filePath))
                .as("Json file was not saved: " + filePath)
                .isTrue();
    }
}
