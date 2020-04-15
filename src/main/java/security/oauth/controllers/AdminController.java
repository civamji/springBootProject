package security.oauth.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import security.oauth.dtos.CustomerAdminApi;
import security.oauth.dtos.SellerAdminApi;
import security.oauth.services.AdminService;
import security.oauth.services.CustomerService;
import security.oauth.services.SellerService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "admin/home")
public class AdminController {

        @Autowired
        private AdminService adminService;


        //Uncomment this



//        @GetMapping(path = "/customers")
//        public MappingJacksonValue getCustomers(@RequestParam(defaultValue = "0") String page, @RequestParam(defaultValue = "10")String size, @RequestParam(defaultValue = "userId") String SortBy){
//            return adminService.registeredCustomers(page, size, SortBy);
//        }
//
//        @GetMapping(path = "/sellers")
//        public MappingJacksonValue getSellers(@RequestParam(defaultValue = "0") String page, @RequestParam(defaultValue = "10")String size, @RequestParam(defaultValue = "userId") String SortBy){
//            return adminService.registeredSellers(page, size, SortBy);
//        }

        @PatchMapping(path = "/activateCustomer/{id}")
        public String activateCustomer(@PathVariable(value = "id") Long id, HttpServletResponse response){

            String message = adminService.activateCustomer(id,response);

            if(!message.equals("Account activated")){
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
            return message;
        }

        @PatchMapping(path = "/de-activateCustomer/{id}")
        public String deactivateCustomer(@PathVariable(value = "id") Long id,HttpServletResponse response){
            String message = adminService.deactivateCustomer(id,response);
            if(!message.equals("Account de-activated")){
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
            return message;
        }

        @PatchMapping(path = "/activateSeller/{id}")
        public String activateSeller(@PathVariable(value = "id") Long id, HttpServletResponse response){
            String message = adminService.activateSeller(id,response);
            if(!message.equals("Account activated")){
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
            return message;
        }

        @PatchMapping(path = "/de-activateSeller/{id}")
        public String deactivateSeller(@PathVariable(value = "id") Long id, HttpServletResponse response){
            String message = adminService.deactivateSeller(id,response);
            if(!message.equals("Account de-activated")){
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
            return message;
        }
    }
