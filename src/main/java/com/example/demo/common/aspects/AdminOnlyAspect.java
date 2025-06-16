package com.example.demo.common.aspects;

//import com.example.demo.common.annotations.AdminOnly;
//import com.example.demo.common.exceptions.AccessDeniedException;
//import com.example.demo.common.security.AuthService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdminOnlyAspect {

//    private final AuthService authService;
//
//    @Autowired
//    public AdminOnlyAspect(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @Before("@annotation(adminOnly)")
//    public void validateAdminAccess(JoinPoint joinPoint, AdminOnly adminOnly) {
//        String roleRequired = adminOnly.role();
//        if (!authService.hasRole(roleRequired)) {
//            throw new AccessDeniedException("Access denied. Role required: " + roleRequired);
//        }
//    }
}
