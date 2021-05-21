export default {
    getProperties(pastry) {
        if (pastry == "croissant") {
            return {
                price: 1.10,
                costPrice: 0.20,
                sound: "test1"
            }
        } else if (pastry == "bread") {
            return {
                price: 1.80,
                costPrice: 0.110,
                sound: "test2",
            }
        } else if (pastry == "cookie") {
            return {
                price: 0.90,
                costPrice: 0.30,
                sound: "test3",
            }
        }
    }
}