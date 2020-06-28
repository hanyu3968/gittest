package cn.mrhan.study.demo.demos;

import cn.mrhan.study.entity.Person;
import cn.mrhan.study.entity.Student;

import java.util.HashMap;
import java.util.Map;

public class Demo02 {
    public static Map<String,String> cardTypeMap = new HashMap<String,String>();
    static{
        cardTypeMap.put("0","身份证");
        cardTypeMap.put("1","户口簿");
        cardTypeMap.put("2","护照");
        cardTypeMap.put("3","军官证");
        cardTypeMap.put("4","士兵证");
    }

    //person.setCass_id_type(StringUtils.isBlank(rspVo.getIdType())?"":Cif_customerinfo.cardTypeMap.get(rspVo.getIdType()));
    public static void main(String[] args) {
        Person p = new Person();
        p.setIdtype("1");
        p.setEarning("你好");
        Student s = new Student();
        s.setIdType(Demo02.cardTypeMap.get(p.getIdtype()));
       /* BigDecimal b = new BigDecimal(p.getEarning());
        System.out.println(b);*/
        System.out.println(s.getIdType());

    }
}
