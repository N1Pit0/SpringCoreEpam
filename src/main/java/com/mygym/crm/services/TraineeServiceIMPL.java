package com.mygym.crm.services;

import com.mygym.crm.models.Trainee;
import com.mygym.crm.repositories.srvicesrepositories.TraineeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TraineeServiceIMPL implements TraineeService {
    @Override
    public Optional<Trainee> update(Trainee trainee) {
        return Optional.empty();
    }

    @Override
    public Optional<Trainee> delete(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Trainee> create(Trainee entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Trainee> select(Integer entityId) {
        return Optional.empty();
    }
}
