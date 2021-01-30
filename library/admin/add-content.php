<?php
session_start();
error_reporting(0);

include('includes/config.php');
$conn = mysqli_connect("localhost", "root", "", "apptruyen");
if(strlen($_SESSION['alogin'])==0)
{ 
header('location:../login.php');
}
else{ 

    if(isset($_POST['update']))
    {
        
        $bookid=intval($_GET['IDtruyen']);
        $chaptername=$_POST['chaptername'];
        $content=$_POST['content'];
        $conn = mysqli_connect("localhost", "root", "", "apptruyen");

        echo $bookid;
        $sql1 = "INSERT INTO `chuong`(`IDtruyen`, `tenchuong`, `noidung`) VALUES ('$bookid', '$chaptername', '$content')";
        $query1 = mysqli_query($conn, $sql1);
        $sql2 ="SELECT * FROM `chuong` WHERE `IDtruyen`= '$bookid'";
        $query2 = $dbh -> prepare($sql2);
        $query2->execute();
        $results=$query2->fetchAll(PDO::FETCH_OBJ);
        $chapter=$query2->rowCount();
        
        echo $chapter;
        $sql3 = "UPDATE `story` SET `chuong`='$chapter' where `story`.`IDtruyen`='$bookid'";
        $query3 = mysqli_query($conn,  $sql3);
        if( $query3) 
        {
            header('location:manage-books.php'); 
        }
        else 
        {
            $_SESSION['error']="Something went wrong. Please try again";
            header('location:manage-books.php');
        }

        

    }
?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>TruyenFull | Add Content</title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME STYLE  -->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="assets/css/style.css" rel="stylesheet" />
    <!-- GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

</head>
<body>
      <!------MENU SECTION START-->
<?php include('includes/header.php');?>
<!-- MENU SECTION END-->
<div class="content-wrapper">
    <div class="container">
        <div class="row pad-botm">
            <div class="col-md-12">
                <h4 class="header-line">Add Content</h4>
                
            </div>

        </div>
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3"">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        Book Content
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label>Chapter Name<span style="color:red;">*</span></label>
                                    <input class="form-control" type="text" name="chaptername" required />
                                </div>

                                <div class="form-group">
                                    <label>Content</label>
                                    <textarea class="form-control" name="content" id="content_editor"></textarea>
                                </div>

                                <div class="form-group">
                                    <input type="submit" class="btn btn-danger" name="update" value="Update" />
                                </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
   
    </div>
</div>
     <!-- CONTENT-WRAPPER SECTION END-->
  <?php include('includes/footer.php');?>
      <!-- FOOTER SECTION END-->
    <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY  -->
    <script src="assets/js/jquery-1.10.2.js"></script>

    <script src="//cdn.ckeditor.com/4.11.1/standard/ckeditor.js"></script>
    <script>
        CKEDITOR.replace('content_editor',{
         
        });
    </script>
    <!-- BOOTSTRAP SCRIPTS  -->
    <script src="assets/js/bootstrap.js"></script>
      <!-- CUSTOM SCRIPTS  -->
    <script src="assets/js/custom.js"></script>
</body>
</html>
<?php } ?>
