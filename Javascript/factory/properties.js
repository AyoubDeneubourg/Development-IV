export default {

  //Will return data depending of input received
  //pure function

  getProperties(pastry, size) {
    if (pastry == "croissant") {
      return {
        name: "Croissant",
        price: 1.2,
        costPrice: 0.2,
        size: size === "XL" || size === "xl" ? "X-Large" : "X-Small",
      };
    } else if (pastry == "bread") {
      return {
        name: "Bread",
        price: 1.8,
        costPrice: 0.7,
        size: size == "XL" || size === "xl" ? "X-Large" : "X-Small",
      };
    } else if (pastry === "cookie") {
      return {
        name: "Cookie",
        price: 0.9,
        costPrice: 0.15,
        size: size === "XL" || size === "xl" ? "X-Large" : "X-Small",
      };
    }
  }
};
