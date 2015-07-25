package hello.dao.service;

import hello.dao.model.SharedModel;
import hello.dao.repository.SharedRepository;
import hello.data.Users;
import hello.utility.WhoWhen;


/**
 * Created by asabanovic on 7/24/15.
 */
public abstract class SharedService
                <
                    Entity      extends SharedModel<Entity>,
                    Repository  extends SharedRepository<Entity, Integer>
                >
        implements Service<Entity>
{
    public SharedService(){}

    private Repository repository;

    @Override
    public Entity save(Entity o, Users userB){
        o.setWhoWhen(new WhoWhen(userB));
        return repository.save(o);
    }

    @Override
    public void delete(Entity t, Users user) {
        repository.delete(t);
    }

    @Override
    public void update(Entity t, Users userB) {
        try{
            Entity te = repository.findOne(t.getId());
            te.update(t);
            repository.save(te);
        }catch (Exception e){

        }
    }

    @Override
    public Iterable<Entity> getAll() {
        return repository.findAll();
    }

    @Override
    public Entity findById(Entity t, Integer id) {
        return null;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

}
