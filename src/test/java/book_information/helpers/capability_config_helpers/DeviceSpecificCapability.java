package book_information.helpers.capability_config_helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DeviceSpecificCapability(
        @JsonProperty("udid")String udid,
        @JsonProperty("systemPort")String systemPort,
        @JsonProperty("platformName")String platformName,
        @JsonProperty("deviceName")String deviceName) {
}