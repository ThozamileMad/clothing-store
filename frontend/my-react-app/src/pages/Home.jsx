import "../styles/home.css";

import heroImage from "../assets/home/hero-2-no-bg.png";

import versaceImage from "../assets/home/brands/versace.png";
import zaraImage from "../assets/home/brands/zara.png";
import gucciImage from "../assets/home/brands/gucci.png";
import pradaImage from "../assets/home/brands/prada.png";
import calvinKleinImage from "../assets/home/brands/calvin-klein.png";

import checkeredShirt from "../assets/home/products/checkered-shirt.png";
import fadedSkinnyJeans from "../assets/home/products/faded-skinny-jeans.png";
import tShirtWithTapeDetails from "../assets/home/products/t-shirt-with-tape-details.png";
import sleeveStripedTShirt from "../assets/home/products/sleeve-striped-t-shirt.png";
import courageGraphicTShirt from "../assets/home/products/courage-graphic-t-shirt.png";
import looseFitBermudaShorts from "../assets/home/products/loose-fit-bermuda-shorts.png";

import casualImage from "../assets/home/categories/casual.png";
import formalImage from "../assets/home/categories/formal.png";
import partyImage from "../assets/home/categories/party.png";
import gymImage from "../assets/home/categories/gym.png";

import { NavLink } from "react-router-dom";

const PRODUCTS = [
  {
    id: 1,
    name: "Checkered Shirt",
    image: checkeredShirt,
    rating: 4.5,
    numberOfRatings: 238,
    price: 599.99,
  },
  {
    id: 2,
    name: "Faded Skinny Jeans",
    image: fadedSkinnyJeans,
    rating: 4.8,
    numberOfRatings: 512,
    price: 299.99,
  },
  {
    id: 3,
    name: "T-shirt with Tape Details",
    image: tShirtWithTapeDetails,
    rating: 4.3,
    numberOfRatings: 184,
    price: 899.99,
  },
  {
    id: 4,
    name: "Sleeve Striped T-shirt",
    image: sleeveStripedTShirt,
    rating: 4.7,
    numberOfRatings: 329,
    price: 749.99,
  },
  {
    id: 5,
    name: "Courage Graphic T-shirt",
    image: courageGraphicTShirt,
    rating: 4.4,
    numberOfRatings: 97,
    price: 499.99,
  },
  {
    id: 6,
    name: "Loose Fit Bermuda Shorts",
    image: looseFitBermudaShorts,
    rating: 4.9,
    numberOfRatings: 641,
    price: 249.99,
  },
];

const BRAND_IMAGES = [
  { className: "versace", image: versaceImage },
  { className: "zara", image: zaraImage },
  { className: "gucci", image: gucciImage },
  { className: "prada", image: pradaImage },
  { className: "calvin-klein", image: calvinKleinImage },
];

const CATEGORY_NAMES = ["Casual", "Formal", "Party", "Gym"];

const CATEGORY_IMAGES = [casualImage, formalImage, partyImage, gymImage];

const REVIEWS = [
  {
    username: "Alex K.",
    rating: 3,
    comment:
      "Finding clothes that match my personal style has always been difficult, but this store nailed it 🔥 The hoodie quality is amazing!",
    verified: true,
  },
  {
    username: "Sarah M.",
    rating: 4.5,
    comment:
      "Absolutely love this dress 😍 The material feels premium and the fitting is perfect.",
    verified: true,
  },
  {
    username: "Jordan P.",
    rating: 3.5,
    comment:
      "The design is nice but the sizing was slightly smaller than expected.",
    verified: false,
  },
  {
    username: "Mia R.",
    rating: 5,
    comment:
      "Great quality jeans 👌 They feel durable and look exactly like the pictures.",
    verified: true,
  },
  {
    username: "David L.",
    rating: 5,
    comment: "Best purchase I've made this month 😂🔥 Definitely buying more!",
    verified: true,
  },
];

