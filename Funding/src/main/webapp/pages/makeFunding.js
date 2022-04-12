let idx = 0;
$(document).on("click", ".MF__addTitle", function() {
	let txt =
		'<div class="MF__item"><img src="/Funding/assets/close.svg" class="MF__close"><input class="MF__input__subTitle" placeholder="소제목을 입력하세요">'
	txt += '</div>';

	$("#MF__content").append(txt);
});

$(document).on("click", ".MF__addParagraph", function() {
	let txt =
		'<div class="MF__item"><img src="/Funding/assets/close.svg" class="MF__close"><textarea class="MF__input__paragraph" placeholder="내용을 입력하세요"></textarea>'

	txt += '</div>';

	$("#MF__content").append(txt);
});

$(document).on("change", ".MF__addImage", function(e) {
	idx++;
	const addTarget = $(this).parent().parent().parent().parent();
	let txt = '<div class="MF__item"><img src="/Funding/assets/close.svg" class="MF__close">'
	txt += '<img id="MF__image__' + idx + '" class="MF__item__image" src="">'
	txt += '</div>';
	$("#MF__content").append(txt);

	readURL(this, '#MF__image__' + idx);

})

$(".MF__basic__addImage").change(function() {
	let txt = '<img id="MF__basic__thumb" src="">'
	$(".MF__basic__imgPreview").html(txt);
	readURL(this, '#MF__basic__thumb');
})

function readURL(input, previewId) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$(previewId).attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}

$(document).on("click", ".MF__close", function() {
	if (confirm("해당 항목을 삭제하시겠습니까?")) {
		$(this).parent().remove();
	}
})



$(document).on("blur", ".MF__reward__content", function() {
	if ($(this).val().length < 5) {
		$(this).parent().parent().find(".MF__reward__warning.content").html("리워드 내용을 최소 5자 이상으로 입력해주세요").addClass("block");
	}
	if ($(this).val().length > 60) {
		$(this).parent().parent().find(".MF__reward__warning.content").html("리워드 내용은 60자를 초과할 수 없습니다.").addClass("block");
	}
})
$(document).on("blur", ".MF__reward__price", function() {
	if ($(this).val() * 1 < 1000) {
		console.log('priceWraning')
		$(this).parent().parent().find(".MF__reward__warning.price").html("최소 후원 금액은 1,000원입니다.").addClass("block");
	}
	if ($(this).val() * 1 > 1000000) {
		$(this).parent().parent().find(".MF__reward__warning.price").html("최대 후원 금액은 1,000,000원입니다.").addClass("block");
	}
})
$(document).on("blur", ".MF__reward__amount", function() {
	if ($(this).val() * 1 < 1) {
		$(this).parent().parent().find(".MF__reward__warning.amount").html("최소 수량은 1개입니다.").addClass("block");
	}
	if ($(this).val() * 1 > 9999) {
		$(this).parent().parent().find(".MF__reward__warning.amount").html("최대 수량은 999개입니다.").addClass("block");
	}
})

$(document).on("keyup", ".MF__reward__content", function() {
	$(this).parent().parent().find(".MF__reward__warning.content").html("").removeClass("block");
})
$(document).on("keyup", ".MF__reward__price", function() {
	$(this).parent().parent().find(".MF__reward__warning.price").html("").removeClass("block");
})
$(document).on("keyup", ".MF__reward__amount", function() {
	$(this).parent().parent().find(".MF__reward__warning.amount").html("").removeClass("block");
})

$(document).on("click", ".MF__reward__close", function() {
	if ($(".MF__reward").length > 1) {
		$(this).parent().remove();
	} else {
		alert("최소 1개의 리워드를 입력해야 합니다.")
	}
})


$("#MF__addReward").click(function() {
	if ($(".MF__reward").length < 5) {
		let txt = '<div class="MF__reward"><img src="/Funding/assets/close.svg" class="MF__reward__close">';
		txt += '<div class="MF__reward__liner"><p>리워드 내용</p><input class="MF__reward__content" placeholder="예)사과 1개 + 배 2개">'
		txt += '</div><div class="MF__reward__liner"><p>후원 금액(원)</p><input class="MF__reward__price" type="number" value="10000">'
		txt += '</div><div class="MF__reward__liner"><p>최대 수량</p><input class="MF__reward__amount" type="number" value="99"></div>'
		txt += '<div class="MF__reward__warningBox"><p class="MF__reward__warning content">리워드 내용을 5자 이상으로 입력해주세요.</p>'
		txt += '<p class="MF__reward__warning price">최소 후원 금액은 1,000원입니다.</p><p class="MF__reward__warning amount">최소 수량은 1개입니다.</p></div></div>'

		$("#MF_rewards").append(txt);
	} else {
		alert("리워드는 5개까지 추가할 수 있습니다.")
	}
})

function moveTab(currentIdx, idx) {
	if (currentIdx * 1 === 1) {
		if (checkFirstTab()) {
			executeMove(idx);
		}
	}

	if (currentIdx * 1 === 2) {
		if (idx * 1 === 1) {
			//뒤로 돌아가기
			executeMove(idx);
		} else {
			//다음으로 진행하기
			if (checkSecondTab()) {
				executeMove(idx);
			}
		}
	}

	if (currentIdx * 1 === 3) {
		executeMove(idx);
	}
}

