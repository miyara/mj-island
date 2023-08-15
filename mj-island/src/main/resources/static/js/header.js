$(function() {
    $.ajax({
        url: "./common/SCP003header.html",
        dataType: "html",
        //cache: false,
        success: function (data) {
            $('body').prepend(data);
        },
        error: function (){
            alert('header error...');
        }
    });
});