const Home = () => {
  const showProductList = (list) => {
    return list.map((p, index) => (
      <div key={index} className="product-card">
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
          <span className="product-card-number-rating">{p.rating || 0}/5</span>
        </div>

        <span className="product-card-price">R {p.price || 0}</span>
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
                <button className="nav-dropdown-btn" type="button">
                  Shop <i className="fa-solid fa-chevron-down"></i>
                </button>
              </li>
              <li className="nav-link">
                <NavLink to="#">On Sale</NavLink>
              </li>
              <li className="nav-link">
                <NavLink to="#">New Arrivals</NavLink>
              </li>
              <li className="nav-link">
                <NavLink to="#">Brands</NavLink>
              </li>
            </ul>

            {/* Search Bar */}
            <form id="nav-search-form" onSubmit={() => {}} noValidate>
              <div className="nav-search-form-icon-container">
                <i className="fa-brands fa-sistrix"></i>
              </div>

              <input
                type="text"
                id="navSearchBar"
                name="navSearchBar"
                placeholder="Search for products..."
              ></input>
            </form>

            {/* Navigation Icons */}
            <div className="nav-icons">
              <NavLink to="#">
                <i className="fa-solid fa-cart-shopping"></i>
              </NavLink>
              <NavLink to="#">
                <i className="fa-solid fa-circle-user"></i>
              </NavLink>
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
              <div className="hero-stat-divider"></div>
              <div className="hero-stat-item high-quality-products">
                <h2>2000+</h2>
                <p>High Quality Products</p>
              </div>
              <div className="hero-stat-divider"></div>
              <div className="hero-stat-item happy-customers">
                <h2>30000+</h2>
                <p>Happy Customers</p>
              </div>
            </div>
          </div>

          {/* Hero Second Section */}
          <div className="hero-section-2">
            <img className="hero-image" src={heroImage} alt="hero-image"></img>
          </div>
        </div>

        {/* Brand Associations */}
        <div className="brand-associations">
          {BRAND_IMAGES.map((b, index) => (
            <img
              key={index}
              className={`brand-association-image ${b.className || ""}`}
              src={b.image || null}
              alt="brand-association-image"
            ></img>
          ))}
        </div>
      </section>

      {/* New Products */}
      <section id="new-arrivals">
        <h1 className="product-title">NEW ARRIVALS</h1>
        <div className="product-list">{showProductList(PRODUCTS)}</div>
        <div className="product-view-more-btn-container">
          <button type="button" className="product-view-more-btn">
            View More
          </button>
        </div>
      </section>

      <hr></hr>

      {/* Products with the most sales */}
      <section id="top-selling">
        <h1 className="product-title">TOP SELLING</h1>
        <div className="product-list">{showProductList(PRODUCTS)}</div>
        <div className="product-view-more-btn-container">
          <button type="button" className="product-view-more-btn">
            View More
          </button>
        </div>
      </section>

      {/* Procuct Categories */}
      <section id="categories">
        <h1 className="catagories-title">BROWSE BY DRESS STYLE</h1>

        {/* All Categories */}
        <div className="catagory-list">
          {CATEGORY_IMAGES.map((c, index) => (
            <div
              key={index}
              className="catagory-item"
              style={{
                background: `url(${c})`,
                backgroundRepeat: "no-repeat",
                backgroundPosition: "center",
                backgroundSize: "cover",
              }}
            >
              <h3 className="catagory-name">{CATEGORY_NAMES[index]}</h3>
            </div>
          ))}
        </div>
      </section>

      <section id="reviews">
        <div className="reviews-title-and-buttons">
          <h1 className="reviews-title">OUR HAPPY CUSTOMERS</h1>
          <div className="reviews-buttons">
            <button
              className="reviews-button-left"
              type="button"
              onClick={() => {}}
            >
              <i className="fa-solid fa-arrow-left"></i>
            </button>
            <button
              className="reviews-button-right"
              type="button"
              onClick={() => {}}
            >
              <i className="fa-solid fa-arrow-right"></i>
            </button>
          </div>
        </div>

        <div className="reviews-list">
          {REVIEWS.map((r, index) => (
            <div key={index} className="review-card">
              {/* Review Ratings */}
              <div className="review-card-star-ratings">
                {/* Review Full Stars */}
                {Array(Math.floor(parseFloat(r.rating))).fill(
                  <i className="fa-solid fa-star"></i>,
                )}

                {/* Review Half Star */}
                {parseFloat(r.rating) % 1 > 0.4 ? (
                  <i className="fa-solid fa-star-half"></i>
                ) : null}
              </div>

              <div className="review-card-username-and-verified">
                <h4>{r.username}</h4>
                {r.verified ? (
                  <i className="fa-solid fa-circle-check"></i>
                ) : null}
              </div>

              <p className="review-card-comment">{r.comment}</p>
            </div>
          ))}
        </div>
      </section>

      <section id="newsletter-subscription">
        <h1 className="newsletter-subscription-title">
          STAY UP TO DATE ABOUT OUR LATEST OFFERS
        </h1>
        <form id="newsletter-subscription-form" onSubmit={() => {}} noValidate>
          <div className="newsletter-form-field">
            <i class="fa-regular fa-envelope"></i>
            <input
              type="email"
              id="newsLetterEmail"
              name="newsLetterEmail"
              placeholder="Enter your email address"
            ></input>
          </div>
          <button id="newsLetterSubmitButton" type="submit">
            Subscribe to Newsletter
          </button>
        </form>
      </section>

      <footer>
        <div className="footer-links">
          <div className="footer-brand-description-and-socials">
            <h1 className="footer-brand-name">SHOP.CO</h1>
            <p className="footer-brand-description">
              We have clothes that suits your style and which you’re proud to
              wear. From women to men.
            </p>
            <div className="footer-social-links">
              <a href="#" className="footer-social-link">
                <i className="fa-brands fa-x-twitter"></i>
              </a>
              <a href="#" className="footer-social-link">
                <i className="fa-brands fa-facebook-f"></i>
              </a>
              <a href="#" className="footer-social-link">
                <i className="fa-brands fa-instagram"></i>
              </a>
              <a href="#" className="footer-social-link">
                <i className="fa-brands fa-youtube"></i>
              </a>
            </div>
          </div>

          <div className="footer-company-links">
            <NavLink className="footer-link" to="#">
              About
            </NavLink>
            <NavLink className="footer-link" to="#">
              Features
            </NavLink>
            <NavLink className="footer-link" to="#">
              Works
            </NavLink>
            <NavLink className="footer-link" to="#">
              Career
            </NavLink>
          </div>

          <div className="footer-help-links">
            <NavLink className="footer-link" to="#">
              Customer Support
            </NavLink>
            <NavLink className="footer-link" to="#">
              Delivery Details
            </NavLink>
            <NavLink className="footer-link" to="#">
              Terms &AMP Conditions
            </NavLink>
            <NavLink className="footer-link" to="#">
              Privacy Policy
            </NavLink>
          </div>

          <div className="footer-faqs-links">
            <NavLink className="footer-link" to="#">
              Account
            </NavLink>
            <NavLink className="footer-link" to="#">
              Manage Deliveries
            </NavLink>
            <NavLink className="footer-link" to="#">
              Orders
            </NavLink>
            <NavLink className="footer-link" to="#">
              Payments
            </NavLink>
          </div>

          <div className="footer-resources-links">
            <NavLink className="footer-link" to="#">
              Free eBooks
            </NavLink>
            <NavLink className="footer-link" to="#">
              Development Tutorial
            </NavLink>
            <NavLink className="footer-link" to="#">
              How to Blog
            </NavLink>
            <NavLink className="footer-link" to="#">
              YouTube Playlist
            </NavLink>
          </div>
        </div>
        <hr></hr>
        <p className="footer-copyright-notice">
          Clothify © {new Date().getFullYear()} All Rights Reserved.
        </p>
      </footer>
    </main>
  );
};

export default Home;
