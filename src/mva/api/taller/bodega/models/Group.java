package mva.api.taller.bodega.models;

import java.util.ArrayList;

public class Group {

    Auditoria auditoria;
    ArrayList<Person> people;
    String groupCode;


    public Group(Auditoria auditoria, ArrayList<Person> people, String groupCode) {
        this.auditoria = auditoria;
        this.people = people;
        this.groupCode = groupCode;
    }

    public Group() {
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String code) {
        this.groupCode = code;
    }
}
