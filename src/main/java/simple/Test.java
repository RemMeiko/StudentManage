package simple;

public class Test {
    public static void main(String[] args) {
        int[] a = {3,5,6,7,4,56,34,45,3,2};
        sort(a);
        int[] b = {3,5,6,7,4,56,34,45,3,2};
        sortEach(b);
        for(int i : a) {
            System.out.print(i+",");
        }
        System.out.printf("\n");
        for(int i : b) {
            System.out.print(i+",");
        }
    }

    // 冒泡排序
    public static void sort(int[] arrays) {
        for(int i = 0;i < arrays.length-1;i++) {
            for(int j = 0;j < arrays.length-1-i; j++) {
                if(arrays[j] < arrays[j+1]) {
                    int temp = 0;
                    temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp;
                }
            }
        }
    }

    // 更改冒泡排序
    public static void sortEach(int[] arrays) {
        int lastExchangIndex = 0;
        int sortBoard = arrays.length-1;
        for(int i = 0;i < arrays.length-1;i++) {
            boolean isSorted = true;
            for(int j = 0;j < sortBoard;j++) {
                if(arrays[j] < arrays[j+1]) {
                    int temp = 0;
                    temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                    isSorted = false;
                    lastExchangIndex = j;
                }
            }
            if(isSorted) {
                break;
            }
            sortBoard = lastExchangIndex;
        }
    }
}
