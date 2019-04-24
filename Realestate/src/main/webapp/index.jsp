

<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <title>Real Estate|Welcome</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <link rel="stylesheet" href="css/style.css">


    </head>


    <body>

        <header>

            <div id="nav" class="container">
                <div id="branding">
                    <img src="img/231879-200.png" alt="">  

                </div>
                <div id="branding">

                    <h1><a href="index.jsp" class="custom_font1 highlight">REMS</a></h1>

                </div>
                <nav>
                    <ul>
                        <li><a class="current" href="index.jsp">Home</a></li>
                        <li><a href="#">Property</a></li>
                        <li><a href="#">Association</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="contact.html">Contact</a></li>

                        <button type="button" onclick="document.getElementById('modal-wrapper').style.display = 'block'" class="btn1" href="login.html" data-toggle="tooltip" data-placement="bottom" title="LogIn" onclick="alert('Hooray')">Log  in</button>
                        <button type="button"  onclick="document.getElementById('modal-wrapper1').style.display = 'block'" class="btn2" href="signup.html" data-toggle="tooltip" data-placement="bottom" title="signup" onclick="alert('Hooray')">Sign Up</button>


                    </ul>
                </nav>
            </div>


            <div id="modal-wrapper" class="modal">

                <form class="modal-content animate" action=>

                    <div class="imgcontainer">
                        <span onclick="document.getElementById('modal-wrapper').style.display = 'none'" class="close" title="Close PopUp">&times;</span>

                        <h1 style="text-align:center">LogIn</h1>
                    </div>

                    <div  class="container">
                        <input type="text" placeholder="Enter Username" name="username">
                        <input type="password" placeholder="Enter Password" name="password">        
                        <button type="submit">Login</button>
                        <input type="checkbox" style="margin:26px 30px;"> Remember me      
                        <a href="#" style="text-decoration:none; float:right; margin-right:34px; margin-top:26px;">Forgot Password ?</a>
                    </div>

                </form>

            </div>


            <div id="modal-wrapper1" class="modal">

                <form class="modal-content animate" action="RegisterServlet">

                    <div class="imgcontainer">
                        <span onclick="document.getElementById('modal-wrapper1').style.display = 'none'" class="close" title="Close PopUp">&times;</span>

                        <h1 style="text-align:center">SignUp</h1>
                    </div>

                    <div  class="container">
                        <input type="text" name="name" placeholder="Full Name" />
                        <input type="text" name="username" placeholder="Username" />
                        <input type="text" name="email" placeholder="Email" />
                        <input type="password" name="password" placeholder="Password"/>
                        <input type="password" name="password2" placeholder="Confirm Password"/>        
                        <button type="submit">Sign Up</button>
                        <input type="checkbox" style="margin:26px 30px;"> Remember me      
                        <a href="#" style="text-decoration:none; float:right; margin-right:34px; margin-top:26px;">Forgot Password ?</a>
                    </div>

                </form>

            </div>

        </header>



        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>


        <script src="js/bootstrap.min.js"></script>




        <script>
          function openNav() {
              document.getElementById("mySidenav").style.width = "250px";
          }

          function closeNav() {
              document.getElementById("mySidenav").style.width = "0";

          }
        </script>

        <script>



            var modal = document.getElementById('modal-wrapper');

            window.onclick = function (event) {

                if (event.target == modal) {

                    modal.style.display = "none";

                }

            }




        </script>
        <script>



            var mod = document.getElementById('modal-wrapper1');

            window.onclick = function (event) {

                if (event.target == mod) {

                    modal.style.display = "none";

                }

            }




        </script>





        <footer>
            <div class="logo1">
                <img class="image" src="./img/231879-200.png">
                <h1>REMS</h1>
                <ul>
                    <li> Terms & conditions </li> -
                    <li>Privacy policy </li> -
                    <li>Copyrights Notification </li>
                </ul>

            </div>

            <div class="wrapper">


                <ul>

                    <li ><img class="img1" src="./img/facebook.png"></li>
                    <li><img  class="img2" src="./img/linkedin.png"></li>
                    <li ><img class="img3" src="./img/twitter.png"></li>
                    <li ><img class="img4" src="./img/google.png"></li>


                </ul>

            </div>
            <div class="company">

                <h2>Company</h2>
                <ul>
                    <li> <a href="index.html">Home</a></li><br>
                    <li ><a href="property.html">Property</a></li><br>
                    <li ><a href="association.html">Association</a></li><br>
                    <li><a href="about.html">About</a></li><br>
                    <li ><a href="contact.html">Contact</a></li><br>
                </ul>


            </div>





            <footer>

                <a margin-top:100px; href="index.html">REMS</a>. Copyright &copy; 2018

            </footer>
        </footer>                                 



    </body>





</html>
