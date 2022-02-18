<#import "parts/common.ftlh" as c>
<#include "parts/security.ftl">

<@c.page>

        <div class="alert alert-info mt-2">
            <h3>Содержание: ${note.creationTime}</h3>
            <h2>Содержание: ${note.text}</h2>
        </div>

</@c.page>