package com.kt.asset.controller;

import com.kt.asset.model.Asset;
import com.kt.asset.services.AssetService;
import com.kt.asset.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/asset")
public class AssetController {

    @Autowired
    private AssetService assetService;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewAsset(@Valid @RequestBody Asset asset, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.ValidationErrorService(result);
        if(errorMap!=null) return  errorMap;

        Asset asset1 = assetService.saveOrUpdate(asset);
        return new ResponseEntity<>(asset, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public Iterable<Asset> findAllAssets(){
        return assetService.findAllAssets();
    }
    @GetMapping("/{assetCode}")
    public ResponseEntity<?> findAssetByCode(@PathVariable String code){
        Asset asset = assetService.findAssetByCode(code);
        return new ResponseEntity<>(asset, HttpStatus.OK);
    }
    @GetMapping("/test")
    public ResponseEntity<?> getString(){
        return  new ResponseEntity<>("Hello This is test message!",HttpStatus.OK);
    }
}
