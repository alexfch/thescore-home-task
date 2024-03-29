package hometask;

import java.net.URL;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {
    //String hostIP = "127.0.0.1";
    private static AppiumDriverLocalService server;
    
    public static void start(){
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.withIPAddress("127.0.0.1").usingPort(4723);
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();  

        System.out.println("START. isRunning? : " + server.isRunning());
        System.out.println("Url: " + server.getUrl());
    }

    public static void stop(){
        server.stop();
        System.out.println("STOP. isRunning? : " + server.isRunning());
    }

    public static URL getUrl(){
        return server.getUrl();
    }
}
