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

import hello.service.FooService.FooServiceImpl;
import hello.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
