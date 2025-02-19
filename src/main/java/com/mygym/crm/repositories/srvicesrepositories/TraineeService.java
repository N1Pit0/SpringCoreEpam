package com.mygym.crm.repositories.srvicesrepositories;

import com.mygym.crm.models.Trainee;

import java.util.Optional;

public interface TraineeService extends BaseService<Trainee, Integer>{
    Optional<Trainee> update(Trainee trainee);

    Optional<Trainee> delete(Integer id);
}
