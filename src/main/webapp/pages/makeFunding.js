let idx = 0;
$(document).on("click", ".MF__addTitle", function() {
	let txt =
		'<div class="MF__item"><img src="/funding/assets/close.svg" class="MF__close"><input class="MF__input__subTitle" placeholder="소제목을 입력하세요">'
	txt += '</div>';

	$("#MF__content").append(txt);
});

$(document).on("click", ".MF__addParagraph", function() {
	let txt =
		'<div class="MF__item"><img src="/funding/assets/close.svg" class="MF__close"><textarea class="MF__input__paragraph" placeholder="내용을 입력하세요"></textarea>'

	txt += '</div>';

	$("#MF__content").append(txt);
});

$(document).on("change", ".MF__addImage", function(e) {
	idx++;
	const addTarget = $(this).parent().parent().parent().parent();
	let txt = '<div class="MF__item"><img src="/funding/assets/close.svg" class="MF__close">'
	txt += '<img id="MF__image__' + idx + '" class="MF__item__image" src="">'
	txt += '</div>';
	$("#MF__content").append(txt);

	readURL(this, '#MF__image__' + idx);

})

$(".MF__basic__addImage").change(function(){
	let txt = '<img id="MF__basic__thumb" src="">'
	$(".MF__basic__imgPreview").html(txt);
	readURL(this, '#MF__basic__thumb');
})

$(document).on("click", ".MF__close", function() {
	if (confirm("해당 항목을 삭제하시겠습니까?")) {
		$(this).parent().remove();
	}
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
	console.log("keyup")
	$(this).parent().parent().find(".MF__reward__warning.content").html("").removeClass("block");
})
$(document).on("keyup", ".MF__reward__price", function() {
	$(this).parent().parent().find(".MF__reward__warning.price").html("").removeClass("block");
})
$(document).on("keyup", ".MF__reward__amount", function() {
	$(this).parent().parent().find(".MF__reward__warning.amount").html("").removeClass("block");
})

$(document).on("click", ".MF__reward__close", function(){
	if ($(".MF__reward").length > 1){
		$(this).parent().remove();
	}else{
		alert("최소 1개의 리워드를 입력해야 합니다.")
	}
})


$("#MF__addReward").click(function() {
	if ($(".MF__reward").length < 5) {
		let txt = '<div class="MF__reward"><img src="/funding/assets/close.svg" class="MF__reward__close">';
		txt += '<div class="MF__reward__liner"><p>리워드 내용</p><input class="MF__reward__content" placeholder="예)사과 1개 + 배 2개">'
		txt += '</div><div class="MF__reward__liner"><p>후원 금액(원)</p><input class="MF__reward__price" type="number" value="10000">'
		txt += '</div><div class="MF__reward__liner"><p>최대 수량</p><input class="MF__reward__amount" type="number" value="99"></div>'
		txt += '<div class="MF__reward__warningBox"><p class="MF__reward__warning content">리워드 내용을 5자 이상으로 입력해주세요.</p>'
		txt += '<p class="MF__reward__warning price">최소 후원 금액은 1,000원입니다.</p><p class="MF__reward__warning amount">최소 수량은 1개입니다.</p></div></div>'

		$("#MF_rewards").append(txt);
	}else{
		alert("리워드는 5개까지 추가할 수 있습니다.")
	}
})

function moveTab(currentIdx, idx){
	$(".MF__tab").removeClass("selected");
	$("#MF__tab__"+idx).addClass("selected");
	
	$(".MF__tabContent").removeClass("selected");
	$("#tabContent__"+idx).addClass("selected");
	
	$('html, body').animate({scrollTop: '0px'}, 300);

	if(currentIdx*1 === 1){
		checkFirstTab();
	}
}

function checkFirstTab(){
	
}

