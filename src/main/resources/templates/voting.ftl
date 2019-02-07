<!DOCTYPE html>

<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
</head>
<body>
	<div class="container">
	    <div class="jumbotron">
            <p>${message}</p>

            <form method="get">
               <#-- <p><input type="submit" name="1" formaction="voice" value="Да"></p>
                <p><input type="submit" name="no" formaction="voice" ></p>
                <p><input type="submit" name="3" formaction="voice" value="Затрудняюсь ответить"></p>

                -->
                <p><input type="radio" name="answer" value="1"> Да <Br>
                    <input type="radio" name="answer" value="2"> Нет <Br>
                    <input type="radio" name="answer" value="3"> Затрудняюсь ответить<Br>
                </p>
                   <p><input type="submit" formaction="voice"></p>
            </form>
	    </div>
	</div>
</body>
</html>