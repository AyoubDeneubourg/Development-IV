const cookie = function ({ title, price, costPrice, size, weight }) {
  this.title = title;
  this.price = price;
  this.costPrice = costPrice;
  this.size = size;
  this.weight = weight;
};

//module.exports = cookie;
export default cookie;
