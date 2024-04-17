class User {
    name: string;
    email: string;

    constructor(name: string, email: string) {
        this.name = name;
        this.email = email;
    }

    validEmail() {
        const emailRegex = /^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,})$/;
        return emailRegex.test(this.email);
    }

    greeting() {
        if (!this.validEmail()) {
            throw new Error('This Email is not valid')
        }
        return `Willkommen auf der Webseite ${this.name} Sie sind angemeldet als ${this.email}`
    }
}

const details = new User('Example', 'example@example.com')
console.log(details.greeting());