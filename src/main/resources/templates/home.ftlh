<#import "parts/common.ftlh" as c>
<#include "parts/security.ftl">

<@c.page>
    <div>

        <#if name == 'unknown'><h1>Здравствуйте!</h1>
            <h><a href="/login">Войдите</a> или <a href="/registration">зарегистрируйтесь.</a></h>
        <#else> <h1>Привет ${name}!</h1>

            <h4>Это приложение для работы с заметками</h4>

            <a href="/notes" class="btn btn-success">Приступить к работе!</a>
            <br>

        </#if>
    </div>
</@c.page>
