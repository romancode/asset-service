package com.kt.asset.repository;

import com.kt.asset.model.Asset;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AssetRepository extends CrudRepository<Asset,Long> {
    Asset findAssetByAssetCode(String assetCode);
}
