package com.retexspa.xr.ms.iam.main.core.dto.configUser;

public class MenuDTO {

    private String strjson;
    private boolean isLeaf;
    private String radice;
    private Integer idRadice;
    private Integer idMenu;
    private Integer pidMenu;
    private Integer rootSort;
    private Integer ordinamento;
    private String titolo;
    private String menuCharId;
    private String urlLink;
    private String icone;
    private String queryParams;
    private String homePagina;  
   
    
    public MenuDTO(String strjson, boolean isLeaf, String radice, Integer idRadice, Integer idMenu,
            Integer pidMenu, Integer rootSort, Integer ordinamento, String titolo, String menuCharId, String urlLink,
            String icone, String queryParams, String homePagina) {
        this.strjson = strjson;
        this.isLeaf = isLeaf;
        this.radice = radice;
        this.idRadice = idRadice;
        this.idMenu = idMenu;
        this.pidMenu = pidMenu;
        this.rootSort = rootSort;
        this.ordinamento = ordinamento;
        this.titolo = titolo;
        this.menuCharId = menuCharId;
        this.urlLink = urlLink;
        this.icone = icone;
        this.queryParams = queryParams;
        this.homePagina = homePagina;
    }
    public String getStrjson() {
        return strjson;
    }
    public void setStrjson(String strjson) {
        this.strjson = strjson;
    }
    public boolean isLeaf() {
        return isLeaf;
    }
    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
    public String getMenuCharId() {
        return menuCharId;
    }
    public void setMenuCharId(String menuCharId) {
        this.menuCharId = menuCharId;
    }
    public Integer getIdRadice() {
        return idRadice;
    }
    public void setIdRadice(Integer idRadice) {
        this.idRadice = idRadice;
    }
    public int getOrdinamento() {
        return ordinamento;
    }
    public void setOrdinamento(int ordinamento) {
        this.ordinamento = ordinamento;
    }
    public String getRadice() {
        return radice;
    }
    public void setRadice(String radice) {
        this.radice = radice;
    }
    public Integer getIdMenu() {
        return idMenu;
    }
    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }
    public Integer getPidMenu() {
        return pidMenu;
    }
    public void setPidMenu(Integer pidMenu) {
        this.pidMenu = pidMenu;
    }
    public int getRootSort() {
        return rootSort;
    }
    public void setRootSort(int rootSort) {
        this.rootSort = rootSort;
    }
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
    public String getIcone() {
        return icone;
    }
    public void setIcone(String icone) {
        this.icone = icone;
    }
    public String getQueryParams() {
        return queryParams;
    }
    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }
    public String getHomePagina() {
        return homePagina;
    }
    public void setHomePagina(String homePagina) {
        this.homePagina = homePagina;
    }
    @Override
    public String toString() {
        return "ConfigUserDTO [strjson=" + strjson + ", isLeaf=" + isLeaf + ", menuCharId=" + menuCharId + ", idRadice="
                + idRadice + ", ordinamento=" + ordinamento + ", radice=" + radice + ", idMenu=" + idMenu + ", pidMenu="
                + pidMenu + ", rootSort=" + rootSort + ", titolo=" + titolo + ", urlLink=" + urlLink + ", icone="
                + icone + ", queryParams=" + queryParams + ", homePagina=" + homePagina + "]";
    }

    
    
}
