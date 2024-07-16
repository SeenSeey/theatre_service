package com.example.repositories;

import com.example.entities.Contract;
import java.util.Optional;

public interface ContractRepository {
    Contract save(Contract contract);
}
