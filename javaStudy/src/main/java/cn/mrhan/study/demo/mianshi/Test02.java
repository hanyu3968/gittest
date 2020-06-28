package cn.mrhan.study.demo.mianshi;

import cn.mrhan.study.entity.User;
import cn.mrhan.study.entity.UserDTO;
import org.springframework.beans.BeanUtils;


public class Test02 {

    public static User addUser(UserDTO  userDTO){
        int x =1;
        User user = new User();
/*        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());*/
        BeanUtils.copyProperties(userDTO,user);

        user.setMobile(userDTO.getPhone());
        return  user;
    }

    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId("1");
        userDTO.setName("张三");
        userDTO.setPhone("1885623");
        User user = Test02.addUser(userDTO);
        System.out.println(user);
    }

}
