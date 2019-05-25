package com.example.demo.Model;

public class Message  {
    private String text;
    private String username;

    public Message(String username, String text){
        this.username = username;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "## " + getUsername() + " says:\n" + getText() + "\n";
    }
}
