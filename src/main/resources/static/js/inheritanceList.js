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
//assetList


    $(document).ready(function () {
        const user = JSON.parse(sessionStorage.getItem("loggedUser"));
        const data = JSON.stringify({
            digitalOwner: user,
        });
        debugger;
        $.ajax({
            type: "POST",
            url: "api/heritage/list/v1",
            dataType: "json",
            contentType: 'application/json',
            processData: false,
            data: data,// now data come in this function
            success: function (data, status, jqXHR) {
                for (let i = 0; i < data.assetList.length; i++) {
                    document.getElementById("dataTable_wrapper").appendChild

                    let table = document.getElementById("dataTable");

                    // Create row element
                    let row = document.createElement("tr")

                    // Create cells
                    let c1 = document.createElement("td")
                    let c2 = document.createElement("td")
                    let c3 = document.createElement("td")
                    let c4 = document.createElement("td")
                    let c5 = document.createElement("td")

                    c1.innerText = data.assetList[i].asset.name;
                    c2.innerText = data.assetList[i].asset.description;
                    c3.innerText = data.assetList[i].asset.type;
                    c4.innerText = data.assetList[i].custodianDigitalUser.id;
                    c5.innerText = data.assetList[i].note;

                    row.appendChild(c1);
                    row.appendChild(c2);
                    row.appendChild(c3);
                    row.appendChild(c4);
                    row.appendChild(c5);

                    // Append row to table body
                    table.appendChild(row)

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

    $("#login-button").on('click', function (e) {


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
