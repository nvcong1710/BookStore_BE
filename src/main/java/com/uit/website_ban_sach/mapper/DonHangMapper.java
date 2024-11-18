package com.uit.website_ban_sach.mapper;

import com.uit.website_ban_sach.dto.dto_entity.DonHangDTO;
import com.uit.website_ban_sach.entity.DonHang;

public class DonHangMapper {
    public static DonHang mapToDonHang(DonHangDTO donHangDTO){
        return new DonHang(donHangDTO.getId(),
                donHangDTO.getNgayDat(),
                null,
                donHangDTO.getDiaChi(),
                donHangDTO.getTongTien(),
                donHangDTO.getDaThanhToan(),
                donHangDTO.getTenNguoiNhan(),
                donHangDTO.getSoDienThoai());
    }
    public static DonHangDTO mapToDonHangDTO(DonHang dh){
        return new DonHangDTO(dh.getId(),
                dh.getNgayDatHang(),
                dh.getTaiKhoan().getId(),
                dh.getDiaChi(),
                dh.getTongTien(),
                dh.getDaThanhToan(),
                dh.getTenNguoiNhan(),
                dh.getSoDienThoai());
    }
}
