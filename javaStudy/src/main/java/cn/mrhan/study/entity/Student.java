package cn.mrhan.study.entity;

public class Student {

    private String idType;

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idType='" + idType + '\'' +
                '}';
    }

    public void sleep(){
        System.out.println("sleep....");
    }
}
