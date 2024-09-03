package com.example.repositories.impl;

import com.example.entities.Contract;
import com.example.repositories.ContractRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ContractRepositoryImpl implements ContractRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Contract save(Contract contract) {
        entityManager.persist(contract);
        return contract;
    }
}
