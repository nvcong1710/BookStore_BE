package com.nhom13.website_ban_sach.repository;

import com.nhom13.website_ban_sach.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DonHangRepository extends JpaRepository<DonHang, Long> {
    @Query("SELECT SUM(dh.tongTien) FROM DonHang dh")
    Long sumTongTien();
}
