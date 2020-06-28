package cn.mrhan.study.method;

import java.util.*;

public class DemoUtil {

    public static <K, E> boolean isEmpty2(Map<K, E> m) {
        return m == null || m.isEmpty();
    }

    public static boolean isEmpty(Object value) {
        if (value == null) {
            return true;
        } else if (value instanceof String) {
            return ((String)value).length() == 0;
        } else if (value instanceof Collection) {
            return ((Collection)value).size() == 0;
        } else if (value instanceof Map) {
            return ((Map)value).size() == 0;
        } else if (value instanceof CharSequence) {
            return ((CharSequence)value).length() == 0;
        }  else if (value instanceof Boolean) {
            return false;
        } else if (value instanceof Number) {
            return false;
        } else if (value instanceof Character) {
            return false;
        } else if (value instanceof java.util.Date) {
            return false;
        }else{
            return  false;
        }


    }
    public static boolean isNotEmpty(Object o) {
        return !DemoUtil.isEmpty(o);
    }

    public static boolean isEmpty(Map map) {
        if (DemoUtil.isEmpty2(map)) {
            return true;
        }
        Iterator iter = map.values().iterator();
        while (iter.hasNext()) {
            Object obj = iter.next();
            if (DemoUtil.isNotEmpty(obj)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Map<String,Object> infoMap = new HashMap<>();
        List<Map<String,Object>> list1 = new ArrayList<>();
        Map<String,Object> list1map1 = new HashMap<>();
        list1map1.put("list1map1-1",null);
        list1map1.put("list1map1-2","list1map1String1");
        list1map1.put(null,"list1map1String1");
        list1map1.put(null,null);

        Map<String,Object> list1map2 = new HashMap<>();
        list1map2.put("list1map2-1",null);
        list1map2.put("list1map2-2","list1map2String2");
        list1map2.put("list1map2-3","list1map3String2");
        list1map2.put(null,null);
        list1.add(list1map1);
        list1.add(list1map2);
        infoMap.put("list1",list1);


        List<Map<String,Object>> list2 = new ArrayList<>();
        Map<String,Object> list2map1 = new HashMap<>();
        list2map1.put("list2map1-1",null);
        list2map1.put("list2map1-2","list2map1String2");
        list2map1.put(null,"list2map1String3");

        Map<String,Object> list2map2 = new HashMap<>();
        list2map2.put("list2map2-1",null);
        list2map2.put("list2map2-2","list2map2String2");
        list2map2.put("list2map2-3","list2map3String3");
        list2.add(list2map1);
        list2.add(list2map2);
        infoMap.put("list2",list2);
        System.out.println(infoMap);
        Iterator<Map.Entry<String,Object>> ite = infoMap.entrySet().iterator();
        System.out.println(ite);
        Map.Entry<String, Object> entry = null;
        Object obj = null;
        List<Map<String, Object>> infoList = null;
        System.out.println("=================================");
        while (ite.hasNext()) {
            entry = ite.next();
            obj = entry.getValue();
            if (obj instanceof List) {
                infoList = (List<Map<String, Object>>)obj;
                Iterator<Map<String, Object>> iter = infoList.iterator();
                while (iter.hasNext()) {
                    Map<String, Object> map = iter.next();
                    if (DemoUtil.isEmpty(map)) {
                        iter.remove();
                    }
                }
            }
        }
        System.out.println("去除空map后");
        System.out.println(infoMap);
    }


}
