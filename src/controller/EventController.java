package controller;

import entity.Event;
import model.EventModel;

import java.util.ArrayList;
import java.util.Scanner;

public class EventController {
    EventModel eventModel = new EventModel();
    Scanner sc = new Scanner(System.in);

    public void addEventController() {
        System.out.println("-----------------------------------");
        System.out.println("Please enter Event Code: ");
        String eventCode = sc.nextLine();
        System.out.println("Please enter Event Name: ");
        String eventName = sc.nextLine();
        System.out.println("Please enter Start Time: ");
        Long startTime = sc.nextLong();
        System.out.println("Please enter Finish Time: ");
        Long finishTime = sc.nextLong();
        System.out.println("Please enter Event Type: ");
        Integer eventType = sc.nextInt();
        if (eventType == 1 || eventType == 2) {
            System.out.println("Please enter Event Status: ");
            Integer status = sc.nextInt();
            if (status == 0 || status == 1) {
                if (eventCode != null && eventName != null && startTime != null && finishTime != null && eventType != null && status != null) {
                    eventModel.addEvent(eventCode, eventName, startTime, finishTime, eventType, status);
                } else {
                    System.out.println("Your Input is Null. Please Re-enter.");
                }
            } else {
                System.err.println("Status incorrect ( Enter only 0 or 1 ).");
            }
        } else {
            System.err.println("Event Type incorrect ( Enter only 1 or 2 ).");
        }
    }

    public void printEventList() {
        ArrayList<Event> list = eventModel.query();
        System.out.println("--------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s \n", "Event Code", "Event Name", "Start Time", "Finish Time", "Event Type", "Status");
        System.out.println("------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            Event ev = list.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s \n", ev.getEventCode(), ev.getEventName(), ev.getStartTime(), ev.getFinishTime(), (ev.getEventType() == 1 ? "Metting" : "Team Building"), (ev.getStatus() == 1 ? "Delete" : "Action"));
        }
    }

    public void printEventByCode() {
        System.out.println("-------------------------------------");
        System.out.println("Please enter Event Code: ");
        String eventCode = sc.nextLine();
        Event existEvent = eventModel.getEventById(eventCode);
        if (existEvent == null) {
            System.out.println("Event is not exist or has been deleted!");
        } else {
            System.out.println("Event information: ");
            System.out.println("Event Code: " + existEvent.getEventCode());
            System.out.println("Event Name: " + existEvent.getEventName());
            System.out.println("Event Start Time: " + existEvent.getStartTime());
            System.out.println("Event Finish Time: " + existEvent.getFinishTime());
            System.out.println("Event Type: " + (existEvent.getEventType() == 1 ? "Metting" : "Team Building"));
            System.out.println("Status: " + (existEvent.getStatus() == 1 ? "Delete" : "Action"));
        }
    }

}
