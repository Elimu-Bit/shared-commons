package com.skillforge.Shared_Commons.dtos.user;

import com.skillforge.Shared_Commons.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileDTO {

    private long userId;
    private String bio;
    private Gender gender;
    private String profileImageUrl;
    private LocalDate dateOfBirth;
    private String idNumber;
    private String country;


}
