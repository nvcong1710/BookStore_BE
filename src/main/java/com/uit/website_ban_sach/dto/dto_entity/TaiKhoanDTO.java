package com.uit.website_ban_sach.dto.dto_entity;

import com.uit.website_ban_sach.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;

@Getter
@Setter
@AllArgsConstructor
public class TaiKhoanDTO {
    private Long id;
    private String username;
    private String password;
    //    private String roles;
    private Collection<Role> roles;
    private String email;
    private String gioiTinh;
}
