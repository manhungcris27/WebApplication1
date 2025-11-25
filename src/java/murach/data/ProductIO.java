package murach.data;

import java.io.*;
import java.util.ArrayList;

import murach.business.Product;

public class ProductIO {

    private static ArrayList<Product> products = null;

    // Đọc danh sách sản phẩm (chỉ đọc 1 lần)
    public static ArrayList<Product> getProducts(String path) {
        products = new ArrayList<Product>();
        File file = new File(path);

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));

            String line = in.readLine();
            // Bắt đầu từ dòng 21 (vị trí cũ của String[] fields = line.split("\t");)
while (line != null) {
    // 1. Kiểm tra dòng trống
    if (line.trim().isEmpty()) {
        line = in.readLine();
        continue; // Bỏ qua và đọc dòng tiếp theo
    }

    // 2. Tách bằng dấu phẩy
    String[] fields = line.split(",");
    
    // 3. Kiểm tra độ dài an toàn (phải có ít nhất 3 trường)
    if (fields.length < 3) {
        System.err.println("LỖI ĐỊNH DẠNG: Dòng thiếu trường dữ liệu đã bị bỏ qua: " + line);
        line = in.readLine();
        continue; // Bỏ qua và đọc dòng tiếp theo
    }

    // Nếu đạt đến đây, dữ liệu hợp lệ (có ít nhất 3 trường)
    try {
        String code = fields[0];
        String description = fields[1];
        // Dòng 24 (sẽ không gây lỗi vì fields.length >= 3)
        double price = Double.parseDouble(fields[2]);

        products.add(new Product(code, description, price));
    } catch (NumberFormatException e) {
        // Xử lý lỗi nếu trường thứ 3 không phải là số (giá)
        System.err.println("LỖI ĐỊNH DẠNG GIÁ: Dòng không hợp lệ đã bị bỏ qua: " + line);
    }

    line = in.readLine();
}
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        return products;
    }

    // Lấy sản phẩm theo mã
    public static Product getProduct(String code, String path) {
        if (products == null) {
            products = getProducts(path);
        }

        for (Product p : products) {
            if (p.getCode().equalsIgnoreCase(code)) {
                return p;
            }
        }
        return null;
    }
}
