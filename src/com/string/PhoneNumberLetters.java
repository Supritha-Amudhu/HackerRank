package com.string;

import java.util.*;

public class PhoneNumberLetters {

    Map<Integer, String> phonePad;

    PhoneNumberLetters() {
        phonePad = new HashMap<>();
        phonePad.put(2, "abc");
        phonePad.put(3, "def");
        phonePad.put(4, "ghi");
        phonePad.put(5, "jkl");
        phonePad.put(6, "mno");
        phonePad.put(7, "pqrs");
        phonePad.put(8, "tuv");
        phonePad.put(9, "wxyz");
    }
//    "ad", "ae", "af", "bd, "be, "bf, "cd", "ce", "cf"

    void processDials(String dials) {
        if(dials == null || dials.length() == 0) {
            return;
        }
        if(dials.length() == 1) {
            System.out.println(phonePad.get(Integer.parseInt(dials)));
            return;
        }
        String[] split = dials.split("");
        int[] numberDials = new int[split.length];
        for(int i=0;i<split.length;i++) {
            numberDials[i] = Integer.parseInt(split[i]);
        }
        List<String> stringList = new ArrayList<>();
        for(int eachNumber:numberDials) {
            stringList.add(phonePad.get(eachNumber));
        }
        List<String> combinations = new ArrayList<>();
        List<String> combinationsFinal = new ArrayList<>();
        while(stringList.size() != 0) {
            if(combinations.isEmpty()) {
                combinations.addAll(Arrays.asList(stringList.remove(0).split("")));
                continue;
            }
            String first = stringList.remove(0);
            System.out.println("First string: " + first);
            combinationsFinal.clear();
            for(int i=0;i<combinations.size();i++) {
                for(int j=0;j<first.length();j++) {
                    combinationsFinal.add(String.valueOf(combinations.get(i)) + first.charAt(j));
                }
            }
            combinations.clear();
            combinations.addAll(combinationsFinal);
            System.out.println("Combination: "+combinations);
            System.out.println("Combination Final: "+combinationsFinal);
            System.out.println("Final String List: "+stringList);
        }
    }

    public static void main(String[] args) {
        PhoneNumberLetters phone = new PhoneNumberLetters();
        phone.processDials("234");
    }
}
