package mva.api.taller.bodega.models;

public class Person {
    String name;
    String an8;
    String identity;

    public Person(String name, String an8, String identity) {
        this.name = name;
        this.an8 = an8;
        this.identity = identity;
    }

    public Person() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAn8() {
        return an8;
    }

    public void setAn8(String an8) {
        this.an8 = an8;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
