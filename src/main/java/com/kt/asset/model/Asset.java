package com.kt.asset.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Asset code is required!")
    @Size(min = 4, max = 5, message = "Please use 4 to 5 characters!")
    @Column(updatable = false, unique = true)
    private String assetCode;
    @NotBlank(message = "Asset name is required!")
    private String Name;
    private long assetType;
    private  String description;
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date createAt;
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getAssetType() {
        return assetType;
    }

    public void setAssetType(long assetType) {
        this.assetType = assetType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate(){
        this.createAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
