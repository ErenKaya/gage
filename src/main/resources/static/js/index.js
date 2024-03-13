(function ($) {
    "use strict"; // Start of use strict

    // Toggle the side navigation
    $("#sidebarToggle, #sidebarToggleTop").on('click', function (e) {
        $("body").toggleClass("sidebar-toggled");
        $(".sidebar").toggleClass("toggled");
        if ($(".sidebar").hasClass("toggled")) {
            $('.sidebar .collapse').collapse('hide');
        }
        ;
    });

    $("#login-button").on('click', function (e) {
        const data = JSON.stringify({
            identity: document.getElementById("exampleInputEmail").value,
            password: document.getElementById("exampleInputPassword").value
        });
        $.ajax({
            type: "POST",
            url: "api/start/login/v1",
            dataType: "json",
            contentType: 'application/json',
            processData: false,
            data: data,// now data come in this function

            success: function (data, status, jqXHR) {
                window.location.href = "index.html";
            },

            error: function (jqXHR, status) {
                // error handler
                console.log(jqXHR);
                alert('fail' + status.code);
            }
        });
    });

        $(document).ready(function () {
            const user = JSON.parse(sessionStorage.getItem("loggedUser"));
            const data = user.id;
            $.ajax({
                type: "POST",
                url: "api/transfer/list/v1",
                dataType: "json",
                contentType: 'application/json',
                processData: false,
                data: data,// now data come in this function

                success: function (data, status, jqXHR) {
                var tableRef = document.getElementById("dataTable").getElementsByTagName('tbody')[0];
                    for (let i = 0; i < data.length; i++) {
                        const item = data[i];
                                tableRef.insertRow().innerHTML =
                                "<th scope='row'>" + (i + 1).toString()+ "</th>" +
                                "<td>" +item.asset.name+ "</td>"+
                                "<td>" +item.asset.type+ "</td>"+
                                "<td>" +item.payment.amount+ "</td>"+
                                "<td>" +item.payment.amount+ "</td>"+
                                "<td>" +item.type+ "</td>";
                        //document.getElementById("dataTable").row(new Option(item.name, item.id));

                    }
                    console.log("data", data)

                },

                error: function (jqXHR, status) {
                    // error handler
                    console.log(jqXHR);
                    alert('fail' + status.code);
                }
            });


        });



    // Close any open menu accordions when window is resized below 768px
    $(window).resize(function () {
        if ($(window).width() < 768) {
            $('.sidebar .collapse').collapse('hide');
        }
        ;

        // Toggle the side navigation when window is resized below 480px
        if ($(window).width() < 480 && !$(".sidebar").hasClass("toggled")) {
            $("body").addClass("sidebar-toggled");
            $(".sidebar").addClass("toggled");
            $('.sidebar .collapse').collapse('hide');
        }
        ;
    });

    // Prevent the content wrapper from scrolling when the fixed side navigation hovered over
    $('body.fixed-nav .sidebar').on('mousewheel DOMMouseScroll wheel', function (e) {
        if ($(window).width() > 768) {
            var e0 = e.originalEvent,
                delta = e0.wheelDelta || -e0.detail;
            this.scrollTop += (delta < 0 ? 1 : -1) * 30;
            e.preventDefault();
        }
    });

    // Scroll to top button appear
    $(document).on('scroll', function () {
        var scrollDistance = $(this).scrollTop();
        if (scrollDistance > 100) {
            $('.scroll-to-top').fadeIn();
        } else {
            $('.scroll-to-top').fadeOut();
        }
    });

    // Smooth scrolling using jQuery easing
    $(document).on('click', 'a.scroll-to-top', function (e) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: ($($anchor.attr('href')).offset().top)
        }, 1000, 'easeInOutExpo');
        e.preventDefault();
    });

})(jQuery); // End of use strict
