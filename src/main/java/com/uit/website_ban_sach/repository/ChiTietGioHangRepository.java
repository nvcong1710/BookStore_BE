package com.uit.website_ban_sach.repository;

import com.uit.website_ban_sach.entity.ChiTietGioHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChiTietGioHangRepository extends JpaRepository<ChiTietGioHang, Long> {
    List<ChiTietGioHang> findAllByTaiKhoanId(Long taiKhoanId);
}
