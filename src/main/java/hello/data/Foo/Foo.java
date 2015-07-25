package hello.data.Foo;

import hello.dao.model.AbstractModel;
import hello.dao.model.SharedModel;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by asabanovic on 7/25/15.
 */
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
