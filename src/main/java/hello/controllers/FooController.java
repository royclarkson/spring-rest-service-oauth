package hello.controllers;

import hello.service.FooService.FooServiceImpl;
import hello.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by asabanovic on 7/25/15.
 */
@RestController
public class FooController {

    private FooServiceImpl fooService;

    @Autowired
    public FooController(FooServiceImpl fooService){
        this.fooService = fooService;
        this.fooService.setRepository();
    }

    @RequestMapping("/foo")
    public Response home() {
        Response response = new Response();
        try {
            response.setSuccessWithData(fooService.getAll());
        }catch (Exception e){
            response.setServerError(e.getMessage());
        }
        return response;
    }
}
