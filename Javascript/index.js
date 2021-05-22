"use strict";

//const pastryFactory = require("./factory/pastryFactory");

import pastryFactory from "./factory/pastryFactory.js";
import properties from "./factory/properties.js";

let croissantInput = document.getElementById("croissant");
let breadInput = document.getElementById("bread");
let cookieInput = document.getElementById("cookie");
let submitButton = document.getElementById("submit-button");

let croissantSizeInput = document.getElementById("croissantSize");
let breadSizeInput = document.getElementById("breadSize");
let cookieSizeInput = document.getElementById("cookieSize");

let allCookies = [];
let allBreads = [];
let allCroissants = [];

function bakePastries(
  amountOfCroissants,
  amountOfBreads,
  amountOfCookies,
  croissantSizeInput,
  breadInput,
  cookieSizeInput
) {
  allCroissants.push(
    ...pastryFactory.createPastry(
      "croissant",
      amountOfCroissants,
      properties.getProperties("croissant", croissantSizeInput)
    )
  );

  allBreads.push(
    ...pastryFactory.createPastry(
      "bread",
      amountOfBreads,
      properties.getProperties("bread", breadInput)
    )
  );
  allCookies.push(
    ...pastryFactory.createPastry(
      "cookie",
      amountOfCookies,
      properties.getProperties("cookie", cookieSizeInput)
    )
  );

  showUser(bubbleSort(allCroissants), "allCroissants");
  showUser(bubbleSort(allBreads), "allBreads");
  showUser(bubbleSort(allCookies), "allCookies");
}

submitButton.addEventListener("click", (e) => {
  e.preventDefault();
  bakePastries(
    croissantInput.value,
    breadInput.value,
    cookieInput.value,
    croissantSizeInput.value,
    breadSizeInput.value,
    cookieSizeInput.value
  );
  resetInputs();
});

function resetInputs() {
  let form = document.getElementById("form");
  form.reset();
}

function bubbleSort(unsortedPastry) {
  unsortedPastry.forEach((pastry, index) => {
    let nextPastry =
      index === unsortedPastry.length - 1
        ? unsortedPastry[index]
        : unsortedPastry[index + 1];
    if (pastry.weight > nextPastry.weight) {
      let temp = unsortedPastry[index];
      unsortedPastry[index] = unsortedPastry[index + 1];
      unsortedPastry[index + 1] = temp;
      bubbleSort(unsortedPastry);
    }
  });

  return unsortedPastry;
}

function showUser(elements, type) {
  let pastryType = document.getElementById(type);
  pastryType.innerText = elements.length;
  elements.forEach((element) => {
    pastryType.insertAdjacentHTML("beforeend", getPastryCard(element));
  });
}

function getPastryCard(element) {
  return `
  <div id="card">
  ${element.size}  ${element.title} die  ${element.weight}  gr weegt.
  </div>`;
}

function getWeightRange(weight) {
  if (weight <= 11) {
    console.log("weight 1" + weight);
    return 10;
  } else if (weight <= 11) {
    console.log("weight 2" + weight);
    return 11;
  } else if (weight <= 12) {
    console.log("weight 3" + weight);
    return 12;
  } else if (weight <= 13) {
    console.log("weight 4" + weight);
    return 13;
  } else if (weight <= 14) {
    console.log("weight 5" + weight);
    return 14;
  } else {
    return 15;
  }
  console.log(arr);
}
