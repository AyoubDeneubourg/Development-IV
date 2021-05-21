//const pastryFactory = require("./factory/pastryFactory");

import pastryFactory from "./factory/pastryFactory.js";
import properties from "./factory/properties.js";

let croissant = document.getElementById('croissant');
let bread = document.getElementById('bread');
let cookie = document.getElementById('cookie');
let submitButton = document.getElementById('submit-button');

function bakePastries(amountOfCroissants, amountOfBreads, amountOfCookies) {

    pastryFactory.createPastry("croissant", amountOfCroissants, properties.getProperties("croissant"));
    pastryFactory.createPastry("bread", amountOfBreads, properties.getProperties("bread"));
    pastryFactory.createPastry("cookie", amountOfCookies, properties.getProperties("cookie"));

}

submitButton.addEventListener('click', () => {
    let amountOfCroissants = croissant.value;
    let amountOfBreads = bread.value;
    let amountOfCookies = cookie.value;
    bakePastries(amountOfCroissants, amountOfBreads, amountOfCookies);
});