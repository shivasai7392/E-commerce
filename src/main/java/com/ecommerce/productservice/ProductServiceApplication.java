package com.ecommerce.productservice;

import com.ecommerce.productservice.models.Category;
import com.ecommerce.productservice.models.Price;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.repositories.CategoryRepository;
import com.ecommerce.productservice.repositories.PriceRepository;
import com.ecommerce.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
@Transactional
public class ProductServiceApplication implements CommandLineRunner {

//    private final MentorRepository mentorRepository;
//    private final StudentRepository studentRepository;
//    private final UserRepository userRepository;
//
//    public ProductServiceApplication(@Qualifier("stMentorRepository") MentorRepository mentorRepository,
//                                     @Qualifier("stStudentRepository") StudentRepository studentRepository,
//                                     @Qualifier("stUserRepository") UserRepository userRepository) {
//        this.mentorRepository = mentorRepository;
//        this.studentRepository = studentRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("John");
//        mentor.setEmailId("john@gmail.com");
//        mentor.setSalary(10000);
//        mentor.setAverageRating(4.5);
//
//        this.mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("Smith");
//        student.setEmailId("smith@gmail.com");
//
//        this.studentRepository.save(student);
//
//        User user = new User();
//        user.setName("David");
//        user.setEmailId("david@gamil.com");
//
//        this.userRepository.save(user);
//
//    }
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository, ProductRepository productRepository, PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Category category = new Category();
//        category.setName("Electronics");
//        category.setDescription("Electronics items");
//        Category savedCategory =  this.categoryRepository.save(category);
//
//        Price price = new Price();
//        price.setCurrency("USD");
//        price.setValue(10000);
//        Price savedPrice = this.priceRepository.save(price);
//
//        Optional<Category> optionalCategory = this.categoryRepository.findById(UUID.fromString("149bcf77-bed0-4ea1-af2d-9f033a3caac5"));
//        if (optionalCategory.isEmpty()) {
//            throw new Exception("Category not found");
//        }
//        Category category = optionalCategory.get();
//
//        Product product = new Product();
//        product.setTitle("Laptop2");
//        product.setDescription("Laptop2");
//        product.setStock(10);
//        product.setPrice(price);
//        product.setImage("https://picsum.photos/200/300");
//        product.setCategory(category);
//
//        this.productRepository.save(product);

//        this.productRepository.deleteById(UUID.fromString("1ac20edf-e907-4801-8661-d0d0d8c4aa17"));
//        this.priceRepository.deleteById(UUID.fromString("f532b29b-ba6a-4c16-9c3e-794ddc430161"));

//        System.out.println(category.getName());
//        List<Product> products = category.getProducts();
//        System.out.println(products.size());

//        List<Product> products = this.productRepository.findByPriceValueGreaterThanEqual(5000);
//        for(Product product: products) {
//            System.out.println(product.getTitle());
//        }

//        Optional<Product> optionalProduct = this.productRepository.findByTitle("Laptop");
//        if (optionalProduct.isEmpty()) {
//            throw new Exception("Product not found");
//        }
//        Product product = optionalProduct.get();
//        System.out.println(product.getTitle());
    }
}
