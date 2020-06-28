package cn.mrhan.study.demo.demos;

import cn.mrhan.study.entity.Action;
import cn.mrhan.study.entity.Person;

public class Demo10 {
    public static void main(String[] args) {
        Person person = new Person();

        Action action = person.getAction();

        if(action.getLengends()!=null){
            System.out.println("helloWorld");
        }
    }
}
