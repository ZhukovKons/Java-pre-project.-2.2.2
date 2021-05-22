package web.dao;


import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Role getRole(Long id) {
       return entityManager.find(Role.class, id);
    }
}
