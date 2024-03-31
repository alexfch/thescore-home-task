package hometask;

import java.io.File;
import java.net.URL;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {
    private static AppiumDriverLocalService server;
    
    public static void start(){
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder
            .withIPAddress("127.0.0.1")
            .usingPort(4723);
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();  
    }

    public static void stop(){
        server.stop();
    }

    public static URL getUrl(){
        return server.getUrl();
    }
}
