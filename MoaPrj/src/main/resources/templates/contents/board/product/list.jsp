<!-- prod/list -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<main id="body">

	<h1 class="hidden">Body</h1>

	<div id="container">

		<section class="noodle-list">
			<h1 class="hidden">noodle-list</h1>

			<nav class="noodle-list-category">
				<h1 class="hidden">notice-list-category</h1>
				<ul>
					<li><a class="${param.m==''?'current':''}" href="list?m=&p=1&s=${param.s}">전체</a></li>
					<li><a class="${param.m=='농심'?'current':''}" href="list?m=농심&p=1&s=${param.s}">농심</a></li>
					<li><a class="${param.m=='삼양'?'current':''}" href="list?m=삼양&p=1&s=${param.s}">삼양</a></li>
					<li><a class="${param.m=='오뚜기'?'current':''}" href="list?m=오뚜기&p=1&s=${param.s}">오뚜기</a></li>
					<li><a class="${param.m=='팔도'?'current':''}" href="list?m=팔도&p=1&s=${param.s}">팔도</a></li>
					<li><a class="${param.m=='PB'?'current':''}" href="list?m=PB&p=1&s=${param.s}">PB</a></li>
					<li>
						<form action="list" method="get">
							<input class="search" type="text" name="s" value="${param.s}" placeholder="검색"> <input
								type="submit" value="&#xf002">
						</form>
					</li>
					<li><label>컵라면</label> <input type="checkbox" name="c" value="컵"></li>
				</ul>
			</nav>

			<c:set var="page" value="${(empty param.p)?1:param.p}" />
			<c:set var="lastNum" value="${fn: substringBefore(count/16+1,'.')}" />

			<section class="noodle-img">
				<h1 class="hidden">noodle-image</h1>
				<div class="noodle-list-img">

					<c:forEach var="l" items="${list}">

						<div class="item">
							<div class="item-img">
								<img class="rm-img list" src="${l.img}" value="${l.id}">
							</div>
							<div class="item-name">
								<span>${l.name}</span>
							</div>
							<div class="review-link">
								<div>
									<a href=""> <i class="far fa-comment-dots"></i> <span>${999}</span>
									</a>
								</div>
								<div>
									<a href=""> <i class="far fa-heart"></i> <span>${999}</span>
									</a>
								</div>
							</div>
						</div>

					</c:forEach>
				</div>
			</section>

			<div class="pager">

				<c:set var="page" value="${(empty param.p)?1:param.p}" />
				<c:set var="startNum" value="${page-(page-1)%5}" />
				<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/16),'.')}" />

				<div class="list">
					<div class="current">${page}</div>
					<div>/</div>
					<div>${lastNum}</div>
					<div>pages</div>
				</div>

				<div class="pageLink">
					<c:choose>
						<c:when test="${startNum>1}">
							<a href="list?m=${param.m}&p=${startNum-5}&s=${param.s}">
								<i class="fas fa-arrow-left fa-2x"></i>
							</a>
						</c:when>
						<c:otherwise>
							<i class="fas fa-arrow-left fa-2x" onclick="alert('이전 페이지가 없습니다.');"></i>
						</c:otherwise>
					</c:choose>

					<ul class="flex">
						<c:forEach begin="0" end="4" var="i">
							<c:if test="${startNum+i<=lastNum}">
								<li><a class="${(page==startNum+i)?'current':''}"
										href="list-data?m=${param.m}&p=${startNum+i}&s=${param.s}">${startNum+i}</a>
								</li>
							</c:if>
						</c:forEach>
					</ul>

					<c:choose>
						<c:when test="${startNum+4<lastNum}">
							<a href="list?m=${param.m}&p=${startNum+5}&s=${param.s}">
								<i class="fas fa-arrow-right fa-2x"></i>
							</a>
						</c:when>
						<c:otherwise>
							<i class="fas fa-arrow-right fa-2x" onclick="alert('다음 페이지가 없습니다.');"></i>
						</c:otherwise>
					</c:choose>
				</div>

			</div>
		</section>

		<section class="noodle-ranking">
			<h1 class="hidden">noodle-ranking</h1>

			<div class="ranking-menu">
				<div>
					<span class="table-title">Ranking</span>
					<div class="table-sub-left">
						<span>(2019년 3분기 매출액 - 단위:백만원)</span>
					</div>
				</div>

				<!-- <div class="radio">
					<div>
						<label for="">판매량</label> <input type="radio" name="ranking" value="sales" checked="checked">
					</div>
					<div>
						<label for="">좋아요</label> <input type="radio" name="ranking" value="likes">
					</div>
				</div> -->
			</div>


			<table class="noodle-ranking-table">

				<c:forEach var="r" items="${rank}" varStatus="rank">
					<tr>
						<td class="cell-rank">${rank.index+1}</td>
						<td class="cell-rank">(-)</td>
						<td class="cell-img"><img class="rm-img ranking" src="${r.img}" value="${r.id}"></td>
						<td>
							<fmt:formatNumber value="${r.amount}" type="number" />
						</td>
						<td class="value"><a href="">★★★☆☆</td>
						<td><a href=""><i class="fas fa-heart" style="color: #ff3575"></i><br /></a>${999}</a></td>
						<td><img class="logo-img" src="${r.logo}" alt=""></td>
					</tr>
				</c:forEach>

			</table>

			<div class="table-sub-right">

				<span>(판매량 출처: FIS 식품산업통계정보)</span>

			</div>
		</section>

	</div>

</main>


<script src="/js/product/list.js"></script>