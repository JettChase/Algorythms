public class Main {
    public static void main(String[] args) {
        // int [] array2 = new int[100];
        // for(int i = 0; i<100; i++){
        // array2[i] = i+1;
        // }

        // int [] array3 = new int[]{10,20,25,1000,2000,2001,10000,25000};

        // binarySearch(array3, 2002);

        // System.out.println(binarySearch(array2, 4));

        // System.out.println(factorial(3));
        // System.out.println(fibonacci(5));
        // for(int i = -10; i<120; i++){
        // System.out.println(i + " " + recursion(array2, i, 0, array2.length-1));
        // }

        // int[] unSortedArray1 = new int[] { 1, 3, 5, 7, 9, 11 };
        // int[] unSortedArray2 = new int[] { 2, 4, 6, 8 };

        // // merge(unSortedArray1, unSortedArray2);

        // // for (int i = 0; i < unSortedArray1.length + unSortedArray2.length; i++) {
        // // System.out.println(merge(unSortedArray1, unSortedArray2));
        // // }

        // int[] newArray = new int[] { 6, 23, 10000, 0, 15, 4, 1000 };
        // for (int i = 0; i < newArray.length; i++) {
        //     System.out.println(mergeSort(newArray)[i]);
        // }
        LinkList list = new LinkList();
        list.add(7);
        System.out.println(list.tailNode.num1);
        list.add(14);
        System.out.println(list.tailNode.num1);
    }

    public static int[] merge(int[] unSortAr1, int[] unSortAr2) {
        int[] sortedArray = new int[unSortAr1.length + unSortAr2.length];
        int checker1 = 0;
        int checker2 = 0;
        int count = 0;

        // loops length of smaller array
        while (checker1 < unSortAr1.length && checker2 < unSortAr2.length) {

            // if array1Pos>array2Pos && if array1 > array2
            if (unSortAr1[checker1] > unSortAr2[checker2]) {
                sortedArray[count] = unSortAr2[checker2];
                // add to higher check
                checker2++;
                count++;
                continue;
            }

            // if array1Pos<array2Pos && if array1 > array2
            if (unSortAr1[checker1] < unSortAr2[checker2]) {
                sortedArray[count] = unSortAr1[checker1];
                // add to higher check
                checker1++;
                count++;
                continue;
            }
        }

        // if there are extra in other array print them after
        while (checker1 >= unSortAr1.length && checker2 != unSortAr2.length) {
            // sortedArray at [after checker1 finished] = bigger array
            sortedArray[checker2 + checker1] = unSortAr2[checker2];
            checker2++;
        }

        while (checker2 >= unSortAr2.length && checker1 != unSortAr1.length) {
            // sortedArray at [after checker1 finished] = bigger array
            sortedArray[checker2 + checker1] = unSortAr1[checker1];
            checker1++;
        }

        // if same length array
        return sortedArray;
    }

    public static int[] mergeSort(int[] unSortAr) {
        // base case when comparing 1v1
        if (unSortAr.length == 1) {
            int[] unSortArC = new int[unSortAr.length];
            unSortArC[0] = unSortAr[0];

            return unSortArC;
        }

        // base case if placeholder == 0
        if (unSortAr.length == 0) {
            return unSortAr;
        }

        // placeholder arrays
        int[] unSortArCopy = new int[unSortAr.length / 2];
        int[] unSortArCopy1 = new int[unSortAr.length / 2];
        int[] sortAr = new int[unSortAr.length];

        // if the # of numbers in the array is odd then add to a placerholder
        if (unSortAr.length % 2 != 0) {
            unSortArCopy = new int[unSortAr.length / 2 + 1];
            unSortArCopy[unSortArCopy.length - 1] = unSortAr[unSortAr.length - 1];
        }

        // loops filling place holders with original num split in half
        for (int i = 0; i < unSortAr.length / 2; i++) {
            unSortArCopy[i] = unSortAr[i];
            unSortArCopy1[i] = unSortAr[i + (unSortAr.length / 2)];
        }
        // combine in order //recurse each half
        sortAr = merge(mergeSort(unSortArCopy), mergeSort(unSortArCopy1));

        return sortAr;
    }

    public static int factorial(int num1) {
        int newNum1;
        if (num1 == 1) {
            return num1;
        } else {
            newNum1 = factorial(num1 - 1) * num1;
            return newNum1;
        }
    }

    public static int fibonacci(int sequencePos) {
        int num1;
        // if input is 1 then return 1
        if (sequencePos == 1) {
            return sequencePos;
        }
        // if input is 2 then return 1
        if (sequencePos == 2) {
            return sequencePos - 1;
        }
        // if input is any number but 1 or 2 then recurse the 2 numbers before it and
        // return it
        else {
            num1 = fibonacci(sequencePos - 1) + fibonacci(sequencePos - 2);
            return num1;
        }
    }

    // array1 = array that is being search
    public static boolean recursion(int[] array1, int num1, int start, int end) {
        if (num1 < array1[start]) {
            return false;
        }

        if (num1 > array1[end]) {
            return false;
        }

        if (num1 == array1[(start + end) / 2]) {
            return true;
        }

        if (num1 < array1[(start + end) / 2]) {
            end = (end + start) / 2;
        }

        if (num1 > array1[(start + end) / 2]) {
            start = (start + end) / 2;
        }

        if (end == start + 1) {
            start++;
        }

        return recursion(array1, num1, start, end);
    }

    public static boolean binarySearch(int[] array1, int num1) {
        int start = 0;
        int end = array1.length;

        while (true) {
            if (num1 == array1[(start + end) / 2] || start == end - 1) {
                if (array1[(start + end) / 2] == num1) {
                    return true;
                } else {
                    return false;
                }
            } else if (num1 < array1[(start + end) / 2]) {
                end = (end + start) / 2;
            } else if (num1 > array1[(start + end) / 2]) {
                start = (start + end) / 2;
            }
        }
    }

}