// Dummy data for the catalog
const catalog = [
    { id: 1, name: 'Product 1', price: 20 },
    { id: 2, name: 'Product 2', price: 30 },
    { id: 3, name: 'Product 3', price: 25 }
];

// Function to load the catalog
function loadCatalog() {
    const catalogContainer = document.getElementById('content');
    catalogContainer.innerHTML = '<h2>Catalog</h2>';
    catalog.forEach(product => {
        const productCard = document.createElement('div');
        productCard.classList.add('product-card');
        productCard.innerHTML = `
            <h3>${product.name}</h3>
            <p>$${product.price}</p>
            <button data-id="${product.id}">Add to Cart</button>
        `;
        catalogContainer.appendChild(productCard);
    });

    // Add event listeners for all 'Add to Cart' buttons
    catalogContainer.querySelectorAll('button').forEach(button => {
        button.addEventListener('click', (event) => {
            const productId = event.target.getAttribute('data-id');
            addToCart(productId);
        });
    });
}

// Function to add a product to the cart
function addToCart(productId) {
    // For demonstration, we just log the productId
    console.log(`Product ${productId} added to cart`);
    // You can add more functionality here, like updating a cart counter or saving to local storage
}

// Initial load
document.addEventListener('DOMContentLoaded', loadCatalog);