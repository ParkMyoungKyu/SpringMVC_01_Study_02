package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
//    @RequestMapping(value = "/mapping/users", method = RequestMethod.GET)
    public String users(){
        return "get users";
    }

    @PostMapping
//    @RequestMapping(value = "/mapping/users", method = RequestMethod.POST)
    public String addUser(){
        return "post user";
    }

    @PatchMapping("/{userId}")
//    @RequestMapping(value = "/mapping/users/{userId}", method = RequestMethod.PATCH)
    public String updateUser(@PathVariable String userId){
        return "update userId = " + userId;
    }

    @DeleteMapping("/{userId}")
//    @RequestMapping(value = "/mapping/users/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String userId){
        return "delete userId = " + userId;
    }
}
