package vladasustum.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vladasustum.api.model.Account;
import vladasustum.api.model.Role;
import vladasustum.api.repository.AccountRepository;
import vladasustum.api.repository.RoleRepository;
import vladasustum.api.service.AccountService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    @Override
    public Account createAccount(Account account) {
        account.setPassword(encoder.encode(account.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        account.setRoles(roles);
        return accountRepository.save(account);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
}
