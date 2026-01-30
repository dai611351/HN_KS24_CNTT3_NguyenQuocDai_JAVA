import java.util.*;
import java.util.regex.*;

public class LeetCodeConsoleApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            System.out.print("👉 Nhập lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    twoSum();
                    break;
                case 2:
                    moveZeroes();
                    break;
                case 3:
                    validPalindrome();
                    break;
                case 4:
                    reverseWords();
                    break;
                case 5:
                    happyNumber();
                    break;
                case 0:
                    System.out.println("👋 Thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);
    }

    // ================= MENU =================
    static void showMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Two Sum");
        System.out.println("2. Move Zeroes");
        System.out.println("3. Valid Palindrome");
        System.out.println("4. Reverse Words");
        System.out.println("5. Happy Number");
        System.out.println("0. Thoát");
        System.out.println("==========================");
    }

    // ================= FR1 =================
    static void twoSum() {
        System.out.print("Nhập số phần tử: ");
        int n = Integer.parseInt(sc.nextLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.print("Nhập target: ");
        int target = Integer.parseInt(sc.nextLine());

        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("✅ Tìm thấy: [" + i + ", " + j + "]");
                    found = true;
                    return;
                }
            }
        }

        if (!found) {
            System.out.println("❌ Không tìm thấy cặp số phù hợp");
        }
    }

    // ================= FR2 =================
    static void moveZeroes() {
        System.out.print("Nhập số phần tử: ");
        int n = Integer.parseInt(sc.nextLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }

        while (index < n) {
            arr[index++] = 0;
        }

        System.out.println("✅ Mảng sau khi dồn 0:");
        System.out.println(Arrays.toString(arr));
    }

    // ================= FR3 =================
    static void validPalindrome() {
        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();

        // Regex: loại bỏ ký tự không phải chữ cái
        String cleaned = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        int left = 0, right = cleaned.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("✅ Kết quả: " + isPalindrome);
    }

    // ================= FR4 =================
    static void reverseWords() {
        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();

        // Xóa khoảng trắng thừa
        String[] words = input.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }

        System.out.println("✅ Kết quả:");
        System.out.println(sb.toString().trim());
    }

    // ================= FR5 =================
    static void happyNumber() {
        System.out.print("Nhập số n: ");
        int n = Integer.parseInt(sc.nextLine());

        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
        }

        if (n == 1) {
            System.out.println("✅ Đây là số hạnh phúc");
        } else {
            System.out.println("❌ Không phải số hạnh phúc");
        }
    }

    static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
