let $windowinnerWidth = window.innerWidth;
let windowSm = 700;
if ($windowinnerWidth <= windowSm) {
    window.document.getElementsByClassName('body_template').width = $windowinnerWidth;
} else {
    //横幅640px超のとき（タブレット、PC）に行う処理を書く
}
