package com.sam.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.sam.e.Print.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.



public class Main {


    public boolean isUnique(int[] array){
        HashSet<Integer> aSet = new HashSet<Integer>();

        return true;
    }


    public boolean isPolyndrom(String s){
        if(s == null){
            // change as needed
            return true;
        }
        int len = s.length();
        for(int i = 0; i < len/2; i++ ){
            if(s.charAt(i) != s.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }

    public boolean isAngram(String str1, String str2){
        HashSet<Object> s1 = new HashSet<>();
        HashSet<Object> s2 = new HashSet<>();
        // Could be adjusted according to the use to the function
        if(str1 == null && str2 == null){
            return true;
        } else if (str1 == null || str2 == null) {
            return false;
        } else if (str1.length()!=str2.length()){
            return false;
        }
        int len = str1.length();
        for (int i = 0; i < len; i++){
            s1.add(str1.charAt(i));
            s2.add(str2.charAt(i));
        }
        return s1.equals(s2);
    }

    public static void main(String[] args) {

    }
}
