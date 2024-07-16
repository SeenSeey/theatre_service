package com.example.services.impl;

import com.example.dto.ContractDto;
import com.example.dto.api.AddContractDto;
import com.example.entities.Contract;
import com.example.repositories.ContractRepository;
import com.example.services.ContractService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public ContractDto add(AddContractDto addContractDto) {
        Contract contract = mapper.map(addContractDto, Contract.class);
        return mapper.map(contractRepository.save(contract), ContractDto.class);
    }
}
