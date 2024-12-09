public class RecursionApplication {
    static void towerOfHanoi(char source_rod, char destination_rod, char auxialry_rod, int n){
        if (n == 1){
            System.out.println("Move disk from " + source_rod + " to " + destination_rod);
        }
        else{
            towerOfHanoi(source_rod, auxialry_rod, destination_rod, n-1);
            towerOfHanoi(source_rod, destination_rod, auxialry_rod, 1);
            towerOfHanoi(auxialry_rod, destination_rod, source_rod, n-1);
        }
    }
    
    public static void main(String[] args){
        int noOfDisk = 4;
        towerOfHanoi('A', 'B', 'C', noOfDisk);
    }
}
