/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cntt.edu.vn;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PC-31
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Cấu hình UTF-8 để hiển thị tiếng Việt không bị lỗi font
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Lấy dữ liệu được gửi từ form
        String maSV = request.getParameter("maSV");
        String hoTen = request.getParameter("hoTen");
        String email = request.getParameter("email");
        String ngaySinh = request.getParameter("ngaySinh");

        // Xuất kết quả ra màn hình trình duyệt
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Kết quả Sinh viên</title></head>");
        out.println("<body>");
        out.println("<h2>THÔNG TIN SINH VIÊN ĐÃ NHẬN</h2>");
        out.println("<p><b>Mã sinh viên:</b> " + maSV + "</p>");
        out.println("<p><b>Họ tên:</b> " + hoTen + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Ngày sinh:</b> " + ngaySinh + "</p>");
        out.println("<br><a href='sinhvien.html'>Quay lại form nhập</a>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Nếu người dùng truy cập trực tiếp bằng phương thức GET, chuyển về trang nhập
        response.sendRedirect("sinhvien.html");
    }
}
