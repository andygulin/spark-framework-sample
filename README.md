#### Spark Framework Sample

##### 返回所有用户
    URL : /user/all
    METHOD : GET
    
##### 根据ID返回用户
    URL : /user/get/{id}
    METHOD : GET
    
##### 根据ID删除用户
    URL : /user/delete/{id}
    METHOD : DELETE
    
##### 插入用户
    URL : /user/insert
    METHOD : PUT
    BODY : {
               "name":"insert user",
               "age":123,
               "address":"insert address"
           }
    
##### 更新用户
    URL : /user/update
    METHOD : PUT
    BODY : {
                "id":1,
                "name":"update user",
                "age":123,
                "address":"update address"
              }
