import java.util.Scanner;
import java.util.ArrayList;

public class ArrayUtils {

    // 1. Method nhập mảng số thực
    public static float[] importData(float[] arrays) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < arrays.length; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arrays[i] = scanner.nextFloat();
        }
        return arrays;
    }

    // 2. Method xuất mảng ra màn hình
    public static void printData(float[] arrays) {
        System.out.println("Các phần tử của mảng là:");
        for (float element : arrays) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // 3. Method tìm giá trị phần tử lớn thứ 2 trong mảng
    public static float findMax2(float[] arrays) {
        if (arrays.length < 2) {
            System.out.println("Mảng phải có ít nhất 2 phần tử để tìm giá trị lớn thứ 2.");
            return Float.NaN; // Trả về Not-a-Number (NaN) nếu không thể tìm giá trị lớn thứ 2
        }

        float max1 = Float.NEGATIVE_INFINITY;
        float max2 = Float.NEGATIVE_INFINITY;

        for (float element : arrays) {
            if (element > max1) {
                max2 = max1;
                max1 = element;
            } else if (element > max2 && element != max1) {
                max2 = element;
            }
        }

        if (max2 == Float.NEGATIVE_INFINITY) {
            System.out.println("Không tìm thấy giá trị lớn thứ 2 khác giá trị lớn nhất.");
            return Float.NaN;
        }

        return max2;
    }

    // 4. Method xóa các phần tử lẻ ra khỏi mảng
    public static float[] deleteOddNumber(float[] arrays) {
        ArrayList<Float> evenList = new ArrayList<>();

        for (float element : arrays) {
            if (element % 2 == 0) { // Kiểm tra nếu phần tử là số chẵn
                evenList.add(element);
            }
        }

        // Chuyển ArrayList thành mảng float[]
        float[] resultArray = new float[evenList.size()];
        for (int i = 0; i < evenList.size(); i++) {
            resultArray[i] = evenList.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        // Tạo mảng số thực
        float[] numbers = new float[5];

        // Nhập mảng số thực từ bàn phím
        numbers = importData(numbers);

        // Xuất mảng ra màn hình
        System.out.println("Mảng ban đầu:");
        printData(numbers);

        // Tìm giá trị phần tử lớn thứ 2 trong mảng
        float max2 = findMax2(numbers);
        if (!Float.isNaN(max2)) {
            System.out.println("Giá trị lớn thứ 2 trong mảng là: " + max2);
        }

        // Xoá các phần tử lẻ ra khỏi mảng
        numbers = deleteOddNumber(numbers);
        System.out.println("Mảng sau khi xóa các phần tử lẻ:");
        printData(numbers);
    }
}



