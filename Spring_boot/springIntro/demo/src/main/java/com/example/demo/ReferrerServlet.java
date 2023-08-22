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

@WebServlet("/reference")
public class ReferrerServlet extends HttpServlet {

    Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{

        response.setHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_HTML_VALUE);

        log.info("informacino de referencia");
        String referrer = request.getHeader(HttpHeaders.REFERER);
        log.info("Referrer {}", referrer);
        
        ServletOutputStream out = response.getOutputStream();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hola Mundo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Referrer</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
