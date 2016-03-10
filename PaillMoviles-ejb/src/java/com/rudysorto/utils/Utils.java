/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.utils;

/**
 *
 * @author rsorto
 */
public class Utils {
    
    public static boolean isNumeric(String str)  
{  
  try  
  {  
    int d =  Integer.parseInt(str);  
  }  
  catch(NumberFormatException nfe)  
  {  
    return false;  
  }  
  return true;  
}
    
}
