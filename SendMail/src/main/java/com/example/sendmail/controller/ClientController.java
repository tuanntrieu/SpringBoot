package com.example.sendmail.controller;

import com.example.sendmail.dto.sdi.ClientSdi;
import com.example.sendmail.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping(value = "create")
    public ResponseEntity<Boolean> create(
            @RequestBody ClientSdi sdi) {
        return ResponseEntity.ok(clientService.create(sdi));
    }


}
