package com.uit.website_ban_sach.service;

import com.uit.website_ban_sach.dto.dto_entity.ChiTietTacGiaDTO;
import com.uit.website_ban_sach.dto.dto_entity.SachDTO;
import com.uit.website_ban_sach.dto.dto_entity.TacGiaDTO;
import com.uit.website_ban_sach.dto.response.TacGiaResponse;
import com.uit.website_ban_sach.entity.Sach;
import com.uit.website_ban_sach.entity.TacGia;
import com.uit.website_ban_sach.mapper.SachMapper;
import com.uit.website_ban_sach.mapper.TacGiaMapper;
import com.uit.website_ban_sach.repository.TacGiaRepository;
import com.uit.website_ban_sach.service.service_interface.ITacGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TacGiaService implements ITacGiaService {
    @Autowired
    private TacGiaRepository tacGiaRepository;

    public List<Optional<TacGia>> getAuthorByIds(List<Long> ids){
        List<Optional<TacGia>> authors = new ArrayList<>();
        for(Long id: ids){
            authors.add(tacGiaRepository.findById(id));
        }
        return authors;
    }

    public TacGiaDTO saveTacGia(TacGiaDTO tg){
        return TacGiaMapper.mapToTacGiaDTO(tacGiaRepository.save(TacGiaMapper.mapToTacGia(tg)));
    }

    public List<TacGiaResponse> getAllTacGia() {
        List<TacGia> tacGiaList = tacGiaRepository.findAll();
        List<TacGiaResponse> tacGiaDTOList = new ArrayList<>();
        for(TacGia tg: tacGiaList){
            tacGiaDTOList.add(new TacGiaResponse(tg.getId(), tg.getTenTacGia(), tg.getImage(), tg.getSaches().stream().count()));
        }

        return tacGiaDTOList;
    }

    @Override
    public ChiTietTacGiaDTO getTacGia(Long id) {
        TacGia tg = tacGiaRepository.findById(id).get();
        List<SachDTO> dsSach = new ArrayList<>();
        for(Sach s:tg.getSaches()){
            dsSach.add(SachMapper.mapToSachDTO(s));
        }
        ChiTietTacGiaDTO chiTietTacGiaDTO = new ChiTietTacGiaDTO(
                tg.getId(),
                tg.getTenTacGia(),
                tg.getImage(),
                dsSach
        );
        return chiTietTacGiaDTO;
    }

    public List<TacGiaDTO> get10TacGia(){
        List<TacGia> tacGiaList = tacGiaRepository.findAll();
        List<TacGiaDTO> tacGiaDTOList = new ArrayList<>();
        for(TacGia tg: tacGiaList){
            tacGiaDTOList.add(TacGiaMapper.mapToTacGiaDTO(tg));
        }
        if(tacGiaDTOList.size() > 10) return tacGiaDTOList.subList(0, 10);
        else return tacGiaDTOList;
    }

    public TacGiaDTO updateTacGia(Long id, TacGiaDTO tacGiaDTO) {
        TacGia tg = tacGiaRepository.findById(id).get();
        tg.setTenTacGia(tacGiaDTO.getTenTacGia());
        tg.setImage(tacGiaDTO.getImage());
        return TacGiaMapper.mapToTacGiaDTO(tacGiaRepository.save(tg));
    }
}
