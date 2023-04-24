public class TernarySearch {
    public static int ternarySearchRec(int [] A, int left, int right, int key){
        if (right <left){
            return -1;
        }
        int mid1= left +  (right - 1) / 3;
        int mid2= right - (right - left) / 3;
        if(A[mid1]==key){
            return mid1;
        }
        if(A[mid2]==key){
            return mid2;
        }
        if (A[mid2] < key){
            return ternarySearchRec(A,mid2-1,right,key);
        }else if (A[mid1] < key) {
            return ternarySearchRec(A, mid1-1,right-1,key);
        }else{
            return ternarySearchRec(A,left,mid1-1,key);
        }
    }

    public static void ternaryWrapper(int [] A,int key){
        System.out.println(ternarySearchRec(A,0,A.length-1,key));
    }

    public static void main(String[] args) {
        int [] A= new int[] {1,2,3,4,5,6};
        ternaryWrapper(A,5);
        // The worst case scenario is log3(n) since we are cutting the array into 3 parts ...
    }
}
