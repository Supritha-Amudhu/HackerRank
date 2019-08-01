package com.string;

public class Permutations {

    void permute(String str, int left, int right) {
        if(left == right) {
            System.out.println(str);
        }
        else {
            for(int i=left;i<=right;i++) {
                str = swap(str, left, i);
                permute(str, left+1, right);
                str = swap(str, left, i);
            }
        }
    }

    String swap(String str, int left, int right) {
        char[] split = str.toCharArray();
        char temp = split[left];
        split[left] = split[right];
        split[right] = temp;
        return String.valueOf(split);
    }

    public static void main(String[] args) {
        String str = "abcd";
        int size = str.length();
        Permutations permutations = new Permutations();
        permutations.permute(str, 0, size-1);
    }
}
