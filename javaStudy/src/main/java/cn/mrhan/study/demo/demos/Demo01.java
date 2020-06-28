package cn.mrhan.study.demo.demos;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {
    public int add(int a,int b){
        return a+b;

    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("type","1");
        map.put("name",null);
        String name = (String) map.get("id");
        System.out.println(name);
        boolean flag = "1".equals((String)map.get("type"));
        System.out.println(flag);
    }


}
