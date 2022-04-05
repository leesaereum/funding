let options = {};
let sqlOptions = {
	1: 32000,
	2: 32000,
	3: 32000,
};
function toast(string) {
	const toast = document.getElementById("toast");

	toast.classList.contains("reveal")
		? (clearTimeout(removeToast),
			(removeToast = setTimeout(function() {
				document.getElementById("toast").classList.remove("reveal");
			}, 3000)))
		: (removeToast = setTimeout(function() {
			document.getElementById("toast").classList.remove("reveal");
		}, 3000));
	toast.classList.add("reveal"), (toast.innerText = string);
}

$(document).on("click", ".detail__tab__tab", function(e) {
	e.stopPropagation();
	const tab = $(this).attr("data-id");
	$(".detail__content__tab p").removeClass("detail__tab__selected");
	$(this).addClass("detail__tab__selected");
	$(".detail__tab").removeClass("selected");
	$("#tab-" + tab).addClass("selected");
});

function calculate(optionID) {
	$("#priceSum_" + optionID).html(
		(sqlOptions[optionID] * options[optionID]).toLocaleString() + "원"
	);
	$("#option_" + optionID + " input").val(options[optionID]);
	calculateTotal();
}

function share(fid) {
	if (Navigator && Navigator.share) {
		Navigator.share({
			title: "해피펀딩",
			text: "세상을 널리 이롭게 하다!",
			url: "http://localhost:8080/Funding/pages/detail.jsp?fid=" + fid,
		});
	} else {
		$("body").append('<input id="copyURL" type="text" value="" />');
		$("#copyURL").val(window.location.href).select();
		document.execCommand("copy");
		$("#copyURL").remove();
		toast("주소가 복사되었습니다.");
	}
}
function calculateTotal() {
	let total = 0;
	let totalCount = 0;

	for (const id in options) {
		const count = options[id];
		totalCount += count;
		total += count * sqlOptions[id];
	}
	$(".detail__funding__total__amount").html("총 수량 " + totalCount + "개");
	$(".detail__funding__total__totalPrice > strong").html(
		total.toLocaleString()
	);
}

$(document).on("click", ".detail__funding__selected__close", function(e) {
	const id = $(this).attr("data-optionID");
	delete options[id];
	$(this).parent().parent().remove();
	calculateTotal();
});

$(document).click(function() {
	console.log("document");
	$(".detail__funding__select").removeClass("opened");
});
$(document).on("click", ".detail__funding__btnBox", function(e) {
	e.stopPropagation();
	$(".detail__funding__select").toggleClass("opened");
});

$(document).on("click", ".detail__add__option", function(e) {
	e.stopPropagation();
	const id = $(this).attr("data-optionID");
	if (options[id] < 5) {
		options[id]++;
		$("#option_" + id + " input").val(options[id]);
	} else {
		alert("최대 5개까지만 선택할 수 있습니다.");
	}
	calculate(id);
});

$(document).on("click", ".detail__substract__option", function(e) {
	e.stopPropagation();
	const id = $(this).attr("data-optionID");
	if (options[id] > 1) {
		options[id]--;
		$("#option_" + id + " input").val(options[id]);
	} else {
		alert("수량을 1개 미만으로 줄일 수 없습니다.");
	}
	calculate(id);
});
$(document).on("change", ".detail__funding__selected__number", function(e) {
	e.stopPropagation();
	let val = $(this).val();
	const id = $(this).attr("data-optionID");
	if (val < 1) {
		val = 1;
		$("#option_" + id + " input").val(1);
		alert("수량을 1개 미만으로 줄일 수 없습니다.");
		options[id] = 1;
	} else {
		options[id] = val;
	}
	if (val > 5) {
		val = 5;
		$("#option_" + id + " input").val(5);
		alert("최대 5개까지만 선택할 수 있습니다.");
		options[id] = 5;
	} else {
		options[id] = val;
	}
	calculate(id);
});

function add__option(optionID) {
	console.log(optionID);
	if (document.getElementById("option_" + optionID)) {
		alert("이미 등록된 옵션입니다.");
	} else {
		let txt = $("#selected__box").html();
		txt +=
			'<div class="detail__funding__selected" id="option_' + optionID + '">';
		txt += '<div class="detail__funding__selected__top">';
		txt +=
			'<p class="detail__funding__selected__subtitle">치즈떡2팩+쌀떡2팩+어묵2팩+소스분말4팩(짜장맛2/보통맛2)</p>';
		txt +=
			'<img class="detail__funding__selected__close" src="/Funding/assets/close.svg" data-optionID="' +
			optionID +
			'"></div>';
		txt +=
			'<div class="detail__funding__selected__bottom"><div class="detail__funding__selected__number__box">';
		txt +=
			'<div class="detail__funding__selected__number__button detail__substract__option" data-optionID="' +
			optionID +
			'" >-</div>';
		txt +=
			'<input type="number" class="detail__funding__selected__number" data-optionID="' +
			optionID +
			'" value="1">';
		txt +=
			'<div class="detail__funding__selected__number__button detail__add__option" data-optionID="' +
			optionID +
			'">+</div></div>';
		txt +=
			'<p class="detail__funding__selected__price" id="priceSum_' +
			optionID +
			'"></p></div></div>';
		options[optionID] = 1;
		document.getElementById("selected__box").innerHTML = txt;
		for (const key in options) {
			calculate(key);
		}
	}
}

function joinFunding() {
	let len = $(".detail__funding__selected").length;

	if (len > 0) {
		let txt = '<form action="/fundingPayment.do" id="finalForm" method="post"><div class="detail__popup__countOption">';
		txt += '<input name="optionCount" readonly="readonly" value="' + len + '">'
		txt += '<p>개의 리워드 옵션을 선택하셨습니다.</p></div>'
		for (let i = 0; i < len; i++) {
			let count = $(".detail__funding__selected__number").eq(i).val()*1;
			let optionName = $(".detail__funding__selected__subtitle").eq(i).html();
			let optionPrice = $(".detail__funding__selected__price").eq(i).html();
			
			txt += '<div class="detail__popup__liner"><p>' + optionName + '</p>';
			txt += '<input name=""><p>개</p><p>'+optionPrice+'</p></div>'
		}

		txt += '</form>'
		$(".detail__popup__wrap").html(txt).addClass('block');
	} else {
		alert("하나 이상의 옵션을 선택해주세요")
	}


}

