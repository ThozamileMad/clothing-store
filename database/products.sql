-- ============================================
-- Dress Styles
-- ============================================
CREATE TABLE dress_styles (
    id      SERIAL PRIMARY KEY,
    name    TEXT UNIQUE NOT NULL
);

-- ============================================
-- Dress Types
-- ============================================
CREATE TABLE dress_types (
    id      SERIAL PRIMARY KEY,
    name    TEXT UNIQUE NOT NULL
);

-- ============================================
-- Products
-- ============================================
CREATE TABLE products (
    id             SERIAL PRIMARY KEY,
    style_id       INT NOT NULL REFERENCES dress_styles(id),
    type_id        INT NOT NULL REFERENCES dress_types(id),
    name           TEXT UNIQUE NOT NULL,
    price          DECIMAL(10,2) NOT NULL,
    description    TEXT,
    created_at     TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at     TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

-- ============================================
-- Product Variants
-- (Color + Size + Stock)
-- ============================================
CREATE TABLE product_variants (
    id            SERIAL PRIMARY KEY,
    product_id    INT NOT NULL REFERENCES products(id) ON DELETE CASCADE,
    color         TEXT NOT NULL,
    size          TEXT NOT NULL,
    stock         INT NOT NULL DEFAULT 0,

    CONSTRAINT size_check CHECK (
        size IN (
            'XXS',
            'XS',
            'S',
            'M',
            'L',
            'XL',
            'XXL'
        )
    )
);

-- ============================================
-- Product Images
-- ============================================
CREATE TABLE product_images (
    id              SERIAL PRIMARY KEY,
    product_id      INT NOT NULL REFERENCES products(id) ON DELETE CASCADE,
    url             TEXT NOT NULL,
    display_order   INT NOT NULL DEFAULT 1
);

-- ============================================
-- Product Reviews
-- ============================================
CREATE TABLE product_reviews (
    id            SERIAL PRIMARY KEY,
    product_id    INT NOT NULL REFERENCES products(id) ON DELETE CASCADE,
    -- user_id     INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    rating        DECIMAL(2,1) NOT NULL,
    comment       TEXT,
    created_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT rating_check CHECK (rating BETWEEN 1 AND 5)
);