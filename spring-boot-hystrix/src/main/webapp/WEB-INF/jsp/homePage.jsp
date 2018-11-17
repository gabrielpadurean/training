<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <link rel="shortcut icon" type="image/png" href="/images/favicon.png"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('.slider').slider();
        });
    </script>

    <title>Spectre</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
    <div class="slider fullscreen">
        <ul class="slides">
            <c:forEach var="apod" items="${apods}">
                <li>
                    <a href="${apod.hdurl}" target="_blank" title="Open image in new tab"><img src="${apod.hdurl}"></a>
                    <div class="caption left-align">
                        <h3>${apod.title}</h3>
                        <h5 class="light grey-text text-lighten-3">${apod.explanation}</h5>
                        <br/>
                        <br/>
                        <h3>Zodiac</h3>
                        <h5 class="light grey-text text-lighten-3">
                            Sign: ${aztro.sign}
                            <br/>
                            Day: ${aztro.day}
                            <br/>
                            Mood: ${aztro.mood}
                            <br/>
                            ${aztro.description}
                        </h5>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>