const croissant = require("./croissant");
const bread = require("./bread");
const cookie = require("./cookie");
const pastry = { croissant, bread, cookie };

module.exports = {
    createPastry(type, attributes) {
        const pastryType = pastry[type];
        return new pastryType(attributes);
    }
};