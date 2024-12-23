package com.uit.website_ban_sach.service.service_interface;

import com.uit.website_ban_sach.dto.dto_entity.ChiTietGioHangDTO;
import com.uit.website_ban_sach.dto.request.AddToCartRequest;
import com.uit.website_ban_sach.dto.request.ChiTietGioHangRequest;

import java.util.List;

public interface IGioHangService {
    public ChiTietGioHangDTO addToCart(AddToCartRequest request);
    public ChiTietGioHangDTO updateGioHang(Long id, ChiTietGioHangRequest chiTietGioHangRequest);
    public List<ChiTietGioHangDTO> getAllGioHang(Long accountId);
    public void deleteChiTietGioHang(Long ctghId);

}
