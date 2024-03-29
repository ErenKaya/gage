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
    const paymentType = {
        "Free": "FREE",
        "Paid": "PAID",
    }

    $(document).ready(function () {
        document.getElementById("transferDate").value = new Date().toISOString();

        const user = JSON.parse(sessionStorage.getItem("loggedUser"));
        const data = JSON.stringify({
            digitalUser: user,
        });
        $.ajax({
            type: "POST",
            url: "api/asset/list/v1",
            dataType: "json",
            contentType: 'application/json',
            processData: false,
            data: data,// now data come in this function

            success: function (data, status, jqXHR) {

                for (let i = 0; i < data.assetList.length; i++) {
                    const item = data.assetList[i];
                    document.getElementById("assetList").appendChild(new Option(item.name, item.id));

                }
                console.log("data", data)

            },

            error: function (jqXHR, status) {
                // error handler
                console.log(jqXHR);
                alert('fail' + status.code);
            }
        });

        $.ajax({
            type: "GET",
            url: "api/user/list/v1",
            dataType: "json",
            contentType: 'application/json',
            processData: false,
            success: function (data, status, jqXHR) {

                for (let i = 0; i < data.userListItemList.length; i++) {
                    const item = data.userListItemList[i];
                    document.getElementById("userList").appendChild(new Option(item.mail, item.id));

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


    $("#sendAsset").on('click', function (e) {
        const user = JSON.parse(sessionStorage.getItem("loggedUser"));
        const assetSelect = document.getElementById("assetList")
        const assetId = assetSelect.options[assetSelect.selectedIndex].value;

        const userList = document.getElementById("userList")
        const test = userList.options[userList.selectedIndex].text;

        const typeList = document.getElementById("paymentTypeList")
        const type = paymentType[typeList.options[typeList.selectedIndex].text];
        const data = {
            asset: {id: assetId},
            broker: {id: user.id},
            payment: {amount: document.getElementById("paymentAmount").value},
            transferDate: document.getElementById("transferDate").value,
            consumerMail: test,
            type: type

        };
        const dataAsString = JSON.stringify(data);

        console.log(data);

        /**
         *     PaymentSellerDto payment;
         *     @NotNull(message = "Transfer type must be filled")
         *     TransferType type;
         *     OffsetDateTime transferDate;
         *     String consumerMail;
         */

        $.ajax({
            type: "POST",
            url: "api/transfer/create/v1",
            dataType: "json",
            contentType: 'application/json',
            processData: false,
            data: dataAsString,// now data come in this function

            success: function (data, status, jqXHR) {
                alert("başarıyla tamamlandı", data)
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
