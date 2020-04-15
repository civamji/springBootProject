package security.oauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import security.oauth.dtos.SellerRegistration;
import security.oauth.entities.Seller;
import security.oauth.entities.User;
import security.oauth.repos.SellerRepository;
import security.oauth.repos.UserRepository;

@Service
public class SellerService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SellerRepository sellerRepository;

    public String validateSeller(SellerRegistration sellerDto){
        StringBuilder sb = new StringBuilder();
        System.out.println("Seller Dto is : "+sellerDto);
        User user = userRepository.findByEmail(sellerDto.getEmail());

        System.out.println("Seller is : "+user);

        System.out.println("Gst number is : "+sellerDto.getGST());
        Seller seller = sellerRepository.findByGst(sellerDto.getGST());
        if (null!=user){
            sb.append("Email already exist");
        }else if(!sellerDto.getPassword().equals(sellerDto.getConfirmPassword())){
            sb.append("Passwords not matched");
        }else if(null!=seller){
            System.out.println("Seller Gst : "+seller);
            sb.append("Gst number already exist");
        }else {
            sb.append("validated");
        }
        return sb.toString();
    }
}
