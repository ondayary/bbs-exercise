package com.mustache.bbs3.domain.repository;

import com.mustache.bbs3.domain.entity.Hospital;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    // 먼저 아이디 한개를 뽑아 테스트해보자.
    @Test
    void findById() {
        Optional<Hospital> optHospital = hospitalRepository.findById(1);
        Hospital hp = optHospital.get();
        System.out.println(hp.getId());
        assertEquals(1, hp.getId());
    }
}