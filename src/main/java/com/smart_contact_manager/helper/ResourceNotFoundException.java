package com.smart_contact_manager.helper;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String str){
        super(str);
    }
    public ResourceNotFoundException(){
        super("Resource not found!!");
    }
}
