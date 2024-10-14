package com.nhom13.website_ban_sach.service;

import com.nhom13.website_ban_sach.dto.dto_entity.TaiKhoanDTO;
import com.nhom13.website_ban_sach.dto.request.LoginRequest;
import com.nhom13.website_ban_sach.entity.TaiKhoan;
import com.nhom13.website_ban_sach.mapper.TaiKhoanMapper;
import com.nhom13.website_ban_sach.repository.TaiKhoanRepository;
import com.nhom13.website_ban_sach.service.service_interface.ITaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaiKhoanService implements ITaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    public TaiKhoan register(TaiKhoan taiKhoan) {
        TaiKhoan tk = taiKhoanRepository.findByUsername(taiKhoan.getUsername());
        if (tk == null) return taiKhoanRepository.save(taiKhoan);
        else return null;
    }

    public TaiKhoanDTO login(LoginRequest loginRequest){
        TaiKhoan taiKhoan = taiKhoanRepository.findByUsername(loginRequest.getUsername());
        if(taiKhoan != null && taiKhoan.getPassword().equals(loginRequest.getPassword())){
            return TaiKhoanMapper.mapToTaiKhoanDTO(taiKhoan);
        }
        else return null;
    }

    @Override
    public List<TaiKhoanDTO> getAllTaiKhoan() {
        List<TaiKhoanDTO> res = new ArrayList<>();
        List<TaiKhoan> dstk = taiKhoanRepository.findAll();
        for(TaiKhoan tk: dstk){
            res.add(TaiKhoanMapper.mapToTaiKhoanDTO(tk));
        }
        return res;
    }

    public long getTotalTaiKhoan() {
        return taiKhoanRepository.count();
    }
}
