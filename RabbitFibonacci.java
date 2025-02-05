/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fibonacci;

/**
 *
 * @author Shasha
 */
public class RabbitFibonacci {

    public static int rabbitPairs(int months) {
        if (months == 0 || months == 1) {
            return 1;
        }
        return rabbitPairs(months - 1) + rabbitPairs(months - 2);
    }
    public static void main(String[] args){
        int months = 12;
            System.out.println("Number of rabbit pairs after "
                 + months + " month is "
                 + rabbitPairs(months)            
            );
    }

}
