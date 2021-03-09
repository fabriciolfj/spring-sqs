package com.github.fabriciolfj.springredissqs.adapters.redis;

import com.github.fabriciolfj.springredissqs.core.model.User;
import com.github.fabriciolfj.springredissqs.core.port.out.UserRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final RedisTemplate<String, User> redisTemplate;
    private final HashOperations hashOperations;

    public UserRepositoryImpl(final RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(final User user) {
        hashOperations.put("usercache", user.getId(), user);
    }

    @Override
    public void update(final User user) {
        save(user);
    }

    @Override
    public void delete(final Integer id) {
        hashOperations.delete("usercache", id);
    }

    @Override
    public Map<Integer, User> findAll() {
        return hashOperations.entries("usercache");
    }

    @Override
    public User findById(final Integer id) {
        return (User) hashOperations.get("usercache", id);
    }
}
