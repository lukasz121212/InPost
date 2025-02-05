package pl.inpost.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParcelLocker {
    private String name;
    @JsonProperty("address_details")
    private pl.inpost.models.AddressDetails addressDetails;
    private pl.inpost.models.Location location;
}

