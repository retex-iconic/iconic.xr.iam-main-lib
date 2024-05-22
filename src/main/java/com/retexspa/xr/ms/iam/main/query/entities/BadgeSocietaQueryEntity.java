package com.retexspa.xr.ms.iam.main.query.entities;

import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.iam.main.core.dto.badgeSocieta.BadgeSocietaBaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "badgeSocieta")
public class BadgeSocietaQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name="codiceBadge")
    private String codiceBadge;

    @Column(name="pwd")
    private String pwd;

    @Column(name="tipoBadge")
    @EnumValidator(enumClazz = Enums.TipoBadge.class)
    private String tipoBadge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "societa_id", referencedColumnName = "id")
    private SocietaQueryEntity societa;

    @Column(name="version")
    private Long version;

    public BadgeSocietaQueryEntity() {
    }

    public BadgeSocietaQueryEntity(@NotNull String id, BadgeSocietaBaseDTO dto, Long version) {
        this.id = id;
        this.codiceBadge = dto.getCodiceBadge();
        this.pwd= dto.getPwd();
        this.tipoBadge = dto.getTipoBadge();
        this.version = version;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getCodiceBadge() {
        return codiceBadge;
    }

    public void setCodiceBadge(String codiceBadge) {
        this.codiceBadge = codiceBadge;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTipoBadge() {
        return tipoBadge;
    }

    public void setTipoBadge(String tipoBadge) {
        this.tipoBadge = tipoBadge;
    }

    public SocietaQueryEntity getSocieta() {
        return societa;
    }

    public void setSocieta(SocietaQueryEntity societa) {
        this.societa = societa;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
