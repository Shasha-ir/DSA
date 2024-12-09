public class Hanoi {
    public static void hanoi(String src, String des, String aux, int n) {
        if (n == 1) {
            System.out.println( src + " to " + des);
        } else {
            hanoi(src, aux, des, n-1); 
            System.out.println( src + " to " + des);
            hanoi(aux, des, src, n-1); 
        }
    }

    public static void main(String[] args) {
        int n = 4; 
        hanoi("A", "B", "C", n); 
    }
}
