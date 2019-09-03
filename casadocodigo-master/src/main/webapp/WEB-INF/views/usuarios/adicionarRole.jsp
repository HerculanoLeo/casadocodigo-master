<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>



<tags:pageTemplate titulo="Cadastro das ROLES">
	<div>
		<h1>${message }</h1>
	</div>

	<div>
		<h1>Cadastro de Permissões para ${usuario.nome }</h1>
	</div>
	<div>
		<form:form action="${s:mvcUrl('UC#atualizarRole').build() }" method="post" modelAttribute ="usuario" >
				<form:checkboxes path="roles" items="${listaRole }" itemLabel="authority" itemValue="authority" delimiter="<br/>"/>
			<form:hidden path="email"/>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form:form>
		
	
	</div>






</tags:pageTemplate>