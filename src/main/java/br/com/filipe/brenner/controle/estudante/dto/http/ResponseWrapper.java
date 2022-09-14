package br.com.filipe.brenner.controle.estudante.dto.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseWrapper {

    private Object data;

    private boolean success;

    private int status;

    public ResponseWrapper(){
        // Construtor padrão
    }

    public ResponseWrapper(Object data, boolean success, int status){
        this.data = (data instanceof Exception) ? new ErrorBody(((Exception) data).getMessage()) : data;
        this.success = success;
        this.status = status;
    }

    public static ResponseEntity<Object> createResponse(Object data, boolean success, HttpStatus status){
        return ResponseEntity.status(status).body(new ResponseWrapper(data, success, status.value()));
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    static class ErrorBody {

        private String message;

        public ErrorBody() {
            // Construtor padrão
        }

        public ErrorBody(String message) {
            this.message = message;
        }

        public ErrorBody(Exception e) {
            this.message = e.getMessage();
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
