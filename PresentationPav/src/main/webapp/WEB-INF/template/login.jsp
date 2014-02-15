
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Commande Online ::. Connexion</title>
    <style type="text/css">
        body {
            height: 100%;
        }

        body > table {
            width: 100%;
            height: 100%;
        }

        body > table > tbody > tr > td
        {
            text-align: center;
        }

        form > table
        {
            margin-left:auto;
            margin-right:auto;
        }

        .error
        {
            font-weight: bold;
            color: red;
        }	
        .barreBouton {
    margin-top: 5px;
    text-align: right;
    padding-top: 5px;
    padding-right: 5px;
    height: 30px;
    vertical-align: middle;
}


.champsobligatoire {
    text-align: right;
    margin: 32px 15px -45px 0px;
    padding: 0px;
    font-weight: normal;
}

fieldset {
    background-color: rgb(255, 255, 255);
    border: 1px solid rgb(196, 201, 125);
    margin-top: 10px;
    font-weight: normal;
    padding: 5px 10px 10px;
    margin-top:100px;
    margin-left: 300px;
    margin-right: 300px
}

.piedPage {
    background: url("../images/bg_hr.gif") repeat-x scroll center top transparent;
    width: 100%;
    height: 6px;
    border: medium none;
    margin: 20px 0px;
}
        .ind_obligatoire
        {
            font-weight: normal;
            color: red;
        }
    </style>
</head>
<body>
  <fieldset id="connexion">
    <legend> &nbsp; Gestion Commande Online &nbsp;</legend>
       
                   <#if userNotFound?? && userNotFound?string == "true">
                <div class="error">Les informations de connexion sont incorrectes</div>
            <#elseif userLocked?? && userLocked?string == "true">
                <div class="error">User locked</div>
            <#elseif error?? && error?string == "true">
                <div class="error">Internal error</div>
            </#if>
        <div class="champsobligatoire">
      <p>
        <span class="ind_obligatoire">*</span>Champ obligatoire
      </p>
    </div>
    <div>
    &nbsp;&nbsp;
    </div>
<table>
    <tr>
        <td>
            
            <form method="post" action="">
                <table>
                    <tr>
                        <td>&nbsp;&nbsp;</td>
                        <td>&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                        <td style="text-align: right;"><span class="ind_obligatoire">*</span>Identifiant :</td>
                        <td><input type="text" name="username"  size="50"/></td>
                    </tr>
                    <tr>
                        <td style="text-align: right;"><span class="ind_obligatoire">*</span>Mot de passe :</td>
                        <td><input type="password" name="password" size="50"/></td>
                    </tr>
                    <tr>
                    	<td>&nbsp;</td>
                    	<td>
                    		        <a href="/PresentationPav/#!erreur" >Mot de passe oubli&eacute;?</a>
                    	</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="submit" value="Connexion"></td>
                    </tr>
                </table>
            </form>

            <span>
                <br/>Les utilisateurs ayant un role de client ou plus peuvent s'authentifier<br>
   
            </span>

        </td>
    </tr>
</table>
</fieldset>
<br>
</body>
</html>