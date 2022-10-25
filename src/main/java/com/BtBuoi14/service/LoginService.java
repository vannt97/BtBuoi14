package com.BtBuoi14.service;

import com.BtBuoi14.models.User;
import com.BtBuoi14.respository.UserRespository;

import java.util.List;

public class LoginService {
        private UserRespository userRespository = new UserRespository();

        public boolean checkLogin(String email, String password){
            List<User> list = userRespository.getUserByEmailAndPassword(email,password);
            if(list.size() > 0){
                return  true;
            }else {
                return  false;
            }
        }
}
