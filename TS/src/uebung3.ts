import * as readline from 'readline';

class Person {
    name: string

    constructor() {
        this.name = '';
    }

    greetPerson() {
        const readLine = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });
        readLine.question(('Wie ist dein name?'), name => {
            this.name = name;
            console.log(`Hallo ${this.name}`)
            readLine.question('War diese Aufgabe lehrreich für dich= [j / n]', (response: string) => {
                if (response === 'j') {
                    console.log('super')
                } else {
                    console.log('Schade! :(')
                }
                readLine.close();
            })
        })
    }
}

const person = new Person();
person.greetPerson();
