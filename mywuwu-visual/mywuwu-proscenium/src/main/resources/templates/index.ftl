<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首頁</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <!-- FONTS ONLINE -->
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
          rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <#assign path="${springMacroRequestContext.getContextPath()}">
    <!--MAIN STYLE-->
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../css/main.css" rel="stylesheet" type="text/css">
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <link href="../static/css/animate.css" rel="stylesheet" type="text/css">
    <link href="../static/css/responsive.css" rel="stylesheet" type="text/css">
    <link href="../static/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<!-- Page Wrap ===========================================-->
<div id="wrap" class="home-1">

    <!--======= TOP BAR =========-->
    <div class="top-bar">
        <div class="container">
            <ul class="left-bar-side">
                <li>
                    <p><i class="fa fa-phone"></i> +01 123 456 78 </p>
                    <span>|</span>
                </li>
                <li>
                    <p><i class="fa fa-envelope-o"></i> Info@ourinfomail.com </p>
                    <span>|</span>
                </li>
                <li class="logri">
                    <p><i class="fa fa-lock"></i> <a href="">會員登入</a> / <a href="">線上註冊</a></p>
                    <span>|</span>
                </li>
            </ul>
            <ul class="right-bar-side social_icons">
                <li class="facebook"><a href="#"><i class="fa fa-facebook"></i> </a></li>
                <li class="twitter"><a href="#"><i class="fa fa-twitter"></i> </a></li>
                <li class="linkedin"><a href="#"><i class="fa fa-linkedin"></i> </a></li>
                <li class="tumblr"><a href="#"><i class="fa fa-tumblr"></i> </a></li>
            </ul>
        </div>
    </div>

    <!--======= HEADER =========-->
    <header class="sticky">
        <div class="container">
            <div class="logo"><a href="#."><img src="../images/logo.png" alt=""></a></div>
            <nav>
                <ul class="ownmenu">
                    <li class="active"><a href="../index.ftl">首頁</a>
                    </li>
                    <li><a href="">借錢找我</a></li>
                    <li><a href="">借錢許願池</a></li>
                    <li><a href="">廣告刊登 </a></li>
                    <li><a href="">最新情報</a></li>
                    <li><a href="">服務與支持</a></li>
                    <li><a href="">青創貸款融資案例</a></li>
                    <li><a href="">聯絡我們</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <!--======= BANNER =========-->
    <div id="banner">
        <div class="flex-banner">
            <ul class="slides">
                <li><img src="../images/slider-img-1.jpg" alt=""></li>
            </ul>
        </div>

        <!--======= FIND PROPERTY =========-->
        <div class="finder">
            <div class="container">
                <div class="find-sec">
                    <ul class="row">
                        <li class="col-sm-3 col-xs-6">
                            <label>北部借錢</label>
                            <select class="selectpicker" onchange="window.location=this.value;">
                                <option value="">桃員</option>
                                <option value="">新竹</option>
                                <option value="">苗栗</option>
                            </select>
                        </li>
                        <li class="col-sm-3 col-xs-6">
                            <label>中部借錢</label>
                            <select class="selectpicker" onchange="window.location=this.value;">
                                <option value="">彰化</option>
                                <option value="">南投</option>
                                <option value="">雲林</option>
                                <option value="">嘉義</option>
                            </select>
                        </li>
                        <li class="col-sm-3 col-xs-6">
                            <label>南部借錢</label>
                            <select class="selectpicker" onchange="window.location=this.value;">
                                <option value="">高雄</option>
                                <option value="">屏東</option>
                            </select>
                        </li>
                        <li class="col-sm-3 col-xs-6">
                            <label>東部借錢</label>
                            <select class="selectpicker" onchange="window.location=this.value;">
                                <option value="">花蓮</option>
                                <option value="">宜蘭</option>
                            </select>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>


    <!--======= PROPERTY =========-->
    <section class="property-slide">
        <div class="prot-slide">

            <!--======= PROPERTY SLIDE =========-->
            <div class="plots">
                <div class="row">
                    <div class="col-xs-4">
                        <a href="#."> <img class="img-responsive" src="../images/propt-img-1.jpg" alt=""> </a>
                    </div>
                    <div class="col-xs-8">
                        <div class="pri-info">
                            <span class="sale">我要速速借錢</span>
                            <p>免費透過多位金主，快速借現金、融資周轉、小額借款、臨時救急、多元化借錢管道。隨時可結案。</p>
                            <a href="#" class="btn btn-primary" role="button">速速借錢</a>
                        </div>
                    </div>
                </div>
            </div>

            <!--======= PROPERTY SLIDE =========-->
            <div class="plots">
                <div class="row">
                    <div class="col-xs-4">
                        <a href="#."> <img class="img-responsive" src="../images/propt-img-1.jpg" alt=""> </a>
                    </div>
                    <div class="col-xs-8">
                        <div class="pri-info">
                            <span class="sale">我要速速放款</span>
                            <p>刊登放款廣告，每月多筆公開新需求等您滿足:這合銀行代辦代書、融資租賃公司、當鋪、民間金主等。</p>
                            <a href="#" class="btn btn-primary" role="button">速速放款</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="plots">
                <div class="row">
                    <div class="col-xs-4">
                        <a href="#."> <img class="img-responsive" src="../images/propt-img-1.jpg" alt=""> </a>
                    </div>
                    <div class="col-xs-8">
                        <div class="pri-info">
                            <span class="sale">我要速速借錢1</span>
                            <p>免費透過多位金主，快速借現金、融資周轉、小額借款、臨時救急、多元化借錢管道。隨時可結案。</p>
                            <a href="#" class="btn btn-primary" role="button">速速借錢</a>
                        </div>
                    </div>
                </div>
            </div>

            <!--======= PROPERTY SLIDE =========-->
            <div class="plots">
                <div class="row">
                    <div class="col-xs-4">
                        <a href="#."> <img class="img-responsive" src="../images/propt-img-1.jpg" alt=""> </a>
                    </div>
                    <div class="col-xs-8">
                        <div class="pri-info">
                            <span class="sale">我要速速放款1</span>
                            <p>刊登放款廣告，每月多筆公開新需求等您滿足:這合銀行代辦代書、融資租賃公司、當鋪、民間金主等。</p>
                            <a href="#" class="btn btn-primary" role="button">速速放款</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>

    <!--======= 借錢找我 =========-->
    <section class="properties">
        <div class="container">
            <div class="tittle"><img src="../images/head-top.png" alt="">
                <h3>借錢找我</h3>
                <p>頭版快訊，搶先曝光</p>
            </div>
            <ul class="row">
                <li class="col-sm-4">
                    <span class="tag font-montserrat rent">NEW</span>
                    <section>
                        <div class="img">
                            <img class="img-responsive" src="../images/img-1.jpg" alt="">
                            <div class="over-proper">
                                <a href="#" class="btn font-montserrat">詳細了解</a>
                            </div>
                        </div>
                        <ul class="home-in">
                            <li><span><i class="fa fa-eye"></i> 8830 次</span></li>
                        </ul>

                        <div class="detail-sec">
                            <a href="#" class="font-montserrat">借錢免求人，還款沒壓力</a> <span class="locate"><i
                                        class="fa fa-user"></i> 陳媽媽</span>

                        </div>
                    </section>
                </li>
                <li class="col-sm-4">
                    <span class="tag font-montserrat rent">NEW</span>
                    <section>
                        <div class="img">
                            <img class="img-responsive" src="../images/img-2.jpg" alt="">
                            <div class="over-proper">
                                <a href="#" class="btn font-montserrat">詳細了解</a>
                            </div>
                        </div>
                        <ul class="home-in">
                            <li><span><i class="fa fa-eye"></i> 8830 次</span></li>
                        </ul>

                        <div class="detail-sec">
                            <a href="#" class="font-montserrat">借錢免求人，還款沒壓力</a> <span class="locate"><i
                                        class="fa fa-user"></i> 陳媽媽</span>

                        </div>
                    </section>
                </li>
                <li class="col-sm-4">
                    <span class="tag font-montserrat rent">NEW</span>
                    <section>
                        <div class="img">
                            <img class="img-responsive" src="../images/img-3.jpg" alt="">
                            <div class="over-proper">
                                <a href="#" class="btn font-montserrat">詳細了解</a>
                            </div>
                        </div>
                        <ul class="home-in">
                            <li><span><i class="fa fa-eye"></i> 8830 次</span></li>
                        </ul>

                        <div class="detail-sec">
                            <a href="#" class="font-montserrat">借錢免求人，還款沒壓力</a> <span class="locate"><i
                                        class="fa fa-user"></i> 陳媽媽</span>

                        </div>
                    </section>
                </li>
                <li class="col-sm-4">
                    <span class="tag font-montserrat rent">NEW</span>
                    <section>
                        <div class="img">
                            <img class="img-responsive" src="../images/img-4.jpg" alt="">
                            <div class="over-proper">
                                <a href="#" class="btn font-montserrat">詳細了解</a>
                            </div>
                        </div>
                        <ul class="home-in">
                            <li><span><i class="fa fa-eye"></i> 8830 次</span></li>
                        </ul>

                        <div class="detail-sec">
                            <a href="#" class="font-montserrat">借錢免求人，還款沒壓力</a> <span class="locate"><i
                                        class="fa fa-user"></i> 陳媽媽</span>

                        </div>
                    </section>
                </li>
                <li class="col-sm-4">
                    <span class="tag font-montserrat rent">NEW</span>
                    <section>
                        <div class="img">
                            <img class="img-responsive" src="../images/img-5.jpg" alt="">
                            <div class="over-proper">
                                <a href="#" class="btn font-montserrat">詳細了解</a>
                            </div>
                        </div>
                        <ul class="home-in">
                            <li><span><i class="fa fa-eye"></i> 8830 次</span></li>
                        </ul>

                        <div class="detail-sec">
                            <a href="#" class="font-montserrat">借錢免求人，還款沒壓力</a> <span class="locate"><i
                                        class="fa fa-user"></i> 陳媽媽</span>

                        </div>
                    </section>
                </li>
                <li class="col-sm-4">
                    <span class="tag font-montserrat rent">NEW</span>
                    <section>
                        <div class="img">
                            <img class="img-responsive" src="../images/img-6.jpg" alt="">
                            <div class="over-proper">
                                <a href="#" class="btn font-montserrat">詳細了解</a>
                            </div>
                        </div>
                        <ul class="home-in">
                            <li><span><i class="fa fa-eye"></i> 8830 次</span></li>
                        </ul>

                        <div class="detail-sec">
                            <a href="#" class="font-montserrat">借錢免求人，還款沒壓力</a> <span class="locate"><i
                                        class="fa fa-user"></i> 陳媽媽</span>

                        </div>
                    </section>
                </li>
                <li class="col-sm-4">
                    <span class="tag font-montserrat rent">NEW</span>
                    <section>
                        <div class="img">
                            <img class="img-responsive" src="../images/img-1.jpg" alt="">
                            <div class="over-proper">
                                <a href="#" class="btn font-montserrat">詳細了解</a>
                            </div>
                        </div>
                        <ul class="home-in">
                            <li><span><i class="fa fa-eye"></i> 8830 次</span></li>
                        </ul>

                        <div class="detail-sec">
                            <a href="#" class="font-montserrat">借錢免求人，還款沒壓力</a> <span class="locate"><i
                                        class="fa fa-user"></i> 陳媽媽</span>

                        </div>
                    </section>
                </li>
                <li class="col-sm-4">
                    <span class="tag font-montserrat rent">NEW</span>
                    <section>
                        <div class="img">
                            <img class="img-responsive" src="../images/img-2.jpg" alt="">
                            <div class="over-proper">
                                <a href="#" class="btn font-montserrat">詳細了解</a>
                            </div>
                        </div>
                        <ul class="home-in">
                            <li><span><i class="fa fa-eye"></i> 8830 次</span></li>
                        </ul>

                        <div class="detail-sec">
                            <a href="#" class="font-montserrat">借錢免求人，還款沒壓力</a> <span class="locate"><i
                                        class="fa fa-user"></i> 陳媽媽</span>

                        </div>
                    </section>
                </li>
                <li class="col-sm-4">
                    <span class="tag font-montserrat rent">NEW</span>
                    <section>
                        <div class="img">
                            <img class="img-responsive" src="../images/img-3.jpg" alt="">
                            <div class="over-proper">
                                <a href="#" class="btn font-montserrat">詳細了解</a>
                            </div>
                        </div>
                        <ul class="home-in">
                            <li><span><i class="fa fa-eye"></i> 8830 次</span></li>
                        </ul>

                        <div class="detail-sec">
                            <a href="#" class="font-montserrat">借錢免求人，還款沒壓力</a> <span class="locate"><i
                                        class="fa fa-user"></i> 陳媽媽</span>

                        </div>
                    </section>
                </li>
                <li class="col-sm-4">
                    <span class="tag font-montserrat rent">NEW</span>
                    <section>
                        <div class="img">
                            <img class="img-responsive" src="../images/img-4.jpg" alt="">
                            <div class="over-proper">
                                <a href="#" class="btn font-montserrat">詳細了解</a>
                            </div>
                        </div>
                        <ul class="home-in">
                            <li><span><i class="fa fa-eye"></i> 8830 次</span></li>
                        </ul>

                        <div class="detail-sec">
                            <a href="#" class="font-montserrat">借錢免求人，還款沒壓力</a> <span class="locate"><i
                                        class="fa fa-user"></i> 陳媽媽</span>

                        </div>
                    </section>
                </li>
                <li class="col-sm-4">
                    <span class="tag font-montserrat rent">NEW</span>
                    <section>
                        <div class="img">
                            <img class="img-responsive" src="../images/img-5.jpg" alt="">
                            <div class="over-proper">
                                <a href="#" class="btn font-montserrat">詳細了解</a>
                            </div>
                        </div>
                        <ul class="home-in">
                            <li><span><i class="fa fa-eye"></i> 8830 次</span></li>
                        </ul>

                        <div class="detail-sec">
                            <a href="#" class="font-montserrat">借錢免求人，還款沒壓力</a> <span class="locate"><i
                                        class="fa fa-user"></i> 陳媽媽</span>

                        </div>
                    </section>
                </li>
                <li class="col-sm-4">
                    <span class="tag font-montserrat rent">NEW</span>
                    <section>
                        <div class="img">
                            <img class="img-responsive" src="../images/img-6.jpg" alt="">
                            <div class="over-proper">
                                <a href="#" class="btn font-montserrat">詳細了解</a>
                            </div>
                        </div>
                        <ul class="home-in">
                            <li><span><i class="fa fa-eye"></i> 8830 次</span></li>
                        </ul>

                        <div class="detail-sec">
                            <a href="#" class="font-montserrat">借錢免求人，還款沒壓力</a> <span class="locate"><i
                                        class="fa fa-user"></i> 陳媽媽</span>

                        </div>
                    </section>
                </li>
            </ul>
        </div>
    </section>

    <!--======= 廣告刊登 =========-->
    <section class="services">
        <div class="container">
            <div class="tittle"><img src="../images/head-top.png" alt="">
                <h3>廣告刊登</h3>
                <p>頭版快訊，搶先曝光</p>
            </div>
            <ul class="row">
                <!--======= SERVICE SECTION =========-->
                <li class="col-sm-3">
                    <section>
                        <a href="">
                            <img class="img-responsive" src="../images/service-img-1.jpg" alt="">
                            <div class="icon"><img src="../images/icon-services-4.png" alt="">
                            </div>
                            <div class="ser-hover">
                                <p>全國最大貸款平臺，客護自動找上門，等妳來救急</p>
                            </div>
                            <div class="heading">廣告招商中</div>
                        </a>
                    </section>
                </li>

                <!--======= SERVICE SECTION =========-->
                <li class="col-sm-3">
                    <section>
                        <a href="">
                            <img class="img-responsive" src="../images/service-img-2.jpg" alt="">
                            <div class="icon"><img src="../images/icon-services-4.png" alt="">
                            </div>
                            <div class="ser-hover">
                                <p>全國最大貸款平臺，客護自動找上門，等妳來救急</p>
                            </div>
                            <div class="heading">廣告招商中</div>
                        </a>
                    </section>
                </li>

                <!--======= SERVICE SECTION =========-->
                <li class="col-sm-3">
                    <section>
                        <a href="">
                            <img class="img-responsive" src="../images/service-img-3.jpg" alt="">
                            <div class="icon"><img src="../images/icon-services-4.png" alt="">
                            </div>
                            <div class="ser-hover">
                                <p>全國最大貸款平臺，客護自動找上門，等妳來救急</p>
                            </div>
                            <div class="heading">廣告招商中</div>
                        </a>
                    </section>
                </li>

                <!--======= SERVICE SECTION =========-->
                <li class="col-sm-3">
                    <section>
                        <a href="">
                            <img class="img-responsive" src="../images/service-img-4.jpg" alt="">
                            <div class="icon"><img src="../images/icon-services-4.png" alt="">
                            </div>
                            <div class="ser-hover">
                                <p>全國最大貸款平臺，客護自動找上門，等妳來救急</p>
                            </div>
                            <div class="heading">廣告招商中</div>
                        </a>
                    </section>
                </li>

                <!--======= SERVICE SECTION =========-->
                <li class="col-sm-3">
                    <section>
                        <a href="">
                            <img class="img-responsive" src="../images/service-img-1.jpg" alt="">
                            <div class="icon"><img src="../images/icon-services-4.png" alt="">
                            </div>
                            <div class="ser-hover">
                                <p>全國最大貸款平臺，客護自動找上門，等妳來救急</p>
                            </div>
                            <div class="heading">廣告招商中</div>
                        </a>
                    </section>
                </li>

                <!--======= SERVICE SECTION =========-->
                <li class="col-sm-3">
                    <section>
                        <a href="">
                            <img class="img-responsive" src="../images/service-img-2.jpg" alt="">
                            <div class="icon"><img src="../images/icon-services-4.png" alt="">
                            </div>
                            <div class="ser-hover">
                                <p>全國最大貸款平臺，客護自動找上門，等妳來救急</p>
                            </div>
                            <div class="heading">廣告招商中</div>
                        </a>
                    </section>
                </li>

                <!--======= SERVICE SECTION =========-->
                <li class="col-sm-3">
                    <section>
                        <a href="">
                            <img class="img-responsive" src="../images/service-img-3.jpg" alt="">
                            <div class="icon"><img src="../images/icon-services-4.png" alt="">
                            </div>
                            <div class="ser-hover">
                                <p>全國最大貸款平臺，客護自動找上門，等妳來救急</p>
                            </div>
                            <div class="heading">廣告招商中</div>
                        </a>
                    </section>
                </li>

                <!--======= SERVICE SECTION =========-->
                <li class="col-sm-3">
                    <section>
                        <a href="">
                            <img class="img-responsive" src="../images/service-img-4.jpg" alt="">
                            <div class="icon"><img src="../images/icon-services-4.png" alt="">
                            </div>
                            <div class="ser-hover">
                                <p>全國最大貸款平臺，客護自動找上門，等妳來救急</p>
                            </div>
                            <div class="heading">廣告招商中</div>
                        </a>
                    </section>
                </li>
            </ul>
        </div>
    </section>


    <!--======= 聯絡我們 =========-->

    <section class="contact">
        <div class="contact-form">
            <div class="container">
                <div class="tittle"><img src="../images/head-top.png" alt="">
                    <h3>融資借錢快訊</h3>
                    <div class="jied-more">
                        <a href=""><i class="fa fa-hand-o-right"></i> 點擊查看更多借錢需求</a>
                    </div>
                </div>
                <div class="row pricing">

                    <!-- 借錢成功 -->
                    <div class="col-sm-3 active">
                        <h6>
                            <a href="">沒東西可抵壓 也無薪轉勞保 希望有好人單純借五萬用簽名本票或借據的</a>
                        </h6>
                        <div class="price-head font-montserrat">
                            29<span class="month">/ 萬</span>
                        </div>
                        <div class="p-details">
                            <p>
                                <i class="fa fa-user"></i> 浩浩
                                <i class="fa fa-map-marker"></i> 臺中
                                <i class="fa fa-credit-card"></i> 信用本票
                            </p>
                            <p class="gry-bg"><i class="fa fa-clock-o"></i> 2018-03-16 22:30:29</p>
                            <a href="#" class="font-montserrat">借錢成功 </a>
                        </div>
                    </div>

                    <!-- 等待金主救援 -->
                    <div class="col-sm-3">
                        <h6>
                            <a href="">沒東西可抵壓 也無薪轉勞保 希望有好人單純借五萬用簽名本票或借據的</a>
                        </h6>
                        <div class="price-head font-montserrat">
                            29<span class="month">/ 萬</span>
                        </div>
                        <div class="p-details">
                            <p>
                                <i class="fa fa-user"></i> 浩浩
                                <i class="fa fa-map-marker"></i> 臺中
                                <i class="fa fa-credit-card"></i> 信用本票
                            </p>
                            <p class="gry-bg"><i class="fa fa-clock-o"></i> 2018-03-16 22:30:29</p>
                            <a href="#" class="font-montserrat">等待金主救援 </a>
                        </div>
                    </div>

                    <!-- 借錢成功 -->
                    <div class="col-sm-3 active">
                        <h6>
                            <a href="">沒東西可抵壓 也無薪轉勞保 希望有好人單純借五萬用簽名本票或借據的</a>
                        </h6>
                        <div class="price-head font-montserrat">
                            29<span class="month">/ 萬</span>
                        </div>
                        <div class="p-details">
                            <p>
                                <i class="fa fa-user"></i> 浩浩
                                <i class="fa fa-map-marker"></i> 臺中
                                <i class="fa fa-credit-card"></i> 信用本票
                            </p>
                            <p class="gry-bg"><i class="fa fa-clock-o"></i> 2018-03-16 22:30:29</p>
                            <a href="#" class="font-montserrat">借錢成功 </a>
                        </div>
                    </div>

                    <!-- 等待金主救援 -->
                    <div class="col-sm-3">
                        <h6>
                            <a href="">沒東西可抵壓 也無薪轉勞保 希望有好人單純借五萬用簽名本票或借據的</a>
                        </h6>
                        <div class="price-head font-montserrat">
                            29<span class="month">/ 萬</span>
                        </div>
                        <div class="p-details">
                            <p>
                                <i class="fa fa-user"></i> 浩浩
                                <i class="fa fa-map-marker"></i> 臺中
                                <i class="fa fa-credit-card"></i> 信用本票
                            </p>
                            <p class="gry-bg"><i class="fa fa-clock-o"></i> 2018-03-16 22:30:29</p>
                            <a href="#" class="font-montserrat">等待金主救援 </a>
                        </div>
                    </div>

                    <!-- 借錢成功 -->
                    <div class="col-sm-3 active">
                        <h6>
                            <a href="">沒東西可抵壓 也無薪轉勞保 希望有好人單純借五萬用簽名本票或借據的</a>
                        </h6>
                        <div class="price-head font-montserrat">
                            29<span class="month">/ 萬</span>
                        </div>
                        <div class="p-details">
                            <p>
                                <i class="fa fa-user"></i> 浩浩
                                <i class="fa fa-map-marker"></i> 臺中
                                <i class="fa fa-credit-card"></i> 信用本票
                            </p>
                            <p class="gry-bg"><i class="fa fa-clock-o"></i> 2018-03-16 22:30:29</p>
                            <a href="#" class="font-montserrat">借錢成功 </a>
                        </div>
                    </div>

                    <!-- 等待金主救援 -->
                    <div class="col-sm-3">
                        <h6>
                            <a href="">沒東西可抵壓 也無薪轉勞保 希望有好人單純借五萬用簽名本票或借據的</a>
                        </h6>
                        <div class="price-head font-montserrat">
                            29<span class="month">/ 萬</span>
                        </div>
                        <div class="p-details">
                            <p>
                                <i class="fa fa-user"></i> 浩浩
                                <i class="fa fa-map-marker"></i> 臺中
                                <i class="fa fa-credit-card"></i> 信用本票
                            </p>
                            <p class="gry-bg"><i class="fa fa-clock-o"></i> 2018-03-16 22:30:29</p>
                            <a href="#" class="font-montserrat">等待金主救援 </a>
                        </div>
                    </div>

                    <!-- 借錢成功 -->
                    <div class="col-sm-3 active">
                        <h6>
                            <a href="">沒東西可抵壓 也無薪轉勞保 希望有好人單純借五萬用簽名本票或借據的</a>
                        </h6>
                        <div class="price-head font-montserrat">
                            29<span class="month">/ 萬</span>
                        </div>
                        <div class="p-details">
                            <p>
                                <i class="fa fa-user"></i> 浩浩
                                <i class="fa fa-map-marker"></i> 臺中
                                <i class="fa fa-credit-card"></i> 信用本票
                            </p>
                            <p class="gry-bg"><i class="fa fa-clock-o"></i> 2018-03-16 22:30:29</p>
                            <a href="#" class="font-montserrat">借錢成功 </a>
                        </div>
                    </div>

                    <!-- 等待金主救援 -->
                    <div class="col-sm-3">
                        <h6>
                            <a href="">沒東西可抵壓 也無薪轉勞保 希望有好人單純借五萬用簽名本票或借據的</a>
                        </h6>
                        <div class="price-head font-montserrat">
                            29<span class="month">/ 萬</span>
                        </div>
                        <div class="p-details">
                            <p>
                                <i class="fa fa-user"></i> 浩浩
                                <i class="fa fa-map-marker"></i> 臺中
                                <i class="fa fa-credit-card"></i> 信用本票
                            </p>
                            <p class="gry-bg"><i class="fa fa-clock-o"></i> 2018-03-16 22:30:29</p>
                            <a href="#" class="font-montserrat">等待金主救援 </a>
                        </div>
                    </div>
                </div>
                <div class="show-more">
                    <a href=""><i class="fa fa-arrow-down"></i> 顯示更多</a>
                </div>
            </div>
        </div>
    </section>


    <!--======= 青創貸款融資案例 =========-->
    <section class="blog">
        <div class="container">
            <div class="tittle">
                <img src="images/head-top.png" alt="">
                <h3>青創貸款融資案例</h3>
            </div>
            <ul class="row">
                <li class="col-sm-3">
                    <a href="">
                        <div class="b-inner">
                            <img class="img-responsive" src="../images/blog-img-1.jpg" alt="">
                            <div class="b-details">
                                <div class="bottom-sec">
                                    <span><i class="fa fa-calendar"></i> 2018-03-16</span>
                                    <div>貸款融資案例8</div>

                                    <hr>
                                    <p>短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明 </p>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="col-sm-3">
                    <a href="">
                        <div class="b-inner">
                            <img class="img-responsive" src="../images/blog-img-2.jpg" alt="">
                            <div class="b-details">
                                <div class="bottom-sec">
                                    <span><i class="fa fa-calendar"></i> 2018-03-16</span>
                                    <div>貸款融資案例2</div>

                                    <hr>
                                    <p>短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明 </p>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="col-sm-3">
                    <a href="">
                        <div class="b-inner">
                            <img class="img-responsive" src="../images/blog-img-3.jpg" alt="">
                            <div class="b-details">
                                <div class="bottom-sec">
                                    <span><i class="fa fa-calendar"></i> 2018-03-16</span>
                                    <div>貸款融資案例3</div>

                                    <hr>
                                    <p>短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明 </p>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="col-sm-3">
                    <a href="">
                        <div class="b-inner">
                            <img class="img-responsive" src="../images/blog-img-1.jpg" alt="">
                            <div class="b-details">
                                <div class="bottom-sec">
                                    <span><i class="fa fa-calendar"></i> 2018-03-16</span>
                                    <div>貸款融資案例4</div>

                                    <hr>
                                    <p>短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明 </p>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="col-sm-3">
                    <a href="">
                        <div class="b-inner">
                            <img class="img-responsive" src="../images/blog-img-2.jpg" alt="">
                            <div class="b-details">
                                <div class="bottom-sec">
                                    <span><i class="fa fa-calendar"></i> 2018-03-16</span>
                                    <div>貸款融資案例5</div>

                                    <hr>
                                    <p>短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明 </p>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="col-sm-3">
                    <a href="">
                        <div class="b-inner">
                            <img class="img-responsive" src="../images/blog-img-3.jpg" alt="">
                            <div class="b-details">
                                <div class="bottom-sec">
                                    <span><i class="fa fa-calendar"></i> 2018-03-16</span>
                                    <div>貸款融資案例6</div>

                                    <hr>
                                    <p>短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明 </p>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="col-sm-3">
                    <a href="">
                        <div class="b-inner">
                            <img class="img-responsive" src="../images/blog-img-2.jpg" alt="">
                            <div class="b-details">
                                <div class="bottom-sec">
                                    <span><i class="fa fa-calendar"></i> 2018-03-16</span>
                                    <div>貸款融資案例7</div>

                                    <hr>
                                    <p>短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明 </p>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="col-sm-3">
                    <a href="">
                        <div class="b-inner">
                            <img class="img-responsive" src="../images/blog-img-3.jpg" alt="">
                            <div class="b-details">
                                <div class="bottom-sec">
                                    <span><i class="fa fa-calendar"></i> 2018-03-16</span>
                                    <div>貸款融資案例8</div>

                                    <hr>
                                    <p>短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明短說明 </p>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
    </section>

    <!--======= FOOTER =========-->
    <footer>
        <div class="container">
            <ul class="row">
                <li class="col-sm-3">
                    <h5>關於我們</h5>
                    <hr>
                    <p>我們了解資金周轉不靈的困擾，5757借錢網，提供您資金貸款需求，小額貸款，工商融資，家庭急用，歡迎有興趣刊登廣告的金主速速與我們聯絡.</p>
                    <ul class="social_icons">
                        <li class="facebook"><a href="#."><i class="fa fa-facebook"></i> </a></li>
                        <li class="twitter"><a href="#."><i class="fa fa-twitter"></i> </a></li>
                        <li class="linkedin"><a href="#."><i class="fa fa-linkedin"></i> </a></li>
                        <li class="tumblr"><a href="#."><i class="fa fa-tumblr"></i> </a></li>
                    </ul>
                </li>

                <li class="col-sm-3">
                    <h5>最新消息</h5>
                    <hr>
                    <ul class="recent-come">
                        <li>
                            <div class="img-post"><img src="../images/recent-img.jpg" alt=""></div>
                            <div class="text-post"><a href="#.">XXX公司取得1000萬融資</a></div>
                        </li>
                        <li>
                            <div class="img-post"><img src="../images/recent-img-1.jpg" alt=""></div>
                            <div class="text-post"><a href="#.">XXX公司取得1000萬融資</a></div>
                        </li>
                        <li>
                            <div class="img-post"><img src="../images/recent-img-2.jpg" alt=""></div>
                            <div class="text-post"><a href="#.">XXX公司取得1000萬融資</a></div>
                        </li>
                    </ul>
                </li>

                <li class="col-sm-3">
                    <h5>聯絡方式</h5>
                    <hr>
                    <div class="loc-info">
                        <p><i class="fa fa-map-marker"></i> 臺南市永康區
                            中山路354號3樓9</p>
                        <p><i class="fa fa-phone"></i> +01 123 456 78</p>
                        <p><i class="fa fa-print"></i> +01 123 456 78</p>
                        <p><i class="fa fa-envelope-o"></i> Info@realtor.com</p>
                    </div>
                </li>

                <li class="col-sm-3 properti-detsil pds1">
                    <h5>地区</h5>
                    <hr>
                    <ul class="tags">
                        <#list areaList as area >
                            <a href="">${area!''}</a>
                        </#list>
                        <li>
                            <a href="">臺南市</a>
                        </li>
                        <li>
                            <a href="">臺南市</a>
                        </li>
                        <li>
                            <a href="">臺南市</a>
                        </li>
                        <li>
                            <a href="">臺南市</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </footer>

    <!--======= RIGHTS =========-->
    <div class="rights">
        <div class="container">
            <p class="font-montserrat">© 2015 Realtor. All rights reserved</p>
        </div>
    </div>
</div>

<script src="../js/jquery-1.11.0.min.js"></script>
<script src="../js/wow.min.js"></script>
<script src="../js/bootstrap-select.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.stellar.js"></script>
<script src="../js/jquery.flexslider-min.js"></script>
<script src="../js/owl.carousel.min.js"></script>
<script src="../js/jquery.sticky.js"></script>
<script src="../js/own-menu.js"></script>
<script src="../js/jquery.nouislider.min.js"></script>
<script src="../js/main.js"></script>

</body>
<script>
    var arealist;
    $(function () {
        getArea();
    })

    function getArea() {
        arealist = [];
        for (var i = 0; i <= 5; i++) {
            arealist.push("地区" + i);
        }
        alert("sfafafsf");
    }

</script>
</html>