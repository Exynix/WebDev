package com.example.demo;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MimeTypeUtils;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{

        response.setHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_HTML_VALUE);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment");

        response.setStatus(300);
        response.setHeader(HttpHeaders.LOCATION, "/hola");
        
        ServletOutputStream out = response.getOutputStream();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Download page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Download page</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
