package com.mygym.crm.repositories.srvicesrepositories;

import java.util.Optional;

public interface BaseService <T, ID>{
    Optional<T> create(T entity);

    Optional<T> select(ID entityId);
}
