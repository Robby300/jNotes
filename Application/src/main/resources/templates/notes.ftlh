<#import "parts/common.ftlh" as c>
<#include "parts/security.ftl">

<@c.page>
    <h2>Ваши заметки:</h2><br>
    <a href="notes/add" class="nav-link">Добавить заметку</a>


        <#list notes as note>

                    <div class="card-body">
                        <h4> ${note.creationTime}</h4>
                        <h5> ${note.text}</h5>
                        <a href="/notes/${note.id}" class="btn btn-success">Подробнее о заметке</a>
                    </div>

        <#else>
            Замиеток нет!
        </#list>


</@c.page>

