import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuanLyMSSV {

    static String[] mssvList = new String[100];
    static int count = 0;

    static Scanner sc = new Scanner(System.in);

    static final String MSSV_REGEX = "^B\\d{7}$";

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            System.out.print(" Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    hienThiDanhSach();
                    break;
                case 2:
                    themMoiMSSV();
                    break;
                case 3:
                    capNhatMSSV();
                    break;
                case 4:
                    xoaMSSV();
                    break;
                case 5:
                    timKiemMSSV();
                    break;
                case 0:
                    System.out.println(" Thoát chương trình!");
                    break;
                default:
                    System.out.println(" Lựa chọn không hợp lệ!");
            }

         } while (choice != 0);
    }
      static void showMenu() {
        System.out.println("\n====== QUẢN LÝ MSSV ======");
        System.out.println("1. Hiển thị danh sách MSSV");
        System.out.println("2. Thêm mới MSSV");
        System.out.println("3. Cập nhật MSSV theo index");
        System.out.println("4. Xóa MSSV");
        System.out.println("5. Tìm kiếm MSSV");
        System.out.println("0. Thoát");
    }


    static void hienThiDanhSach() {
        if (count == 0) {
            System.out.println(" Danh sách MSSV rỗng!");
            return;
        }

        System.out.println(" Danh sách MSSV:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + mssvList[i]);
        }
    }

    static void themMoiMSSV() {
        if (count >= 100) {
            System.out.println(" Mảng đã đầy, không thể thêm!");
            return;
        }

        String mssv;
        while (true) {
            System.out.print("Nhập MSSV mới: ");
            mssv = sc.nextLine();

            if (isValidMSSV(mssv)) {
                break;
            } else {
                System.out.println(" Sai định dạng! MSSV phải dạng Bxxxxxxx");
            }
        }

        mssvList[count] = mssv;
        count++;
        System.out.println(" Thêm MSSV thành công!");
    }


    static void capNhatMSSV() {
        if (count == 0) {
            System.out.println(" Danh sách rỗng!");
            return;
        }

        System.out.print("Nhập index cần sửa (0 - " + (count - 1) + "): ");
        int index = Integer.parseInt(sc.nextLine());

        if (index < 0 || index >= count) {
            System.out.println(" Index không hợp lệ!");
            return;
        }

        String newMssv;
        while (true) {
            System.out.print("Nhập MSSV mới: ");
            newMssv = sc.nextLine();

            if (isValidMSSV(newMssv)) {
                break;
            } else {
                System.out.println(" Sai định dạng MSSV!");
            }
        }

        mssvList[index] = newMssv;
        System.out.println(" Cập nhật thành công!");
    }
    static void xoaMSSV() {
        if (count == 0) {
            System.out.println(" Danh sách rỗng!");
            return;
        }

        System.out.print("Nhập MSSV cần xóa: ");
        String target = sc.nextLine();

        int pos = -1;
        for (int i = 0; i < count; i++) {
            if (mssvList[i].equalsIgnoreCase(target)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println(" Không tìm thấy MSSV!");
            return;
        }
        for (int i = pos; i < count - 1; i++) {
            mssvList[i] = mssvList[i + 1];
        }

        mssvList[count - 1] = null;
        count--;

        System.out.println(" Đã xóa MSSV thành công!");

    }
    static void timKiemMSSV() {
        if (count == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        System.out.print("Nhập chuỗi cần tìm: ");
        String keyword = sc.nextLine();

        Pattern pattern = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);
        boolean found = false;

        System.out.println(" Kết quả tìm kiếm:");
        for (int i = 0; i < count; i++) {
            Matcher matcher = pattern.matcher(mssvList[i]);
            if (matcher.find()) {
                System.out.println("- " + mssvList[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println(" Không có MSSV phù hợp!");
        }
    }

    static boolean isValidMSSV(String mssv) {
        return mssv.matches(MSSV_REGEX);
    }
}
