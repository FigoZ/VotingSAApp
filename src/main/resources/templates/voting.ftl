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
                <p><input type="radio" name="answer" value="1"> Да <Br>
                    <input type="radio" name="answer" value="2"> Нет <Br>
                    <input type="radio" name="answer" value="3"> Затрудняюсь ответить<Br>
                </p>
                   <p><input type="submit" formaction="voice"></p>
                <input type="hidden" name="id" value=${votingId}>
            </form>
	    </div>
	</div>
</body>
</html>