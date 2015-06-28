<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>Apache Shiro Tutorial Webapp</title>
<body>
	<h1>
		Hi
		<shiro:guest>Guest</shiro:guest>
		<shiro:user>
			<%
				request.setAttribute("account", SecurityUtils.getSubject().getPrincipal());
			%>
	    ${account}
    </shiro:user>
		! (
		<shiro:user>
			<a href='<c:url value="/logout"/>'>Log out</a>
		</shiro:user>
		<shiro:guest>
			<a href='<c:url value="/login.jsp"/>'>Log in</a>
		</shiro:guest>
		)
	</h1>

	<shiro:authenticated>
		<p>
			Visit your <a href="<c:url value="/account"/>">account page</a>.
		</p>
	</shiro:authenticated>
	<shiro:notAuthenticated>
		<p>
			If you want to access the authenticated-only <a
				href="<c:url value="/account"/>">account page</a>, you will need to
			log-in first.
		</p>
	</shiro:notAuthenticated>

	<h2>Roles</h2>

	<p>Here are the roles you have and don't have. Log out and log back
		in under different user accounts to see different roles.</p>

	<h3>Roles you have:</h3>
	<p>
		<shiro:hasRole name="admin">admin<br />
		</shiro:hasRole>
		<shiro:hasRole name="schwartz">schwartz <br />
		</shiro:hasRole>
		<shiro:hasRole name="goodguy">goodguy <br />
		</shiro:hasRole>
	</p>


	<h3>Roles you DON'T have:</h3>
	<p>
		<shiro:lacksRole name="admin">admin<br />
		</shiro:lacksRole>
		<shiro:lacksRole name="schwartz">schwartz <br />
		</shiro:lacksRole>
		<shiro:lacksRole name="goodguy">goodguy <br />
		</shiro:lacksRole>
	</p>

	<h2>Permissions</h2>

	<ul>
		<li>You may <shiro:lacksPermission name="ship:NCC-1701-D:command">
				<b>NOT</b>
			</shiro:lacksPermission> command the <code>NCC-1701-D</code> Starship!
		</li>
		<li>You may <shiro:lacksPermission name="user:${account}:edit">
				<b>NOT</b>
			</shiro:lacksPermission> edit the ${account} user!
		</li>
	</ul>
</body>
</html>