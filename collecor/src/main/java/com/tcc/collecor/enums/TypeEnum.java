package com.tcc.collecor.enums;

public enum TypeEnum {
    TEXTOS(1),
    VIDEO(2),
    IMAGEM(3);

    private int code;
    
    private TypeEnum(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TypeEnum valueOf(int code){
        for( TypeEnum value : TypeEnum.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("codigo invalido");
    }
}
