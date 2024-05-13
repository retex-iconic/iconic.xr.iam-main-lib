package com.retexspa.xr.ms.iam.main.core.dto.menu;

import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

import java.util.List;


public class MenuIndexUkDTO extends AggregateIndexUkBaseDTO {

    List<String> idMenuUkList;

    public MenuIndexUkDTO() {
    }
    

    public static String getUk(String menuCharId, String applicazioneId) {
        String uk =  menuCharId + MenuIndexUkDTO.getUkSeparator() + applicazioneId;
        return uk;
    }

    public static String getIdMenuUk(Integer idMenu, String applicazioneId) {
        String uk =  idMenu + MenuIndexUkDTO.getUkSeparator() + applicazioneId;
        return uk;
    }


    public List<String> getIdMenuUkList() {
        return idMenuUkList;
    }


    public void setIdMenuUkList(List<String> idMenuUkList) {
        this.idMenuUkList = idMenuUkList;
    }


    public static String getIndexName(){
        return "MenuIndexUk";
      }
  
      public static String getIndexAggregateName(){
        return "MenuIndexUkAggregate";
      }
}
