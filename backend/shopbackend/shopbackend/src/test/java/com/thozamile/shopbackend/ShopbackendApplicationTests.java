package com.thozamile.shopbackend;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestRestTemplate
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShopbackendApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;

	//@Test
	void getProducts() {
		
	}

}


/* ====== JSON TESTS ======

Import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class ShopbackendApplicationTests {
    
    @Autowired 
    private JacksonTester<Product> productJson;

    @Autowired
    private JacksonTester<DressStyle> dressStyleJson;
    
    @Autowired
    private JacksonTester<DressType> dressTypeJson;
    
    @Autowired
    private JacksonTester<ProductVariant> productVariantJson;
    
    @Autowired
    private JacksonTester<ProductImage> productImageJson;
    
    @Autowired
    private JacksonTester<ProductReview> productReviewJson;

    @Test
    void productSerializationTest() throws IOException {
        Product product = new Product(
            1L, 
            1L,
            1L, 
            "Baggy Jeans", 
            80.99, 
            "Simple baggy jeans.", 
            LocalDateTime.of(2026, 7, 5, 0, 0, 0),
            LocalDateTime.of(2026, 7, 5, 0, 0, 0)
        );

        assertThat(productJson.write(product)).isStrictlyEqualToJson(
            new ClassPathResource("json/product.json")
        );

        assertThat(productJson.write(product)).hasJsonPathNumberValue("@.id");
        assertThat(productJson.write(product))
            .extractingJsonPathNumberValue("@.id")
            .isEqualTo(1);
        
        assertThat(productJson.write(product)).hasJsonPathNumberValue("@.style_id");
        assertThat(productJson.write(product))
            .extractingJsonPathNumberValue("@.style_id")
            .isEqualTo(1);

        assertThat(productJson.write(product)).hasJsonPathNumberValue("@.type_id");
        assertThat(productJson.write(product))
            .extractingJsonPathNumberValue("@.type_id")
            .isEqualTo(1);

        assertThat(productJson.write(product)).hasJsonPathStringValue("@.name");
        assertThat(productJson.write(product))
            .extractingJsonPathStringValue("@.name")
            .isEqualTo("Baggy Jeans");

        assertThat(productJson.write(product)).hasJsonPathNumberValue("@.price");
        assertThat(productJson.write(product))
            .extractingJsonPathNumberValue("@.price")
            .isEqualTo(80.99);

        assertThat(productJson.write(product)).hasJsonPathStringValue("@.description");
        assertThat(productJson.write(product))
            .extractingJsonPathStringValue("@.description")
            .isEqualTo("Simple baggy jeans.");

        assertThat(productJson.write(product)).hasJsonPathStringValue("@.created_at");
        assertThat(productJson.write(product))
            .extractingJsonPathStringValue("@.created_at")
            .isEqualTo("2026-07-05T00:00:00");

        assertThat(productJson.write(product)).hasJsonPathStringValue("@.updated_at");
        assertThat(productJson.write(product))
            .extractingJsonPathStringValue("@.updated_at")
            .isEqualTo("2026-07-05T00:00:00");
    }

    @Test 
    void productDeserializationTest() throws IOException {
        String expected = """
            {
                "id": 1,
                "style_id": 1,
                "type_id": 1,
                "name": "Baggy Jeans",
                "price": 80.99,
                "description": "Simple baggy jeans.",
                "created_at": "2026-07-05T00:00:00",
                "updated_at": "2026-07-05T00:00:00"
            }
        """;

        assertThat(productJson.parse(expected))
            .isEqualTo(new Product(
                1L, 
                1L,
                1L, 
                "Baggy Jeans", 
                80.99, 
                "Simple baggy jeans.", 
                LocalDateTime.of(2026, 7, 5, 0, 0, 0),
                LocalDateTime.of(2026, 7, 5, 0, 0, 0)
            ));

        assertThat(productJson.parseObject(expected).id()).isEqualTo(1);
        assertThat(productJson.parseObject(expected).style_id()).isEqualTo(1);
        assertThat(productJson.parseObject(expected).type_id()).isEqualTo(1);
        assertThat(productJson.parseObject(expected).name()).isEqualTo("Baggy Jeans");
        assertThat(productJson.parseObject(expected).price()).isEqualTo(80.99);
        assertThat(productJson.parseObject(expected).description()).isEqualTo("Simple baggy jeans.");
        assertThat(productJson.parseObject(expected).created_at())
            .isEqualTo(LocalDateTime.of(2026, 7, 5, 0, 0, 0));
        assertThat(productJson.parseObject(expected).updated_at())
            .isEqualTo(LocalDateTime.of(2026, 7, 5, 0, 0, 0));
    }

    @Test
    void dressStyleSerializationTest() throws IOException {
        DressStyle dressStyle = new DressStyle(1L, "casual");

        assertThat(dressStyleJson.write(dressStyle)).isStrictlyEqualToJson(
            new ClassPathResource("json/dress_style.json")
        );

        assertThat(dressStyleJson.write(dressStyle)).hasJsonPathNumberValue("@.id");
        assertThat(dressStyleJson.write(dressStyle))
            .extractingJsonPathNumberValue("@.id")
            .isEqualTo(1);

        assertThat(dressStyleJson.write(dressStyle)).hasJsonPathStringValue("@.name");
        assertThat(dressStyleJson.write(dressStyle))
            .extractingJsonPathStringValue("@.name")
            .isEqualTo("casual");
    }

    @Test 
    void dressStyleDeserializationTest() throws IOException {
        String expected = """
            {
                "id": 1,
                "name": "casual"
            }
        """;

        assertThat(dressStyleJson.parse(expected))
            .isEqualTo(new DressStyle(1L, "casual"));

        assertThat(dressStyleJson.parseObject(expected).id()).isEqualTo(1L);
        assertThat(dressStyleJson.parseObject(expected).name()).isEqualTo("casual");
    }


    @Test
    void dressTypeSerializationTest() throws IOException {
        DressType dressType = new DressType(1L, "casual");

        assertThat(dressTypeJson.write(dressType)).isStrictlyEqualToJson(
            new ClassPathResource("json/dress_type.json")
        );

        assertThat(dressTypeJson.write(dressType)).hasJsonPathNumberValue("@.id");
        assertThat(dressTypeJson.write(dressType))
            .extractingJsonPathNumberValue("@.id")
            .isEqualTo(1);

        assertThat(dressTypeJson.write(dressType)).hasJsonPathStringValue("@.name");
        assertThat(dressTypeJson.write(dressType))
            .extractingJsonPathStringValue("@.name")
            .isEqualTo("casual");
    }

    @Test 
    void dressTypeDeserializationTest() throws IOException {
        String expected = """
            {
                "id": 1,
                "name": "casual"
            }
        """;

        assertThat(dressTypeJson.parse(expected))
            .isEqualTo(new DressType(1L, "casual"));

        assertThat(dressTypeJson.parseObject(expected).id()).isEqualTo(1L);
        assertThat(dressTypeJson.parseObject(expected).name()).isEqualTo("casual");
    }

    @Test
    void productVariantSerializationTest() throws IOException {
        ProductVariant variant = new ProductVariant(
            1L,
            1L,
            "Black",
            "M",
            50
        );

        assertThat(productVariantJson.write(variant)).hasJsonPathNumberValue("@.id");
        assertThat(productVariantJson.write(variant))
            .extractingJsonPathNumberValue("@.id")
            .isEqualTo(1);
        
        assertThat(productVariantJson.write(variant)).hasJsonPathNumberValue("@.product_id");
        assertThat(productVariantJson.write(variant))
            .extractingJsonPathNumberValue("@.product_id")
            .isEqualTo(1);
        
        assertThat(productVariantJson.write(variant)).hasJsonPathStringValue("@.color");
        assertThat(productVariantJson.write(variant))
            .extractingJsonPathStringValue("@.color")
            .isEqualTo("Black");
        
        assertThat(productVariantJson.write(variant)).hasJsonPathStringValue("@.size");
        assertThat(productVariantJson.write(variant))
            .extractingJsonPathStringValue("@.size")
            .isEqualTo("M");
        
        assertThat(productVariantJson.write(variant)).hasJsonPathNumberValue("@.stock");
        assertThat(productVariantJson.write(variant))
            .extractingJsonPathNumberValue("@.stock")
            .isEqualTo(50);
    }

    @Test
    void productVariantDeserializationTest() throws IOException {
        String expected = """
            {
                "id": 1,
                "product_id": 1,
                "color": "Black",
                "size": "M",
                "stock": 50
            }
        """;

        assertThat(productVariantJson.parse(expected))
            .isEqualTo(new ProductVariant(1L, 1L, "Black", "M", 50));
        
        assertThat(productVariantJson.parseObject(expected).id()).isEqualTo(1L);
        assertThat(productVariantJson.parseObject(expected).product_id()).isEqualTo(1L);
        assertThat(productVariantJson.parseObject(expected).color()).isEqualTo("Black");
        assertThat(productVariantJson.parseObject(expected).size()).isEqualTo("M");
        assertThat(productVariantJson.parseObject(expected).stock()).isEqualTo(50);
    }

    @Test
    void productImageSerializationTest() throws IOException {
        ProductImage image = new ProductImage(
            1L,
            1L,
            "https://example.com/image.jpg",
            1
        );

        assertThat(productImageJson.write(image)).hasJsonPathNumberValue("@.id");
        assertThat(productImageJson.write(image))
            .extractingJsonPathNumberValue("@.id")
            .isEqualTo(1);
        
        assertThat(productImageJson.write(image)).hasJsonPathNumberValue("@.product_id");
        assertThat(productImageJson.write(image))
            .extractingJsonPathNumberValue("@.product_id")
            .isEqualTo(1);
        
        assertThat(productImageJson.write(image)).hasJsonPathStringValue("@.url");
        assertThat(productImageJson.write(image))
            .extractingJsonPathStringValue("@.url")
            .isEqualTo("https://example.com/image.jpg");
        
        assertThat(productImageJson.write(image)).hasJsonPathNumberValue("@.display_order");
        assertThat(productImageJson.write(image))
            .extractingJsonPathNumberValue("@.display_order")
            .isEqualTo(1);
    }

    @Test
    void productImageDeserializationTest() throws IOException {
        String expected = """
            {
                "id": 1,
                "product_id": 1,
                "url": "https://example.com/image.jpg",
                "display_order": 1
            }
        """;

        assertThat(productImageJson.parse(expected))
            .isEqualTo(new ProductImage(1L, 1L, "https://example.com/image.jpg", 1));
        
        assertThat(productImageJson.parseObject(expected).id()).isEqualTo(1L);
        assertThat(productImageJson.parseObject(expected).product_id()).isEqualTo(1L);
        assertThat(productImageJson.parseObject(expected).url())
            .isEqualTo("https://example.com/image.jpg");
        assertThat(productImageJson.parseObject(expected).display_order()).isEqualTo(1);
    }

    @Test
    void productReviewSerializationTest() throws IOException {
        ProductReview review = new ProductReview(
            1L,
            1L,
            4.5,
            "Great product!",
            LocalDateTime.of(2026, 7, 5, 10, 30, 0),
            LocalDateTime.of(2026, 7, 5, 10, 30, 0)
        );

        assertThat(productReviewJson.write(review)).hasJsonPathNumberValue("@.id");
        assertThat(productReviewJson.write(review))
            .extractingJsonPathNumberValue("@.id")
            .isEqualTo(1);
        
        assertThat(productReviewJson.write(review)).hasJsonPathNumberValue("@.product_id");
        assertThat(productReviewJson.write(review))
            .extractingJsonPathNumberValue("@.product_id")
            .isEqualTo(1);
        
        assertThat(productReviewJson.write(review)).hasJsonPathNumberValue("@.rating");
        assertThat(productReviewJson.write(review))
            .extractingJsonPathNumberValue("@.rating")
            .isEqualTo(4.5);
        
        assertThat(productReviewJson.write(review)).hasJsonPathStringValue("@.comment");
        assertThat(productReviewJson.write(review))
            .extractingJsonPathStringValue("@.comment")
            .isEqualTo("Great product!");
        
        assertThat(productReviewJson.write(review)).hasJsonPathStringValue("@.created_at");
        assertThat(productReviewJson.write(review))
            .extractingJsonPathStringValue("@.created_at")
            .isEqualTo("2026-07-05T10:30:00");
        
        assertThat(productReviewJson.write(review)).hasJsonPathStringValue("@.updated_at");
        assertThat(productReviewJson.write(review))
            .extractingJsonPathStringValue("@.updated_at")
            .isEqualTo("2026-07-05T10:30:00");
    }

    @Test
    void productReviewDeserializationTest() throws IOException {
        String expected = """
            {
                "id": 1,
                "product_id": 1,
                "rating": 4.5,
                "comment": "Great product!",
                "created_at": "2026-07-05T10:30:00",
                "updated_at": "2026-07-05T10:30:00"
            }
        """;

        assertThat(productReviewJson.parse(expected))
            .isEqualTo(new ProductReview(
                1L, 
                1L, 
                4.5, 
                "Great product!",
                LocalDateTime.of(2026, 7, 5, 10, 30, 0),
                LocalDateTime.of(2026, 7, 5, 10, 30, 0)
            ));
        
        assertThat(productReviewJson.parseObject(expected).id()).isEqualTo(1L);
        assertThat(productReviewJson.parseObject(expected).product_id()).isEqualTo(1L);
        assertThat(productReviewJson.parseObject(expected).rating()).isEqualTo(4.5);
        assertThat(productReviewJson.parseObject(expected).comment()).isEqualTo("Great product!");
        assertThat(productReviewJson.parseObject(expected).created_at())
            .isEqualTo(LocalDateTime.of(2026, 7, 5, 10, 30, 0));
        assertThat(productReviewJson.parseObject(expected).updated_at())
            .isEqualTo(LocalDateTime.of(2026, 7, 5, 10, 30, 0));
    }
}*/