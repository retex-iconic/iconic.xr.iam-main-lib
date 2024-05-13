package com.retexspa.xr.ms.iam.main.core.dto.attributiUtenti;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttributiUtentiIndexDTO {

    private String attributiUtentiId;
    private String applicazioneId;
    private String societaId;

    public AttributiUtentiIndexDTO() {
    }
    public AttributiUtentiIndexDTO(String attributiUtentiId, String applicazioniId, String societaId) {
        this.attributiUtentiId = attributiUtentiId;
        this.applicazioneId = applicazioniId;
        this.societaId = societaId;
    }

    public AttributiUtentiIndexDTO(String attributiUtentiId) {
        this.attributiUtentiId = attributiUtentiId;
    }

    public static String getIdFromAttributiUtenti(String attributiUtentiId) {
        return UUID.nameUUIDFromBytes(("/AttributiUtentiIndex/" + attributiUtentiId).getBytes()).toString();
    }

    public String getAttributiUtentiId() {
        return attributiUtentiId;
    }

    public void setAttributiUtentiId(String attributiUtentiId) {
        this.attributiUtentiId = attributiUtentiId;
    }
}
