package com.dlithe.bankingapp.serviceimpl;

import com.dlithe.bankingapp.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    public String fetchProductDetails(String productName) {

        if(productName != null) {
            switch (productName) {
                case "A":
                    return "RayBan Sunglasses Starts from 1500 Rupees";
                case "B":
                    return "Apple Iphone is about to launch iphone 14";
                default:
                    return "No product Found";
            }
        }
        else
            return "you have not specified any product";
    }
}
