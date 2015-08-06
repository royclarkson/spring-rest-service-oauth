package hello.controllers;

import hello.dao.model.SharedModel;
import hello.dao.service.SharedService;
import hello.data.Users;
import hello.utility.Response;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by asabanovic on 8/6/15.
 */
public abstract class CrudController<Model extends SharedModel<Model>, Service extends SharedService>{

    private Service service;

    public void setDependencies(Service service){
        this.service = service;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Response get(){
        Response response = new Response();
        try{
            response.setStatusCode(200);
            response.setMessage("Successfully retrieved " + service.count() + ".");
            response.setData(service.getAll());
        }catch(Exception e){
            response.setServerError(e.getMessage());
        }
        return response;
    }
    
    @RequestMapping(value =  "/create", method = RequestMethod.POST)
    public Response create(@ModelAttribute Model model, @AuthenticationPrincipal Users user){
        Response response = new Response();
        try{
            service.save(model, user);
            response.setSuccess();
        }catch(Exception e){
            response.setServerError(e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response delete(@ModelAttribute Model model, @AuthenticationPrincipal  Users user){
        Response response = new Response();
        try{
            service.delete(model, user);
            response.setSuccess();
        }catch(Exception e){
            response.setServerError(e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Response update(@ModelAttribute Model model, @AuthenticationPrincipal Users user){
        Response response = new Response();
        try{
            service.update(model, user);
            response.setSuccess();
        }catch(Exception e){
            response.setServerError(e.getMessage());
        }
        return response;
    }
}
