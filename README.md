# A SpringBoot Demo
>
## By renshuai 
## For Epoint Test
### CURD user table
>
#### restful junit && mock junit
> restful junit
>>insert data
#####http://127.0.0.1:8080/insertUser?name=renshuai3&age=25
######
>>query data By Id
#####http://127.0.0.1:8080/queryUserById?id=71 
######
>>query list
#####http://127.0.0.1:8080/queryUserList?pageNum=1&pageSize=3
######
>>update data
#####http://127.0.0.1:8080/updateUser?name=renshuai&age=26&id=71
######
>>delete data(Logical deletion.set state 0)
#####http://127.0.0.1:8080/deleteUser?id=71
######
> mock junit
##### com.demo.controller.UserControllerTest
###### @Test  
public void queryUserById()
###### @Test  restful
public void queryUserList()
###### @Test  restful
public void insertUser()
###### @Test  restful
public void updateUser()
###### @Test
public void deleteUser()