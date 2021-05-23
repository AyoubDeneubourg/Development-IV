"use strict";

//const pastryFactory = require("./factory/pastryFactory");

import pastryFactory from "./factory/pastryFactory.js";
import properties from "./factory/properties.js";
import bubbleSort from "./algorithms/bubbleSort.js";

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

function bakePastry(array, pastry, amountOfPastries, inputSize) {
    array.push(
        ...pastryFactory.createPastry(
            pastry,
            amountOfPastries,
            properties.getProperties(pastry, inputSize)
        )
    )
    showPastry(array, `all-${pastry}`);
}

function resetInputs() {
    let form = document.getElementById("form");
    form.reset();
}

function showPastry(elements, type) {
    let pastryType = document.getElementById(type);
    pastryType.innerText = elements.length;
    elements.forEach((element) => {
        pastryType.insertAdjacentHTML("beforeend", getPastryCard(element));
    });
}

function getPastryCard(element) {
    return `
  <div id="card">
    <div id="img-and-data">
        <div id="img">
        <img src="./assets/img/${element.title}.png">
        </div>

        <div id="data">
            <p id="title">${element.title}</p>
            <div id="size-and-weight">
                <p id="size">${element.size}</p>
                <p id="weight">${element.weight}</p>
            </div>
        </div>
    </div>
  </div>
  `
}

submitButton.addEventListener("click", (e) => {
    e.preventDefault();
    bakePastry(allCroissants, "croissant", croissantInput.value, croissantSizeInput.value);
    bakePastry(allBreads, "bread", breadInput.value, breadSizeInput.value);
    bakePastry(allCookies, "cookie", cookieInput.value, cookieSizeInput.value);
    resetInputs();
});

sortButton.addEventListener('click', () => {
    showPastry(bubbleSort(allCroissants), `all-croissant`);
    showPastry(bubbleSort(allBreads), `all-bread`);
    showPastry(bubbleSort(allCookies), `all-cookie`);
});
