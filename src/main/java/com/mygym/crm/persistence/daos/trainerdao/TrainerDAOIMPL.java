package com.mygym.crm.persistence.daos.trainerdao;

import com.mygym.crm.domain.models.Trainer;
import com.mygym.crm.repositories.daorepositories.TrainerDAO;
import com.mygym.crm.persistence.storages.TrainerStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class TrainerDAOIMPL implements TrainerDAO {

    private TrainerStorage trainerStorage;

    @Autowired
    public void setTrainerStorage(TrainerStorage trainerStorage) {
        this.trainerStorage = trainerStorage;
    }

    @Override
    public Optional<Trainer> create(Trainer trainer) {
        Trainer previous = trainerStorage.getStorage()
                .putIfAbsent(trainer.getUserId(), trainer);

        return (previous == null) ? Optional.of(trainer) //Successfully added
                : Optional.empty();// Trainee already exists.
    }

    @Override
    public Optional<Trainer> update(Trainer trainer) {
        Trainer previous = trainerStorage.getStorage().replace(trainer.getUserId(), trainer);

        return (previous != null) ? Optional.of(trainer) //Successfully added
                : Optional.empty();// Trainee already exists.
    }

    @Override
    public Optional<Trainer> delete(Integer trainerId) {
        Trainer removedTrainer = trainerStorage.getStorage().remove(trainerId);

        return Optional.ofNullable(removedTrainer); // Returns Optional.empty() if not present.
    }

    @Override
    public Optional<Trainer> select(Integer trainerId) {
        Trainer trainer = trainerStorage.getStorage().get(trainerId);

        return Optional.ofNullable(trainer); // Returns Optional.empty() if not present.
    }
}
