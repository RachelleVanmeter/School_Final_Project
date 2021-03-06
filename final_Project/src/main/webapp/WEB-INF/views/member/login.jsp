<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./include/header.jsp"%>
<section class="content">
	<div class="container">
		<div class="col-lg-12 col-md-12 col-sm-6">
			<div class="box ">
				<div class="box-header with-border">
					<h3>로그인</h3>
				</div>
				<div class="box-body">
					<form action="/member/loginPost" method="post">
						<div class="form-group has-feedback">
							<input type="text" name="mwid" class="form-control" placeholder="USER ID" required />
						</div>
						<div class="form-group has-feedback">
							<input type="password" name="mwpw" class="form-control" placeholder="USER PW" required />
						</div>
						<div class="box-footer">
							<div class="col-xs-8">
								<label><input type="checkbox" name="useCookie" /> 로그인 유지</label>
							</div>
							<div class="col-xs-4">
								<input type="submit" class="btn btn-primary btn-block btn-flat" value="로그인" />
							</div>
							<div class="col-xs-8"></div>
							<div class="col-xs-4">
								<a class="btn btn-primary btn-block btn-flat" href="/member/register">회원가입 하러가기</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
	var message = '${message}';
	
	if (message != null && message != '') { alert(message); }
</script>
<%@include file="./include/footer.jsp"%>