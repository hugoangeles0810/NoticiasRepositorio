/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function () {
    'use strict';
    var enlaceValido = false;
    var enlaceExp = /[A-Za-z0-9_-]+/;
    var enlaceUpdated = null;
    var MODIFY = 4;
    var DELETE = 5;


    $(document).ready(function () {

        var table = $("#table").bootstrapTable();

        table.on("click-cell.bs.table", function (field, value, row, $element) {
            if (value === MODIFY) {
                $.ajax({
                    url: '/NoticiasUNP/editor/update/index.html',
                    type: 'POST',
                    dataType: 'html',
                    data: {id: $element.id},
                    success: function (data) {
                        $("#dialog-content").html(data);
                        enlaceUpdated = $("#enlace").val();
                        $("#enlace").change(validarEnlace);
                    }
                });
                $("#dialog").modal('show');
            }

            if (value == DELETE) {
                var response = confirm("¿Desea eliminar el registro?");
                if (response) {
                    deleteNoticia($element.id);
                }
            }
        });

        $(".delete").click(function () {
            var parent = $(this).parent().parent();
            var id = parent[0];

            console.log(parent);

            var response = confirm("¿Desea eliminar el registro?");
            if (response) {
                deleteNoticia(id);
            }
        });

        $(".update").click(function () {
            var parent = $(this).parent().parent();
            var id = parent[0].id;
            $.ajax({
                url: '/NoticiasUNP/editor/update/index.html',
                type: 'POST',
                dataType: 'html',
                data: {id: id},
                success: function (data) {
                    $("#dialog-content").html(data);
                    enlaceUpdated = $("#enlace").val();
                    $("#enlace").change(validarEnlace);
                }
            });
            $("#dialog").modal('show');
        });


        $("#form-noticia").submit(function (e) {
            if (!enlaceValido) {
                e.preventDefault();
                alert("Debe ingresar Enlace válido.");
                return;
            }
        });

        $("#nueva-noticia").click(function (e) {
            $.ajax({
                url: '/NoticiasUNP/editor/new/index.html',
                type: 'POST',
                dataType: 'html',
                success: function (data) {
                    $("#dialog-content").html(data);
                    $("#enlace").change(validarEnlace);
                }
            });
            $("#dialog").modal('show');
        });
    });

    function validarEnlace() {

        if (enlaceUpdated === $("#enlace").val()) {
            enlaceValido = true;
            $("#alert-error").hide();
            return;
        }

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
    }

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

function showFormatter(value) {
    return "<a href='/NoticiasUNP/noticias/" + value + ".html' target='_new' ><span class='glyphicon glyphicon-search'></span></a>";
}

function modifyFormatter(value) {
    return "<a href='javascript:void(0);' class='update'><span class='glyphicon glyphicon-pencil'></span></a>";
}

function deleteFormatter(value) {
    return "<a href='javascript:void(0);' class='delete'><span class='glyphicon glyphicon-remove'></span></a>";
}

