package com.dlithe.bankingapp.service;


import org.springframework.stereotype.Component;

@Component
public interface TestService {
    String fetchProductDetails(String productName);
}
