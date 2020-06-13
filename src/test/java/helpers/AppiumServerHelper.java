package helpers;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumServerHelper {
    public static URL getServerUrl() {
        URL url = null;
        try {
            url = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
