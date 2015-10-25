<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

Humans list
<table border=1 width="100%">
<tr>
<th>Name</th><th>Last name</th><th>Country</th><th>City</th><th>Email</th><th>Phone</th>
</tr>
<c:forEach var="contact" items="${ResultMap}" varStatus="status">
	<tr>
		<td>${contact.value.NAME}</td>
		<td>${contact.value.LastName}</td>
		<td>${contact.value.Country}</td>
		<td>${contact.value.City}</td>
		<td>${contact.value.Email}</td>
		<td>${contact.value.Phone}</td>
	</tr>
</c:forEach>
</table>