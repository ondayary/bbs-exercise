package com.mustache.bbs3.controller;

import com.mustache.bbs3.domain.entity.Article;
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
import java.util.Optional;

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

    @GetMapping("/{id}")
    public String findById(@PathVariable Integer id, Model model) {
        Optional<Hospital> optHospital = hospitalRepository.findById(id);
        if (!optHospital.isEmpty()) {
            model.addAttribute("hospitals",optHospital.get());
            return "hospitals/show";
        } else {
            return "hospitals/error";
        }
    }

    // 병원 전체 리스트 조회 페이지
    @GetMapping("/list")
    public String hospitalList(Pageable pageable, Model model) {
        log.info("hospitalList 호출");
//        List<Hospital> hospitalList = hospitalRepository.findAll();
        Page<Hospital> hospitalList = hospitalRepository.findAll(pageable);

        model.addAttribute("hospitals", hospitalList);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasPrevious", hospitalList.hasPrevious());
        model.addAttribute("hasNext", hospitalList.hasNext());

        return "hospitals/list";
    }
}
