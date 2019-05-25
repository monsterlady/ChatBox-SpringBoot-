package com.example.demo;

import com.example.demo.Model.Message;
import com.example.demo.Model.Room;

import java.util.ArrayList;

public class RoomProvider {

    public ArrayList<Room> rooms = new ArrayList<>();

    public  String printAllrooms() {
        String str = "";
        if (rooms.size() == 0) {
            return "No room available now";
        } else {
            for (Room room : rooms) {
                str += "Room: " + room.getRoomID() + ": " + room.getRoomName() + "\n";
            }
            return str;
        }
    }

    public  String getMessagebyID(int id){
        boolean isFound = false;
        for(Room room : rooms){
            if(room.getRoomID() == id){
                isFound = true;
            }
        }
        //
        if(isFound){
            return getRoombyID(id).toString();
        } else {
            return "Room " + id + " doesn't exist!";
        }
    }

    public  void addAroom(Room nwRoom){
        rooms.add(nwRoom);
    }

    public  Room getRoombyID(int id){
        for(Room room : rooms){
            if(room.getRoomID() == id){
                return room;
            }
        }
        return null;
    }
}
