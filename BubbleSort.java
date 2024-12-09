import java.util.Arrays;

public class BubbleSort {
    
    
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
                System.out.println(
                        "i = "
                        +(i+1)
                        + "; j = "
                        + (j + 1)
                        + "; "
                        + Arrays.toString(array)
                );
            }
        }
    }
    
     public static void main(String[] args) {
        int[] numbers = {76,6,107,92,21,23,5,9,8,8043};
        
        BubbleSort sorter = new BubbleSort();
        
        
        System.out.println("Array before sorting:");
        System.out.println(Arrays.toString(numbers));
        
        
        sorter.sort(numbers);
        
        
        System.out.println("Array after sorting:");
        System.out.println(Arrays.toString(numbers));
    }
}
