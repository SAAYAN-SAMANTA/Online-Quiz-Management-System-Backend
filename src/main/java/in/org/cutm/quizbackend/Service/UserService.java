package in.org.cutm.quizbackend.Service;
import in.org.cutm.quizbackend.Entity.Users;
import in.org.cutm.quizbackend.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users createUser(Users user) {
        // Perform any necessary validation or business logic
        // Save the user entity in the database
        return userRepository.save(user);
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }


    public Users updateUser(Long id, Users updatedUser) {
        Users user = getUserById(id);
        // Perform any necessary validation or business logic
        // Update the user entity with the new values
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setEmail(updatedUser.getEmail());
        user.setRole(updatedUser.getRole());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        Users user = getUserById(id);
        // Perform any necessary validation or business logic
        userRepository.delete(user);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Users> getAllCategory(String role){
//       return userRepository.findByRole(role);
        List<Users> users = getAllUsers()
                .stream().filter(user -> Objects.equals(user.getRole(), role)).collect(Collectors.toList());
        return users;
    }
}
