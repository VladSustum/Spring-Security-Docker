package vladasustum.api.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vladasustum.api.model.Account;
import vladasustum.api.service.AccountService;

import java.util.List;

import static vladasustum.api.resource.EmployeeResource.getLocation;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/accounts")
public class AccountResource {

    private final AccountService accountService;


    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.created(getLocation(newAccount.getId().intValue())).body(newAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccount(){
        return ResponseEntity.ok(accountService.getAccounts());
    }
}
