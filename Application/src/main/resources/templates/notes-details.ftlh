<#import "parts/common.ftlh" as c>
<#include "parts/security.ftl">

<@c.page>

<div class="alert alert-info mt-2">
    <h4>Создана: ${note.creationTime}</h4>
    <h4>Содержание: ${note.text}</h4>
</div>

<br>
<a href="/notes/${note.id}/edit" class="btn btn-warning">Редактировать</a>
<p></p>
<form action="/notes/${note.id}/remove" method="post">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button class="btn btn-warning" type="submit">Удалить</button>
</form>

</@c.page>