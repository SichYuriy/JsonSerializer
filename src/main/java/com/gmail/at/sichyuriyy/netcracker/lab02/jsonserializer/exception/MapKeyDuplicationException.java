package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.exception;

public class MapKeyDuplicationException extends RuntimeException {
    
    /**
     * 
     */
    private static final long serialVersionUID = -1715192992871795478L;

    public MapKeyDuplicationException() {

    }

    public MapKeyDuplicationException(String str) {
        super(str);
    }

    public MapKeyDuplicationException(Exception e) {
        super(e);
    }

}
