package com.github.fabriciolfj.springredissqs.core.port.out;

import com.github.fabriciolfj.springredissqs.core.model.User;

import java.util.Map;

public interface UserRepository {

    void save(final User user);
    void update(final User user);
    void delete(final Integer id);

    Map<Integer, User> findAll();
    User findById(final Integer id);
}
