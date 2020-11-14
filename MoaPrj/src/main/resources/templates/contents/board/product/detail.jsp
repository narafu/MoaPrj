
<!-- prod/detail -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<main id="body">
	<h1 class="hidden">main</h1>

	<div id="container">

		<span class="prod-detail-title">${nutri.item}</span>
		
		<div class="prod-title-img">
			<img src="${nutri.img}" alt="">
		</div>

		<section class="prod-detail-board-top">
			<h1 class="hidden">prod-detail-board</h1>
			<table class="prod-detail-table-top">
				<tr>
					<th>제조사</th>
					<td><img src="${nutri.logo}" alt=""></td>
				</tr>
				<tr>
					<th>용량</th>
					<td>${nutri.capacity}g</td>
				</tr>
				<tr>
					<th>열량</th>
					<td>${nutri.calorie}kcal</td>
				</tr>
				<tr>
					<th>원재료<br>및<br>원산지
					</th>
					<td>${nutri.details}</td>
				</tr>
			</table>
		</section>

		<section class="go-to-review">
			<h1 class="hidden">go-to-review</h1>
			<div>
				<a>Go to Review</a>
			</div>
		</section>


		<section class="prod-detail-board-bottom">
			<h1 class="hidden">prod-detail-table</h1>
			<table class="prod-detail-table-bottom">
				<thead>
					<tr>
						<td class="thead">영양성분표</td>
						<td class="thead">나트륨</td>
						<td class="thead">탄수화물</td>
						<td class="thead">당류</td>
						<td class="thead">지방</td>
						<td class="thead">트랜스지방</td>
						<td class="thead">포화지방</td>
						<td class="thead">콜레스테롤</td>
						<td class="thead">단백질</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th class="thead">1회 제공량</th>
						<td>${nutri.natrium}mg</td>
						<td>${nutri.carbohydrate}g</td>
						<td>${nutri.sugars}g</td>
						<td>${nutri.fat}g</td>
						<td>${nutri.transFat}g</td>
						<td>${nutri.saturatedFat}g</td>
						<td>${nutri.cholesterol}mg</td>
						<td>${nutri.protein}g</td>
					</tr>
					<tr>
						<th class="thead">영양성분<br>기준치(%)
						</th>
						<td>${Math.round(nutri.natrium/nutriStd.natrium*100)}%</td>
						<td>${Math.round(nutri.carbohydrate/nutriStd.carbohydrate*100)}%</td>
						<td>${Math.round(nutri.sugars/nutriStd.sugars*100)}%</td>
						<td>${Math.round(nutri.fat/nutriStd.fat*100)}%</td>
						<td>X</td>
						<td>${Math.round(nutri.saturatedFat/nutriStd.saturatedFat*100)}%</td>
						<td>${Math.round(nutri.cholesterol/nutriStd.cholesterol*100)}%</td>
						<td>${Math.round(nutri.protein/nutriStd.protein*100)}%</td>
					</tr>
				</tbody>
			</table>
			<div>
				(% 영양성분 기준치 : 1일 영양성분 기준치에 대한 비율)</
				<div>
		</section>
	</div>
</main>