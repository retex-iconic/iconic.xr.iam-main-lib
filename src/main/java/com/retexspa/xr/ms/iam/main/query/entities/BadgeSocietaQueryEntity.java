package com.retexspa.xr.ms.iam.main.query.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.retexspa.xr.ms.iam.main.core.dto.Enums;
import com.retexspa.xr.ms.iam.main.core.dto.badgeSocieta.BadgeSocietaBaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

@Entity
@Table(name = "badgeSocieta", uniqueConstraints = {
        @UniqueConstraint(name = "badgeSocieta_uk", columnNames = { "societa_id", "codiceBadge" })
})
public class BadgeSocietaQueryEntity {

    @Id
    @NonNull
    private String id;

    @Column(name = "codiceBadge")
    private String codiceBadge;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "tipoBadge")
    @EnumValidator(enumClazz = Enums.TipoBadge.class)
    private String tipoBadge;

    //foriengKey
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "societa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_badgeSocieta_societa"))
    private SocietaQueryEntity societa;

    //Master Detail
     @OneToMany(fetch = FetchType.EAGER, mappedBy = "badge")
     @JsonIgnore
     private Set<UtentiSocietaQueryEntity>  utentiSocieta;

     @OneToMany(fetch = FetchType.EAGER, mappedBy = "badge")
     @JsonIgnore
     private Set<SostituzioniBadgeQueryEntity>  sostituzioniBadge;
    

    @Column(name = "version")
    private Long version;

    public BadgeSocietaQueryEntity() {
    }

    public BadgeSocietaQueryEntity(@NonNull String id, String codiceBadge, String pwd, String tipoBadge,
            SocietaQueryEntity societa, Long version) {
        this.id = id;
        this.codiceBadge = codiceBadge;
        this.pwd = pwd;
        this.tipoBadge = tipoBadge;
        this.societa = societa;
        this.version = version;
    }

    public BadgeSocietaQueryEntity(@NotNull String id, BadgeSocietaBaseDTO dto, Long version) {
        this.id = id;
        this.codiceBadge = dto.getCodiceBadge();
        this.pwd = dto.getPwd();
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
