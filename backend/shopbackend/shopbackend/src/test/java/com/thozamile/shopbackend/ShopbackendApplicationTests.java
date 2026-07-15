package com.thozamile.shopbackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class ShopbackendApplicationTests {
	@Autowired 
	private JacksonTester<Product> productJson;

	@Autowired
	private JacksonTester<DressStyle> dressStyleJson;

	/* ====== 1. PRODUCT TESTS ====== */

	// ------ PRODUCT JSON SERIALIZATION TEST ------
	@Test
	void productSerializationTest() throws IOException {
		Product product = new Product(
			1L, 
			1L,
			1L, 
			"Baggy Jeans", 
			80.99, 
			"Simple baggy jeans.", 
			"2026/07/05", 
			"2026/07/05"
		);

		// Object Test
		assertThat(productJson.write(product)).isStrictlyEqualToJson(
			new ClassPathResource("json/product.json")
		);

		// ID Test
		assertThat(productJson.write(product)).hasJsonPathNumberValue("@.id");
		assertThat(productJson.write(product))
									   .extractingJsonPathNumberValue("@.id")
									   .isEqualTo(1);
		
	    // Style ID Test
		assertThat(productJson.write(product)).hasJsonPathNumberValue("@.style_id");
		assertThat(productJson.write(product))
									   .extractingJsonPathNumberValue("@.style_id")
									   .isEqualTo(1);

		// Type ID Test
		assertThat(productJson.write(product)).hasJsonPathNumberValue("@.type_id");
		assertThat(productJson.write(product))
									   .extractingJsonPathNumberValue("@.type_id")
									   .isEqualTo(1);

		// Name Test
		assertThat(productJson.write(product)).hasJsonPathStringValue("@.name");
		assertThat(productJson.write(product))
									   .extractingJsonPathStringValue("@.name")
									   .isEqualTo("Baggy Jeans");

	    // Price Test
		assertThat(productJson.write(product)).hasJsonPathNumberValue("@.price");
		assertThat(productJson.write(product))
									   .extractingJsonPathNumberValue("@.price")
									   .isEqualTo(80.99);

		// Description Test
		assertThat(productJson.write(product)).hasJsonPathStringValue("@.description");
		assertThat(productJson.write(product))
									   .extractingJsonPathStringValue("@.description")
									   .isEqualTo("Simple baggy jeans.");

		// Created At Test
		assertThat(productJson.write(product)).hasJsonPathStringValue("@.created_at");
		assertThat(productJson.write(product))
									   .extractingJsonPathStringValue("@.created_at")
									   .isEqualTo("2026/07/05");

		// Updated At Test
		assertThat(productJson.write(product)).hasJsonPathStringValue("@.updated_at");
		assertThat(productJson.write(product))
									   .extractingJsonPathStringValue("@.updated_at")
									   .isEqualTo("2026/07/05");
	}

	// ------ PRODUCT JSON DESERIALIZATION TEST ------ 
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
					"created_at": "2026/07/05",
					"updated_at": "2026/07/05"
				}
		""";

		assertThat(productJson.parse(expected))
			.isEqualTo(
				new Product(
					1L, 
					1L,
					1L, 
					"Baggy Jeans", 
					80.99, 
					"Simple baggy jeans.", 
					"2026/07/05", 
					"2026/07/05"
				)
		);

		assertThat(productJson.parseObject(expected).id()).isEqualTo(1);
		assertThat(productJson.parseObject(expected).style_id()).isEqualTo(1);
		assertThat(productJson.parseObject(expected).type_id()).isEqualTo(1);
		assertThat(productJson.parseObject(expected).name()).isEqualTo("Baggy Jeans");
		assertThat(productJson.parseObject(expected).price()).isEqualTo(80.99);
		assertThat(productJson.parseObject(expected).description()).isEqualTo("Simple baggy jeans.");
		assertThat(productJson.parseObject(expected).created_at()).isEqualTo("2026/07/05");
		assertThat(productJson.parseObject(expected).updated_at()).isEqualTo("2026/07/05");
	}

	/* ====== 2. DRESS-STYLE TESTS ====== */

	// ------ DRESS-STYLE JSON SERIALIZATION TEST ------ */
	@Test
	void dressStyleSerializationTest() throws IOException {
		DressStyle dressStyle = new DressStyle(1L, "casual");

		// Object Test
		assertThat(dressStyleJson.write(dressStyle)).isStrictlyEqualToJson(
			new ClassPathResource("json/dress_style.json")
		);

		// ID Test
		assertThat(dressStyleJson.write(dressStyle)).hasJsonPathNumberValue("@.id");
		assertThat(dressStyleJson.write(dressStyle))
										  .extractingJsonPathNumberValue("@.id")
										  .isEqualTo(1);

	    // Name Test
		assertThat(dressStyleJson.write(dressStyle)).hasJsonPathStringValue("@.dress_style");
		assertThat(dressStyleJson.write(dressStyle))
										  .extractingJsonPathStringValue("@.dress_style")
										  .isEqualTo("casual");
	}

	// ------ DRESS-STYLE JSON SERIALIZATION TEST ------ */
	@Test 
	void dressStyleDeserializationTest() throws IOException {
		String expected = """
			{
				"id": 1,
				"name": "casual"
			}
		""";

		// Object Test
		assertThat(dressStyleJson.parse(expected))
			.isEqualTo(
				new DressStyle(
					1L,
					"casual"
				)
		);

		assertThat(dressStyleJson.parseObject(expected).id()).isEqualTo(1);
		assertThat(dressStyleJson.parseObject(expected).name()).isEqualTo("casual");
	}

	/* ====== 2. DRESS-TYPE TESTS ====== */

	// ------ DRESS-TYPE JSON SERIALIZATION TEST ------ */
	@Test
	void dressTypeSerializationTest() throws IOException {
		DressType dressType = new DressType(1L, "casual");

		// Object Test
		assertThat(dressTypeJson.write(dressType)).isStrictlyEqualToJson(
			new ClassPathResource("json/dress_type.json")
		);

		// ID Test
		assertThat(dressTypeJson.write(dressType)).hasJsonPathNumberValue("@.id");
		assertThat(dressTypeJson.write(dressType))
										  .extractingJsonPathNumberValue("@.id")
										  .isEqualTo(1);

	    // Name Test
		assertThat(dressTypeJson.write(dressType)).hasJsonPathStringValue("@.dress_type");
		assertThat(dressTypeJson.write(dressType))
										  .extractingJsonPathStringValue("@.dress_type")
										  .isEqualTo("casual");
	}

	// ------ DRESS-STYLE JSON SERIALIZATION TEST ------ */
	@Test 
	void dressStyleDeserializationTest() throws IOException {
		String expected = """
			{
				"id": 1,
				"name": "casual"
			}
		""";

		// Object Test
		assertThat(dressStyleJson.parse(expected))
			.isEqualTo(
				new DressStyle(
					1L,
					"casual"
				)
		);

		assertThat(dressStyleJson.parseObject(expected).id()).isEqualTo(1);
		assertThat(dressStyleJson.parseObject(expected).name()).isEqualTo("casual");
	}
	

}
