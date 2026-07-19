INSERT INTO dressStyle (id, name) VALUES (1, 'casual');
INSERT INTO dressStyle (id, name) VALUES (2, 'Slim Fit');
INSERT INTO dressStyle (id, name) VALUES (3, 'Regular');


INSERT INTO dressType (id, name) VALUES (1, 'jeans');
INSERT INTO dressType (id, name) VALUES (2, 'T-Shirt');
INSERT INTO dressType (id, name) VALUES (3, 'Jacket');


INSERT INTO product (id, styleId, typeId, name, price, description)
VALUES (1, 1, 1, 'Baggy Jeans', 80.99, 'Comfortable baggy fit jeans with a relaxed feel.');

INSERT INTO product (id, styleId, typeId, name, price, description)
VALUES (2, 2, 2, 'Slim Fit Tee', 25.50, 'A classic slim fit t-shirt, soft cotton blend.');

INSERT INTO product (id, styleId, typeId, name, price, description)
VALUES (3, 3, 3, 'Regular Denim Jacket', 120.00, 'A timeless denim jacket for everyday wear.');

INSERT INTO productVariant (id, productId, color, size, stock)
VALUES (1, 1, 'Blue', 'M', 15);

INSERT INTO productVariant (id, productId, color, size, stock)
VALUES (2, 1, 'Black', 'L', 8);

INSERT INTO productVariant (id, productId, color, size, stock)
VALUES (3, 2, 'White', 'S', 20);

INSERT INTO productVariant (id, productId, color, size, stock)
VALUES (4, 3, 'Blue', 'XL', 5);

INSERT INTO productImage (id, productId, url, displayOrder)
VALUES (1, 1, 'https://example.com/images/baggy-jeans-1.jpg', 1);

INSERT INTO productImage (id, productId, url, displayOrder)
VALUES (2, 1, 'https://example.com/images/baggy-jeans-2.jpg', 2);

INSERT INTO productImage (id, productId, url, displayOrder)
VALUES (3, 2, 'https://example.com/images/slim-tee-1.jpg', 1);

INSERT INTO productImage (id, productId, url, displayOrder)
VALUES (4, 3, 'https://example.com/images/denim-jacket-1.jpg', 1);

INSERT INTO productReview (id, productId, rating, comment)
VALUES (1, 1, 4.5, 'Great fit, very comfortable for everyday wear.');

INSERT INTO productReview (id, productId, rating, comment)
VALUES (2, 1, 3.5, 'Good jeans but sizing runs a bit large.');

INSERT INTO productReview (id, productId, rating, comment)
VALUES (3, 2, 5.0, 'Perfect fit and great material quality.');

INSERT INTO productReview (id, productId, rating, comment)
VALUES (4, 3, 4.0, 'Solid jacket, a bit pricey but worth it.');