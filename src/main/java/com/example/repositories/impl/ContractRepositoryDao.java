package com.example.repositories.impl;

import com.example.entities.Contract;
import com.example.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ContractRepositoryDao implements ContractRepository {
    @Autowired
    private BaseContractRepository baseContractRepository;

    @Override
    public Contract save(Contract contract) {
        return baseContractRepository.save(contract);
    }

    @Override
    public Optional<Contract> update(Contract contract) {
        return Optional.of(baseContractRepository.save(contract));
    }
}

@Repository
interface BaseContractRepository extends JpaRepository<Contract, Integer> {
}