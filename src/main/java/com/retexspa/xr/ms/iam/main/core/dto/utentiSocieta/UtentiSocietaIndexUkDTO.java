package com.retexspa.xr.ms.iam.main.core.dto.utentiSocieta;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

import java.util.List;

public class UtentiSocietaIndexUkDTO extends AggregateIndexUkBaseDTO {
    List<String> matricolaUkList;
    List<String> upnUkList;
    List<String> badgeUkList;

    public UtentiSocietaIndexUkDTO() {
    }

    public List<String> getMatricolaUkList() {
        return matricolaUkList;
    }

    public void setMatricolaUkList(List<String> matricolaUkList) {
        this.matricolaUkList = matricolaUkList;
    }

    public List<String> getUpnUkList() {
        return upnUkList;
    }

    public void setUpnUkList(List<String> upnUkList) {
        this.upnUkList = upnUkList;
    }

    public List<String> getBadgeUkList() {
        return badgeUkList;
    }

    public void setBadgeUkList(List<String> badgeUkList) {
        this.badgeUkList = badgeUkList;
    }

    public static String getUk(UtentiSocietaBaseDTO utentiSocieta) {
        String uk = utentiSocieta.getUtenteId() +
                UtentiSocietaIndexUkDTO.getUkSeparator() +
                utentiSocieta.getSocietaId();
        return uk;
    }

    public static String getMatricolaUk(String matricola, String societaId) {
        String uk = matricola +
                UtentiSocietaIndexUkDTO.getUkSeparator() +
                societaId;
        return uk;
    }

    public static String getUpnUk(String upn, String societaId) {
        String uk = upn +
                UtentiSocietaIndexUkDTO.getUkSeparator() +
                societaId;
        return uk;
    }

    public static String getBadgeUk(String badgeId, String societaId) {
        String uk = badgeId +
                UtentiSocietaIndexUkDTO.getUkSeparator() +
                societaId;
        return uk;
    }

    public static String getIndexName(){
        return "UtentiSocietaIndexUk";
    }

    public static String getIndexAggregateName(){
        return "UtentiSocietaIndexUkAggregate";
    }
}
