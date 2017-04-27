$(function () {
    function htsHide() {
        $(".hovertreeshowlayer img").remove();
        $(".hovertreeshowcover").hide();
        $(".hovertreeshowclose").hide();
        $(".hovertreeshowlayer").hide();
    }
    $(".hovertreeshow img").on("click", function () {
        if ($(".hovertreeshowclose").length == 0) {
            $("body").append("<div class='hovertreeshowclose'>X</div>").append("<div class='hovertreeshowcover'></div>").append("<div class='hovertreeshowlayer'></div>")

            $(".hovertreeshowclose").on("click", function () { htsHide(); })
            $(".hovertreeshowcover").on("dblclick", function () { htsHide(); })
            $(".hovertreeshowlayer").on("dblclick", function () { htsHide(); })
        }
        else {
            $(".hovertreeshowclose").show();
            $(".hovertreeshowcover").show();
            $(".hovertreeshowlayer").show();
        }
        $(".hovertreeshowlayer").append("<img src='" + this.src + "' />")
    })
})