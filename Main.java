public class Main{
    public static void main(String[] args){
        int [] array2 = new int[100];
        for(int i = 0; i<100; i++){
            array2[i] = i;
        }

        int [] array3 = new int[]{10,20,25,1000,2000,2001,10000,25000};
        
        binarySearch(array3, 2001);

        
    }

    public static void binarySearch(int [] array1, int num1){
        int numTotal = array1.length;
        int start=0;
        int end=array1.length-1;
        array1= new int[numTotal];
        //int numMin = 1;
        //int numMax = 100;
        
        while(true){
            if(num1>array1[(start+end)/2]){
                numTotal/=2;
                System.out.println("less");
            }
            else if(num1<array1[(start+end)/2]){
                numTotal/=2;
                System.out.println("more");
            }
        }
    }

}