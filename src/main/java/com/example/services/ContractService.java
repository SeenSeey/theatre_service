package com.example.services;

import com.example.dto.ContractDto;
import com.example.dto.api.AddContractDto;

public interface ContractService {
    ContractDto add(AddContractDto addContractDto);
}
