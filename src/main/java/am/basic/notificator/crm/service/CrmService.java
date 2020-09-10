package am.basic.notificator.crm.service;


import am.basic.notificator.model.User;

public interface CrmService {

    User getByUsername(String username);

}
