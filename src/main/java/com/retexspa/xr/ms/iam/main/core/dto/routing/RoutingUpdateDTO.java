package com.retexspa.xr.ms.iam.main.core.dto.routing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RoutingUpdateDTO {
    private String titolo;
    private String urlLink;
    private String subtitolo;
    private String icone;


    @EnumValidator(enumClazz = Enums.CheckSN.class , message = "FlgGdpr not valid")
    private String flgGdpr;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public String getSubtitolo() {
        return subtitolo;
    }

    public void setSubtitolo(String subtitolo) {
        this.subtitolo = subtitolo;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }


    public String getFlgGdpr() {
        return flgGdpr;
    }

    public void setFlgGdpr(String flgGdpr) {
        this.flgGdpr = flgGdpr;
    }

}
