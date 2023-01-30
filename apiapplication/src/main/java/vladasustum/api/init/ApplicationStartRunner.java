package vladasustum.api.init;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vladasustum.api.model.Role;
import vladasustum.api.repository.RoleRepository;

import static java.util.Arrays.asList;

@RequiredArgsConstructor
@Component
public class ApplicationStartRunner implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Role roleUser = new Role(1L, "123", "ROLE_USER");
        Role roleAdmin = new Role(2L, "456", "ROLE_ADMIN");
        roleRepository.saveAll(asList(roleUser,roleAdmin));
    }
}
