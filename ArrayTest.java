/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa_day3;

/**
 *
 * @author Shasha
 */
import java.util.Arrays;

public class ArrayTest {
    
    public static void main(String[] args){
        int array[] = new int[] {9, 7, 11, 8, 1};
        System.out.println(Arrays.toString(array));
        
        
        int temp = array[4];
        array[4] = array[3];
        array[3] = temp;
        
        System.out.println(Arrays.toString(array));
    }
    
}
