"use strict";

import pastryFactory from "./factory/pastryFactory.js";
import properties from "./factory/properties.js";
import bubbleSort from "./algorithms/bubbleSort.js";

/* VARIABLES */

let croissantInput = document.getElementById("croissant");
let breadInput = document.getElementById("bread");
let cookieInput = document.getElementById("cookie");
let submitButton = document.getElementById("submit-button");
let croissantSizeInput = document.getElementById("croissantSize");
let breadSizeInput = document.getElementById("breadSize");
let cookieSizeInput = document.getElementById("cookieSize");
let sortButton = document.getElementById('sort-button');
let allCookies = [];
let allBreads = [];
let allCroissants = [];

/* FUNCTIONS */

//function which take the parameters to create a pastry, this function calls the pastry factory and a function to show the pastries

function bakePastry(array, pastry, amountOfPastries, inputSize) {
    array.push(
        ...pastryFactory.createPastry(
            pastry,
            amountOfPastries,
            properties.getProperties(pastry, inputSize)
        )
    );
    showPastries(array, `all-${pastry}`);
};

//function to reset the input fields
//side effects

function resetInputs() {
    let form = document.getElementById("form");
    form.reset();
};

//Get html of a single pastry card

function getPastryCard(pastry) {
    return `
  <div id="card">
    <div id="img-and-data">
        <div id="img">
        <img src="./assets/img/${pastry.name}.png">
        </div>

        <div id="data">
            <p id="title">${pastry.name}</p>
            <div id="size-and-weight">
                <p id="size">${pastry.size}</p>
                <p id="weight">${pastry.weight} gr</p>
            </div>
        </div>
    </div>
  </div>
  `
};

//function that will insert the data to the DOM, it takes an pastriesArray and a type (of pastry)

function showPastries(pastriesArray, type) {
    let pastryType = document.getElementById(type);
    pastryType.innerText = pastriesArray.length;
    pastriesArray.forEach((pastry) => {
        pastryType.insertAdjacentHTML("beforeend", getPastryCard(pastry));
    });
};

/* EVENT LISTENERS */

//Button to bake the pastries

submitButton.addEventListener("click", (e) => {
    e.preventDefault();
    bakePastry(allCroissants, "croissant", croissantInput.value, croissantSizeInput.value);
    bakePastry(allBreads, "bread", breadInput.value, breadSizeInput.value);
    bakePastry(allCookies, "cookie", cookieInput.value, cookieSizeInput.value);
    resetInputs();
});

//Button to sort the pastries

sortButton.addEventListener('click', () => {
    showPastries(bubbleSort(allCroissants), `all-croissant`);
    showPastries(bubbleSort(allBreads), `all-bread`);
    showPastries(bubbleSort(allCookies), `all-cookie`);
});