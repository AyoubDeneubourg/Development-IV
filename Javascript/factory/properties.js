export default {
  getProperties(pastry, size) {
    if (pastry == "croissant") {
      return {
        title: "Croissant",
        price: 1.2,
        costPrice: 0.2,
        size: size === "XL" || size === "xl" ? "X-Large" : "X-Small",
      };
    } else if (pastry == "bread") {
      return {
        title: "Bread",
        price: 1.8,
        costPrice: 0.7,
        size: size == "XL" || size === "xl" ? "X-Large" : "X-Small",
      };
    } else if (pastry === "cookie") {
      return {
        title: "Cookie",
        price: 0.9,
        costPrice: 0.15,
        size: size === "XL" || size === "xl" ? "X-Large" : "X-Small",
      };
    }
  },
};
