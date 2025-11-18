package murach.email;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import murach.business.UserSurvey;
// Thay đổi package nếu UserSurvey ở chỗ khác

@WebServlet("/survey") // Ánh xạ Servlet tới URL mà form HTML gọi
public class SurveyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Lấy 6 tham số từ form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        
        // Tên tham số khớp với form Survey đã chỉnh sửa
        String heardFrom = request.getParameter("heardFrom");
        
        // Checkbox "updates" sẽ là null nếu không được chọn
        String updates = request.getParameter("updates");
        if (updates == null) {
            updates = "No"; 
        }
        
        String contactVia = request.getParameter("contactVia");
        
        // 2. Tạo đối tượng UserSurvey và gán dữ liệu
        UserSurvey user = new UserSurvey(firstName, lastName, email, 
                             heardFrom, updates, contactVia);
        
        // 3. Đặt đối tượng UserSurvey vào request scope
        // Sử dụng tên "user" để JSP dễ truy cập bằng ${user.propertyName}
        request.setAttribute("user", user);
        
        // 4. Định nghĩa URL của trang JSP kết quả
        String url = "/survey.jsp"; 
        
        // 5. Chuyển tiếp (forward) đến survey.jsp
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }
    
    // Thêm doGet nếu bạn muốn xử lý form gửi bằng GET, nhưng POST là tốt hơn cho form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}