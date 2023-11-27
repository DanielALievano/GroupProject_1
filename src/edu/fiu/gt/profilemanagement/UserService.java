package edu.fiu.gt.profilemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    public User createUser(User newUser) {
        return repository.save(newUser);
    }

    public User updateUser(String username, User newUser) {
        String newUsername = newUser.getUsername();
        String newPassword = newUser.getPassword();
        String newfName = newUser.getfName();
        String newlName = newUser.getlName();
        String newAddress = newUser.getAddress();

        User oldUser = repository.findByUsername(username);
        if(oldUser == null)
            return null;
        if(newUsername != null)
            oldUser.setUsername(newUsername);
        if(newPassword != null)
            oldUser.setPassword(newPassword);
        if(newfName != null)
            oldUser.setfName(newfName);
        if(newlName != null)
            oldUser.setlName(newlName);
        if(newAddress != null)
            oldUser.setAddress(newAddress);

        return repository.save(oldUser);
    }
}
