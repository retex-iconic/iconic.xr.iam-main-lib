package com.retexspa.xr.ms.iam.main.core.dto.configUser;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class RoutingDTO {

    @JsonIgnore
    private String id_routing;
    private String title;
    private String subtitle;
    private String url_link;
    private String icon;
    private String flg_access_gdpr;
    private String flg_attiva;
    private String flg_delete;
    private String flg_insert;
    private String flg_read_only;
    private String flg_update;
    private List<RoutingSectionsDTO> rountingSection; 

    public RoutingDTO(String id_routing, String title, String subtitle, String url_link, String icon,
            String flg_access_gdpr, String flg_attiva, String flg_delete, String flg_insert, String flg_read_only,
            String flg_update) {
        this.id_routing = id_routing;
        this.title = title;
        this.subtitle = subtitle;
        this.url_link = url_link;
        this.icon = icon;
        this.flg_access_gdpr = flg_access_gdpr;
        this.flg_attiva = flg_attiva;
        this.flg_delete = flg_delete;
        this.flg_insert = flg_insert;
        this.flg_read_only = flg_read_only;
        this.flg_update = flg_update;
    }

    public RoutingDTO(String id_routing) {
        this.id_routing = id_routing;
    }

    public String getId_routing() {
        return id_routing;
    }

    public void setId_routing(String id_routing) {
        this.id_routing = id_routing;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getUrl_link() {
        return url_link;
    }

    public void setUrl_link(String url_link) {
        this.url_link = url_link;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getFlg_access_gdpr() {
        return flg_access_gdpr;
    }

    public void setFlg_access_gdpr(String flg_access_gdpr) {
        this.flg_access_gdpr = flg_access_gdpr;
    }

    public String getFlg_attiva() {
        return flg_attiva;
    }

    public void setFlg_attiva(String flg_attiva) {
        this.flg_attiva = flg_attiva;
    }

    public String getFlg_delete() {
        return flg_delete;
    }

    public void setFlg_delete(String flg_delete) {
        this.flg_delete = flg_delete;
    }

    public String getFlg_insert() {
        return flg_insert;
    }

    public void setFlg_insert(String flg_insert) {
        this.flg_insert = flg_insert;
    }

    public String getFlg_read_only() {
        return flg_read_only;
    }

    public void setFlg_read_only(String flg_read_only) {
        this.flg_read_only = flg_read_only;
    }

    public String getFlg_update() {
        return flg_update;
    }

    public void setFlg_update(String flg_update) {
        this.flg_update = flg_update;
    }

    public List<RoutingSectionsDTO> getRountingSection() {
        return rountingSection;
    }

    public void setRountingSection(List<RoutingSectionsDTO> rountingSection) {
        this.rountingSection = rountingSection;
    }

    
}
