import croissant from "./croissant.js";
import bread from "./bread.js";
import cookie from "./cookie.js";

const pastry = { croissant, bread, cookie };

//Returns random number between two given numbers
function randomWeight(min, max) {
  return Math.random() * (max - min) + min;
}

//Creates pastries and return the array of pastries
//Not a pure function because randomness is used

export default {
  createPastry(type, amount, attributes) {
    let arr = [];
    for (let i = 0; i < amount; i++) {
      const pastryType = pastry[type];
      attributes.weight =
        attributes.size == "X-Small"
          ? randomWeight(10, 15).toFixed(2)
          : randomWeight(20, 25).toFixed(2);
      arr.push(new pastryType(attributes));
    }
    return arr;
  },
};
