package com.retexspa.xr.ms.iam.main.core.searchRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.BaseSortPagination;

import java.util.List;

public class RoutingSectionsSearchRequest extends BaseSortPagination {

    private String id;
    private String codice;
    private String description;
    private String routingId;
    private Long version;

    public RoutingSectionsSearchRequest(
            @JsonProperty("page") Integer page,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("sort") List<BaseSort> sort,
            @JsonProperty("id") String id,
            @JsonProperty("codice") String codice,
            @JsonProperty("description") String description,
            @JsonProperty("routingId") String routingId,
            @JsonProperty("version") Long version
    ) {
        super(page, limit, sort);
        this.id = id;
        this.codice = codice;
        this.description = description;
        this.routingId = routingId;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

