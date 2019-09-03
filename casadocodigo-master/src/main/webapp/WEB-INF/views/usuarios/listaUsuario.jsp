<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />
<tags:pageTemplate titulo="Lista de Usuarios">
	<div>
		<a href="${s:mvcUrl('UC#form').build() }">Novo Usuario</a>

		<h1>${message }</h1>

		<h1>Lista de Usuarios</h1>
		<table>
			<tr>
				<th>Nome</th>
				<th>E-mail</th>
				<th>ROLE</th>
				<th>Adcionar ROLE</th>
				<th>Deletar o Usuario</th>
			</tr>
			<c:forEach items="${usuarios }" var="usuario">
				<tr>
					<td>${usuario.nome }</td>
					<td>${usuario.email }</td>
					<td><c:forEach items="${usuario.roles }" var="role">${role.authority}<br/></c:forEach></td>
					<td>
						<form:form action="${s:mvcUrl('UC#adicionarRole').arg(0, usuario.email).build() }"	method="POST">
							<input type="image"	src="${contextPath }resources/imagens/adicionar.png" alt="Adcionar" title="Adcionar" />
						</form:form>
					</td>
					<td><form:form
							action="${s:mvcUrl('UC#deletar').arg(0, usuario.email).build() }"
							method="POST">
							<input type="image"
								src="${contextPath }resources/imagens/excluir.png" alt="Excluir"
								title="Excluir" />
						</form:form></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</tags:pageTemplate>