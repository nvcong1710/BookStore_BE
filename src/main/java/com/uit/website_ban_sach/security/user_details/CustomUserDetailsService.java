package com.uit.website_ban_sach.security.user_details;

import com.uit.website_ban_sach.entity.TaiKhoan;
import com.uit.website_ban_sach.repository.TaiKhoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final TaiKhoanRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        TaiKhoan user = userRepository.findByEmail(email);
        return CustomUserDetails.buildUserDetails(user);
    }
}