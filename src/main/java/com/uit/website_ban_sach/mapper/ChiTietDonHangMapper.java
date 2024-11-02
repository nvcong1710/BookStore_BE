package com.uit.website_ban_sach.mapper;

import com.uit.website_ban_sach.dto.dto_entity.ChiTietDonHangDTO;
import com.uit.website_ban_sach.entity.ChiTietDonHang;

public class ChiTietDonHangMapper {

    public static ChiTietDonHangDTO mapToChiTietDonHangDTO(ChiTietDonHang dh) {
        return new ChiTietDonHangDTO(
                dh.getId(),
                dh.getDonHang().getId(),
                SachMapper.mapToSachDTO(dh.getSach()),
                dh.getSoLuong(),
                dh.getGia()
        );
    }
}
