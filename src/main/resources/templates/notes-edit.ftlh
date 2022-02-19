<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container mt-5 mb-5">

        <#list notes as note>
            <h1>Редактирование заметки</h1><br>
            <form method="post">

                <textarea name="text" placeholder="Введите текст заметки"
                          class="form-control">${note.text}</textarea>
                <input type="hidden" value="${_csrf.token}" name="_csrf"><br>
                <div class="form-group">
                    <button type="submit" class="btn btn-success">Обновить</button>
                </div>
            </form>
            <br>
        </#list>
    </div>
</@c.page>