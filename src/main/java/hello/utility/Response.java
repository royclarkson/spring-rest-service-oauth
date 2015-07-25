package hello.utility;

/**
 * Created by asabanovic on 7/2/15.
 */
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
