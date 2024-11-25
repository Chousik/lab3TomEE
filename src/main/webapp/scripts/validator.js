function validateY() {
    const elementY = document.getElementById("j_id_8:Y_input");
    const y = parseFloat(elementY.value.replace(',', '.'));

    if (!isNumeric(y) || y > 5 || y < -5) {
        elementY.setCustomValidity("Please enter an real between -5 and 5");
        elementY.reportValidity();
        return false;
    }
    return true;
}
function validateX(){
    const elementY = document.getElementById("j_id_8:Y_input");
    const elementX = document.getElementById("j_id_8:xValue");
    const xValue = parseFloat(elementX.value.replace(',', '.'));
    if (xValue > 3 || xValue < -3){
        elementY.setCustomValidity("Please enter X an real between -3 and 3");
        elementY.reportValidity();
        return false;
    }
    return true;
}
function validateAll(){
    return validateY() && validateX();
}
function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}