/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function () {
    'use strict';
    $(document).ready(function () {

        $(".delete").click(function () {
            var parent = $(this).parent().parent();
            var id = parent[0].id;

            var response = confirm("¿Desea eliminar el registro?");
            if (response) {
                deleteNoticia(id);
            }
        });
        
        $(".update").click(function (){
            var parent = $(this).parent().parent();
            var id = parent[0].id;
            $.ajax({
                url: '/NoticiasUNP/editor/new/index.html',
                type: 'GET',
                dataType: 'html',
                success: function(data){
                    $("#dialog-content").html(data);
                }
            });
            $("#dialog").modal('show');
        });

        var enlaceValido = false;
        var enlaceExp = /[A-Za-z0-9_-]+/;
        $("#enlace").change(function (e) {
            $("#mini-loader").show();
            if (!$(this).val().match(enlaceExp)) {
                showAlert("El campo Enlace solo debe tener caractéres alfanumericos");
                $(this).focus();
                $("#mini-loader").hide();
                enlaceValido = false;
                return;
            }

            $.ajax({
                url: "/NoticiasUNP/editor/consulta-enlace.json",
                type: 'POST',
                dataType: 'json',
                data: $("#enlace").serialize(),
                success: function (data) {
                    $("#mini-loader").hide();
                    if (data.valido) {
                        enlaceValido = true;
                        $("#alert-error").hide();
                    } else {
                        enlaceValido = false;
                        showAlert("El campo Enlace ya esta registrado");
                    }
                }
            });
        });

        $("#form-noticia").submit(function (e) {
            if (!enlaceValido) {
                e.preventDefault();
                alert("Debe ingresar Enlace válido.");
                return;
            }
        });
        
        $("#nueva-noticia").click(function(e){
            $.ajax({
                url: '/NoticiasUNP/editor/new/index.html',
                type: 'GET',
                dataType: 'html',
                success: function(data){
                    $("#dialog-content").html(data);
                }
            });
            $("#dialog").modal('show');
        });
    });

    function showAlert(msg) {
        $("#error-msg").html(msg);
        $("#alert-error").show();
    }

    function deleteNoticia(id) {
        $.ajax({
            url: "/NoticiasUNP/editor/delete/index.json",
            type: 'POST',
            dataType: 'json',
            data: id,
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data) {
                if (data.success) {
                    window.location.reload();
                } else {
                    alert("Ocurrio un error al borrar el registro.");
                }
            }

        });
    }
})();

