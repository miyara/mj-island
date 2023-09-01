let $windowinnerWidth = window.innerWidth;
let windowSm = 700;
if ($windowinnerWidth <= windowSm) {
    window.document.getElementsByClassName('body_template').width = $windowinnerWidth;
} else {
    //横幅640px超のとき（タブレット、PC）に行う処理を書く
}

function changeImage() {
    var image = document.getElementById('ster');
    if (image.src.match("../static/material/star.png")) {
        image.src = "../static/material/star_empty.png";
    } else {
        image.src = "../static/material/star.png";
    }
}