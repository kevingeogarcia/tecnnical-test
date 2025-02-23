package com.kevingeo.api.fakestoreapi.conector.ServiceImpl;

import com.kevingeo.api.fakestoreapi.conector.dto.Products;
import com.kevingeo.api.fakestoreapi.conector.feign.client.FakStoreApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl {

    @Autowired
    private FakStoreApiClient fakStoreApiClient;


    public List<Products> getAllProducts(Integer limit) {
        List<Products> ls  =  new ArrayList<>();
        ls = fakStoreApiClient.getAllProduct(limit);
        return ls;
    }


}
