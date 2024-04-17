var User = /** @class */ (function () {
    function User(name, email) {
        this.name = name;
        this.email = email;
    }
    User.prototype.validEmail = function () {
        var emailRegex = /^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,})$/;
        return emailRegex.test(this.email);
    };
    User.prototype.greeting = function () {
        if (!this.validEmail()) {
            throw new Error('This Email is not valid');
        }
        return "Willkommen auf der Webseite ".concat(this.name, " Sie sind angemeldet als ").concat(this.email);
    };
    return User;
}());
var details = new User('Example', 'example@example.com');
console.log(details.greeting());
