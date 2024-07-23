package com.amit.springRestapi.rest;

import com.amit.springRestapi.entity.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustContriller {
    @GetMapping("/customers")
    public List<Customer> getCustomer() {
        List<Customer> theCustomers = new ArrayList<>();

        theCustomers.add(new Customer(11, "RamPraksh"));
        theCustomers.add(new Customer(22, "RamPraksh"));
        theCustomers.add(new Customer(33, "RamPraksh"));
        return theCustomers;
    }
}