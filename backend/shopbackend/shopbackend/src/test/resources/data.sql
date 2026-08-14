-- =========================================================
-- DRESS STYLES
-- =========================================================

INSERT INTO dress_style (name) VALUES ('casual');
INSERT INTO dress_style (name) VALUES ('formal');
INSERT INTO dress_style (name) VALUES ('party');
INSERT INTO dress_style (name) VALUES ('gym');


-- =========================================================
-- DRESS TYPES
-- =========================================================

INSERT INTO dress_type (name) VALUES ('jeans');
INSERT INTO dress_type (name) VALUES ('T-Shirt');
INSERT INTO dress_type (name) VALUES ('Jacket');
INSERT INTO dress_type (name) VALUES ('Hoodie');
INSERT INTO dress_type (name) VALUES ('Shirt');
INSERT INTO dress_type (name) VALUES ('Shorts');
INSERT INTO dress_type (name) VALUES ('Sweatpants');
INSERT INTO dress_type (name) VALUES ('Dress');
INSERT INTO dress_type (name) VALUES ('Skirt');
INSERT INTO dress_type (name) VALUES ('Tracksuit');


-- =========================================================
-- PRODUCTS
-- =========================================================

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (1, 1, 'Baggy Jeans', 80.99,
        'Comfortable baggy fit jeans with a relaxed feel.',
        '2026-07-01 09:00:00', '2026-07-01 09:00:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (2, 2, 'Slim Fit Tee', 25.50,
        'A classic slim fit t-shirt made from a soft cotton blend.',
        '2026-07-05 14:30:00', '2026-07-05 14:30:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (3, 3, 'Regular Denim Jacket', 120.00,
        'A timeless denim jacket for everyday wear.',
        '2026-07-10 11:15:00', '2026-07-10 11:15:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (1, 1, 'Straight Leg Jeans', 69.99,
        'Classic straight leg jeans with a comfortable everyday fit.',
        '2026-07-12 10:20:00', '2026-07-12 10:20:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (3, 1, 'Distressed Jeans', 89.99,
        'Stylish distressed jeans with a modern party-ready look.',
        '2026-07-14 13:45:00', '2026-07-14 13:45:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (4, 1, 'Athletic Fit Jeans', 74.50,
        'Flexible denim jeans designed for an active and comfortable fit.',
        '2026-07-16 09:30:00', '2026-07-16 09:30:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (1, 2, 'Oversized T-Shirt', 29.99,
        'Relaxed oversized t-shirt made from soft cotton.',
        '2026-07-18 15:10:00', '2026-07-18 15:10:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (3, 2, 'Graphic Print T-Shirt', 35.00,
        'Trendy graphic print t-shirt designed for a stylish casual look.',
        '2026-07-20 11:25:00', '2026-07-20 11:25:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (4, 2, 'Performance T-Shirt', 32.50,
        'Lightweight breathable t-shirt suitable for workouts and training.',
        '2026-07-22 16:40:00', '2026-07-22 16:40:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (1, 3, 'Bomber Jacket', 135.99,
        'Lightweight bomber jacket with a modern casual design.',
        '2026-07-24 10:00:00', '2026-07-24 10:00:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (2, 3, 'Classic Blazer Jacket', 175.00,
        'Smart tailored blazer jacket suitable for formal occasions.',
        '2026-07-26 14:15:00', '2026-07-26 14:15:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (3, 3, 'Party Leather Jacket', 199.99,
        'Sleek leather-style jacket designed for parties and evening events.',
        '2026-07-28 12:35:00', '2026-07-28 12:35:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (4, 3, 'Training Jacket', 95.99,
        'Lightweight athletic jacket designed for warm-ups and outdoor training.',
        '2026-07-30 09:15:00', '2026-07-30 09:15:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (1, 4, 'Classic Pullover Hoodie', 65.99,
        'Soft fleece hoodie with a relaxed fit for everyday wear.',
        '2026-08-01 10:30:00', '2026-08-01 10:30:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (3, 4, 'Graphic Hoodie', 79.99,
        'Stylish graphic hoodie designed for a modern streetwear look.',
        '2026-08-02 13:20:00', '2026-08-02 13:20:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (4, 4, 'Training Hoodie', 72.50,
        'Comfortable lightweight hoodie suitable for warm-ups and training.',
        '2026-08-03 17:05:00', '2026-08-03 17:05:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (2, 5, 'Classic Formal Shirt', 59.99,
        'Smart button-up shirt suitable for formal and professional occasions.',
        '2026-08-04 09:45:00', '2026-08-04 09:45:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (1, 5, 'Casual Oxford Shirt', 54.99,
        'Versatile Oxford shirt that works well for casual everyday outfits.',
        '2026-08-05 11:15:00', '2026-08-05 11:15:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (3, 5, 'Party Print Shirt', 62.99,
        'Bold patterned shirt designed for parties and social events.',
        '2026-08-06 15:30:00', '2026-08-06 15:30:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (1, 6, 'Casual Chino Shorts', 45.99,
        'Lightweight chino shorts with a clean and versatile design.',
        '2026-08-07 10:00:00', '2026-08-07 10:00:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (3, 6, 'Denim Party Shorts', 49.99,
        'Stylish denim shorts suitable for casual parties and social events.',
        '2026-08-08 12:40:00', '2026-08-08 12:40:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (4, 6, 'Training Shorts', 39.99,
        'Lightweight athletic shorts designed for workouts and training.',
        '2026-08-09 08:30:00', '2026-08-09 08:30:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (1, 7, 'Relaxed Sweatpants', 59.99,
        'Comfortable relaxed-fit sweatpants suitable for everyday wear.',
        '2026-08-09 14:20:00', '2026-08-09 14:20:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (4, 7, 'Performance Sweatpants', 64.99,
        'Breathable sweatpants designed for workouts and active lifestyles.',
        '2026-08-10 09:10:00', '2026-08-10 09:10:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (3, 8, 'Evening Party Dress', 145.99,
        'Elegant party dress designed for evening events and celebrations.',
        '2026-08-10 13:45:00', '2026-08-10 13:45:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (2, 8, 'Formal Midi Dress', 159.99,
        'Elegant midi dress suitable for formal occasions and events.',
        '2026-08-11 10:25:00', '2026-08-11 10:25:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (3, 9, 'Pleated Party Skirt', 75.99,
        'Stylish pleated skirt designed for parties and evening occasions.',
        '2026-08-11 15:15:00', '2026-08-11 15:15:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (2, 9, 'Formal Pencil Skirt', 82.50,
        'Classic pencil skirt with a sophisticated formal design.',
        '2026-08-12 11:00:00', '2026-08-12 11:00:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (4, 10, 'Gym Training Tracksuit', 110.00,
        'Comfortable tracksuit designed for gym sessions and training.',
        '2026-08-12 14:30:00', '2026-08-12 14:30:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (1, 10, 'Casual Tracksuit', 99.99,
        'Comfortable tracksuit suitable for casual everyday activities.',
        '2026-08-13 09:15:00', '2026-08-13 09:15:00');


