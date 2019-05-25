package com.example.demo.Model;

import java.util.ArrayList;

public class Room {
    private String roomName;
    private ArrayList<Message> messages;
    private int roomID;
    private static int thelastID = 0;

    public Room(String roomName){
        this.roomName = roomName;
        thelastID++;
        this.roomID = thelastID;
        this.messages = new ArrayList<>();

    }

    public int getRoomID() {
        return roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void addMessage(String username, String message){
        messages.add(new Message(username,message));
    }

    @Override
    public String toString() {
        String str = "";
        str += "#Room: " + getRoomName() + "\n";
        for(Message message : getMessages()){
            str += message.toString();
        }
        return str;
    }
}
