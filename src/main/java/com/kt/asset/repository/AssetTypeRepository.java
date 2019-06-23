package com.kt.asset.repository;


import com.kt.asset.model.AssetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetTypeRepository extends CrudRepository<AssetType,Long> {
}
