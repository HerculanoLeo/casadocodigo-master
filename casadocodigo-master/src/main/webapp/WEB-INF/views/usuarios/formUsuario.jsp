<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>


<tags:pageTemplate titulo="Cadastro de Usuarios">
		<div class="container">
		<h1>Cadastro de Usuario</h1>
		<h2>${message }</h2>		
		<form:form action="${s:mvcUrl('UC#cadastraUsuario').build() }" method="post" modelAttribute="usuario" >
			<div class="form-group">
				<label>Nome</label>
				<form:input path="nome" type="text" cssClass="form-control" />
				<form:errors path="nome" />
			</div>
			<div class="form-group">
		        <label>E-Mail</label>
				<form:input path="email" type="email"  cssClass="form-control" /> 
		        <form:errors path="email" />
			</div>
			<div class="form-group">
				<label>Senha</label>
				<form:input path="senha" type="password" cssClass="form-control" />
		        <form:errors path="senha" />
			</div>
			<div class="form-group">
				<label>Repetir a Senha</label>
				<form:input path="repetirSenha" type="password" cssClass="form-control"/>
		        <form:errors path="repetirSenha" />
			</div>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form:form>
	</div>

</tags:pageTemplate>