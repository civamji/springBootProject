//package security.oauth.entities;
//
//
//import javax.persistence.*;
//
//@Entity
//public class CategoryMetadataFieldValues {
////
////    @EmbeddedId
////    private CategoryMetadataFieldValuesId id = new CategoryMetadataFieldValuesId();
//
//
//    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @MapsId("categoryId")
//    private Category category;
//
//    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @MapsId("categoryMetadataFieldId")
//    private CategoryMetadataField categoryMetadataField;
//
//    private String values;
//
//    public CategoryMetadataFieldValues(String values) {
//        this.values = values;
//    }
//
//    @Override
//    public String toString() {
//        return "CategoryMetadataFieldValues{" +
//                ", category=" + category.getName() +
//                ", categoryMetadataField=" + categoryMetadataField.getName() +
//                ", values='" + values + '\'' +
//                '}';
//    }
//}
