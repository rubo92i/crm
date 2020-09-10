package am.basic.notificator.crm.service.impl;

import am.basic.notificator.model.Authority;
import am.basic.notificator.model.User;
import am.basic.notificator.crm.repository.UserRepository;
import am.basic.notificator.crm.service.CrmService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Log4j2
@Service
public class CrmServiceImpl implements CrmService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public User getByUsername(String username) {
        log.info("received request for user with username : {}", username);
        User user = userRepository.getByUsername(username);
        List<Authority> list = new ArrayList<>(user.getAuthorities());
        user.setAuthorities(list);
        return user;
    }
}
