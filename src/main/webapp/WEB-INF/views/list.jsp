<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <html>
<body>
	<h2>Spring MVC and List Example</h2>

	<c:if test="${not empty lists}">

		<ul>
			<c:forEach var="listValue" items="${lists}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>

	</c:if>
</body>
</html> -->

<c:forEach var="contact" items="${customerList}" varStatus="status">
	<tr>
		<td>${contact.custId}</td>
		<td>${contact.name}</td>
		<td>${contact.email}</td>
		<td>${contact.age}</td>
		<td class="list-actions">
			<button type="button" class="btn btn-warning edit"  data-target="#mainModal" value="${contact.custId}" style="border-radius: 5px!important;">Edit</button>
			<a type="button" class="btn btn-warning delete"  data-target="#mainModal" href="delete_customer?id=${contact.custId}" style="border-radius: 5px!important;">Delete</a>
		</td>	
	</tr>
</c:forEach>