package book_information.helpers.capability_config_helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CapabilitiesConfig(@JsonProperty("capabilities")List<DeviceSpecificCapability>deviceCapabilities) {
}
