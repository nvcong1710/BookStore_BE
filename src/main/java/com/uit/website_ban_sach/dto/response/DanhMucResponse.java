package com.uit.website_ban_sach.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DanhMucResponse {
    private Long id;
    private String tenDanhMuc;
    private Long soLuongSach;
}
