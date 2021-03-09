package com.github.fabriciolfj.springredissqs.core.service.cruduser;

import com.github.fabriciolfj.springredissqs.core.model.User;
import com.github.fabriciolfj.springredissqs.core.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    
    public User getById(final Integer id) {
        return userRepository.findById(id);
    }
    
    public Map<Integer, User> findAll() {
        return userRepository.findAll();
    }
    
    public void save(final User user) {
        userRepository.save(user);
    }
}
