package hello.service.FooService;

import hello.dao.service.SharedService;
import hello.data.Foo.Foo;
import hello.data.Foo.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by asabanovic on 7/25/15.
 */
@Service
public class FooServiceImpl extends SharedService<Foo, FooRepository> implements FooService {
    @Autowired
    FooRepository fooRepository;

    public void setRepository(){
        super.setRepository(fooRepository);
    }
}
