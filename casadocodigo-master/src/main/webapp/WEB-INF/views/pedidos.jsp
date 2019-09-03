<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Pedidos">
	<div class="container">
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>ID</th>
				<th>Valor</th>
				<th>Data Pedido</th>
				<th>Títulos</th>
			</tr>
			<c:forEach items="${pedidos }" var="pedidos">
				<tr>
					<th>${pedidos.id }</th>
					<th>${pedidos.valor }</th>
					<th><fmt:formatDate value="${pedidos.data.time }" pattern="dd/MM/yyyy"/></th>
					<th>${pedidos.titulos }</th>
				</tr>
			</c:forEach>



		</table>
	</div>

</tags:pageTemplate>