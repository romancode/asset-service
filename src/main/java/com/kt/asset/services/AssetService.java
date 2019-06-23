package com.kt.asset.services;

import com.kt.asset.Exceptions.AssetCodeException;
import com.kt.asset.model.Asset;
import com.kt.asset.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public Asset saveOrUpdate(Asset asset) {
        try {
            asset.setAssetCode(asset.getAssetCode().toUpperCase());
            return assetRepository.save(asset);
        } catch (Exception e) {
            throw new AssetCodeException("Asset Code '" + asset.getAssetCode().toUpperCase() + "' already exist!");

        }
    }
    public Iterable<Asset> findAllAssets(){
        return  assetRepository.findAll();
    }
    public Asset findAssetByCode(String code){
        return assetRepository.findAssetByAssetCode(code.toUpperCase());
    }
}
