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
package hello.dao.model;

import hello.utility.Date;
import hello.utility.WhoWhen;
import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractModel<T extends AbstractModel<T>> {
    /**
     * CONSTRUCTORS
     */

    public AbstractModel(){

    }

    public AbstractModel(WhoWhen whoWhen, String name){
        this.whoWhen = whoWhen;
        this.name = name;

    }

    public AbstractModel(Integer id, WhoWhen whoWhen){
        this.id = id;
        this.whoWhen = whoWhen;
    }

    public void update(T t){
        this.name = t.getName();
        this.whoWhen.setUpdated_at(Date.now());
    }

    /**
     * PROPERTIES
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Embedded
    private WhoWhen whoWhen;

    /**
     * GETTERS
     * SETTERS
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WhoWhen getWhoWhen() {
        return whoWhen;
    }

    public void setWhoWhen(WhoWhen whoWhen) {
        this.whoWhen = whoWhen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
