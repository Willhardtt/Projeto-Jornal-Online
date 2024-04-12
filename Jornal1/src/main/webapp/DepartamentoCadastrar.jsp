<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário|Departamento</title>
    <style>
        body{
            font-family: Arial, Helvetica, sans-serif;
            background-image: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(98,10,145,1) 35%, rgba(64,0,255,1) 100%);
        }
        .salva{
            color: white;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            background-color: rgba(0, 0, 0, 0.6);
            padding: 15px;
            border-radius: 15px;
            width: 20%;
        }
        .box{
            color: white;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            background-color: rgba(0, 0, 0, 0.6);
            padding: 15px;
            border-radius: 15px;
            width: 20%;
        }
        fieldset{
            border: 3px solid dodgerblue;
        }
        legend{
            border: 1px solid dodgerblue;
            padding: 10px;
            text-align: center;
            background-color: dodgerblue;
            border-radius: 8px;
        }
        .inputBox{
            position: relative;
        }
        .inputUser{
            background: none;
            border: none;
            border-bottom: 1px solid white;
            outline: none;
            color: white;
            font-size: 15px;
            width: 100%;
            letter-spacing: 2px;
        }
        .labelInput{
            position: absolute;
            top: 0px;
            left: 0px;
            pointer-events: none;
            transition: .5s;
        }
        .inputUser:focus ~ .labelInput,
        .inputUser:valid ~ .labelInput{
            top: -20px;
            font-size: 12px;
            color: dodgerblue;
        }
        #data_nascimento{
            border: none;
            padding: 8px;
            border-radius: 10px;
            outline: none;
            font-size: 15px;
        }
        #submit{
            background-image: linear-gradient(90deg, rgba(27,138,240,1) 0%, rgba(98,10,145,1) 35%, rgba(64,0,255,1) 100%);
            width: 100%;
            border: none;
            padding: 15px;
            color: white;
            font-size: 15px;
            cursor: pointer;
            border-radius: 10px;
        }
        #submit:hover{
            background-image: linear-gradient(to right,rgb(0, 80, 172), rgb(80, 19, 195));
        }
    </style>
</head>
<body>
<% session = null; %>
    <div class="box">
       <form name="frmDepartamento" action="ControleDepartamentoServletAction" method="post">
            <fieldset>
                <legend><b>Tela Departamento - Cadastrar</b></legend>
                <br>
                <div class="inputBox">
                    <input type="text" name="txtDepartamento" id="txtDepartamento" class="inputUser" required>
                    <label for="nome" class="labelInput">Departamento</label>
                </div>
				
                <br><br>
				 
				 	<input type="hidden" name="txtCodDepartamento" maxlength="45" value="0">
			
                <input type="submit" name="btnOpcao" value="Cadastrar" id="submit"> </td>
              	<br> </br>
                <input type="reset" name="btnLimpar" value="Limpar" id="submit"> </td>
                	<br> </br> 
                	
                <h3 style="submit">Retornar Tela Principal: <a href="TelaDepartamento.jsp" />Clicar</a></h3>
				
            </fieldset>
        </form>
    </div>
</body>
</html>