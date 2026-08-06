INSERT INTO dress_style (name) VALUES ('casual');
INSERT INTO dress_style (name) VALUES ('formal');
INSERT INTO dress_style (name) VALUES ('party');
INSERT INTO dress_style (name) VALUES ('gym');


INSERT INTO dress_type (name) VALUES ('jeans');
INSERT INTO dress_type (name) VALUES ('T-Shirt');
INSERT INTO dress_type (name) VALUES ('Jacket');


INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (1, 1, 'Baggy Jeans', 80.99, 'Comfortable baggy fit jeans with a relaxed feel.', '2026-07-01 09:00:00', '2026-07-01 09:00:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (2, 2, 'Slim Fit Tee', 25.50, 'A classic slim fit t-shirt, soft cotton blend.', '2026-07-05 14:30:00', '2026-07-05 14:30:00');

INSERT INTO product (style_id, type_id, name, price, description, created_at, updated_at)
VALUES (3, 3, 'Regular Denim Jacket', 120.00, 'A timeless denim jacket for everyday wear.', '2026-07-10 11:15:00', '2026-07-10 11:15:00');

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

INSERT INTO app_user (username, email, password_hash, first_name, last_name, role) 
VALUES ('ThaboNkosi', 'thabo.nkosi@example.com', '$2b$10$EVTefnKr1DBeXu6XOGXSduN8AAXWq87unyLRIHP3gyLvWZ0GTUOKa', 'Thabo', 'Nkosi', 'admin');

INSERT INTO app_user (username, email, password_hash, first_name, last_name) 
VALUES ('LeratoDlamini', 'lerato.dlamini@example.com', '$2b$10$o9wY00vo/.tT1N0rRijfNu05Csx4KyZgHoSr2f5X7XMLOTtjtOSga', 'Lerato', 'Dlamini');

INSERT INTO app_user (username, email, password_hash, first_name, last_name) 
VALUES ('SiphoMahlangu', 'sipho.mahlangu@example.com', '$2b$10$FtZC50me.Gzbaf0dvBFTNuDYlnY9B8f.65oKdISqKRJ8OMZ/ZgvS.', 'Sipho', 'Mahlangu');

INSERT INTO product_review (
    product_id,
    user_id,
    rating,
    comment,
    created_at,
    updated_at
)
VALUES (
    1,
    1,
    4.5,
    'Great fit, very comfortable for everyday wear.',
    '2026-07-15 09:12:45',
    '2026-07-15 09:18:10'
);

INSERT INTO product_review (
    product_id,
    user_id,
    rating,
    comment,
    created_at,
    updated_at
)
VALUES (
    1,
    2,
    3.5,
    'Good jeans but sizing runs a bit large.',
    '2026-07-18 14:27:03',
    '2026-07-18 15:01:42'
);

INSERT INTO product_review (
    product_id,
    user_id,
    rating,
    comment,
    created_at,
    updated_at
)
VALUES (
    2,
    3,
    5.0,
    'Perfect fit and great material quality.',
    '2026-07-22 11:05:18',
    '2026-07-22 11:05:18'
);

INSERT INTO product_review (
    product_id,
    user_id,
    rating,
    comment,
    created_at,
    updated_at
)
VALUES (
    3,
    1,
    4.0,
    'Solid jacket, a bit pricey but worth it.',
    '2026-07-28 18:44:56',
    '2026-07-29 08:13:27'
);

INSERT INTO sale (user_id, product_id, variant_id, quantity, unit_price, total_price)
VALUES (1, 1, 1, 1, 80.99, 80.99);

INSERT INTO sale (user_id, product_id, variant_id, quantity, unit_price, total_price)
VALUES (2, 2, 3, 2, 25.50, 51.00);

INSERT INTO sale (user_id, product_id, variant_id, quantity, unit_price, total_price)
VALUES (3, 3, 4, 1, 120.00, 120.00);

INSERT INTO sale (user_id, product_id, variant_id, quantity, unit_price, total_price)
VALUES (1, 2, 3, 1, 25.50, 25.50);