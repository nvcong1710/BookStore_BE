package com.uit.website_ban_sach.controller;

import com.uit.website_ban_sach.dto.dto_entity.TaiKhoanDTO;
import com.uit.website_ban_sach.dto.request.LoginRequest;
import com.uit.website_ban_sach.dto.response.JwtResponse;
import com.uit.website_ban_sach.entity.TaiKhoan;
import com.uit.website_ban_sach.security.jwt.JwtUtils;
import com.uit.website_ban_sach.security.user_details.CustomUserDetails;
import com.uit.website_ban_sach.service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;


//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody TaiKhoan taiKhoan) {
//        TaiKhoan tk = taiKhoanService.register(taiKhoan);
//        if (tk == null) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Tài khoản đã tồn tại");
//        } else return ResponseEntity.ok(taiKhoan);
//    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
//        TaiKhoanDTO account = taiKhoanService.login(loginRequest);
//        if (account != null) return ResponseEntity.ok(account);
//        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login fail");
//    }

    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody TaiKhoan user) {
        try {
            taiKhoanService.registerUser(user);
            return ResponseEntity.ok("Registration successful!");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest request) {
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtTokenForUser(authentication);
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority).toList();
        return ResponseEntity.ok(new JwtResponse(
                userDetails.getId(),
                userDetails.getUsername(),
                jwt,
                roles));
    }

    @GetMapping("/getalltaikhoan")
    public List<TaiKhoanDTO> getAllTaiKhoan() {
        return taiKhoanService.getAllTaiKhoan();
    }
}