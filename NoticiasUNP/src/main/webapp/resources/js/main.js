/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
jQuery.fn.shakeit = function (intShakes, intDistance, intDuration) {
    this.each(function () {
        $(this).css("position", "relative");
        for (var x = 1; x <= intShakes; x++) {
            $(this).animate({left: (intDistance * -1)}, (((intDuration / intShakes) / 4)))
                    .animate({left: intDistance}, ((intDuration / intShakes) / 2))
                    .animate({left: 0}, (((intDuration / intShakes) / 4)));
        }
    });
    return this;
};

(function () {
    'use strict';
    $(document).ready(function () {


        var options = {weekday: "long", year: "numeric", month: "long", day: "numeric"};
        $("#fecha").html(new Date().toLocaleDateString("es-Pe", options));

        $("#logo-img").mouseenter(function () {
            $("#logo-img").shakeit(2, 8, 600);
        });

        $("#btn-login").click(function () {
            $.ajax({
                url: 'login.html',
                type: 'GET',
                dataType: 'html',
                success: function (data) {
                    $("#dialog-content").html(data);
                    $("#login-form").submit(function (e) {
                        e.preventDefault();
                        $.ajax({
                            url: 'login.json',
                            type: 'POST',
                            dataType: 'json',
                            data: $("#login-form").serialize(),
                            success: function(data){
                                if (!data.success){
                                    $("#login-error-msg").show();
                                }else{
                                    window.location.reload();
                                }
                                console.log(data);
                            },
                            error: function(data){
                                console.log(data);
                            }
                        });
                    });
                    $("#dialog").modal('show');
                }
            });
        });




    });
})();
