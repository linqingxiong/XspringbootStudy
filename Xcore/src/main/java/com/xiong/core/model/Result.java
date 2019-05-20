package com.xiong.core.model;

import lombok.Data;

/**
 * @Author Xiong
 * @Description //TODO
 * @Date 10:20 2019/3/1
 **/
@Data
public class Result {

    public static final String SUCCESS_CODE = "100";
    public static final String ERROR_CODE = "200";
    public static final String ERROR_CODE_GOON = "201";
    public static final String NOTFOUND_CODE = "300";

    public static final String SUCCESS_MESSAGE = "success";
    public static final String ERROR_MESSAGE = "error";
    public static final String ERROR_MESSAGE_GOON = "error but still go on";
    public static final String NOTFOUND_MESSAGE = "notfound";

    private final String code;
    private final String message;
    private final Object data;

    private Result(Builder builder){
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }

    public static class Builder{
        private String code = ERROR_CODE;
        private String message = ERROR_MESSAGE;
        private Object data = null;

        public Builder code(String code){
            this.code = code;
            return this;
        }
        public Builder message(String message){
            this.message = message;
            return this;
        }
        public Builder data(Object data){

            this.data = data;
            return this;
        }

        public Builder success(Object data){
            this.code = SUCCESS_CODE;
            this.message = SUCCESS_MESSAGE;
            this.data = data;
            return this;
        }

        public Builder success(){
            this.code = SUCCESS_CODE;
            this.message = SUCCESS_MESSAGE;
            return this;
        }

        public Builder error(){
            this.code = ERROR_CODE;
            this.message = ERROR_MESSAGE;
            return this;
        }

        public Builder error(String message){
            this.code = ERROR_CODE;
            this.message = message;
            return this;
        }

        public Builder error(Exception e){
            this.code = ERROR_CODE;
            this.message = e.getMessage();
            this.data = e;
            return this;
        }

        public Builder errorgoon(){
            this.code = ERROR_CODE_GOON;
            this.message = ERROR_MESSAGE_GOON;
            return this;
        }

        public Builder notfound(){
            this.code = NOTFOUND_CODE;
            this.message = NOTFOUND_MESSAGE;
            return this;
        }

        public Builder notfound(String message){
            this.code = NOTFOUND_CODE;
            this.message = message;
            return this;
        }

        public Result build(){
            return new Result(this);
        }
    }
}
