<#if name??>
    <#list greetings as g>
        <p>${g}, ${name}!</p>
    </#list>
<#else>
    Hello, anonim!
</#if>