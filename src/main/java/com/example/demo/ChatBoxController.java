package com.example.demo;


import com.example.demo.Model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ChatBoxController {
    RoomProvider roomProvider = new RoomProvider();
    @GetMapping(path = "rooms")
    @ResponseBody
    public  String getAllrooms(){
        return roomProvider.printAllrooms();
    }

    @PostMapping(path = "rooms")
    @ResponseBody
    public  String addAroom(@RequestBody String nameofRoom){
        Room nwRoom = new Room(nameofRoom);
        roomProvider.addAroom(nwRoom);
        return "Added room with id: " + nwRoom.getRoomID();
    }

   @GetMapping(path = "rooms/{id}")
    @ResponseBody
    public  String getALLmessage(@PathVariable("id") int id){
        return roomProvider.getMessagebyID(id);
   }

   @PostMapping(path = "rooms/{id}")
    @ResponseBody
    public  String addAmessage(@PathVariable("id") int id,@RequestParam("username") String username,@RequestBody String text){
        String str = "";
        if(roomProvider.getRoombyID(id) == null){
            return "Room not found!";
        }
       roomProvider.getRoombyID(id).addMessage(username,text);
        return "Added message to room" +   id  + " , total messages: " + roomProvider.getRoombyID(id).getMessages().size();
   }
}
