package dev.educosta.masking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerMapper mapper;

    @PostMapping(path = "/customer")
    void create(@RequestBody CustomerRequest customerRequest){

    }

}
