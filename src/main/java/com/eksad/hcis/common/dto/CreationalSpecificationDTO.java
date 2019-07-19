package com.eksad.hcis.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


import java.io.Serializable;
import java.util.Date;

@Data
public class CreationalSpecificationDTO implements Serializable {

    private String createdBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    private Date createdDate;
    private String modifiedBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    private Date modifiedDate;

    @JsonIgnore
    public CreationalSpecificationDTO getInstance() {
        CreationalSpecificationDTO creationalSpecificationDTO = new CreationalSpecificationDTO();
        creationalSpecificationDTO.setCreatedDate(new Date());
        creationalSpecificationDTO.setCreatedBy("SYSTEM");
        return creationalSpecificationDTO;
    }
}
