package com.example.demo.common;

public class Result<T> {
    private String code;
    private String msg;
    private T data;
    public T getData(){
        return data;
    }
    public void SetData(T data){
        this.data = data;
    }
    public Result(){
    }
    public Result(T data){
        this.data = data;
    }
    public static  Result success(){
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }
    public static<T>  Result<T> success(T data){
        Result<T> result = new Result<T>(data);
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }
    public static  Result error(String code,String msg){
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode(){
        return code;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg(){
        return msg;
    }
}
