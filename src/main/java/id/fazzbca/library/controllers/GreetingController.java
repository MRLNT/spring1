package id.fazzbca.library.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/hello") nanti dibawahnya yang ada hello2 jadi 2 aja
public class GreetingController {
    @GetMapping("/hello")
    //localhost:8080/hello
    public String greeting(){
        return "halo lombok";
    }
    
    @GetMapping("/hello2")
    //request params
    //localhost:8080/hello?name=value
    public String greeting(@RequestParam String name){
        return "halo " + name + "!";
    }

    @GetMapping("/hello3/{name}")
    //path variable
    //localhost:8080/hello3/value
    public String greeting2(@PathVariable String name){
        return "halo " + name + "!";
    }

    //request body
    //localhost:8080/hello4
    //nanti ke text trus send
    //outputnya ada di clientnya
    @PostMapping("/hello4")
    public String greeting3(@RequestBody String name){
        return "halo " + name + "! ini dari request body";
    }
}