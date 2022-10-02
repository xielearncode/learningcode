package com.ibm.learning.web; /**
 * @Author 谢飞
 * @Date 2022/9/30 20:43
 */

import com.ibm.learning.entity.Brand;
import com.ibm.learning.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addServlet", value = "/addServlet")
public class addServlet extends HttpServlet {
    BrandService brandService = new BrandService();

    public addServlet() throws IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));

        brandService.add(brand);

        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
        System.out.println("添加一条数据get");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post...");
        doGet(request,response);
    }
}
