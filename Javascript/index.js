const pastryFactory = require("./factory/pastryFactory");

const myCroissant = pastryFactory.createPastry("croissant", {
    price: 1.10,
    costPrice: 0.20,
    sound: "test1",
    weight: 30
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
});

console.log(myCroissant);
console.log(myCookie);
console.log(myBread);
