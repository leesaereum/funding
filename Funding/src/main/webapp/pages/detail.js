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
		($("#optionPrice_"+optionID).val()*1 * options[optionID]).toLocaleString() + "원"
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
		total += count * ($("#optionPrice_"+id).val()*1);
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

function add__option(optionID, optionName) {
	if (document.getElementById("option_" + optionID)) {
		alert("이미 등록된 옵션입니다.");
	} else {
		let txt = $("#selected__box").html();
		txt +=
			'<div class="detail__funding__selected" data-optionNum="'+optionID+'" id="option_' + optionID + '">';
		txt += '<div class="detail__funding__selected__top">';
		txt +=
			'<p class="detail__funding__selected__subtitle">'+ optionName +'</p>';
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
	let total = $(".detail__funding__total__totalPrice > strong").html();
	total = total.replaceAll(",", "") * 1;

	if (len > 0) {
		let txt = '<div class="detail__popup"><form class="detail__popup__form" action="/fundingPayment.do" id="finalForm" method="post">';
		txt += '<div class="detail__popup__countOption"><input name="optionCount" readonly="readonly" value="' + len + '">'
		txt += '<p>개의 리워드 옵션을 선택하셨습니다.</p></div>'
		for (let i = 0; i < len; i++) {
			let count = $(".detail__funding__selected__number").eq(i).val()*1;
			let optionName = $(".detail__funding__selected__subtitle").eq(i).html();
			let optionPrice = $(".detail__funding__selected__price").eq(i).html();
			txt += '<div class="detail__popup__option">'
			txt += '<p class="detail__popup__subtitle">옵션'+(i+1)+'</p>'
			txt += '<p class="detail__popup__optionName">' + optionName + '</p>';
			txt += '<div class="detail__popup__right">'
			txt += '<p class="detail__popup__optionPrice">'+optionPrice+'</p>'
			txt += '<p class="detail__popup__countTxt">개</p>'
			txt += '<input class="detail__popup__count" name=""" readonly="readonly" value="'+count+'"></div>'
			txt += '</div>'
		}
		txt += '<div class="detail__popup__total">'
		txt += '<p class="detail__popup__totalTxt">합계 <span>'+ total.toLocaleString() +'</span>원</p>'
		txt += '<input type="hidden" readonly="readonly" value="'+total+'"></form></div>'
		txt += '<div class="detail__popup__bottom"><p>목표금액이 달성되지 않으면 결제한 금액은 전액 환불됩니다.</p>'
		txt += '<div class="detail__popup__payMethod"><p class="detail__popup__payMethod__ini">결제하기</p></div></div>'
		$(".detail__popup__wrap").html(txt).addClass('block');
	} else {
		alert("하나 이상의 옵션을 선택해주세요")
	}
}
$(document).on("click", ".detail__popup__wrap", function(e) {
	e.stopPropagation();
	$(".detail__popup__wrap").html("").removeClass('block');
});
$(document).ready(function(){
    IMP.init('imp28775004'); 
})
$(document).on("click", ".detail__popup__payMethod__kakao", function(e) {
	e.stopPropagation();
	
	let pg = "kakaopay"
	payOn(pg);
});

function payOn(pg){

	IMP.request_pay({
    	pg : pg, 
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : '해피펀딩',
        amount : 100,
        //amount : $(".detail__popup__totalTxt > span").html().replaceAll(",","")*1,
        buyer_email : $(".signedIn_email").html(),
        buyer_name : $(".signedIn_email").html(),
        buyer_tel : '',
        buyer_addr : '',
        buyer_postcode : '',
        m_redirect_url : 'happybean.naver.com'
    }, function(rsp) {
        if ( rsp.success ) {
            var msg = '펀딩에 참여해주셔서 감사합니다.';
            trans();
        }else{
	console.log("request - pay")
        	console.log(rsp)
        }
    });
}
$(document).on("click", ".detail__popup__payMethod__ini", function(e) {
	e.stopPropagation();
	let pg = "html5_inicis"
	payOn(pg);
});

function trans(){
	let form = document.createElement('form'); // 폼객체 생성
	
	let order_customer = document.createElement('input');
	order_customer.setAttribute('type', 'text');
	order_customer.setAttribute('name', 'order_customer');
	order_customer.setAttribute('value', $(".signedIn_email").html())
	form.appendChild(order_customer);
	
	let order_funding = document.createElement('input');
	order_funding.setAttribute('type', 'number');
	order_funding.setAttribute('name', 'order_funding');
	order_funding.setAttribute('value', $("#fidfid").val());
	form.appendChild(order_funding);
	
	for(let i = 0; i<$(".detail__popup__option").length; i++){
		let optionNum = $(".detail__funding__selected__close").eq(i).attr("data-optionid")*1
		
		let order_option = document.createElement('input');
		order_option.setAttribute('type', 'number');
		order_option.setAttribute('name', 'order_option'+i);
		order_option.setAttribute('value', optionNum)
		form.appendChild(order_option);
		
		let order_price = document.createElement('input');
		order_price.setAttribute('type', 'text');
		order_price.setAttribute('name', 'order_price'+i);
		order_price.setAttribute('value', $("#optionPrice_"+optionNum).val()*1)
		form.appendChild(order_price);
		
		let order_count = document.createElement('input');
		order_count.setAttribute('type', 'number');
		order_count.setAttribute('name', 'order_count'+i);
		order_count.setAttribute('value', $(".detail__popup__count").eq(i).val()*1)
		form.appendChild(order_count);
		
		
		form.setAttribute('method', 'post'); //get,post 가능
	form.setAttribute('action', "/Funding/fundingOrder.do"); //보내는 url > 나중에 login.do로 보내야 함;
	document.body.appendChild(form);
	form.submit();
	}
}
