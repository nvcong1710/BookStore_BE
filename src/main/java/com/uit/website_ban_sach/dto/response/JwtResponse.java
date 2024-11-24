package com.uit.website_ban_sach.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class JwtResponse {
    private Long id;
    private String username;
    private String token;
    private String type = "Bearer";
    private List<String> roles;

    public JwtResponse(Long id, String username, String token, List<String> roles) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.roles = roles;
    }
}