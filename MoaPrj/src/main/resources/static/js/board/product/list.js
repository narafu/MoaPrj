
addEventListener("load", function () {

	var container = document.querySelector("#container");

	var categoryUl = container.querySelector(".noodle-list-category ul");
	var categoryA = categoryUl.querySelectorAll("a");

	var pager = container.querySelector(".pager");
	var pageLink = pager.querySelector(".pageLink>ul");
	var pagerA = pageLink.querySelectorAll("a");

	var search = categoryUl.querySelector(".search")
	var submit = categoryUl.querySelector("input[type='submit']")
	var imgSec = container.querySelector(".noodle-img");
	var listImgDiv = imgSec.querySelector(".noodle-list-img");
	var itemName = listImgDiv.querySelectorAll(".item-name");

	var checkCup = container.querySelector("input[type='checkbox']");

	var rankingSec = container.querySelector(".noodle-ranking");
	var radioSales = rankingSec.querySelector("input[value='sales']");
	var radioLikes = rankingSec.querySelector("input[value='likes']");

	var currentPage = pager.querySelector(".list .current");
	var pageShare;
	var mfrShare;
	var searchShare;
	var cupShare;

	for (var i = 0; i < itemName.length; i++) {

		if (itemName[i].innerText.includes("(")) {
			var index = itemName[i].innerText.indexOf("(");
			itemName[i].innerText = itemName[i].innerText.substring(0, index);
		}

		if (itemName[i].innerText.includes(" ")) {
			var temp = itemName[i].innerText.split(" ");
			itemName[i].innerHTML = `${temp[0]}<br/>${temp[1]}`;
		}
	}

	checkCup.oninput = function () {
		cupShare = checkCup.value;
		var xhr = new XMLHttpRequest();
		xhr.open('get', `list-data?m=${mfrShare}&p=${pageShare}&s=${searchShare}&c=${cupShare}`, true);
		xhr.send();
		xhr.onload = function () {
			var list = JSON.parse(xhr.responseText);
			listImgDiv.innerHTML = "";
			printList(list);
		}
	}

	submit.onclick = function (e) {

		e.preventDefault();
		searchShare = search.value;

		var xhr = new XMLHttpRequest();
		xhr.open('get', `list-data?m=${mfrShare}&p=${pageShare}&s=${searchShare}&c=${cupShare}`, true);
		xhr.send();
		xhr.onload = function () {
			var list = JSON.parse(xhr.responseText);
			listImgDiv.innerHTML = "";
			printList(list);
		}
	}

	pageLink.onclick = function (e) {

		e.preventDefault();
		if (e.target.nodeName != 'A') return;

		pageShare = e.target.innerText;
		currentPage.innerText = pageShare;

		for (var i = 0; i < pagerA.length; i++) {
			pagerA[i].style.color = "#000000";
		}
		e.target.style.color = "#c4001d";

		var xhr = new XMLHttpRequest();
		xhr.open('get', `list-data?m=${mfrShare}&p=${pageShare}&s=${searchShare}&c=${cupShare}`, true);
		xhr.send();
		xhr.onload = function () {
			var list = JSON.parse(xhr.responseText);
			listImgDiv.innerHTML = "";
			printList(list);
		}
	}

	container.onclick = function (e) {

		if (!e.target.classList.contains("rm-img")) return;

		var detailsId = e.target.getAttribute("value");
		var detailContainer = document.createElement("div");
		listImgDiv.append(detailContainer);

		detailContainer.style.position = "absolute";

		if (600 < e.pageX) {
			detailContainer.style.left = `${e.pageX - 300}px`;
		}
		else {
			detailContainer.style.left = `${e.pageX}px`;
		}
		detailContainer.style.top = `${e.pageY - 200}px`;

		var xhr = new XMLHttpRequest();
		xhr.open('get', 'detail?id=' + detailsId, true);
		xhr.send();

		xhr.onload = function () {

			var result = JSON.parse(xhr.responseText);

			var natrium_ = `${result.natrium / 2000 * 100}`;
			var natrium = natrium_.substr(0, 3);

			var carbohydrate_ = `${result.carbohydrate / 324 * 100}`;
			var carbohydrate = carbohydrate_.substr(0, 3);

			var sugars_ = `${result.sugars / 100 * 100}`;
			var sugars = sugars_.substr(0, 3);

			var fat_ = `${result.fat / 54 * 100}`;
			var fat = fat_.substr(0, 3);

			var saturatedFat_ = `${result.saturatedFat / 15 * 100}`;
			var saturatedFat = saturatedFat_.substr(0, 3);

			var cholesterol_ = `${result.cholesterol / 300 * 100}`;
			var cholesterol = cholesterol_.substr(0, 3);

			var protein_ = `${result.protein / 55 * 100}`;
			var protein = protein_.substr(0, 3);

			if (result.name.includes("(")) {
				var index = result.name.indexOf("(");
				result.name = result.name.substring(0, index);
			}

			if (result.name.includes(" ")) {
				var temp = result.name.split(" ");
				result.name = `${temp[0]}<br/>${temp[1]}`;
			}

			detailContainer.innerHTML =
				`<div class="detail">
				<i class="fas fa-times-circle fa-2x"></i>
				<div class="top-container">
					<div class="img-container">
						<img src="${result.img}" />
					</div>
					<div class="info-container">
						<div class="item-name">${result.name}</div>
						<div class="info-sub-container">
							<div>
								<i class="fas fa-check"></i>
								<span>용량: ${result.capacity}g</span>
							</div>
							<div>
								<i class="fas fa-check"></i>
								<span>열량: ${result.kcal}kcal</span>
							</div>
						</div>
						<div class="review-link">
							<div>
								<a href="">
									<i class="far fa-comment-dots fa-2x"></i>
									<span>${999}</span>
								</a>
							</div>
							<div>
								<a href="">
									<i class="far fa-heart fa-2x"></i>
									<span>${999}</span>
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="table-container">
					<table border="1">
						<thead>
							<tr>
								<td>나트륨</td>
								<td>탄수화물</td>
								<td>당류</td>
								<td>지방</td>
								<td>트랜스지방</td>
								<td>포화지방</td>
								<td>콜레스테롤</td>
								<td>단백질</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${result.natrium == null ? 0 : result.natrium}g</td>
								<td>${result.carbohydrate == null ? 0 : result.carbohydrate}g</td>
								<td>${result.sugars == null ? 0 : result.sugars}g</td>
								<td>${result.fat == null ? 0 : result.fat}g</td>
								<td>${result.transfat == null ? 0 : result.transfat}g</td>
								<td>${result.saturatedFat == null ? 0 : result.saturatedFat}g</td>
								<td>${result.cholesterol == null ? 0 : result.cholesterol}g</td>
								<td>${result.protein == null ? 0 : result.protein}g</td>
							</tr>
						</tbody>
						<tbody>
							<tr>
								<td>${natrium}%</td>
								<td>${carbohydrate}%</td>
								<td>${sugars}%</td>
								<td>${fat}%</td>
								<td>-</td>
								<td>${saturatedFat}%</td>
								<td>${cholesterol}%</td>
								<td>${protein}%</td>
							</tr>
						</tbody>
					</table>
					<span>(% 영양성분 기준치 : 1일 영양성분 기준치에 대한 비율)</span>
				</div>
			</div >`}

		detailContainer.onclick = function () {
			detailContainer.remove();
		}

	}

	// categoryUl.onclick = function (e) {

	// 	e.preventDefault();
	// 	if (e.target.nodeName != "A") return;

	// 	for (var i = 0; i < categoryA.length; i++) {
	// 		categoryA[i].style.color = "#666666";
	// 	}
	// 	e.target.style.color = "#c4001d";

	// 	for (var i = 0; i < pagerA.length; i++) {
	// 		pagerA[i].style.color = "#666666";
	// 	}
	// 	pagerA[0].style.color = "#c4001d";

	// 	var link = e.target.getAttribute("href");
	// 	var xhr = new XMLHttpRequest();
	// 	xhr.open('get', link, true);
	// 	xhr.send();
	// 	xhr.onload = function () {
	// 		var list = JSON.parse(xhr.responseText);
	// 		listImgDiv.innerHTML = "";

	// 		for (var i in list) {

	// 			if (list[i].name.includes("(")) {
	// 				var index = list[i].name.indexOf("(");
	// 				list[i].name = list[i].name.substring(0, index);
	// 			}

	// 			if (list[i].name.includes(" ")) {
	// 				var temp = list[i].name.split(" ");
	// 				list[i].name = `${temp[0]}<br/>${temp[1]}`;
	// 			}

	// 			var itemDiv = document.createElement("div");
	// 			listImgDiv.append(itemDiv);
	// 			itemDiv.classList.add("item");
	// 			itemDiv.innerHTML = `<div class="item-img">
	// 									<img class="rm-img" src="${list[i].img}" value="${list[i].id}">
	// 									</div>
	// 									<div class="item-name">
	// 										<span>${list[i].name}</span>
	// 									</div>
	// 									<div class="review-link">
	// 										<div>
	// 											<a href="">
	// 												<i class="far fa-comment-dots"></i>
	// 												<span>${9999}</span>
	// 											</a>
	// 										</div>
	// 										<div>
	// 											<a href="">
	// 												<i class="far fa-heart"></i>
	// 												<span>${9999}</span>
	// 											</a>
	// 										</div>
	// 									</div>`;
	// 		}

	// 	}

	// }

	function printList(list) {

		for (var i in list) {

			if (list[i].name.includes("(")) {
				var index = list[i].name.indexOf("(");
				list[i].name = list[i].name.substring(0, index);
			}

			if (list[i].name.includes(" ")) {
				var temp = list[i].name.split(" ");
				list[i].name = `${temp[0]}<br/>${temp[1]}`;
			}

			var itemDiv = document.createElement("div");
			listImgDiv.append(itemDiv);
			itemDiv.classList.add("item");
			itemDiv.innerHTML = `<div class="item-img">
								<img class="rm-img" src="${list[i].img}" value="${list[i].id}">
								</div>
								<div class="item-name">
									<span>${list[i].name}</span>
								</div>
								<div class="review-link">
									<div>
										<a href="">
											<i class="far fa-comment-dots"></i>
											<span>${9999}</span>
										</a>
									</div>
									<div>
										<a href="">
											<i class="far fa-heart"></i>
											<span>${9999}</span>
										</a>
									</div>
								</div>`;
		}
	}

})