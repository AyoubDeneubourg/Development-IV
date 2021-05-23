export default function bubbleSort(unsortedPastry) {
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
;

