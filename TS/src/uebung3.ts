import * as readline from 'readline';

class Person {
    name: string

    constructor() {
        this.name = '';
    }

    greetPerson() {
        const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });
        rl.question(('Wie ist dein name?'), name => {
            this.name = name;
            console.log(`Hallo ${this.name}`)
            rl.question('War diese Aufgabe lehrreich für dich= [j / n]', (response: string) => {
                if (response === 'j') {
                    console.log('super')
                } else {
                    console.log('Schade! :(')
                }
                rl.close()
            })
        })
    }
}

const person = new Person()
person.greetPerson();
