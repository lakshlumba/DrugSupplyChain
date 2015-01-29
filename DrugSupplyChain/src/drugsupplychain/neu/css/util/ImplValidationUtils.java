/*
 * Class : ImplValidationUtils.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 1:57:15 AM
 * ---------------------------------------------------------------------------
 * Change History
 * Develper :
 * Reviwer :
 * Changed ON :
 * ---------------------------------------------------------------------------
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugsupplychain.neu.css.util;

import drugsupplychain.neu.css.log.ImplLogger;

/**
 *
 * @author Laksh
 */
public final class ImplValidationUtils {
    /**
     * null and empty check for strings
     * @param str
     * @return 
     */
    public static final boolean isStringEmptyOrNull(String str) {
        if(null == str || ImplConst.EMPTY.equals(str.trim())){
            return true;
        } else {
            return false;
        }
    }
    /**
     * to check if the string is an integer.
     * @param integer
     * @return 
     */
    public static final boolean isInteger(String integer) {
        try {
            int n = Integer.parseInt(integer);
            if ( n > 0){
                return true;
            }else {
                return false;
            }            
        } catch (NumberFormatException numberFormatException) {
            ImplLogger.error(numberFormatException);
            return false;
        }
    }   
    /**
     * to check if the string is an integer.
     * @param flt
     * @return 
     */
    public static final boolean isFloat(String flt) {
        try {
            Float.parseFloat(flt);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    } 
    
    /**
     * to check if the string is an integer.
     * @param str
     * @return 
     */
    public static final boolean isAlphabetOnly(String str) {
        String expression = "^[a-zA-Z]*$";
        if (!isStringEmptyOrNull(str) && str.matches(expression)){
            return true;
        }
        return false;
    } 
    
    /**
     * to check if the string is an integer.
     * @param str
     * @return 
     */
    public static final boolean isAlphaSpace(String str) {
        //String expression1 = "([a-zA-Z]+\\\\s+)*[a-zA-Z]+";
        String expression = "([a-zA-Z]+ +)*[a-zA-Z]+";
        if (!isStringEmptyOrNull(str) && str.matches(expression)){
            return true;
        }
        return false;
    }
     /**
     * to check if the string is an integer.
     * @param str
     * @return 
     */
    public static final boolean isNumericAndPostive(String str) {
        String expression = "[0-9]+";
        if (!isStringEmptyOrNull(str) && str.matches(expression)){
            return true;
        }
        return false;
    }
}
