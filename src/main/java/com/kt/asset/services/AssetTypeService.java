package com.kt.asset.services;

import com.kt.asset.model.AssetType;
import com.kt.asset.repository.AssetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetTypeService {
    @Autowired
    private AssetTypeRepository assetTypeRepository;
    public AssetType save(AssetType type){
        return assetTypeRepository.save(type);
    }
    public Iterable<AssetType> all(){
        return assetTypeRepository.findAll();
    }
}
