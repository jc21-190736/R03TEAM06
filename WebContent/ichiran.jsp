<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Optional"%> 
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">

</script>

<meta charset="UTF-8">
<title>一覧画面</title>
</head>

<!-- 
Optional<List<String[]>> optList = Optional.ofNullable((List<String[]>) request.getAttribute("list"));
List<String[]> list = new ArrayList<>();
if (optList.isPresent()) {
	list = optList.get();
}
 -->


<body onload="LoadProc();">
	<table border="5" width="100%" cellspacing="0" cellpadding="2"
		align="center">
		<tr>
			<th>食材</th>
		</tr>
 
		for (String[] s : list) {
			//if (s[2] == "1") {
		%>
		<tr>
			<td colspan="2" align="center"><%=s[1]%></td>
			<td colspan="2" align="left"><%=s[3]%>個</td>
		</tr>
		<tr>
			<td height="70">image</td>

			<td id="text" align="center">
				<form action="/admin/measurestart" method="get">
					<a
						style="display: block; padding: 0 0; text-decoration: none; width: 100%;"
						onclick=<form method="get" action="Ichiran">
							<input type="submit" name="aaa"　value=<%=s[2]%> />
							</form>></a>
					-->
			</td>


			<td id="text" align="center">

				<form action="/admin/measurefinish" method="get">
					<a
						style="display: block; padding: 0 0; text-decoration: none; width: 100%;"
						onclick=<form method="get" action="Ichiran">
							<input type="submit" name="aaa"　value=<%=s[2]%> />
							</form>>
					</a>
				</form>

			</td>


			<td align="center"><a
				style="display: block; padding: 0 0; text-decoration: none; width: 100%;"
				href="#">増減</a></td>
		</tr>
		<%
		//}
		}
		%>
	</table>

	<table border="5" width="100%" cellspacing="0" cellpadding="2"
		align="center">
		<tr>
			<th>日用品</th>
		</tr>

		<tr>
			<td colspan="2" align="center">商品名</td>
			<td colspan="2" align="left">個数</td>
		</tr>
		<tr>
			<td height="70">image</td>
			<td align="center"><a
				style="display: block; padding: 0 0; text-decoration: none; width: 100%;"
				href="/ichiran/Ichiran" 　onclick=alert( "a");　name="sonekeisoku">計測開始</a></td>
			<td align="center"><a
				style="display: block; padding: 0 0; text-decoration: none; width: 100%;"
				href="/ichiran/Ichiran" 　onclick=alert( "a");　name="stwokeisoku">計測終了</a></td>
			<td align="center"><a
				style="display: block; padding: 0 0; text-decoration: none; width: 100%;"
				href="#">増減</a></td>
		</tr>

	</table>






</body>
</html>