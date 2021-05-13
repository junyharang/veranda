<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
/* position for grid system */
int offset = 2;
int mywidth = twelve - 2 * offset;
int formleft = 3;
int formright = twelve - formleft;
//int rightButton = 2 ;
%>
<!DOCTYPE html>
<html>
<head>
<script>
	$(document).ready(function() {
	});
</script>
</head>
<body>
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>상품 등록</h4>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" action="<%=FormYes%>" method="post">
					<input type="hidden" name="command" value="prInsert">
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="state">카테고리</label>
						<div class="col-sm-<%=formright%>"></div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="title">글
							제목</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" id="title" name="title"
								value="${bean.title}"> <span class="err">${errtitle}</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="content">글
							내용</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" id="content"
								name="content" value="${bean.content}"> <span
								class="err">${errcontent}</span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
							<button type="submit" class="btn btn-default">게시물 작성</button>
							&nbsp;&nbsp;&nbsp;
							<button type="reset" class="btn btn-default">초기화</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>


