package com.retexspa.xr.ms.iam.main.core.searchRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfigUserSearchRequest {
    public String roleId;

    public ConfigUserSearchRequest(@JsonProperty("roleId") String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    
}
