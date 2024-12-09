public class FindFactorial {
    //method to find the factorial
    public static long factorial(int n){
        if (n == 1)
            return 1;
        else
            return n * factorial(n-1);
    }
    
    public static void main(String[] args){
        
        long result = factorial(5);
        System.out.println("Factorial is " + result);
        
        long result2 = factorial(10);
        System.out.println("Factorial is " + result2);
        
        
        
    }
    
}
