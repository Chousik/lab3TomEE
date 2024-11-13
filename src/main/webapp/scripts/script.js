// const table = `<tr id="head-table">
//                     <td>x</td>
//                     <td>y</td>
//                     <td>r</td>
//                     <td>status</td>
//                     <td>current time</td>
//                     <td>script runtime</td>
//                     </tr>
//                 `
//
// $(document).ready(function() {
//     const canvas = new Canvas('canvas');
//     if (validateR()) {
//         const elementR = document.querySelector('input[name="R"]:checked');
//         const rValue = parseFloat(elementR.value).toFixed(1)
//         canvas.redrawAll(rValue)
//     }
//     $('input[name="R"]').change(function() {
//         const elementR = document.querySelector('input[name="R"]:checked');
//         const rValue = parseFloat(elementR.value).toFixed(1)
//         canvas.redrawAll(rValue)
//     });
//     $ ("#check_button").click(function() {
//         if (validateAll()){
//             const radios = document.querySelector('input[name="X"]:checked');
//             const elementY = document.getElementById("Y_input");
//             const elementR = document.querySelector('input[name="R"]:checked');
//
//             const xValue = parseFloat(radios.value).toFixed(0)
//             const yValue = parseFloat(elementY.value.replace(',', '.')).toFixed(1)
//             const rValue = parseFloat(elementR.value).toFixed(1)
//             sendPoint(xValue, yValue, rValue)
//         }
//     })
//     document.getElementById('canvas').addEventListener('click', (event) => {
//         if (validateR()){
//             const elementR = document.querySelector('input[name="R"]:checked');
//             const rValue = parseFloat(elementR.value).toFixed(1)
//
//             const { xValue, yValue } = getCanvasCoordinates(event);
//
//             sendPoint(xValue, yValue, rValue);
//             }
//     });
//     function sendPoint(xValue, yValue, rValue) {
//         const request = {
//             method: "GET",
//             headers: { "content-type": "application/json" },
//         };
//
//         fetch(`/Web-lab2-1.0-SNAPSHOT/main?x=${xValue}&y=${yValue}&r=${rValue}`, request)
//             .then(response => {
//                 return response.json().then(dataJson => {
//                     if (!response.ok) {
//                         const elementY = document.getElementById("Y_input");
//                         elementY.setCustomValidity(dataJson.errorText);
//                         elementY.reportValidity();
//                         throw new Error(`Ошибка: ${response.status} - ${dataJson.errorText}`);
//                     }
//                     return dataJson;
//                 });
//             })
//             .then(dataJson => {
//                 const newRow = document.createElement('tr');
//                 newRow.innerHTML = `
//                 <td>${xValue}</td>
//                 <td>${yValue}</td>
//                 <td>${rValue}</td>
//                 <td>${dataJson.inFlag}</td>
//                 <td>${dataJson.time}</td>
//                 <td>${dataJson.executionTime}</td>
//             `;
//                 document.getElementById("result_table").append(newRow);
//
//                 // Рисуем точку на холсте
//                 canvas.drawPoint(xValue, yValue, dataJson.inFlag);
//             })
//             .catch(error => {
//                 console.error(error);
//             });
//     }
//
//
// })
// function getCanvasCoordinates(event) {
//     const canvas = document.getElementById('canvas');
//     const rect = canvas.getBoundingClientRect();
//
//     const x = event.clientX - rect.left;
//     const y = event.clientY - rect.top;
//     const xValue = ((x - rect.width / 2) / 24).toFixed(1);
//     const yValue = (-(y - rect.height / 2) / 24).toFixed(1);
//     return { xValue, yValue };
// }