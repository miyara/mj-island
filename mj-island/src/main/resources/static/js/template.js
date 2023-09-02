let $windowinnerWidth = window.innerWidth;
let windowSm = 700;
if ($windowinnerWidth <= windowSm) {
    window.document.getElementsByClassName('body_template').width = $windowinnerWidth;
} else {
    //横幅640px超のとき（タブレット、PC）に行う処理を書く
}



var imageToggleState = 1;  // 初期状態は1

function changeImage() {
    var img = document.getElementById('toggleButton');
    if (imageToggleState === 1) {
        img.src = '/material/star_empty.png';
        img.alt = 'Image 2';
        imageToggleState = 2;
    } else {
        img.src = '/material/star.png';
        img.alt = 'Image 1';
        imageToggleState = 1;
    }
}