package hello.dao.service;

import hello.data.Users;

/**
 * Created by asabanovic on 7/24/15.
 */
public interface Service<Entity> {
    Entity save(Entity t, Users userB);
    void delete(Entity t, Users userB);
    void update(Entity t, Users userB);
    Entity findById(Entity t, Integer id);
    Iterable<Entity> getAll();
}
