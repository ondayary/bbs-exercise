package com.mustache.bbs3.domain.repository;

import com.mustache.bbs3.domain.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    @DisplayName("업태구분명으로 찾기")
    void findByBusinessTypeNameIn() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);
        for (var hospital : hospitals) {
            System.out.printf("%s, %s\n", hospital.getHospitalName(), hospital.getBusinessTypeName());
        }
    }

    // 먼저 아이디 한개를 뽑아 테스트해보자.
    @Test
    void findById() {
        Optional<Hospital> optHospital = hospitalRepository.findById(1);
        Hospital hp = optHospital.get();
        System.out.println(hp.getId());
        assertEquals(1, hp.getId());
    }
}