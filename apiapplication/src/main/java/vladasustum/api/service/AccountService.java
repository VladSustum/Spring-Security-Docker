package vladasustum.api.service;

import org.springframework.stereotype.Service;
import vladasustum.api.model.Account;

import java.util.List;
@Service
public interface AccountService {

    Account createAccount(Account account);
    Account findByUsername(String username);
    List<Account> getAccounts();
}
