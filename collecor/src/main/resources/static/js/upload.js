function handleSelectChange(select) {
    var selectedOption = select.options[select.selectedIndex];

    if (selectedOption.value === "3") {
        isImage();
    }else{
        whithoutImage()
    }
    }
    function isImage() {
        document.getElementById("imageC").style.visibility = "hidden";
    }
    function whithoutImage() {
        document.getElementById("imageC").style.visibility = "visible";
    }

    const inputFile = document.querySelector("#picture__input");
        const pictureImage = document.querySelector(".picture__image");
        const pictureImageTxt = "Selecione uma imagem";
        pictureImage.innerHTML = pictureImageTxt;

        inputFile.addEventListener("change", function (e) {
        const inputTarget = e.target;
        const file = inputTarget.files[0];

        if (file) {
        const reader = new FileReader();

        reader.addEventListener("load", function (e) {
        const readerTarget = e.target;

        const img = document.createElement("img");
        img.src = readerTarget.result;
        img.classList.add("picture__img");

        pictureImage.innerHTML = "";
        pictureImage.appendChild(img);
        });

        reader.readAsDataURL(file);
        } else {
            pictureImage.innerHTML = pictureImageTxt;
        }
    }
);
function updateFileName() {
    const input = document.getElementById('input-file');
    const fileName = input.files[0].name;
    const fileNameSpan = document.getElementById('file-name');
    fileNameSpan.textContent = fileName;
}

