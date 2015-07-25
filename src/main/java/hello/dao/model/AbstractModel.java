package hello.dao.model;


import hello.utility.Date;
import hello.utility.WhoWhen;
import javax.persistence.*;

/**
 * Created by asabanovic on 7/24/15.
 */
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
