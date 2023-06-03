<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 5/29/2023
  Time: 6:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng kí</title>
    <link rel="stylesheet" href="../bootstrap-5.1.3-dist/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <img src="../images/logo/logo.jpg" height="80" width="160"/>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="fw-bold nav-link active" aria-current="page" href="#" style="font-size: 30px;
                     margin-left: 50px">Home</a>
                </li>
                </li>
                <li class="nav-item dropdown">
                    <a class="fw-bold   nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false"
                       style="font-size: 30px;margin-left: 35px; margin-right: 50px">
                        Menu
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="fw-bold dropdown-item" href="#">Coffee</a></li>
                        <li><a class="fw-bold dropdown-item" href="#">Tea</a></li>
                        <li><a class="fw-bold dropdown-item" href="#">Juice</a></li>
                        <li><a class="fw-bold dropdown-item" href="#">Soda</a></li>
                        <li><a class="fw-bold dropdown-item" href="#">Ice Cream</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="fw-bold dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="navbar-nav">
                <form class="d-flex" style="position: relative;">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                           style="width: 40%">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </ul>

            <ul class="navbar-nav">
                <div style="position: absolute; margin-left: 80%">
                    <a class="fw-bold dropdown-item" href="#">
                        <i class="fa-solid fa-user"></i> Account</a>
                </div>
            </ul>
        </div>

    </nav>
</div>
<div style="position: absolute; margin-left: 74%">
    <a class="fw-bold dropdown-item" href="#"><i class="fa-solid fa-cart-shopping"></i></i> Cart</a>
</div>
<section class="vh-150" style="background-color: gray">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-80">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                                <form class="mx-1 mx-md-4">

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fa-solid fa-user-tie me-4"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="form3Example1c" class="form-control"/>
                                            <label class="form-label" for="form3Example1c">Name User</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="email" id="form3Example2c" class="form-control"/>
                                            <label class="form-label" for="form3Example2c">Your Phone</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="email" id="form3Example3c" class="form-control"/>
                                            <label class="form-label" for="form3Example3c">Your Email</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="form3Example6c" class="form-control"/>
                                            <label class="form-label" for="form3Example6c">User Name</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="password" id="form3Example4c" class="form-control"/>
                                            <label class="form-label" for="form3Example4c">Password</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="password" id="form3Example4cd" class="form-control"/>
                                            <label class="form-label" for="form3Example4cd">Repeat your password</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="button" class="btn btn-primary btn-lg">Register</button>
                                    </div>

                                </form>

                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                     class="img-fluid" alt="Sample image">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
<script src="../bootstrap-5.1.3-dist/js/bootstrap.js"></script>
</html>