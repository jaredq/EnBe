<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="pageNum" required="true"%>
<%@ attribute name="totalPage" required="true"%>
<%@ attribute name="func" required="true"%>


<a href="javascript:${func}(1);">&lt;&lt;First</a>

<c:if test="${pageNum > 1}">
	<a href="javascript:${func}(${pageNum-1});">&lt;Prev</a>
</c:if>

<c:if test="${pageNum-totalPage == 0 && pageNum-4 > 0 }">
	<a href="javascript:${func}(${pageNum-4});">${pageNum-4}</a>
</c:if>

<c:if test="${pageNum >= totalPage-1 && pageNum-3 > 0}">
	<a href="javascript:${func}(${pageNum-3});">${pageNum-3}</a>
</c:if>

<c:if test="${pageNum-2 >= 1}">
	<a href="javascript:${func}(${pageNum-2});">${pageNum-2}</a>
</c:if>

<c:if test="${pageNum-1 >= 1}">
	<a href="javascript:${func}(${pageNum-1});">${pageNum-1}</a>
</c:if>

<span style="font-weight: bold; font-style: !important;">${pageNum}</span>

<c:if test="${pageNum+1 <= totalPage}">
	<a href="javascript:${func}(${pageNum+1});">${pageNum+1}</a>
</c:if>

<c:if test="${pageNum+2 <= totalPage}">
	<a href="javascript:${func}(${pageNum+2});">${pageNum+2}</a>
</c:if>

<c:if test="${pageNum <= 2 && pageNum+3 <= totalPage}">
	<a href="javascript:${func}(${pageNum+3});">${pageNum+3}</a>
</c:if>

<c:if test="${pageNum == 1 && pageNum+4 <= totalPage}">
	<a href="javascript:${func}(${pageNum+4});">${pageNum+4}</a>
</c:if>

<c:if test="${pageNum-totalPage < 0}">
	<a href="javascript:${func}(${pageNum+1});">Next&gt;</a>
</c:if>

<a href="javascript:${func}(${totalPage});">Last&gt;&gt;</a>