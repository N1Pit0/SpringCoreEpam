package com.mygym.crm.persistence.daos.trainingdao;

import com.mygym.crm.domain.models.Training;
import com.mygym.crm.domain.models.TrainingKey;
import com.mygym.crm.repositories.daorepositories.TrainingDAO;
import com.mygym.crm.persistence.storages.TrainingStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TrainingDAOIMPL implements TrainingDAO {

    private TrainingStorage trainingStorage;

    @Autowired
    public void setTrainingStorage(TrainingStorage trainingStorage) {
        this.trainingStorage = trainingStorage;
    }

    @Override
    public Optional<Training> create(Training training) {
        Training previous =  trainingStorage.getStorage()
                .putIfAbsent(training.getTrainingKey(),training);
        System.out.println("inside create");
        return (previous == null)? Optional.of(training) //Successfully added
                : Optional.empty();// Trainee already exists.
    }

    @Override
    public Optional<Training> update(Training training) {
        Training previous = trainingStorage.getStorage().replace(training.getTrainingKey(), training);

        return (previous != null)? Optional.of(training) //Successfully added
                : Optional.empty();// Trainee already exists.
    }

    @Override
    public Optional<Training> delete(TrainingKey trainingKey) {
        Training removedTraining = trainingStorage.getStorage().remove(trainingKey);

        return Optional.ofNullable(removedTraining); // Returns Optional.empty() if not present.
    }

    @Override
    public Optional<Training> select(TrainingKey trainingKey) {
        Training training = trainingStorage.getStorage().get(trainingKey);

        return Optional.ofNullable(training); // Returns Optional.empty() if not present.
    }
}
