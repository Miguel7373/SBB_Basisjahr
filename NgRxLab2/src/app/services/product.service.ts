import { Injectable } from '@angular/core';
import {ProductModel} from "../models/ProductModel";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor() { }

  private products:ProductModel[] = [
    { id: 1, name: 'Double BigMac', price: 100 },
    { id: 2, name: 'Quick Asian', price: 200 },
    { id: 3, name: 'Cheesy Fries', price: 50 },
    { id: 4, name: 'Veggie Wrap', price: 80 },
    { id: 5, name: 'Chicken Nuggets', price: 70 },
    { id: 6, name: 'Fish Fillet', price: 90 },
    { id: 7, name: 'Spicy Burger', price: 120 },
    { id: 8, name: 'Bacon Sandwich', price: 110 },
    { id: 9, name: 'Mango Smoothie', price: 60 },
    { id: 10, name: 'Caesar Salad', price: 130 },
    { id: 11, name: 'Chocolate Shake', price: 70 },
    { id: 12, name: 'Grilled Chicken', price: 140 },
    { id: 13, name: 'Tuna Sub', price: 150 },
    { id: 14, name: 'Beef Taco', price: 100 },
    { id: 15, name: 'Veggie Pizza', price: 160 },
    { id: 16, name: 'Hot Dog', price: 50 },
    { id: 17, name: 'Pasta Primavera', price: 180 },
    { id: 18, name: 'BLT Sandwich', price: 110 },
    { id: 19, name: 'Egg McMuffin', price: 90 },
    { id: 20, name: 'Fruit Salad', price: 70 },
    { id: 21, name: 'Vanilla Cone', price: 40 },
    { id: 22, name: 'Strawberry Sundae', price: 60 },
    { id: 23, name: 'Mozzarella Sticks', price: 80 },
    { id: 24, name: 'Beef Burrito', price: 140 },
    { id: 25, name: 'Chicken Caesar Wrap', price: 130 },
    { id: 26, name: 'Turkey Club', price: 150 },
    { id: 27, name: 'Philly Cheesesteak', price: 160 },
    { id: 28, name: 'BBQ Ribs', price: 200 },
    { id: 29, name: 'Shrimp Cocktail', price: 220 },
    { id: 30, name: 'Mushroom Swiss Burger', price: 170 }
  ];
  getProducts() {
    return this.products;
  }
}
