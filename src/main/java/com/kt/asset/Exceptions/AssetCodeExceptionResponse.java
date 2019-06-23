package com.kt.asset.Exceptions;

public class AssetCodeExceptionResponse {
    private String assetCode;

    public AssetCodeExceptionResponse(String assetCode){
        this.assetCode = assetCode;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }
}
