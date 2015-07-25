package hello.utility;

import hello.data.Users;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by asabanovic on 7/14/15.
 */
@Embeddable
public class WhoWhen {
    public WhoWhen(){

    }

    public WhoWhen(Users user){
        this.created_at = Date.now();
        this.updated_at = Date.now();
        this.author = user;
    }

    public WhoWhen(Users user, boolean update){
        this.author = user;
        this.updated_at = Date.now();
    }

    @Column
    private Timestamp created_at;

    @Column
    private Timestamp updated_at;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "users")
    private Users author;

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Users getAuthor() {
        author.setPassword("");
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }
}
