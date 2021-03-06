package com.example.nginxresource;

import org.springframework.http.HttpHeaders;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;

@RestController
public class Welcome {
    @GetMapping("/welcome")
    public String hello() {
        return "welcome to spring boot!";
    }

    @GetMapping("/auth")
    public String auth(HttpServletRequest request, HttpServletResponse response, @RequestHeader HttpHeaders headers) throws IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        Principal userPrincipal = request.getUserPrincipal();
        if (userPrincipal != null||user!=null) {
            session.setAttribute("user",userPrincipal);
            return "ok";
        } else {

            response.sendError(401);
            return null;
        }
    }
    @GetMapping("/resource/**")
    public void resource(HttpServletRequest request, HttpServletResponse response, @RequestHeader HttpHeaders headers) throws IOException {
        FileInputStream file = new FileInputStream(new File("G:\\apr\\nginx-resource\\src\\main\\resources\\static\\res1\\elf.jpg"));
        FileCopyUtils.copy(file,response.getOutputStream());
    }
}
