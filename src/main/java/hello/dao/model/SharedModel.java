package hello.dao.model;

import hello.utility.WhoWhen;

/**
 * Created by asabanovic on 7/24/15.
 */
public interface SharedModel <T> {
    void update(T t);
    Integer getId();
    void setId(Integer id);
    WhoWhen getWhoWhen();
    void setWhoWhen(WhoWhen whoWhen);
    String getName();
    void setName(String name);
}
