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
