/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Validator {
    
    public static boolean isEmpty(String input) {
        if(input == null)
            return true;
        return input.equals("");
    }
    
    public static boolean isWord(String input) {
        if(input == null) return false;
        String wordRegex = "[a-zA-Z]";
        Pattern pattern = Pattern.compile(wordRegex);
        return pattern.matcher(input).matches();
    }
    
    public static boolean isName(String input) {
        if(input == null) return false;
        String wordRegex = "^[a-zA-Z\\u00C0-\\u1EF9]+(?:[\\s.]+[a-zA-Z\\u00C0-\\u1EF9]+)*$";
        Pattern pattern = Pattern.compile(wordRegex);
        return pattern.matcher(input).matches();
    }
    
    public static boolean isInteger(String num) {
        if (num == null) return false;
        try {
            if(Integer.valueOf(num) < 0)
                return false;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean isFloat(String num) {
        if (num == null) return false;
        try {
            if(Float.valueOf(num) < 0)
                return false;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean isPhoneNumber(String phoneNum) {
        if(phoneNum == null) {
            return false;
        }
        String phoneNumRegex = "^0[0-9]{9}$";
        Pattern pattern = Pattern.compile(phoneNumRegex);
        return pattern.matcher(phoneNum).matches();
    }
    
    public static boolean isEmail(String email) {
        if (email == null) {
            return false;
        }
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
    
    public static boolean isValidISBN(String input) {
        if (input == null) {
            return false;
        }
        String isbnRegex = "^[1-9]{1}[0-9]{10}$";
        Pattern pattern = Pattern.compile(isbnRegex);
        return pattern.matcher(input).matches();
    }
    
}
