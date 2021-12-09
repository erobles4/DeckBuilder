package edu.neiu.magecraft.security;

import edu.neiu.magecraft.data.UserRepository;
import edu.neiu.magecraft.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserDataLoader implements CommandLineRunner {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserDataLoader(UserRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        //User user = new User("admin@admin.com", "admin", "foo1", passwordEncoder.encode("password"), "Admin", "Admin");
        //user.setRoles(Set.of(User.Role.ROLE_ADMIN));
        //user.setEnabled(true);
        //userRepo.save(user);
        //
        //User user1 = new User("user@user.com", "user", "foo2",passwordEncoder.encode("password"),
        //        "Luis", "Rob");
        //user1.setRoles(Set.of(User.Role.ROLE_USER));
        //user1.setEnabled(true);
        //userRepo.save(user1);
    }
}
