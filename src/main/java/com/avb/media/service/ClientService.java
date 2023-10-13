package com.avb.media.service;

import com.avb.media.dto.ClientRequestDto;
import com.avb.media.dto.ClientResponseDto;

import java.util.List;

public interface ClientService
{

    ClientResponseDto save(ClientRequestDto clientRequestDto);

    ClientResponseDto findById(Integer id);

    ClientResponseDto findByNom(String Nom);

    void delete(Integer id);

    ClientResponseDto updated(ClientRequestDto clientRequestDto,Integer id);

    List<ClientResponseDto> findAll();
}
