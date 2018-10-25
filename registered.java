/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amritha Giri
 */
@WebServlet(urlPatterns = {"/registered"})
public class registered extends HttpServlet {

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
         String line=null;
         String fileName="C:\\S3 Buckets\\kerala.txt";
         File fileName1= new File("C:\\S3 Buckets\\kerala.txt");
         fileName1.delete();
         
         creds = new BasicAWSCredentials("AKIAIOIPXD2HOSYLPLJA","1qXauI1NPNn2IMPOkxgHDMjhA0oNzuNmBKQj9zaq");
      String foldername="Kerala.txt";
      AmazonS3 s3 = AmazonS3Client.builder().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();
      S3Object s3object = s3.getObject(bucketName, foldername);
        try (InputStream inputStream = s3object.getObjectContent()) {
            Files.copy(inputStream, Paths.get("C:\\S3 Buckets\\kerala.txt"));
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

          /*  while((line = bufferedReader.readLine()) != null) {
                
                System.out.println(line);
                out.println("<h2>"+line + "</h2>");
            }   */
        
            

            // Always close files.
         
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registered</title>");            
            out.println("<link rel='stylesheet' type=text/css href='style.css' />");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet registered at " + request.getContextPath() + "</h1>");
            try {
            System.out.print("hrello");
           // out.println("<h1>Servlet NewServlet 456 at " + "</h1>");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>District</th>");
            out.println("<th>Location</th>");
            out.println("<th>Name</th>");
            out.println("<th>Phone</th>");
            out.println("<th>Date</th>");
            out.println("<th>Items</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
                int i;
            while((line = bufferedReader.readLine()) != null) {
                String[] output = line.split("\\;");
                out.println("<tr>");
                for(i=0;i<output.length;i++)
                {
                out.println("<td>"+output[i]+"</td>");
                }
                out.println("</tr>");
                 
        }
            out.println("</tbody>");
          out.println("</table>");
          
             bufferedReader.close();  
            }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
            
            out.println("<p><a href=\"home.jsp\"> View Registrations or Request Help </p>");
            out.println("</body>");
            out.println("</html>");
        }
         
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
