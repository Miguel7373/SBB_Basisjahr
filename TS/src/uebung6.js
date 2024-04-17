var Product = /** @class */ (function () {
    function Product(name, price) {
        this.name = name;
        this.price = price;
    }
    return Product;
}());
var ShoppingCart = /** @class */ (function () {
    function ShoppingCart() {
        this.products = [];
    }
    ShoppingCart.prototype.addProducts = function (product) {
        this.products.push(product);
    };
    ShoppingCart.prototype.wholePrice = function () {
        var totalPrice = 0;
        for (var _i = 0, _a = this.products; _i < _a.length; _i++) {
            var product = _a[_i];
            totalPrice += product.price;
        }
        return totalPrice;
    };
    ShoppingCart.prototype.displayCart = function () {
        console.log("Products in shopping cart:");
        for (var _i = 0, _a = this.products; _i < _a.length; _i++) {
            var product = _a[_i];
            console.log("".concat(product.name, " - $").concat(product.price));
        }
    };
    return ShoppingCart;
}());
var shoppingCart = new ShoppingCart();
var firstProduct = new Product("Apple", 2);
var secondProduct = new Product("Pear", 3);
shoppingCart.addProducts(firstProduct);
shoppingCart.addProducts(secondProduct);
shoppingCart.displayCart();
console.log("This is the Total Price ".concat(shoppingCart.wholePrice()));
