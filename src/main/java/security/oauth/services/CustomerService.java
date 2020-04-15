package security.oauth.services;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;
import security.oauth.dtos.CustomerRegistration;
import security.oauth.entities.Customer;
import security.oauth.entities.User;
import security.oauth.repos.CustomerRepository;
import security.oauth.repos.UserRepository;

@Service
public class CustomerService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public String validateCustomer(CustomerRegistration customerDto) {
        StringBuilder sb = new StringBuilder();
        User user = userRepository.findByEmail(customerDto.getEmail());
        if (null!=user){
            sb.append("Email already exist");
        }else if(!customerDto.getPassword().equals(customerDto.getConfirmPassword())){
            sb.append("Password not matched");
        }else {
            sb.append("validated");
        }
        return sb.toString();
    }

    public MappingJacksonValue getCustomerDetails(String email){
        Customer customer = customerRepository.findByEmail(email);
        CustomerRegistration customerDto = new CustomerRegistration();
        BeanUtils.copyProperties(customer,customerDto);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("password","confirmPassword","accountNonLocked","roles");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("CustomerDto-Filter",filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(customerDto);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

}

