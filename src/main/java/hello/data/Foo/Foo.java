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
package hello.data.Foo;

import hello.dao.model.AbstractModel;
import hello.dao.model.SharedModel;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Foo extends AbstractModel<Foo> implements SharedModel<Foo> {
    public Foo(){}

    @Override
    public void update(Foo foo) {
        super.update(foo);
        this.bar = foo.getBar();
    }

    @Column
    private String bar;

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}
