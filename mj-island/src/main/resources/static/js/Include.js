function header() {
    // setRequestHeader("Access-Control-Allow-Origin", "http://localhost:8080");
    $.ajax({
        url: "SCP-003.html",
        cache: false,
        success: function (html) {
            document.write(html);
        }
    });
}