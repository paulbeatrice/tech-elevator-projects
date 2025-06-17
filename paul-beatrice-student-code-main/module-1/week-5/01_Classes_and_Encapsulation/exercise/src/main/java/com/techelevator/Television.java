package com.techelevator;

public class Television {

    // Instance variables
    private boolean isOn;
    private int currentChannel;
    private int currentVolume;

    //Default constructor (values are automatically set to default)
    public Television() {
        isOn = false; //Tv is off by default
        currentChannel = 3; // Default Channel
        currentVolume = 2; // Default Volume

    }

    // Method to turn off the TV and reset channel and volume to default
    public void turnOff() {
        isOn = false;
        currentChannel = 3;
        currentVolume = 2;
    }

    //method to turn on TV
    public void turnOn() {
        isOn = true;
    }

    //method to change the channel if it's within valid range
    public void changeChannel(int newChannel) {
        if( isOn && newChannel >= 3 && newChannel <=18) {
            currentChannel = newChannel;
        }
    }

    // Method to increase the channel by one (loops back to 3 if beyond 18)
    public void channelUp() {
        if (isOn) {
            currentChannel = (currentChannel == 18) ? 3 : currentChannel + 1;
        }
    }

    // method to decrease the channel by one (loops back to 18 if below 3)
    public void channelDown() {
        if (isOn) {
            currentChannel = (currentChannel == 3) ? 18 : currentChannel - 1;
        }
    }

    // method to raise volume by one (max volume is 10)
    public void raiseVolume() {
        if (isOn && currentVolume < 10) {
            currentVolume++;
        }
    }

    // method to lower volume by one (min volume is 0)
    public void lowerVolume() {
        if (isOn && currentVolume > 0) {
            currentVolume--;
        }
    }

    // Getters for testing purposes (optional)
    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }
}
