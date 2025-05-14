package d27_二分查找;

public class text {
    public static void main(String[] args) {
        int[] list = {1,3};

        System.out.println(search(list, 3));

    }

    public static int search(int[] list, int target){

        int left = 0;
        int right = list.length-1;

        while(left <= right){
            int mid = (left + right) /2;

            if(list[mid] == target){
                return mid;
            } else if (list[mid] > target) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
