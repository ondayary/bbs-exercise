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

    @Test
    @DisplayName("Containing 사용")
    void containing() {
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining("송파구");
        for (Hospital hospital : hospitals) {
            System.out.printf("%s, %s\n", hospital.getHospitalName(), hospital.getBusinessTypeName());
        }
    }

    @Test
    @DisplayName("StartsWith 사용")
    void startsWith() {
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressStartsWith("경기도");
        for (Hospital hospital : hospitals) {
            System.out.println(hospital.getRoadNameAddress());
        }
    }

    @Test
    @DisplayName("EndsWith 사용")
    void endsWith() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameEndsWith("의원");
        for (Hospital hospital : hospitals) {
            System.out.println(hospital.getHospitalName());
        }
    }

    @Test
    @DisplayName("Between 사용")
    void between() {
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetween(10,20);
        for (Hospital hospital : hospitals) {
            System.out.printf("%s, %d\n",hospital.getHospitalName(), hospital.getPatientRoomCount());
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