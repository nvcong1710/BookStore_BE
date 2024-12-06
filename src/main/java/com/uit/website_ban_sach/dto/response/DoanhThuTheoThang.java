package com.uit.website_ban_sach.dto.response;

import com.uit.website_ban_sach.dto.dto_entity.DanhMucDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class DoanhThuTheoThang {
    DanhMucResponse danhMuc;
    public BigDecimal[] soLuongSach = new BigDecimal[12];
    public DoanhThuTheoThang(DanhMucResponse dm){
        danhMuc = dm;
        for(int i = 0; i < 12; i++){
            soLuongSach[i] = BigDecimal.valueOf(0);
        }
    }
}
