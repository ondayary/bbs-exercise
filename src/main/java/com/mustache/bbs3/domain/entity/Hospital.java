package com.mustache.bbs3.domain.entity;

import com.mustache.bbs3.domain.dto.HospitalResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "nation_wide_hospitals")
public class Hospital {

    @Id
    // GeneratedValue 안쓴다.
    private Integer id; // Long --> bigint

    @Column(name = "road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Float totalAreaSize;

    // HospitalEntity를 HospitalResponse Dto로 만들어주는 부분
    public static HospitalResponse of(Hospital hospital) {
        return new HospitalResponse(hospital.getId(),
                                    hospital.getRoadNameAddress(),
                                    hospital.getHospitalName(),
                                    hospital.getPatientRoomCount(),
                                    hospital.getTotalNumberOfBeds(),
                                    hospital.getBusinessTypeName(),
                                    hospital.getTotalAreaSize());
    }

    /*private String openServiceName;
    private int openLocalGovernmentCode;
    private String managementNumber;
    private LocalDateTime licenseDate;
    private int businessStatus;
    private int businessStatusCode;
    private String phone;
    private String fullAddress;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;
    private int healthcareProviderCount;
    private int patientRoomCount;
    private int totalNumberOfBeds;
    private float totalAreaSize;*/
}
