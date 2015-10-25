<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="result" items="${ResultMap}" varStatus="statusresult">
										  <a href="#" class="list-group-item company-list" company-id="${result.value.ID}">
									        <h5 class="list-group-item-heading">${result.value.Name} : ${result.value.NameIndustry}</h5>
									        <table>
									      	<tr>
										      	<td style="padding: 5px;"><label>Age From:</label></td>
										      	<td style="padding: 5px;">${result.value.From}</td>
										      	<td style="padding: 5px;"><label>Age To:</label></td>
										      	<td style="padding: 5px;">${result.value.To}</td>
									      	</tr>
									      	<tr>
										      	<td style="padding: 5px;"><label>Gender:</label></td>
										      	<td style="padding: 5px;">
											      	<c:if test="${result.value.Gender ==  \"1\"}">Male</c:if>
											      	<c:if test="${result.value.Gender ==  \"0\"}">Female</c:if>
										      	</td>
										      	<td style="padding: 5px;"><label>Count:</label></td>
										      	<td style="padding: 5px;">${result.value.Count}</td>
									      	</tr>
									      	<tr>
										      	<td style="padding: 5px;"><label>Country:</label></td>
										      	<td style="padding: 5px;">
											      	<c:if test="${result.value.requireCountry ==  \"1\"}">Ukraine</c:if>
											      	<c:if test="${result.value.requireCountry ==  \"0\"}">Poland</c:if>
											      	<c:if test="${result.value.requireCountry ==  \"2\"}">Germany</c:if>
										      	</td>
										      	<td style="padding: 5px;"><label>City:</label></td>
										      	<td style="padding: 5px;">${result.value.City}</td>
									      	</tr>
									      	<tr>
										      	<td style="padding: 5px;"><label>Experience:</label></td>
										      	<td style="padding: 5px;">${result.value.Experience} years</td>
										      	<td style="padding: 5px;"><label>Education:</label></td>
										      	<td style="padding: 5px;">
										      	<c:if test="${result.value.Education == \"0\" }">Primary</c:if> 
								           		<c:if test="${result.value.Education == \"1\" }">Secondary</c:if> 
								           		<c:if test="${result.value.Education == \"2\" }">Tertiary</c:if> 
								           		<c:if test="${result.value.Education == \"3\" }">Vocational</c:if> 
								           		<c:if test="${result.value.Education== \"4\" }">Special</c:if> 
										      	</td>
									      	</tr>
									      	</table>
									      </a>
										</c:forEach>	