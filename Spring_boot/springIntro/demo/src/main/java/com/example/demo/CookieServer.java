package com.example.demo;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MimeTypeUtils;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookies")
public class CookieServer extends HttpServlet {

    Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{

        response.setHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_HTML_VALUE);

        Cookie cookie = new Cookie("hola", "Mundo");
        response.addCookie(cookie);
        cookie = new Cookie("nombre", "juan");
        response.addCookie(cookie);

        if(request.getCookies() != null){
            for (Cookie c: request.getCookies()){
                log.info("clave {} - valor {}", c.getName(), c.getValue());
            }
        }
        
        ServletOutputStream out = response.getOutputStream();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hola Mundo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Galletar</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
