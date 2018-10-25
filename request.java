/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author amritha giri
 */
@WebServlet(urlPatterns = {"/request"})
public class request extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static BasicAWSCredentials creds=null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String bucketName = "amrithas3";
        response.setContentType("text/html;charset=UTF-8");
         
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             File file = new File("C:/S3 Buckets/test.txt"); 
          FileWriter fr = new FileWriter(file, true);
          String dist=request.getParameter("district");
          String loc=request.getParameter("location");
          String name=request.getParameter("name");
          String number=request.getParameter("phone");
          String food=request.getParameter("food");
          String water=request.getParameter("water");
          String clothing=request.getParameter("clothing");
          String medicine=request.getParameter("medicine");
          String sanitation=request.getParameter("sanitation");
          String all=dist+loc+name+number+food+water+clothing+medicine+sanitation;
          //out.println(all);
          out.println("Request successfully registered");
	Date date = new Date();
        String day=date.toString();
        /*fr.append("District");
        fr.append(";");
        fr.append("Location");
        fr.append(";");
        fr.append("Name");
        fr.append(";");
        fr.append("Phone Number");
        fr.append(";");
        fr.append("Date and time of Request");
        fr.append(";");
        fr.append("Requests");
        fr.append(";");
        fr.append('\n');
        */
          fr.append(dist);
          fr.append(";");
          fr.append(loc);
          fr.append(";");
          fr.append(name);
          fr.append(";");
          fr.append(number);
          fr.append(";");
          fr.append(day);
          fr.append(";");
           if(food!=null) {
          fr.append(food);
          fr.append(" ");
          
           }
           if(water!=null) {
          fr.append(water);
          fr.append(" ");
          
           }
           if(clothing!=null) {
          fr.append(clothing);
          fr.append(" ");
         
           }
           if(medicine!=null) {
          fr.append(medicine);
          fr.append(" ");
          
           }
           if(sanitation!=null) {
          fr.append(sanitation);
           }
         
          
           fr.append(System.getProperty("line.separator"));
          fr.close();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet request</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p><a href=\"home.jsp\"> View Registrations or Request Help </p>");
          //  out.println("<h1>Servlet request at " + request.getContextPath() + "</h1>");
            out.println("<meta http-equiv=\"refresh\" content=\"0; URL='http://localhost:8080/labevalaws/home.jsp'\" />");
            out.println("</body>");
            out.println("</html>");
        }
         creds = new BasicAWSCredentials("AKIAIOIPXD2HOSYLPLJA","1qXauI1NPNn2IMPOkxgHDMjhA0oNzuNmBKQj9zaq");
      String path="C:\\S3 Buckets\\test.txt";
      String foldername="Kerala.txt";
      AmazonS3 s3 = AmazonS3Client.builder().withRegion(Regions.US_EAST_1).withCredentials(new AWSStaticCredentialsProvider(creds)).build();
      PutObjectResult res=s3.putObject(new PutObjectRequest(bucketName, foldername, new File(path)));
        System.out.println( res.toString());
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
