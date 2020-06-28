package cn.mrhan.study.demo.demos;

import cn.mrhan.study.entity.Person;

import java.math.BigDecimal;

public class Demo03 {

    public static boolean isBigDecimal(String str){
        if(str==null || str.trim().length() == 0){
            return false;
        }
        char[] chars = str.toCharArray();
        int sz = chars.length;
        int i = (chars[0] == '-') ? 1 : 0;
        if(i == sz) return false;

        if(chars[i] == '.') return false;//除了负号，第一位不能为'小数点'

        boolean radixPoint = false;
        for(; i < sz; i++){
            if(chars[i] == '.'){
                if(radixPoint) return false;
                radixPoint = true;
            }else if(!(chars[i] >= '0' && chars[i] <= '9')){
                return false;
            }
        }
        return true;
    }

    public static boolean isBigDecimal2(String str) {
        try {
            new BigDecimal(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "123.22";
        String str2 = "你好";
        String str3 = null;
        Person p = new Person();
        boolean flag = Demo03.isBigDecimal2(str);
        System.out.println(flag);
    }
}
