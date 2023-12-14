package app.manager.client.controller;

import app.manager.client.model.Order;
import app.manager.client.model.ResponseObject;
import app.manager.client.model.Role;
import app.manager.client.model.User;
import app.manager.client.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private LoginService loginService;
    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @PostMapping("/submitProducts")
    public ResponseEntity<String> submitProducts(@RequestBody List<Order> orders){

//        Lưu thông tin Order vào DB
        System.out.println("Order:");
        for(Order order : orders) {
            System.out.println(order.name() + " - " + order.quantity());
        }

        return ResponseEntity.ok("OK");
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public void login(@ModelAttribute("user") User user){
        user.setRole(Role.USER);

        ResponseEntity<ResponseObject> response = loginService.login(user);

        if(response.getBody().data() == null) {
//             Login Failed
        } else {
//            Login Successed


        }

//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.set("Authorization", "Bearer ");

    }
}
