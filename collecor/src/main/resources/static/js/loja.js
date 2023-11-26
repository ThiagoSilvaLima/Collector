function favoriteSuccess(){
    var element = document.getElementById("result");
    element.style.visibility="visible";

    setTimeout(final, 3000);
}
function favoriteSuccess(){
    var element = document.getElementById("result");
    element.style.visibility="hidden";
}

function hideDescription(){
    var element = document.getElementById("btDesc");
    if(element.innerHTML=="Ocultar descrição"){
        element.innerHTML="Exibir descrição";
    }else
    element.innerHTML="Ocultar descrição";
}
