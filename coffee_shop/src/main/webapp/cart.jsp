<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/7/2023
  Time: 8:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<html>
<head>
    <title>cart</title>
    <style>
        a {
            text-decoration: none;
        }

        table {
            border-collapse: collapse;
        }
    </style>
</head>
<body style="background-color: #562f2f">
<section class="h-100 h-custom" >
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12">
                <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                    <div class="card-body p-0">
                        <div class="row g-0">
                            <div class="col-lg-8">
                                <div class="p-5">
                                    <div class="d-flex justify-content-between align-items-center mb-5">
                                        <h1 class="fw-bold mb-0 text-black">Shopping Cart</h1>
                                        <h6 class="mb-0 text-muted">${size} Items</h6>
                                    </div>
                                    <c:set var="o" value="${sessionScope.cart}"/>
                                    <c:forEach items="${o.items}" var="i" varStatus="look">
                                        <hr class="my-4">

                                        <div class="row mb-4 d-flex justify-content-between align-items-center">
                                            <div class="col-md-2 col-lg-2 col-xl-2">
                                                <img
                                                        src="${i.product.productImage}"
                                                        class="img-fluid rounded-3" alt="photo">
                                            </div>
                                            <div class="col-md-3 col-lg-3 col-xl-3">
                                                <h6 class="text-muted">${i.product.productName}</h6>
                                            </div>
                                            <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                <button class="btn btn-link px-2">
                                                    <a href="/process?action=quanitity&num=-1&id=${i.product.productID}">
                                                        <i class="fas fa-minus"></i>
                                                    </a>
                                                </button>

                                                <input readonly min="0" name="quantity" value="${i.quanitity}"
                                                       type="number"
                                                       class="form-control form-control-sm"/>

                                                <button class="btn btn-link px-2">
                                                    <a href="/process?action=quanitity&num=1&id=${i.product.productID}">
                                                        <i class="fas fa-plus"></i>
                                                    </a>
                                                </button>
                                            </div>
                                            <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                <h6 class="mb-0">$${i.product.productPrice}</h6>
                                            </div>
                                            <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                <a href="/process?action=delete&id=${i.product.productID}"
                                                   class="text-muted"><i class="fas fa-times"></i></a>
                                            </div>
                                        </div>
                                    </c:forEach>

                                    <hr class="my-4">

                                    <div class="pt-5">
                                        <h6 class="mb-0"><a href="/process?action=back" class="text-body"><i
                                                class="fas fa-long-arrow-alt-left me-2"></i>Back to shop</a></h6>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 bg-grey">
                                <div class="p-5">
                                    <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                                    <hr class="my-4">

                                    <div class="d-flex justify-content-between mb-4">
                                        <h5 class="text-uppercase">items ${size}</h5>
                                        <h5>$${o.totalMoney}</h5>
                                    </div>
                                    <form action="/process" method="post">
                                        <h5 class="text-uppercase mb-3">Address<span style="color: red">*</span></h5>

                                        <div class="mb-4 pb-2">
                                            <textarea name="address" placeholder="address" style="width: 100%; height: 15%"
                                                      required></textarea>
                                            <br>
                                        </div>

                                        <h5 class="text-uppercase mb-3">Note</h5>

                                        <div class="mb-5">
                                            <div class="form-outline">
                                                <textarea name="note" placeholder="note" style="width: 100%"></textarea>
                                            </div>
                                        </div>

                                        <hr class="my-4">

                                        <div class="d-flex justify-content-between mb-5">
                                            <h5 class="text-uppercase">TOTAL PRICE</h5>
                                            <h5>$${o.totalMoney}</h5>
                                        </div>

                                        <button type="submit" class="btn btn-dark btn-block btn-lg"
                                                data-mdb-ripple-color="dark">ODER
                                        </button>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>