/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function () {
    'use strict';
    $(document).ready(function () {

        $('#pinBoot').pinterest_grid({
            no_columns: 4,
            padding_x: 10,
            padding_y: 10,
            margin_bottom: 50,
            single_column_breakpoint: 700
        });

        var options = {weekday: "long", year: "numeric", month: "long", day: "numeric"};
        $("#fecha").html(new Date().toLocaleDateString("es-Pe", options));

        $("#logo-img").mouseenter(function () {
            $("#logo-img").shakeit(2, 8, 600);
        });

        $("#btn-login").click(function () {
            $.ajax({
                url: '/NoticiasUNP/login.html',
                type: 'GET',
                dataType: 'html',
                success: function (data) {
                    $("#dialog-content").html(data);
                    $("#login-form").submit(function (e) {
                        e.preventDefault();
                        $.ajax({
                            url: '/NoticiasUNP/login.json',
                            type: 'POST',
                            dataType: 'json',
                            data: $("#login-form").serialize(),
                            success: function (data) {
                                if (!data.success) {
                                    $("#login-error-msg").show();
                                } else {
                                    window.location.reload();
                                }
                                console.log(data);
                            },
                            error: function (data) {
                                console.log(data);
                            }
                        });
                    });
                    $("#dialog").modal('show');
                }
            });
        });

        $("#btn-register").click(function () {
            $.ajax({
                url: '/NoticiasUNP/register.html',
                type: 'GET',
                dataType: 'html',
                success: function (data) {
                    $("#dialog-content").html(data);
                    $("#register-form").submit(function (e) {
                        e.preventDefault();
                        $.ajax({
                            url: '/NoticiasUNP/register.json',
                            type: 'POST',
                            dataType: 'json',
                            data: JSON.stringify($("#register-form").jsonify()),
                            beforeSend: function (xhr) {
                                xhr.setRequestHeader("Accept", "application/json");
                                xhr.setRequestHeader("Content-Type", "application/json");
                            },
                            success: function (data) {
                                if (!data.success) {
                                    $("#login-error-msg").show();
                                    $("#error-msg").html(data.error);
                                } else {
                                    window.location.reload();
                                }
                                console.log(data);
                            },
                            error: function (error) {
                                console.log(error);
                            }
                        });
                    });
                    $("#dialog").modal('show');
                }
            });
        });

    });
})();

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

;(function ($, window, document, undefined) {
    var pluginName = 'pinterest_grid',
        defaults = {
            padding_x: 10,
            padding_y: 10,
            no_columns: 3,
            margin_bottom: 50,
            single_column_breakpoint: 700
        },
        columns,
        $article,
        article_width;

    function Plugin(element, options) {
        this.element = element;
        this.options = $.extend({}, defaults, options) ;
        this._defaults = defaults;
        this._name = pluginName;
        this.init();
    }

    Plugin.prototype.init = function () {
        var self = this,
            resize_finish;

        $(window).resize(function() {
            clearTimeout(resize_finish);
            resize_finish = setTimeout( function () {
                self.make_layout_change(self);
            }, 11);
        });

        self.make_layout_change(self);

        setTimeout(function() {
            $(window).resize();
        }, 500);
    };

    Plugin.prototype.calculate = function (single_column_mode) {
        var self = this,
            tallest = 0,
            row = 0,
            $container = $(this.element),
            container_width = $container.width();
            $article = $(this.element).children();

        if(single_column_mode === true) {
            article_width = $container.width() - self.options.padding_x;
        } else {
            article_width = ($container.width() - self.options.padding_x * self.options.no_columns) / self.options.no_columns;
        }

        $article.each(function() {
            $(this).css('width', article_width);
        });

        columns = self.options.no_columns;

        $article.each(function(index) {
            var current_column,
                left_out = 0,
                top = 0,
                $this = $(this),
                prevAll = $this.prevAll(),
                tallest = 0;

            if(single_column_mode === false) {
                current_column = (index % columns);
            } else {
                current_column = 0;
            }

            for(var t = 0; t < columns; t++) {
                $this.removeClass('c'+t);
            }

            if(index % columns === 0) {
                row++;
            }

            $this.addClass('c' + current_column);
            $this.addClass('r' + row);

            prevAll.each(function(index) {
                if($(this).hasClass('c' + current_column)) {
                    top += $(this).outerHeight() + self.options.padding_y;
                }
            });

            if(single_column_mode === true) {
                left_out = 0;
            } else {
                left_out = (index % columns) * (article_width + self.options.padding_x);
            }

            $this.css({
                'left': left_out,
                'top' : top
            });
        });

        this.tallest($container);
        $(window).resize();
    };

    Plugin.prototype.tallest = function (_container) {
        var column_heights = [],
            largest = 0;

        for(var z = 0; z < columns; z++) {
            var temp_height = 0;
            _container.find('.c'+z).each(function() {
                temp_height += $(this).outerHeight();
            });
            column_heights[z] = temp_height;
        }

        largest = Math.max.apply(Math, column_heights);
        _container.css('height', largest + (this.options.padding_y + this.options.margin_bottom));
    };

    Plugin.prototype.make_layout_change = function (_self) {
        if($(window).width() < _self.options.single_column_breakpoint) {
            _self.calculate(true);
        } else {
            _self.calculate(false);
        }
    };

    $.fn[pluginName] = function (options) {
        return this.each(function () {
            if (!$.data(this, 'plugin_' + pluginName)) {
                $.data(this, 'plugin_' + pluginName,
                new Plugin(this, options));
            }
        });
    }

})(jQuery, window, document);
