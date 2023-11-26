// Get the modal
var modal = document.getElementById("loginModal");

// Get the button that opens the modal
var btn = document.getElementById("btnLogin");

// Get the modal
var siginModal = document.getElementById("siginModal");

// Get the button that opens the modal
var btnSign = document.getElementById("btnSign");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

var spanS = document.getElementsByClassName("close2")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}
btnSign.onclick = function() {
    siginModal.style.display = "block";
}
// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";       
}
spanS.onclick = function() {
    siginModal.style.display = "none";       
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
window.onclick = function(event) {
if (event.target == siginModal) {
    siginModal.style.display = "none";
}
}