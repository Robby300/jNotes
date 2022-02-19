<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div class="mb-1">Регистрация:</div>

    <h2 style="color:red">${message?ifExists}</h2>
    <@l.login "/registration" true />
</@c.page>