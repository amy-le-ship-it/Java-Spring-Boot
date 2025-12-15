<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <title>Homepage - Laptop Shop</title>

                <!--Google Web Fonts-->
                <link rel="preconnect" href="https://fonts.googleapis.com" />
                <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
                <link
                    href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
                    rel="stylesheet" />

                <!-- Icon Font Stylesheet -->
                <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
                    rel="stylesheet" />
                <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
                    rel="stylesheet" />
                <!-- Libraries Stylesheet -->
                <link href="/resources/client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
                <link href="/resources/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

                <!-- Customized Bootstrap Stylesheet -->
                <link href="/resources/client/css/bootstrap.min.css" rel="stylesheet" />
                <!-- Template Stylesheet -->
                <link rel="stylesheet" href="/resources/client/css/style.css" />
            </head>

            <body>
                <!-- Spinner Start -->
                <div id="spinner"
                    class="show w-100 vh-100 position-fixed translate-middle top-50 start-50 d-flex align-items-center justify-content-center bg-white">
                    <div class="spinner-grow text-primary" role="status">
                    </div>
                </div>
                <!-- Spinner End -->

                <jsp:include page="../layout/header.jsp" />

                <!-- Main Content -->
                <div class="container-fluid fruite py-5">
                    <div class="container py-5">
                        <div class="tab-class text-center">
                            <div class="row g-4">
                                <div class="col-lg-4 text-start">
                                    <h1>Các sản phẩm</h1>
                                </div>
                                <div class="col-lg-8 text-end">
                                    <ul class="nav nav-pills d-inline-flex text-center mb-5">
                                        <li class="nav-item">
                                            <a class="d-flex m-2 py-2 bg-light rounded-pill active"
                                                data-bs-toggle="pill" href="#tab-1">
                                                <span class="text-dark" style="width: 130px;">Tất cả sản phẩm</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div>
                                <div class="tab-content">
                                    <div id="tab-1" class="tab-pane fade show p-0 active">
                                        <div class="row g-4">
                                            <div class="col-12">
                                                <div class="row g-4">
                                                    <c:forEach var="product" items="${products}">
                                                        <div class="col-xl-3 col-lg-4 col-md-6">
                                                            <div class="position-relative rounded fruite-item">
                                                                <div class="fruite-img">
                                                                    <img class="img-fluid w-100 rounded-top"
                                                                        src="${pageContext.request.contextPath}/resources/images/product/${product.image}"
                                                                        alt="" />
                                                                </div>
                                                                <div
                                                                    class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                                    <h4 style="font-size: 15px;">
                                                                        <a
                                                                            href="/product/${product.id}">${product.name}</a>
                                                                    </h4>
                                                                    <p style="font-size: 13px;">${product.shortDesc}</p>
                                                                    <div
                                                                        class="d-flex flex-lg-wrap justify-content-center">
                                                                        <p style="font-size: 15px; text-align: center; width: 100%;"
                                                                            class="text-dark fw-bold mb-3">
                                                                            <fmt:formatNumber type="number"
                                                                                value="${product.price}" /> đ
                                                                        </p>
                                                                        <form
                                                                            action="/add-product-to-cart/${product.id}"
                                                                            method="post">
                                                                            <input type="hidden"
                                                                                name="${_csrf.parameterName}"
                                                                                value="${_csrf.token}" />
                                                                            <button
                                                                                class="mx-auto btn border border-secondary rounded-pill text-primary px-3"
                                                                                href="#"><i
                                                                                    class="fa fa-shopping-bag me-2 text-primary"></i>

                                                                                >
                                                                                Thêm vào giỏ hàng
                                                                            </button>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Main Content End -->

                    <jsp:include page="../layout/footer.jsp" />

                    <!-- Back to Top -->
                <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i
                        class="fa fa-arrow-up"></i></a>


                <!-- JavaScript Libraries -->
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
                <script src="/resources/client/lib/easing/easing.min.js"></script>
                <script src="/resources/client/lib/waypoints/waypoints.min.js"></script>
                <script src="/resources/client/lib/lightbox/js/lightbox.min.js"></script>
                <script src="/resources/client/lib/owlcarousel/owl.carousel.min.js"></script>

                <!-- Template Javascript -->
                <script src="/resources/client/js/main.js"></script>
            </body>

            </html>