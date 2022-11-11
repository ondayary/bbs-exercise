package com.mustache.bbs3.controller;

import com.mustache.bbs3.domain.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
