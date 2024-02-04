package main.java.dev.thallesrafael.jdbc.model;

import java.util.Objects;

public class Client {

    private int code;

    private String name;


    public Client(){};

    public Client(Integer code, String name){
        this.code = code;
        this.name = name;
    };

    public int getCode() {
        return code;
    }



    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(getCode(), client.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    @Override
    public String toString() {
        return  "Código: " + code +
                ", Name: " + name;
    }
}
