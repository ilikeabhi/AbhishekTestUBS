package com.ubs.opsit.interviews;

import java.util.stream.Stream;

public class TimeConverter {

    public String convertTime(String aTime) {
//Split the given String on the basis of :
 	String time[] = aTime.split(":");
//Convert the string array to the integer array 	
 	 int[] parts = new int[time.length];
     for (int i = 0; i < time.length; i++) {
        String numberAsString = time[i];
        parts[i] = Integer.parseInt(numberAsString);
     }
 //return the addition of all the methods with newline as the same is expected in testcases    
    return getSeconds(parts[2])+"\r\n"+
    getTopHours(parts[0])+"\r\n"+
    getBottomHours(parts[0])+"\r\n"+
    getTopMinutes(parts[1])+"\r\n"+
    getBottomMinutes(parts[1]);
    
    }
 
    protected String getSeconds(int number) {
        if (number % 2 == 0) return "Y";
        else return "O";
    }
 
    protected String getTopHours(int number) {
        return getOnOff(4, getTopNumberOfOnSigns(number));
    }
 
    protected String getBottomHours(int number) {
        return getOnOff(4, number % 5);
    }
 
    protected String getTopMinutes(int number) {
        return getOnOff(11, getTopNumberOfOnSigns(number), "Y").replaceAll("YYY", "YYR");
    }
 
    protected String getBottomMinutes(int number) {
        return getOnOff(4, number % 5, "Y");
    }
 
    private String getOnOff(int lamps, int onSigns) {
        return getOnOff(lamps, onSigns, "R");
    }
    private String getOnOff(int lamps, int onSigns, String onSign) {
        String out = "";
        for (int i = 0; i < onSigns; i++) {
            out += onSign;
        }
        for (int i = 0; i < (lamps - onSigns); i++) {
            out += "O";
        }
        return out;
    }
 
    private int getTopNumberOfOnSigns(int number) {
        return (number - (number % 5)) / 5;
    }
 public static void main(String[] args) {
	TimeConverter tc = new TimeConverter();
	String str = tc.convertTime("00:00:00");
	System.out.println(str);

}

}
