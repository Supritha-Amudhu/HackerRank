package com.string;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class ZigZagPattern {

    Map<Integer, List<String>> getZigZag(String input, int numRows) {
        String[] split = input.split("");
        Map<Integer, List<String>> inputMap = new HashMap<>();
        int level = 0;
        int counter=1;
        while(counter <= split.length) {
            List<String> chars = new ArrayList<>();
            if(counter%4 == 0) {
                level++;
                if(inputMap.containsKey(level)) {
                    chars = inputMap.get(level);
                }
                else {
                    chars = new ArrayList<>();
                }
                chars.add(split[counter-1]);
                inputMap.put(level, chars);
                level++;
                counter++;
            }
            if(inputMap.containsKey(level)) {
                chars = inputMap.get(level);
            }
            else {
                chars = new ArrayList<>();
            }
            chars.add(split[counter-1]);
            inputMap.put(level, chars);
            counter++;
        }
        System.out.println(inputMap);
        return inputMap;
    }

    void printZigZag(Map<Integer, List<String>> inputMap, int numRows) {
        int internalCounter = 0;
        while(internalCounter < numRows) {
            for(int i=0;i<inputMap.size();i++) {
                if(i % 2 == 0) {
                    if(!inputMap.get(i).isEmpty()) {
                        System.out.print(inputMap.get(i).remove(0) + " ");
                    }
                }
                else if(i % 2 == 1 && internalCounter == 1) {
                    if(!inputMap.get(i).isEmpty()) {
                        System.out.print(inputMap.get(i).remove(0) + " ");
                    }
                }
            }
            System.out.println();
            internalCounter++;
        }
    }

    public static void main(String[] args) {
        ZigZagPattern pattern = new ZigZagPattern();
        String input = "PayPalIsHiring";
        int numRows = 3;
        Map<Integer, List<String>> inputMap = pattern.getZigZag(input, numRows);
        pattern.printZigZag(inputMap, numRows);
    }
}
