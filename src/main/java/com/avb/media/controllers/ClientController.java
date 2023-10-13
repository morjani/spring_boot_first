package com.avb.media.controllers;


import com.avb.media.dto.ClientRequestDto;
import com.avb.media.dto.ClientResponseDto;
import com.avb.media.models.ClientEntity;
import com.avb.media.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

//    @GetMapping("")
//    public List<ClientResponseDto> getClient(){
//        return clientService.findAll();
//    }

    @PostMapping("")
    public ClientResponseDto save(ClientRequestDto clientRequestDto){
        return clientService.save(clientRequestDto);
    }

    @GetMapping("/")
    public String index(){

        return "login";

    }
}
