//package security.oauth.entities;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//public class CategoryMetadataField {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String name;
//
//    @OneToMany(mappedBy = "CategoryMetadataField",cascade = CascadeType.ALL)
//    private Set<CategoryMetadataFieldValues> fieldValues;
//
//    public CategoryMetadataField(String name) {
//        this.name = name;
//    }
//    public void addFieldValues(CategoryMetadataFieldValues fieldValue){
//        if(fieldValue != null){
//            if(fieldValues==null)
//                fieldValues = new HashSet<>();
//
//            fieldValues.add(fieldValue);
//            fieldValue.setCategoryMetadataField(this);
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "CategoryMetadataField{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
