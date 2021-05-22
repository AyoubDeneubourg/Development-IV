/* const croissant = require("./croissant");
const bread = require("./bread");
const cookie = require("./cookie"); */
import croissant from "./croissant.js";
import bread from "./bread.js";
import cookie from "./cookie.js";

const pastry = { croissant, bread, cookie };

function randomWeight(min, max) {
    return Math.random() * (max - min) + min;
}

export default {
    createPastry(type, amount, attributes) {
        let arr = [];
        for (let i = 0; i < amount; i++) {
            const pastryType = pastry[type];
            attributes.weight = randomWeight(10, 15).toFixed(2);
            arr.push(new pastryType(attributes));
        }
        console.log(arr);
        return arr;
        //return new pastryType(attributes);
    }
};


/* const myCroissant = pastryFactory.createPastry("croissant", 10, {
    price: 1.10,
    costPrice: 0.20,
    sound: "test1"
});

 const myCookie = pastryFactory.createPastry("cookie", {
    price: 1.80,
    costPrice: 0.110,
    sound: "test2",
    weight: 15
});

const myBread = pastryFactory.createPastry("bread", {
    price: 1.80,
    costPrice: 0.30,
    sound: "test3",
    weight: 50
}); */