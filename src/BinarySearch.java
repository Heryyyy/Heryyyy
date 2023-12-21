import java.util.Arrays;

//二分查找
public class BinarySearch {
    public int binarySearch(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;//注意减1
        //int j = a.length
        //取等号为了查询自身
        while (i <= j) {
            //while(i <j)
            int m = (i + j) >>> 1;//将m的二进制数右移一位，取中间数；用(i+j)会使int范围溢出产生负数
            if (target < a[m]) {
                j = m - 1;
                //j=m;
            } else if (target > a[m]) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    // For asymmetrical
    public int balanceBinarySearch(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (a[m] <= target) {
                i = m;
            } else
                j = m;
        }
        if (a[i] == target) {
            return i;
        } else
            return -1;
    }

    //    Insert number
    public void insertNumber(int a[], int number) {
//        int a[] = {1, 2, 4};
//        int number = 8;
        int low = Arrays.binarySearch(a, number);//java source code
        if (low < 0) {
            int b[] = new int[a.length + 1];
            int insertIndex = Math.abs(low + 1);
//            arraycopy() -- source array,first index,dest array,first index
            System.arraycopy(a, 0, b, 0, insertIndex);
            b[insertIndex] = number;
            System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);
            System.out.println(Arrays.toString(b));
        }
    }
// find repeat number for leftmost right most
    public int repeatNumber(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int can = -1;// To record the index
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (a[m] < target) {
                i = m + 1;
            } else if (a[m] > target) {
                j = m - 1;
            } else {
                can = m;
                //j = m - 1;//left index
                i = m + 1; //right index
            }
        }
        return can;
    }


    public static void main(String[] args) {
        {
            int[] arr = {1, 2, 3, 4, 4, 5, 6, 7, 8, 9};
            BinarySearch b = new BinarySearch();
            int result1 = b.binarySearch(arr, 7);
            System.out.println(result1);
            int result2 = b.balanceBinarySearch(arr, 7);
            System.out.println(result2);
            int result3 = b.repeatNumber(arr, 4);
            System.out.println(result3);
//        int x = Integer.MAX_VALUE;
//        System.out.println(x);
        }
    }
}
