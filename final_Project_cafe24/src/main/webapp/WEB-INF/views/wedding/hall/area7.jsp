<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="content search-result new-4-cols-layout">
	<div class="product-tiles-grid">
		<c:choose>
			<c:when test="${!empty area7}">
				<c:forEach var="halls" items="${area7}">
					<article class="product-tiles-grid-item product-tiles-grid-item-medium product-tiles-grid-item-small hover-link  border-right">
						<a class="product-tiles-grid-item-link" href="${halls.hall_link}">
							<div class="product-tiles-grid-item-image-wrapper">
								<div class="product-tiles-grid-item-image ">
									<img alt="이미지입니다." style="width: 100%; height: -webkit-fill-available;"
										src="/management/displayFile?fileName=${halls.fullName}">
								</div>
							</div>
							<p class="online-exclusive-badge text-left" data-component-attr-id="online-exclusive">
								<font style="vertical-align: inherit;">
									<font style="vertical-align: inherit;">홀 주소 : ${halls.hall_location}</font><br/>
									<font style="vertical-align: inherit;">홀 수용인원 ${halls.hall_person} 명</font><br/>
									<font style="vertical-align: inherit;">${halls.hall_price}</font><br/>
									<font style="vertical-align: inherit;">${halls.hall_thema}</font><br/>
									<font style="vertical-align: inherit;">${halls.hall_contents}</font><br/>
									<font style="vertical-align: inherit;">${halls.hall_address}</font><br/>
								</font>
							</p>
						</a>
						<button type="button" class="favorite" title="Save for later">
							<font style="vertical-align: inherit;">
								<font style="vertical-align: inherit;">나중에 저장</font>
							</font>
						</button>
					</article>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<article class="product-tiles-grid-item product-tiles-grid-item-medium product-tiles-grid-item-small hover-link  border-right">
					<a class="product-tiles-grid-item-link" href="#">
						<div class="product-tiles-grid-item-image-wrapper">
							<div class="product-tiles-grid-item-image ">
							
							</div>
						</div>
						<p class="online-exclusive-badge text-left" data-component-attr-id="online-exclusive">
							<font style="vertical-align: inherit;">
								<font style="vertical-align: inherit;">해당지역에 정보가 없습니다.</font>
							</font>
						</p>
					</a>
					<button type="button" class="favorite" title="Save for later">
						<font style="vertical-align: inherit;">
							<font style="vertical-align: inherit;">나중에 저장</font>
						</font>
					</button>
				</article>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<%@include file="../include/footer.jsp"%>