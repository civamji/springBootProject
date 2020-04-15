package security.oauth.entities;

        import javax.persistence.*;
        import java.util.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    private Double amountPaid;
    private Date dateCreated;
    @ManyToOne
    @JoinColumn(name = "customer_user_id")
    private Customer customer;
//    private Double amountPaid;
//    private Date dateCreated;
//    private String paymentMethod;
//    private String CustomerAddressCity;
//    private String CustomerAddressState;
//    private String CustomerAddressCountry;
//    private String CustomerAddressAddressLine;
//    private String customerAddressZipCode;
//    private String CustomerAddressLabel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
