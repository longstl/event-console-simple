package model;

import entity.Event;

import java.sql.*;
import java.util.ArrayList;

public class EventModel {
    Event event = new Event();

    public Event addEvent(String eventCode, String eventName, long startTime, long finishTime, int eventType, int status) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aptech_fpt?useUnicode=true&characterEncoding=utf-8", "root", "");
            String insertQ = "INSERT INTO events (eventCode,eventName,startTime,finishTime,eventType,status) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQ);
            preparedStatement.setString(1, eventCode);
            preparedStatement.setString(2, eventName);
            preparedStatement.setLong(3, startTime);
            preparedStatement.setLong(4, finishTime);
            preparedStatement.setInt(5, eventType);
            preparedStatement.setInt(6, status);
            preparedStatement.execute();
            System.out.println("Add event Success !!!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }

    public ArrayList<Event> query() {
        ArrayList<Event> listEvent = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aptech_fpt?useUnicode=true&characterEncoding=utf-8", "root", "");
            String lQuery = "SELECT * FROM events";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(lQuery);
            while (rs.next()) {
                String eventCode = rs.getString("eventCode");
                String eventName = rs.getString("eventName");
                Long startTime = rs.getLong("startTime");
                Long finishTime = rs.getLong("finishTime");
                int eventType = rs.getInt("eventType");
                int status = rs.getInt("status");
                event = new Event(eventCode, eventName, startTime, finishTime, eventType, status);
                listEvent.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEvent;
    }

    public Event getEventById(String eventCode){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aptech_fpt?useUnicode=true&characterEncoding=utf-8", "root", "");
            String lQuery = "SELECT * FROM events where eventCode = " +
                    "'" +
                    eventCode +
                    "'" +
                    "";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(lQuery);
            while (rs.next()) {
                String eventName = rs.getString("eventName");
                Long startTime = rs.getLong("startTime");
                Long finishTime = rs.getLong("finishTime");
                int eventType = rs.getInt("eventType");
                int status = rs.getInt("status");
                event = new Event(eventCode, eventName, startTime, finishTime, eventType, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }
}