function executeMove(idx) {
	$(".MF__tab").removeClass("selected");
	$("#MF__tab__" + idx).addClass("selected");

	$(".MF__tabContent").removeClass("selected");
	$("#tabContent__" + idx).addClass("selected");

	$('html, body').animate({ scrollTop: '0px' }, 300);
}

$(".MF__basic__input").keydown(function() {
	$(this).next().removeClass('block');
})

function checkFirstTab() {
	$('.MF__basic__warning').removeClass('block');
	let target;
	target = $("#MF__basic__title");
	if (target.val().length > 24 || target.val().length < 6) {
		target.next().addClass('block');
	}
	target = $(".MF__basic__imgPreview");
	if (!target.children('img').length) {
		target.next().addClass('block');
	}
	target = $("#MF__basic__goal");
	if (target.val() * 1 > 1000000000 || target.val() * 1 < 100000) {
		target.next().addClass('block');
	}
	let today = new Date();
	target = $("#MF__basic__startDate");
	let startDate = new Date(target.val());
	if (target.val() === "" || startDate <= today) {
		target.next().addClass('block');
	}
	target = $("#MF__basic__endDate");
	let endDate = new Date(target.val());
	let compareDate = new Date();
	compareDate.setDate(startDate.getDate() + 5);
	if (target.val() === "" || endDate < compareDate) {
		target.next().addClass('block');
	}

	if ($(".MF__basic__warning.block").length > 0) {
		return false;
	} else {
		return true;
	}
}

function checkSecondTab() {
	for (let i = 0; i < $(".MF__reward__content").length; i++) {
		let target = $(".MF__reward__content").eq(0);
		if (target.val().length < 5) {
			target.parent().parent().find(".MF__reward__warning.content").html("리워드 내용을 최소 5자 이상으로 입력해주세요").addClass("block")
		}
	}

	if ($(".MF__reward__warning.block").length > 0) {
		return false;
	} else {
		return true;
	}
}

const Editor = toastui.Editor;

const editor = new Editor({
	el: document.querySelector('#editor'),
	height: '500px',
	initialEditType: 'wysiwyg',
	previewStyle: 'vertical'
});

$(".MF__moveTab__btn.finish").click(function() {
	let form = document.createElement('form'); // 폼객체 생성
	
	let funding_banner = document.createElement('input');
	funding_banner.setAttribute('type', 'text');
	funding_banner.setAttribute('name', 'funding_banner');
	funding_banner.setAttribute('value', $("#MF__basic__thumb").attr('src'))
	form.appendChild(funding_banner);
	
	let funding_title = document.createElement('input');
	funding_title.setAttribute('type', 'text');
	funding_title.setAttribute('name', 'funding_title');
	funding_title.setAttribute('value', $("#MF__basic__title").val())
	form.appendChild(funding_title);
	
	let funding_openAt = document.createElement('input');
	funding_openAt.setAttribute('type', 'date');
	funding_openAt.setAttribute('name', 'funding_openAt');
	funding_openAt.setAttribute('value', $("#MF__basic__startDate").val())
	form.appendChild(funding_openAt);
	
	let funding_closeAt = document.createElement('input');
	funding_closeAt.setAttribute('type', 'date');
	funding_closeAt.setAttribute('name', 'funding_closeAt');
	funding_closeAt.setAttribute('value', $("#MF__basic__endDate").val())
	form.appendChild(funding_closeAt);
	
	let funding_purpose = document.createElement('input');
	funding_purpose.setAttribute('type', 'number');
	funding_purpose.setAttribute('name', 'funding_purpose');
	funding_purpose.setAttribute('value', $("#MF__basic__goal").val())
	form.appendChild(funding_purpose);
	
	let funding_fee = document.createElement('input');
	funding_fee.setAttribute('type', 'text');
	funding_fee.setAttribute('name', 'funding_fee');
	funding_fee.setAttribute('value', $("#MF__basic__fee").val())
	form.appendChild(funding_fee);
	
	let funding_content = document.createElement('input');
	funding_content.setAttribute('type', 'text');
	funding_content.setAttribute('name', 'funding_content');
	funding_content.setAttribute('value', editor.getHTML())
	form.appendChild(funding_content);
	
	for(let i = 0; i<$(".MF__reward").length; i++){
		
		let option_numbering = document.createElement('input');
		option_numbering.setAttribute('type', 'number');
		option_numbering.setAttribute('name', 'option_numbering_'+i);
		option_numbering.setAttribute('value', i)
		form.appendChild(option_numbering);
		
		let option_name = document.createElement('input');
		option_name.setAttribute('type', 'text');
		option_name.setAttribute('name', 'option_name_'+i);
		option_name.setAttribute('value', $(".MF__reward__content").eq(i).val())
		form.appendChild(option_name);
		
		let option_price = document.createElement('input');
		option_price.setAttribute('type', 'number');
		option_price.setAttribute('name', 'option_price_'+i);
		option_price.setAttribute('value', $(".MF__reward__price").eq(i).val())
		form.appendChild(option_price);
		
		let option_amount = document.createElement('input');
		option_amount.setAttribute('type', 'number');
		option_amount.setAttribute('name', 'option_amount_'+i);
		option_amount.setAttribute('value', $(".MF__reward__amount").eq(i).val())
		form.appendChild(option_amount);
	}
	console.log(form)
	
	form.setAttribute('method', 'post'); //get,post 가능
	form.setAttribute('action', "/Funding/sFOApply.do"); //보내는 url > 나중에 login.do로 보내야 함;
	document.body.appendChild(form);
	form.submit();
})
