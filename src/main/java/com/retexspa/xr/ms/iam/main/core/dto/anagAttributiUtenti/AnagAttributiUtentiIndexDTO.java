package com.retexspa.xr.ms.iam.main.core.dto.anagAttributiUtenti;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnagAttributiUtentiIndexDTO {

    private String anagAttributiUtentiId;

    public AnagAttributiUtentiIndexDTO() {
    }

    public AnagAttributiUtentiIndexDTO(String anagAttributiUtentiId) {
        this.anagAttributiUtentiId = anagAttributiUtentiId;
    }

    public static String getIdFromAnagAttributiUtenti(String anagAttributiUtentiId) {
        return UUID.nameUUIDFromBytes(("/AnagAttributiUtentiIndex/" + anagAttributiUtentiId).getBytes()).toString();
    }

    public String getAnagAttributiUtentiId() {
        return anagAttributiUtentiId;
    }

    public void setAnagAttributiUtentiId(String anagAttributiUtentiId) {
        this.anagAttributiUtentiId = anagAttributiUtentiId;
    }

}
