<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.JavaBeans" %>
    <%@ page import="java.util.ArrayList" %>
    <%
    	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contato");    
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/phonee.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de contatos</h1>
	<a href="novo.html" class="botao1">Novo contato</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>Email</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i=0; i<lista.size(); i++){ %>
				<tr>
					<td><%=lista.get(i).getIdcontato() %></td>
					<td><%=lista.get(i).getNome() %></td>
					<td><%=lista.get(i).getFone() %></td>
					<td><%=lista.get(i).getEmail() %></td>
					<td><a href="select?idcontato=<%= lista.get(i).getIdcontato()%>" class="botao1">Editar</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>