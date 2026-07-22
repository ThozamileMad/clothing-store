INSERT INTO dress_style (name) VALUES ('casual');
INSERT INTO dress_style (name) VALUES ('Slim Fit');
INSERT INTO dress_style (name) VALUES ('Regular');


INSERT INTO dress_type (name) VALUES ('jeans');
INSERT INTO dress_type (name) VALUES ('T-Shirt');
INSERT INTO dress_type (name) VALUES ('Jacket');


INSERT INTO product (style_id, type_id, name, price, description)
VALUES (1, 1, 'Baggy Jeans', 80.99, 'Comfortable baggy fit jeans with a relaxed feel.');

INSERT INTO product (style_id, type_id, name, price, description)
VALUES (2, 2, 'Slim Fit Tee', 25.50, 'A classic slim fit t-shirt, soft cotton blend.');

INSERT INTO product (style_id, type_id, name, price, description)
VALUES (3, 3, 'Regular Denim Jacket', 120.00, 'A timeless denim jacket for everyday wear.');

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (1, 'Blue', 'M', 15);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (1, 'Black', 'L', 8);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (2, 'White', 'S', 20);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (3, 'Blue', 'XL', 5);

INSERT INTO product_image (product_id, url, display_order)
VALUES (1, 'https://example.com/images/baggy-jeans-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (1, 'https://example.com/images/baggy-jeans-2.jpg', 2);

INSERT INTO product_image (product_id, url, display_order)
VALUES (2, 'https://example.com/images/slim-tee-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (3, 'https://example.com/images/denim-jacket-1.jpg', 1);

INSERT INTO app_user (username, email, password_hash) VALUES ('ThaboNkosi', 'thabo.nkosi@example.com', '$2a$10$examplehashvalUe1');
INSERT INTO app_user (username, email, password_hash) VALUES ('LeratoDlamini', 'lerato.dlamini@example.com', '$2a$10$examplehashvalue2');
INSERT INTO app_user (username, email, password_hash) VALUES ('SiphoMahlangu', 'sipho.mahlangu@example.com', '$2a$10$examplehashvalue3');

INSERT INTO product_review (product_id, user_id, rating, comment)
VALUES (1, 1, 4.5, 'Great fit, very comfortable for everyday wear.');

INSERT INTO product_review (product_id, user_id, rating, comment)
VALUES (1, 2, 3.5, 'Good jeans but sizing runs a bit large.');

INSERT INTO product_review (product_id, user_id, rating, comment)
VALUES (2, 3, 5.0, 'Perfect fit and great material quality.');

INSERT INTO product_review (product_id, user_id, rating, comment)
VALUES (3, 1, 4.0, 'Solid jacket, a bit pricey but worth it.');

INSERT INTO sale (user_id, variant_id, quantity, unit_price, total_price)
VALUES (1, 1, 1, 80.99, 80.99);

INSERT INTO sale (user_id, variant_id, quantity, unit_price, total_price)
VALUES (2, 3, 2, 25.50, 51.00);

INSERT INTO sale (user_id, variant_id, quantity, unit_price, total_price)
VALUES (3, 4, 1, 120.00, 120.00);

INSERT INTO sale (user_id, variant_id, quantity, unit_price, total_price)
VALUES (1, 2, 1, 80.99, 80.99);