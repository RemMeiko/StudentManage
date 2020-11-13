public class Main {
    public static void main(String[] args) {
        int[] a = {3,5,6,7,4,56,34,45,3,2};
        sort(a);
        for(int i : a) {
            System.out.println(i);
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
}
