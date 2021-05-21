const croissant = function ({ price, costPrice, sound, weight }) {
    this.price = price;
    this.costPrice = costPrice;
    this.sound = sound;
    this.weight = weight;
};

module.exports = croissant;