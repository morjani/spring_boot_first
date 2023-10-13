package com.avb.media.service;

import com.avb.media.dao.ClientDao;
import com.avb.media.dto.ClientRequestDto;
import com.avb.media.dto.ClientResponseDto;
import com.avb.media.models.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    private ClientDao clientDao;
    private ModelMapper modelMapper;

    public ClientServiceImpl(ClientDao clientDao,ModelMapper modelMapper) {
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {
        ClientEntity clientEntity = modelMapper.map(clientRequestDto,ClientEntity.class);
        ClientEntity saved = clientDao.save(clientEntity);
        return modelMapper.map(saved,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(Integer id) {
        ClientEntity clientEntity = clientDao.findById(id).orElseThrow(() ->  new RuntimeException("Client not found"));
        return modelMapper.map(clientEntity,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByNom(String Nom) {
        ClientEntity clientEntity = clientDao.findByNom(Nom);
        return modelMapper.map(clientEntity,ClientResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        clientDao.deleteById(id);
    }

    @Override
    public ClientResponseDto updated(ClientRequestDto clientRequestDto, Integer id) {
        Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);

        if(clientEntityOptional.isPresent()){

            ClientEntity clientEntity = modelMapper.map(clientRequestDto,ClientEntity.class);
            clientEntity.setId(id);
            ClientEntity updated = clientDao.save(clientEntity);
            return modelMapper.map(updated,ClientResponseDto.class);

        }
//        else{
//            throw new NotFoundException("Client Not found");
//        }

        return null;
    }

    @Override
    public List<ClientResponseDto> findAll() {
        return clientDao.findAll().stream().map(el->modelMapper.map(el,ClientResponseDto.class))
                .collect(Collectors.toList());
    }
}
