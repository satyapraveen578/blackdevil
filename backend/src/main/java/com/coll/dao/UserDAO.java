package com.coll.dao;

import com.coll.model.UserDetail;

public interface UserDAO 

{

      public boolean registeruser(UserDetail user);

      public UserDetail getUserDetail(String username);

      public UserDetail checkUserCredential(UserDetail user);

      public boolean updateUser(UserDetail user);

}