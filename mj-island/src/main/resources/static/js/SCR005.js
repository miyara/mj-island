(() => {
    $(".favoButton").click(function() {
        var button = this;

        if($(this).data('condition') == false) {
            $(button).css('backgroundcolor', '#FF0');
            $(button).data('consition', true);
        } else if($(this).data(condition) == true) {
            $(button).css('backgroudcolor', '');
            $(button).data('condition', false);
        }
    });
});