-- =========================================================
-- PRODUCT VARIANTS
-- =========================================================

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (1, 'Blue', 'M', 15);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (1, 'Black', 'L', 8);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (2, 'White', 'S', 20);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (3, 'Blue', 'XL', 5);


INSERT INTO product_variant (product_id, color, size, stock)
VALUES (4, 'Blue', 'S', 12);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (4, 'Black', 'M', 18);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (5, 'Light Blue', 'M', 14);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (5, 'Black', 'L', 9);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (6, 'Dark Blue', 'L', 11);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (6, 'Black', 'XL', 6);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (7, 'White', 'S', 20);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (7, 'Black', 'M', 15);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (8, 'Black', 'M', 12);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (8, 'White', 'L', 8);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (9, 'White', 'M', 18);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (9, 'Black', 'L', 15);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (10, 'Black', 'M', 7);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (10, 'Black', 'L', 10);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (11, 'Brown', 'M', 8);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (11, 'Black', 'L', 6);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (12, 'Black', 'M', 10);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (12, 'Navy', 'L', 12);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (13, 'Black', 'M', 15);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (13, 'Grey', 'L', 9);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (14, 'Black', 'M', 14);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (14, 'Grey', 'L', 10);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (15, 'Black', 'M', 12);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (15, 'White', 'L', 8);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (16, 'Grey', 'M', 10);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (16, 'Black', 'L', 7);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (17, 'White', 'M', 12);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (17, 'Blue', 'L', 8);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (18, 'Black', 'M', 15);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (18, 'White', 'L', 9);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (19, 'Red', 'M', 7);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (19, 'Black', 'L', 6);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (20, 'Khaki', 'M', 13);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (20, 'Black', 'L', 10);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (21, 'Black', 'S', 12);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (21, 'Blue', 'M', 15);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (22, 'Blue', 'M', 10);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (22, 'Black', 'L', 8);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (23, 'Grey', 'M', 15);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (23, 'Black', 'L', 10);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (24, 'Black', 'M', 8);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (24, 'Navy', 'L', 6);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (25, 'Red', 'M', 7);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (25, 'Black', 'L', 9);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (26, 'Black', 'M', 10);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (26, 'Grey', 'L', 8);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (27, 'Black', 'S', 12);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (27, 'Green', 'M', 10);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (28, 'Black', 'M', 14);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (28, 'Grey', 'L', 9);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (29, 'Black', 'M', 8);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (29, 'Navy', 'L', 7);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (30, 'Black', 'M', 12);

