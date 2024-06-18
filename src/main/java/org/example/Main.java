package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.example.async.AlertsConsumer;
import org.example.async.AlertsPublisher;
import org.example.async.Publisher;
import org.example.async.Subscriber;
import org.example.model.AlertConfiguration;
import org.example.model.DispatchType;
import org.example.model.Event;
import org.example.model.EventType;
import org.example.service.AlertConfigurationService;
import org.example.service.MonitoringService;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        try (Reader reader = new FileReader("src/main/resources/input.json")) {
            Type listType = new TypeToken<List<AlertConfiguration>>() {
            }.getType();
            List<AlertConfiguration> alertConfigList = gson.fromJson(reader, listType);

            System.out.println(alertConfigList);
            AlertConfigurationService alertConfigurationService = new AlertConfigurationService(alertConfigList);
            MonitoringService monitoringService = new MonitoringService(alertConfigurationService);

            Subscriber subscriber = new AlertsConsumer(monitoringService);
            Publisher publisher = new AlertsPublisher();
            publisher.subscribe(subscriber);

//            for (int i=0;i<22;i++) {
//                Thread.sleep(1000);
//                publisher.publishMessage(new Event(System.currentTimeMillis(), EventType.PAYMENT_EXCEPTION, "X"));
////                publisher.publishMessage(new Event(System.currentTimeMillis(), EventType.USERSERVICE_EXCEPTION, "X"));
//            }

            for (int i=0;i<22;i++) {
                Thread.sleep(1000);
                publisher.publishMessage(new Event(System.currentTimeMillis(), EventType.USERSERVICE_EXCEPTION, "X"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addMessage(JsonObject object) {

    }
}