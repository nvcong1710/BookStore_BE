package com.uit.website_ban_sach.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class TacGiaResponse {
    private Long id;
    private String tenTacGia;
    private String image;
    private Long soLuongSach;
}
