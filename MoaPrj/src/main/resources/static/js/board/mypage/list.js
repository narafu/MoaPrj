$(function () {

    let uid = $("#uid").html();
    let category;
    let subTitleColor;
    let currentPage;
    let lastPage;
    let detailTop;
    let detailLeft;

    // card hover
    $(".card").hover(function () {
        $(this).children("span").slideDown(500);
    }, function () {
        $(this).children("span").slideUp(500);
    });

    // detail hover
    $(".detail i").hover(function () {
        $(this).css("color", subTitleColor)
    }, function () {
        $(this).css("color", "#292929")
    });

    // detail-cloth
    $(".card.cloth").click(function (e) {
        currentPage = 1;
        category = $(this).find("span").text();
        subTitleColor = $(this).css("background-color");
        $(".detail.cloth .sub-title").text(category);
        $(".detail.cloth .sub-title").css("background-color", subTitleColor);

        detailTop = (($(window).height() - $(".detail").outerHeight()) / 2 + $(window).scrollTop()) + "px"
        detailLeft = (($(window).width() - $(".detail").outerWidth()) / 2 + $(window).scrollLeft()) + "px"
        $(".detail").css("top", detailTop);
        $(".detail").css("left", detailLeft);

        $(".detail.cloth").toggle(500);
        $.loadImg();
        $.loadPage();
    });

    // detail-register
    $(".card.register").click(function () {
        category = $(this).find("span").text();
        subTitleColor = $(this).css("background-color");
        $(".register .sub-title").text(category);
        $(".register .sub-title").css("background-color", subTitleColor);

        detailTop = (($(window).height() - $(".detail").outerHeight()) / 2 + $(window).scrollTop()) + "px"
        detailLeft = (($(window).width() - $(".detail").outerWidth()) / 2 + $(window).scrollLeft()) + "px"
        $(".detail").css("top", detailTop);
        $(".detail").css("left", detailLeft);

        $(".detail.register").toggle(500);
        $.loadInput();
    });

    // detail exit
    $(".detail .exit").click(function (e) {
        $(this).parents(".detail").toggle(500);
    });

    // image preview
    $(".register .box-container").click(function (e) {
        if (e.target.nodeName != "INPUT") return;
        $(e.target).change(function () {
            let img = $(this).siblings("img")
            let reader = new FileReader();
            reader.onload = function (e) {
                img.attr("src", e.target.result);
            }
            reader.readAsDataURL(this.files[0]);
            $(this).toggle();
            $(this).siblings(".fa-times").toggle();
        });
    });

    // image upload
    $("form[action='reg']").submit(function (e) {
        e.preventDefault();

        var checked = $("input[name='c']:checked").val();
        if (checked == undefined) {
            alert("카테고리가 입력되지 않았습니다.");
            return;
        }

        let formData = new FormData($("form[action='reg']")[0]);
        $.ajax({
            type: "post",
            enctype: 'multipart/form-data',
            url: "/board/mypage/reg",
            data: formData,
            processData: false,
            contentType: false,
            cache: false,
            success: function () {
                alert("저장되었습니다.");
                $.loadInput();
            }
        });
    });

    // image upload cancel
    $(".register .box-container").click(function (e) {
        if (e.target.nodeName != "I") return;
        $(e.target).toggle();
        $(e.target).siblings("img").remove();
        $("<img src=''>").appendTo($(e.target).parents(".cloth-box"));
        let imgName = $(e.target).siblings("input[type='file']").attr("name");
        $(e.target).siblings("input[type='file']").remove();
        $(`<input type='file' name=${imgName}>`).appendTo($(e.target).parents(".cloth-box"));
    });

    // image del
    $(".cloth .box-container").click(function (e) {
        if (e.target.nodeName != "I") return;
        if (!(confirm("삭제하시겠습니까?"))) return;
        let imgId = $(this).find("img").attr("id");
        $.delImg(imgId);
    });

    // pager(num)
    $(".pager ul").click(function (e) {
        if (e.target.nodeName != "LI") return;
        currentPage = $(e.target).html();
        $.loadImg();
    })

    // pager(arrow)
    $(".pager .fa-arrow-left").click(function () {
        if (currentPage == 1) {
            alert('이전 페이지가 없습니다.');
        }
        else {
            currentPage--;
            $.loadImg();
        }
    })

    $(".pager .fa-arrow-right").click(function () {
        if (currentPage == lastPage) {
            alert('다음 페이지가 없습니다.');
        }
        else {
            currentPage++;
            $.loadImg();
        }
    })

    // image load
    $.loadImg = function () {
        $(".pager ul li").css("color", "#292929");
        $(`.pager ul li:eq(${currentPage - 1})`).css("color", subTitleColor);
        $.ajax({
            type: "get",
            url: "/api/board/mypage/list-ajax",
            data: { "c": category, "p": currentPage, "uid": uid },
            dataType: "json",
            success: function (list) {
                $(".cloth .box-container").empty();
                let listLength = Object.keys(list).length;
                for (let i in list) {
                    $(".cloth .box-container").append(`
                        <div class="cloth-box flex-center">
                                <i class="fas fa-times fa"></i>
                                <img class="cloth-img" src="${list[i].img}" alt="">
                            </div>
                        `);
                    $(`.detail-cloth .cloth-box:eq(${i}) img`)
                        .attr("id", `${list[i].id}`);
                }
                for (let i = 0; i < 6 - listLength; i++) {
                    $(".cloth .box-container").append(`
                        <div class="cloth-box flex-center">
                                <i class="fas fa-times fa"></i>
                                <img class="cloth-img" src="" alt="">
                            </div>
                        `);
                }
            }
        });
    };

    // input load
    $.loadInput = function () {
        $(".register .box-container").empty();
        for (let i = 0; i < 6; i++) {
            $(".register .box-container").append(`
                    <div class="cloth-box flex-center">
                    <i class="fas fa-times fa"></i>
                    <img src="">
                    <input type="file" name=file${i + 1}>
                </div>`);
        }
    };

    // image del
    $.delImg = function (imgId) {
        $.ajax({
            type: "post",
            url: "/api/board/mypage/del",
            data: {
                "id": imgId,
                "c": category,
                "p": currentPage,
                "uid": uid
            },
            success: function (list) {
                alert("삭제되었습니다.");
                $.loadImg();
            }
        });
    };

    // page load
    $.loadPage = function () {
        let size = 6;
        $.ajax({
            type: "get",
            url: "/api/board/mypage/page-ajax",
            data: { "uid": uid },
            dataType: "json",
            success: function (result) {
                $(".detail .pager ul").empty();
                let cntCategory;
                switch (category) {
                    case "Outers":
                        cntCategory = result.cntOuters;
                        break;
                    case "Tops":
                        cntCategory = result.cntTops;
                        break;
                    case "Bottoms":
                        cntCategory = result.cntBottoms;
                        break;
                    case "Shoes":
                        cntCategory = result.cntShoes;
                        break;
                    case "Etc":
                        cntCategory = result.cntEtc;
                        break;
                }
                lastPage = Math.ceil(cntCategory / size);
                for (let i = 0; i < lastPage; i++) {
                    $(".pager ul").append(`<li>${i + 1}</li>`)
                }
                $(".pager ul li:first").css("color", subTitleColor);
            }
        });
    };

});