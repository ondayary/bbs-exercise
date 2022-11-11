package com.mustache.bbs3.controller;

import com.mustache.bbs3.domain.entity.Hospital;
import com.mustache.bbs3.domain.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hospitals")
@Slf4j
public class HospitalController {

    // repository
    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    // /hospitals 만 입력했을 때 리스트 페이지로 이동
    @GetMapping("")
    public String index() {
        return "redirect:/hospitals/list";
    }

    // 병원 전체 리스트 조회 페이지
    @GetMapping("/list")
    public String hospitalList(Model model) {
        log.info("hospitalList 호출");
        List<Hospital> hospitalList = hospitalRepository.findAll();
        model.addAttribute("hospitals", hospitalList);
        return "hospitals/list";
    }
}
