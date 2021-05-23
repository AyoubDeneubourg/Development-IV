const bread = function ({ title, price, costPrice, size, weight }) {
  this.title = title;
  this.price = price;
  this.costPrice = costPrice;
  this.size = size;
  this.weight = weight;
};

//module.exports = bread;
export default bread;
