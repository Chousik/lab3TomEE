// function validateX() {
//     const radios = document.getElementsByName('X');
//     for (const radio of radios) {
//         if (radio.checked) {
//             return true;
//
//         }
//     }
//     const radio = document.getElementById("radio_4")
//     radio.setCustomValidity("Please choose X");
//     radio.reportValidity();
//     return false;
// }
//
// function validateY() {
//     const elementY = document.getElementById("Y_input");
//     const y = parseFloat(elementY.value.replace(',', '.'));
//
//     if (!isNumeric(y) || y >= 5 || y <= -5) {
//         elementY.setCustomValidity("Please enter an real between -5 and 5");
//         elementY.reportValidity();
//         return false;
//     }
//     return true;
// }
//
// function validateR() {
//     const radios = document.getElementsByName('R');
//     for (const radio of radios) {
//         if (radio.checked) {
//             return true;
//
//         }
//     }
//     const radio = document.getElementById("R_3")
//     radio.setCustomValidity("Please choose R");
//     radio.reportValidity();
//     return false;
// }
// function isNumeric(n) {
//     return !isNaN(parseFloat(n)) && isFinite(n);
// }
// function validateAll(){
//     return (validateR() & validateY() & validateX())
// }