class Product {
    name: string;
    price: number;

    constructor(name: string, price: number) {
        this.name = name
        this.price = price
    }
}

class ShoppingCart {
    products: Product[];

    constructor() {
        this.products = []
    }

    addProducts(product: Product) {
        this.products.push(product)
    }

    wholePrice() {
        let totalPrice = 0;
        for (const product of this.products) {
            totalPrice += product.price;
        }
        return totalPrice;
    }

    displayCart() {
        console.log("Products in shopping cart:")
        for (const product of this.products) {
            console.log(`${product.name} - $${product.price}`)
        }
    }
}

const shoppingCart = new ShoppingCart();

const firstProduct = new Product("Apple", 2);
const secondProduct = new Product("Pear", 3);

shoppingCart.addProducts(firstProduct);
shoppingCart.addProducts(secondProduct);

shoppingCart.displayCart()
console.log(`This is the Total Price ${shoppingCart.wholePrice()}`)