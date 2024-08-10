package com.waleedreda.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseDto {

    private Date createdDate;

    private String createdBy;

    private String lastModifiedBy;

    private Date lastModifiedDate;
}
