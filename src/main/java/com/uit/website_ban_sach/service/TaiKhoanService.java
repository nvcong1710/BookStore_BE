package com.uit.website_ban_sach.service;

import com.uit.website_ban_sach.dto.dto_entity.TaiKhoanDTO;
import com.uit.website_ban_sach.entity.Role;
import com.uit.website_ban_sach.entity.TaiKhoan;
import com.uit.website_ban_sach.mapper.TaiKhoanMapper;
import com.uit.website_ban_sach.repository.RoleRepository;
import com.uit.website_ban_sach.repository.TaiKhoanRepository;
import com.uit.website_ban_sach.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    private final TaiKhoanRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    private JwtUtils jwtUtil;

    @Value("${auth.token.jwtSecret}")
    private String jwtSecret;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Value("${auth.token.expirationInMils}")
    private int jwtExpirationMs;

//    public TaiKhoan register(TaiKhoan taiKhoan) {
//        TaiKhoan tk = taiKhoanRepository.findByUsername(taiKhoan.getUsername());
//        if (tk == null) return taiKhoanRepository.save(taiKhoan);
//        else return null;
//    }

    public TaiKhoan registerUser(TaiKhoan user) throws Exception {
        if (userRepository.existsByEmail(user.getEmail())){
            throw new Exception("Email đã được sử dụng");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singletonList(userRole));
        return userRepository.save(user);
    }

//    public TaiKhoanDTO login(LoginRequest loginRequest){
//        TaiKhoan taiKhoan = taiKhoanRepository.findByUsername(loginRequest.getUsername());
//        if(taiKhoan != null && taiKhoan.getPassword().equals(loginRequest.getPassword())){
//            return TaiKhoanMapper.mapToTaiKhoanDTO(taiKhoan);
//        }
//        else return null;
//    }

    public List<TaiKhoanDTO> getAllTaiKhoan() {
        List<TaiKhoanDTO> res = new ArrayList<>();
        List<TaiKhoan> dstk = taiKhoanRepository.findAll();
        for(TaiKhoan tk: dstk){
            res.add(TaiKhoanMapper.mapToTaiKhoanDTO(tk));
        }
        return res;
    }

    public long getTotalTaiKhoan() {
        return taiKhoanRepository.count();
    }
}
