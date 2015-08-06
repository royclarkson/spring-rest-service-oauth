/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hello.dao.service;

import hello.dao.model.SharedModel;
import hello.dao.repository.SharedRepository;
import hello.data.Users;
import hello.utility.WhoWhen;

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

    public Long count(){
        return repository.count();
    }

    @Override
    public Iterable<Entity> getAll() {
        return repository.findAll();
    }

    @Override
    public Entity findById(Integer id) {
        return repository.findOne(id);
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

}
