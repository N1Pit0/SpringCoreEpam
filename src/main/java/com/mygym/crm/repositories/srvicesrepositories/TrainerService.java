package com.mygym.crm.repositories.srvicesrepositories;

import com.mygym.crm.models.Trainer;

import java.util.Optional;

public interface TrainerService extends BaseService<Trainer, Integer>{
    Optional<Trainer> update(Trainer trainer);
}
