/*merge logic adapted from Princeton Algorithms, Part I by Kevin Wayne and Robert Sedgewick
*Additional merge logic adapted from: http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/7-Sort/merge-sort5.html
*/
public class Mergebm {

    private static void merge(int[] a, int low, int middle, int high, int[] tmp){
        //assert statements: write your assertion statements here if you wish

        //create pointers for the start of both lists
        int i = low;
        int j = middle + 1;

        //iterate over the entire array
        for(int l = low; l <= high; l++){
            
            //corner case: if the i pointer is exhausted, store the value of j pointer in the array
            if(i > middle) tmp[l] = a[j++];

            //corner case 2: if the j pointer is exhausted, store the value of the i pointer in the array
            else if (j > high) tmp[l] = a[i++];

            //standard case: compare value pointed to by i and j; store the lower value in a
            else if (a[j] < a[i]) tmp[l] = a[j++]; 
            else tmp[l] = a[i++];
        }
    }
    public static void sort(int[] a, int[] tmp){
        
        int width;

        //outer sort. increment the tmp array by power of 2 after each pass
        for(width = 1; width < a.length; width = 2*width){

            //inner sort
            for(int i = 0; i < a.length - width; i = i+2*width){
                int lo, mid, hi;

                lo = i;
                mid = lo + width - 1;
                hi = Math.min(i + width + width - 1, a.length - 1);
                merge(a, lo, mid, hi, tmp);
            }       
            //***** VERY IMPORTANT: copy array back after each width iteration
            for(int i = 0; i < a.length; i++){        
                a[i] = tmp[i];
            }
        }
    } 
    public static void main(String[] args){
        //array of numbers to be sorted
        int [] array = new int[] {5, 2, 3, 7, 1, 9, 0, 6, 4, 4};

        //create temp array here
        int[] tmp = new int[array.length];

        System.out.print("Unsorted array: ");
        for(int i = 0; i < array.length; i++)
        System.out.print("" + array[i]);

        sort(array, tmp);

        System.out.println();
        System.out.print("Sorted array: ");
        for(int i = 0; i < array.length; i++)
        System.out.print("" + array[i]);
    }

    
}
