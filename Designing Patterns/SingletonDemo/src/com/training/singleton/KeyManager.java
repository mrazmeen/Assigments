package com.training.singleton;

public class KeyManager {
    private static volatile CreateKey createKey;

    public static CreateKey getCreateKey(){
        if(createKey==null){
                synchronized (KeyManager.class){
                    if (createKey==null){
                        CreateKey ck= new CreateKey();
                        ck.setKey("dasdasdsadsadsadsada");
                        createKey=ck;
                    }
                }
        }
        return createKey;
    }
}
