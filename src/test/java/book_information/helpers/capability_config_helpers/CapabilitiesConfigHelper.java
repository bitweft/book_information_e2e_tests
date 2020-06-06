package book_information.helpers.capability_config_helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;

public class CapabilitiesConfigHelper {
    private static CapabilitiesConfig capabilitiesConfig = null;
    private static final String configFileName = "capabilities_config.yml";

    public static DeviceSpecificCapability getDeviceCapability(String deviceName) {
        if (capabilitiesConfig == null) {
            capabilitiesConfig = getCapabilitiesConfig();
        }
        return getDeviceSpecificCapabilities(deviceName);
    }

    private static DeviceSpecificCapability getDeviceSpecificCapabilities(String deviceName) {
        return capabilitiesConfig.deviceCapabilities()
                .stream()
                .filter(capabilities -> capabilities.deviceName().equals(deviceName))
                .collect(Collectors.toList())
                .get(0);
    }

    private static CapabilitiesConfig getCapabilitiesConfig() {
        CapabilitiesConfig deviceConfigs = null;
        try {
            File file = getCapabilityResourceFile();
            deviceConfigs = new ObjectMapper(new YAMLFactory()).readValue(file, CapabilitiesConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deviceConfigs;
    }

    private static File getCapabilityResourceFile() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource(configFileName)).getFile());
    }
}
