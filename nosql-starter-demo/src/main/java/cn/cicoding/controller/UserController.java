package cn.cicoding.controller;

import cn.cicoding.model.UserDomain;
import cn.cicoding.service.UserService;
import com.crecgec.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    RedisUtil redisUtil;

    @PostMapping("")
    public ResponseEntity addUser(@RequestParam(value = "userName", required = true) String userName, @RequestParam(value = "password", required = true)
            String password, @RequestParam(value = "phone", required = false) String phone){
        UserDomain userDomain = new UserDomain();
        userDomain.setUserName(userName);
        userDomain.setPassword(password);
        userDomain.setPhone(phone);
        userService.insert(userDomain);
        return ResponseEntity.ok("添加成功");
    }

    @DeleteMapping("")
    public ResponseEntity deleteUser(@RequestParam(value = "userId", required = true) Integer userId){

        userService.deleteUserById(userId);
        return ResponseEntity.ok("删除成功");
    }

    @PutMapping("")
    public ResponseEntity updateUser(@RequestParam(value = "userId", required = true) Integer userId, @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "password", required = false) String password, @RequestParam(value = "phone", required = false) String phone ){
        UserDomain userDomain = new UserDomain();
        userDomain.setUserId(userId);
        userDomain.setUserName(userName);
        userDomain.setPassword(password);
        userDomain.setPhone(phone);
        userService.updateUser(userDomain);
        return ResponseEntity.ok("更新成功");
    }

    @GetMapping("")
    public ResponseEntity getUsers(){
        return ResponseEntity.ok(userService.selectUsers());
    }

    @GetMapping("/{id}")
    @Cacheable(value="db0",key="T(String).valueOf(#id)")//把id转换为string类型的
    public UserDomain findById(@PathVariable Integer id) {

        return this.userService.findById(id);
    }

}
