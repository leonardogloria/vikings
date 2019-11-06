<html>
<head>
    <meta name='layout' content='main'/>
    <title><g:message code="springSecurity.login.title"/></title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'auth.css')}" type="text/css">
</head>
<body>
<div id='login'>
    <div class='inner'>
        <div class='fheader'>Faça Login para cotinuar</div>

        <g:if test='${flash.message}'>
            <div class='login_message'>${flash.message}</div>
        </g:if>
        <g:form action="doLogin">

            <p>
                <label for='username'>Usuario:</label>
                <input type='text' class='text_' name='nome' id='username'/>
            </p>

            <p>
                <label for='password'>Senha:</label>
                <input type='password' class='text_' name='senha' id='password'/>
            </p>

            <p>
                <input type='submit' id="submit" class="btn" value='Logar'/>
            </p>
        </g:form>
    </div>
</div>
<script type='text/javascript'>
    <!--
    (function() {
        document.forms['loginForm'].elements['j_username'].focus();
    })();
    // -->
</script>
</body>
</html>