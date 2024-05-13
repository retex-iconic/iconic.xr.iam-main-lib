package com.retexspa.xr.ms.iam.main.core.responses;

import java.util.List;

import com.retexspa.xr.ms.iam.main.core.dto.configUser.ConfigUserDTO;

public class ConfigUserResponse {

    List<ConfigUserDTO> records;    

    public ConfigUserResponse() {
    }

    public ConfigUserResponse(List<ConfigUserDTO> records) {
        this.records = records;
    }

    public List<ConfigUserDTO> getRecords() {
        return records;
    }

    public void setRecords(List<ConfigUserDTO> records) {
        this.records = records;
    }

    
    
}