INSERT INTO product_variant (product_id, color, size, stock)
VALUES (30, 'Grey', 'L', 10);


-- =========================================================
-- PRODUCT IMAGES
-- =========================================================

INSERT INTO product_image (product_id, url, display_order)
VALUES (1, 'https://example.com/images/baggy-jeans-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (1, 'https://example.com/images/baggy-jeans-2.jpg', 2);

INSERT INTO product_image (product_id, url, display_order)
VALUES (2, 'https://example.com/images/slim-tee-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (3, 'https://example.com/images/denim-jacket-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (4, 'https://example.com/images/straight-jeans-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (5, 'https://example.com/images/distressed-jeans-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (6, 'https://example.com/images/athletic-jeans-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (7, 'https://example.com/images/oversized-tee-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (8, 'https://example.com/images/graphic-tee-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (9, 'https://example.com/images/performance-tee-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (10, 'https://example.com/images/bomber-jacket-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (11, 'https://example.com/images/blazer-jacket-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (12, 'https://example.com/images/leather-jacket-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (13, 'https://example.com/images/training-jacket-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (14, 'https://example.com/images/hoodie-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (15, 'https://example.com/images/graphic-hoodie-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (16, 'https://example.com/images/training-hoodie-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (17, 'https://example.com/images/formal-shirt-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (18, 'https://example.com/images/oxford-shirt-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (19, 'https://example.com/images/party-shirt-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (20, 'https://example.com/images/chino-shorts-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (21, 'https://example.com/images/denim-shorts-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (22, 'https://example.com/images/training-shorts-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (23, 'https://example.com/images/sweatpants-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (24, 'https://example.com/images/performance-sweatpants-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (25, 'https://example.com/images/party-dress-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (26, 'https://example.com/images/formal-dress-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (27, 'https://example.com/images/party-skirt-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (28, 'https://example.com/images/formal-skirt-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (29, 'https://example.com/images/gym-tracksuit-1.jpg', 1);

INSERT INTO product_image (product_id, url, display_order)
VALUES (30, 'https://example.com/images/casual-tracksuit-1.jpg', 1);


-- =========================================================
-- USERS
-- =========================================================

INSERT INTO app_user (
    username,
    email,
    password_hash,
    first_name,
    last_name,
    role
)
VALUES (
    'ThaboNkosi',
    'thabo.nkosi@example.com',
    '$2b$10$EVTefnKr1DBeXu6XOGXSduN8AAXWq87unyLRIHP3gyLvWZ0GTUOKa',
    'Thabo',
    'Nkosi',
    'admin'
);

INSERT INTO app_user (
    username,
    email,
    password_hash,
    first_name,
    last_name
)
VALUES (
    'LeratoDlamini',
    'lerato.dlamini@example.com',
    '$2b$10$o9wY00vo/.tT1N0rRijfNu05Csx4KyZgHoSr2f5X7XMLOTtjtOSga',
    'Lerato',
    'Dlamini'
);

INSERT INTO app_user (
    username,
    email,
    password_hash,
    first_name,
    last_name
)
VALUES (
    'SiphoMahlangu',
    'sipho.mahlangu@example.com',
    '$2b$10$FtZC50me.Gzbaf0dvBFTNuDYlnY9B8f.65oKdISqKRJ8OMZ/ZgvS.',
    'Sipho',
    'Mahlangu'
);


-- =========================================================
-- PRODUCT REVIEWS
-- =========================================================

INSERT INTO product_review (
    product_id, user_id, rating, comment, is_verified,
    created_at, updated_at
)
VALUES (
    1, 1, 4.5,
    'Great fit, very comfortable for everyday wear.',
    true,
    '2026-07-15 09:12:45',
    '2026-07-15 09:18:10'
);

INSERT INTO product_review (
    product_id, user_id, rating, comment, is_verified,
    created_at, updated_at
)
VALUES (
    1, 2, 3.5,
    'Good jeans but sizing runs a bit large.',
    false,
    '2026-07-18 14:27:03',
    '2026-07-18 15:01:42'
);

INSERT INTO product_review (
    product_id, user_id, rating, comment, is_verified,
    created_at, updated_at
)
VALUES (
    2, 3, 5.0,
    'Perfect fit and great material quality.',
    true,
    '2026-07-22 11:05:18',
    '2026-07-22 11:05:18'
);

INSERT INTO product_review (
    product_id, user_id, rating, comment, is_verified,
    created_at, updated_at
)
VALUES (
    3, 1, 4.0,
    'Solid jacket, a bit pricey but worth it.',
    false,
    '2026-07-28 18:44:56',
    '2026-07-29 08:13:27'
);

INSERT INTO product_review (
    product_id, user_id, rating, comment, is_verified,
    created_at, updated_at
)
VALUES (
    7, 2, 4.5,
    'Really comfortable and the oversized fit looks great.',
    true,
    '2026-07-25 12:10:00',
    '2026-07-25 12:10:00'
);

INSERT INTO product_review (
    product_id, user_id, rating, comment, is_verified,
    created_at, updated_at
)
VALUES (
    10, 3, 4.0,
    'Nice jacket with a good fit and quality finish.',
    true,
    '2026-08-01 16:20:00',
    '2026-08-01 16:20:00'
);

INSERT INTO product_review (
    product_id, user_id, rating, comment, is_verified,
    created_at, updated_at
)
VALUES (
    14, 1, 5.0,
    'Very warm and comfortable hoodie.',
    true,
    '2026-08-04 10:45:00',
    '2026-08-04 10:45:00'
);

INSERT INTO product_review (
    product_id, user_id, rating, comment, is_verified,
    created_at, updated_at
)
VALUES (
    17, 2, 4.0,
    'Looks professional and fits well.',
    true,
    '2026-08-06 13:30:00',
    '2026-08-06 13:30:00'
);

INSERT INTO product_review (
    product_id, user_id, rating, comment, is_verified,
    created_at, updated_at
)
VALUES (
    25, 3, 4.5,
    'Beautiful dress and perfect for an evening event.',
    true,
    '2026-08-09 18:15:00',
    '2026-08-09 18:15:00'
);

INSERT INTO product_review (
    product_id, user_id, rating, comment, is_verified,
    created_at, updated_at
)
VALUES (
    29, 1, 4.0,
    'Great tracksuit for gym sessions.',
    false,
    '2026-08-12 08:20:00',
    '2026-08-12 08:20:00'
);


-- =========================================================
-- SALES
-- =========================================================

INSERT INTO sale (
    user_id, product_id, variant_id, quantity,
    unit_price, total_price, sold_at
)
VALUES (
    1, 1, 1, 1,
    80.99, 80.99,
    '2026-07-16 10:30:00'
);

INSERT INTO sale (
    user_id, product_id, variant_id, quantity,
    unit_price, total_price, sold_at
)
VALUES (
    2, 2, 3, 2,
    25.50, 51.00,
    '2026-07-20 14:15:00'
);

INSERT INTO sale (
    user_id, product_id, variant_id, quantity,
    unit_price, total_price, sold_at
)
VALUES (
    3, 3, 4, 1,
    120.00, 120.00,
    '2026-07-25 11:45:00'
);

INSERT INTO sale (
    user_id, product_id, variant_id, quantity,
    unit_price, total_price, sold_at
)
VALUES (
    1, 2, 3, 1,
    25.50, 25.50,
    '2026-07-30 16:20:00'
);

INSERT INTO sale (
    user_id, product_id, variant_id, quantity,
    unit_price, total_price, sold_at
)
VALUES (
    2, 7, 8, 1,
    29.99, 29.99,
    '2026-08-01 09:30:00'
);

INSERT INTO sale (
    user_id, product_id, variant_id, quantity,
    unit_price, total_price, sold_at
)
VALUES (
    3, 10, 17, 1,
    135.99, 135.99,
    '2026-08-02 13:10:00'
);

INSERT INTO sale (
    user_id, product_id, variant_id, quantity,
    unit_price, total_price, sold_at
)
VALUES (
    1, 14, 25, 2,
    65.99, 131.98,
    '2026-08-04 15:45:00'
);

INSERT INTO sale (
    user_id, product_id, variant_id, quantity,
    unit_price, total_price, sold_at
)
VALUES (
    2, 17, 31, 1,
    59.99, 59.99,
    '2026-08-06 10:20:00'
);

INSERT INTO sale (
    user_id, product_id, variant_id, quantity,
    unit_price, total_price, sold_at
)
VALUES (
    3, 25, 47, 1,
    145.99, 145.99,
    '2026-08-09 18:40:00'
);

INSERT INTO sale (
    user_id, product_id, variant_id, quantity,
    unit_price, total_price, sold_at
)
VALUES (
    1, 29, 55, 1,
    110.00, 110.00,
    '2026-08-12 09:15:00'
);