package com.kt.asset.controller;

import com.kt.asset.model.AssetType;
import com.kt.asset.services.AssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/asset/type")
public class AssetTypeController {
    @Autowired
    private AssetTypeService assetTypeService;

    @PostMapping("")
    public ResponseEntity<?> saveAssetType(@Valid @RequestBody AssetType type, BindingResult result){
        try {
            AssetType assetType = assetTypeService.save(type);
            return new ResponseEntity<>(assetType, HttpStatus.CREATED);
        }
        catch (Exception e){
            throw e;
        }
    }
    @GetMapping("/all")
    public Iterable<AssetType> all(){
        return assetTypeService.all();
    }
}
