<style>
.banners__wrap {
	width: 100%; 
	position : relative;
	height: 0;
	padding-top: 21.9%;
	box-sizing: border-box;
	position: relative;
}

.banners {
	position: absolute !important;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}
.bannerImg{
	width: 100%;
	height: auto;
}
</style>
<script src="/Funding/libraries/splide.min.js"></script>
<link rel="stylesheet" href="/Funding/libraries/splide.min.css">
<script>
	document.addEventListener('DOMContentLoaded', function() {
		var splide = new Splide('.splide', {
			type : 'loop',
			autoplay : true,
		});
		splide.mount();
	});
</script>
<div class="banners__wrap">
	<div class="splide banners">
		<div class="splide__track">
			<ul class="splide__list">
				<li class="splide__slide">
					<div style="background-color: #41C982">
						<img class="bannerImg" src="/Funding/assets/banners/banner01.png">
					</div>
				</li>
				<li class="splide__slide">
					<div style="background-color: #41C982">
						<img class="bannerImg" src="/Funding/assets/banners/banner02.png">
					</div>
				</li>
				<li class="splide__slide">
					<div style="background-color: #699CEE">
						<img class="bannerImg" src="/Funding/assets/banners/banner03.png">
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>
