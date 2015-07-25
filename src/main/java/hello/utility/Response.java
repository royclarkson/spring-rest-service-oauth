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
package hello.utility;

public class Response {
    private int statusCode;
    private String message;

    private Object data;

    public Response() {
    }

    public Response(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
    public Response(int statusCode, String message, Object object) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = object;
    }

    public void setSuccessWithData(Object object){
        success();
        this.message = "Successfully created.";
        this.data = object;
    }

    public void setSuccess(){
        success();
        this.message = "Success";
    }

    public void setServerError(String message){
        this.statusCode = 400;
        this.message = message;
    }

    public void setSuccessDelete(){
        success();
        this.message = "Successfully deleted";
    }

    public void success(){
        this.statusCode = 200;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[{" +
                "'statusCode'='" + statusCode + '\'' +
                ", 'message'='" + message + '\'' +
                '}' + "]";
    }
}
