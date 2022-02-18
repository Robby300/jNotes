<#import "parts/common.ftlh" as c>

<@c.page>


    <form action="/notes/add" method="post"
          style="max-width: 500px; margin: 0 auto;">
        <h1 >Добавление заметки:</h1> <br>

        <textarea name="text" placeholder="описание" class="form-control"></textarea><br>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit" class="btn btn-warning" >Добавить заметку</button>
    </form>
    <br>
</@c.page>