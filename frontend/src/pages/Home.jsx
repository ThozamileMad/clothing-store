import "../styles/home.css";
import versaceImage from "../assets/home/versace.png";
import zaraImage from "../assets/home/zara.png";
import gucciImage from "../assets/home/gucci.png";
import pradaImage from "../assets/home/prada.png";
import calvinKleinImage from "../assets/home/calvin-klein.png";
import { NavLink } from "react-router-dom";

const PRODUCTS = [
  {
    id: 1,
    name: "Classic Black Hoodie",
    image: "https://images.unsplash.com/photo-1556821840-3a63f95609a7",
    rating: 4.5,
    numberOfRatings: 238,
    price: 599.99,
  },
  {
    id: 2,
    name: "Oversized White T-Shirt",
    image: "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab",
    rating: 4.8,
    numberOfRatings: 512,
    price: 299.99,
  },
  {
    id: 3,
    name: "Denim Jacket",
    image: "https://images.unsplash.com/photo-1551537482-f2075a1d41f2",
    rating: 4.3,
    numberOfRatings: 184,
    price: 899.99,
  },
  {
    id: 4,
    name: "Streetwear Hoodie",
    image: "https://images.unsplash.com/photo-1578681994506-b8f463449011",
    rating: 4.7,
    numberOfRatings: 329,
    price: 749.99,
  },
  {
    id: 5,
    name: "Casual Grey Sweatshirt",
    image: "https://images.unsplash.com/photo-1620799140408-edc6dcb6d633",
    rating: 4.4,
    numberOfRatings: 97,
    price: 499.99,
  },
  {
    id: 6,
    name: "Minimalist Black T-Shirt",
    image: "https://images.unsplash.com/photo-1503342217505-b0a15ec3261c",
    rating: 4.9,
    numberOfRatings: 641,
    price: 249.99,
  },
];

const BRANDS_IMAGES = [
  versaceImage,
  zaraImage,
  gucciImage,
  pradaImage,
  calvinKleinImage,
];

const Home = () => {
  const showProductList = (list) => {
    return list.map((p, index) => (
      <div key={index} className="product-list">
        {/* Product Item */}
        <div className="product-card">
          {/* Product Image */}
          <div className="product-card-image-container">
            {p.image ? (
              <img
                className="product-card-image"
                src={p.image || null}
                alt="product-card-image"
              ></img>
            ) : (
              <i class="fa-solid fa-image"></i>
            )}
          </div>

          {/* Product Name */}
          <h3 className="product-card-name">{p.name || "N/A"}</h3>

          {/* Product Ratings */}
          <div className="product-card-ratings">
            {/* Product Star Ratings */}
            <div className="product-card-star-rating">
              {/* Product Full Stars */}
              {Array(Math.floor(parseFloat(p.rating))).fill(
                <i className="fa-solid fa-star"></i>,
              )}

              {/* Product Half Star */}
              {parseFloat(p.rating) % 1 > 0.4 ? (
                <i className="fa-solid fa-star-half"></i>
              ) : null}
            </div>

            {/* Product Number Ratng */}
            <span className="product-card-number-rating">
              {p.rating || 0}/5
            </span>
          </div>

          <span className="product-card-price">R {p.price || 0}</span>
        </div>
      </div>
    ));
  };

  return (
    <main id="home">
      <section id="introduction">
        {/* Navigation Bar */}
        <header>
          <nav className="nav-bar">
            {/* Brand Name */}
            <h1 className="brand-name">SHOP.CO</h1>

            {/* Navigation Links */}
            <ul className="nav-links">
              <li className="nav-link">
                Shop <i className="fa-solid fa-chevron-down"></i>
              </li>
              <li className="nav-link">On Sale</li>
              <li className="nav-link">New Arrivals</li>
              <li className="nav-link">Brands</li>
            </ul>

            {/* Search Bar */}
            <form id="nav-search-form" onSubmit={() => {}} noValidate>
              <i className="fa-brands fa-sistrix"></i>
              <input
                type="text"
                id="navSearchBar"
                name="navSearchBar"
                placeholder="Search for products..."
              ></input>
            </form>

            {/* Navigation Icons */}
            <div className="nav-icons">
              <i className="fa-solid fa-cart-shopping"></i>
              <i className="fa-solid fa-circle-user"></i>
            </div>
          </nav>
        </header>

        {/* Hero */}
        <div className="hero">
          {/* Hero First Section */}
          <div className="hero-section-1">
            {/* Hero Text */}
            <h1 className="hero-title">FIND CLOTHES THAT MATCHES YOUR STYLE</h1>
            <p className="hero-description">
              Browse through our diverse range of meticulously crafted garments,
              designed to bring out your individuality and cater to your sense
              of style.
            </p>

            {/* Hero Action Button */}
            <button className="hero-btn">Show Now</button>

            {/* Hero Statistics */}
            <div className="hero-stats">
              <div className="hero-stat-item international-brands">
                <h2>200+</h2>
                <p>International Brands</p>
              </div>
              <div className="hero-stat-item high-quality-products">
                <h2>2000+</h2>
                <p>High Quality Products</p>
              </div>
              <div className="hero-stat-item happy-customers">
                <h2>30000+</h2>
                <p>Happy Customers</p>
              </div>
            </div>
          </div>

          {/* Hero Second Section */}
          <div className="hero-section-2">
            <img className="hero-image" src="" alt="hero-image"></img>
          </div>
        </div>

        {/* Brand Associations */}
        <div className="brand-associations">
          {BRANDS_IMAGES.map((b, index) => (
            <img
              key={index}
              className="brand-association-image"
              src={b || null}
              alt="brand-association-image"
            ></img>
          ))}
        </div>
      </section>

      {/* New Products */}
      <section id="new-arrivals">
        <h1 className="product-title">NEW ARRIVALS</h1>
        {showProductList(PRODUCTS)}
        <button type="button" className="product-view-more-btn">
          View More
        </button>
      </section>

      <hr></hr>

      {/* Products with the most sales */}
      <section className="top-selling">
        <h1 className="product-title">TOP SELLING</h1>
        {showProductList(PRODUCTS)}
        <button type="button" className="product-view-more-btn">
          View More
        </button>
      </section>

      <section id="categories">
        <h1 className="catagories-title">BROWSE BY DRESS STYLE</h1>
        <div className="catagory-list">
          <div className="catagory-item" style={{
            background: `url(${})`
          }}>
            <h3 className="catagory-name"></h3>
          </div>
        </div>
      </section>
    </main>
  );
};

export default Home;
