package com.nhom13.website_ban_sach.repository;

import com.nhom13.website_ban_sach.dto.dto_entity.ChiTietGioHangDTO;
import com.nhom13.website_ban_sach.entity.ChiTietGioHang;
import com.nhom13.website_ban_sach.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GioHangRepository extends JpaRepository<ChiTietGioHang, Long> {
    Optional<ChiTietGioHang> findByTaiKhoanIdAndSachId(Long taiKhoanId, Long sachId);
}
