<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/pageparts" prefix="pp"%>
<%@ page session="false" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home <pp:title-postfix /></title>
<pp:global-meta />
<pp:global-css-js />
</head>
<body>
	<pp:hdr />
	<pp:nav />

	<section>
		<h1>Hello world!</h1>

		<P>The time on the server is ${serverTime}.</P>
	</section>

	<pp:ftr />
	<pp:global-ftr-js />
	<pp:analyticstracking />
</body>
</html>
