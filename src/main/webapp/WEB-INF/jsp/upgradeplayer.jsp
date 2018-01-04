<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Upgrade</h1>
        <h2>${message}</h2>
        
        
        <table>
			<caption>Your squad</caption>

			<thead>
				<tr>
					<th>Forename</th>
                                        <th>Surname</th>
					<th>Defence</th>
                                        <th>Offence</th>
                                        
                                        
				</tr>
			</thead>
                        Budget : ${budget} $<br>
                        Price for defence upgrade ${pricedef}$<br>
                        Price for offence upgrade ${priceoff}$<br>
                        
			<tbody>
				
					<tr>
						<td>${player.forename}</td>
						<td>${player.surname}</td>
                                                <c:url value="/players/${player.id}/upgrade/" var="upgrade" />
                                                
                                                
                                                <td>${player.defense} 
                                                <form  action="${upgrade}" method="POST">
                                                    <input id="type" name="type" type="hidden" value="def"/>
                                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                    <input type="submit" value="+3" /> 
                                                </form>
                                                </td>
                                                
                                                <td>${player.offense} 
                                                   
                                                        
                                                        
                                                <form  action="${upgrade}" method="POST">
                                                    <input id="type" name="type" type="hidden" value="off"/>
                                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                    <input type="submit" value="+3" /> 
                                                </form>
						<td></td>
                                                
                                                
					</tr>
				
			</tbody>
		</table>
        
        
        
        
         
    </body>
</html>



