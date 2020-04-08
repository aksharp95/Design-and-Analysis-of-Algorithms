//Question 2

public class Zero {
    public static void main(String[] args) {
        int [] A = {1,3,4,6,7,8,9,20};
        int [] B = {0,1,3,4,6,7,8,9,20};

        int start = 0;
        int end = B.length;
        int index = 0;

        if(B[B.length-1]!=0){
            index = binarySearch(A,B,0,start,end);
        }else{
            index = B.length-1;
        }


        System.out.println("Zero found at index "+(index+1));
    }


    /*
    * This method searches for 0 in array B
    * Time Complexity: O(log N)
    * Space Complexity: O(log N)
    * */
    public static int binarySearch(int [] A, int [] B, int element, int start, int end){
        if(end>=start){
            int mid = start+(end-start)/2;
            if(B[mid]==element)
                return mid;

            if(A[mid]==B[mid])
                return binarySearch(A,B,element,mid,end);

            return binarySearch(A,B,element,start,mid-1);
        }
        return -1;
    }
}
