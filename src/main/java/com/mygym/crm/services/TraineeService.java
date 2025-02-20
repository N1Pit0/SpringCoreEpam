package com.mygym.crm.services;

import com.mygym.crm.models.Trainee;
import com.mygym.crm.repositories.daorepositories.TraineeDAO;
import com.mygym.crm.repositories.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TraineeService implements BaseService<Trainee, Integer> {

    private final TraineeDAO traineeDAO;

    @Autowired
    public TraineeService(TraineeDAO traineeDAO) {
        this.traineeDAO = traineeDAO;
    }

    @Override
    public void create(Trainee trainee) {
        traineeDAO.create(trainee);
    }

    @Override
    public void update(Trainee trainee) {
        traineeDAO.update(trainee);
    }

    @Override
    public void delete(Integer id) {
        traineeDAO.delete(id);
    }

    @Override
    public Optional<Trainee> getById(Integer id) {
        return traineeDAO.select(id);
    }
}
