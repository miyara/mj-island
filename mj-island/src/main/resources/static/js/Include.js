function header() {
    // setRequestHeader("Access-Control-Allow-Origin", "http://localhost:8080");
    $.ajax({
        //url: "../../templates/common/SCP003_header.html",
        url: "./common/SCP003_header.html",
        cache: false,
        success: function (html) {
            document.write(html);
        }
    });
}