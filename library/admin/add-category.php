<?php
session_start();
error_reporting(0);
$conn = mysqli_connect("localhost", "root", "", "apptruyen");
if(strlen($_SESSION['alogin'])==0)
{ 
header('location:../login.php');
}
else
{
   if ($conn)
    {
        if(isset($_POST['uploadfilesub'])) {
            //declaring variables
            $catename = $_POST['catename'];
            $image = $_POST['image'];
            $sql = "INSERT INTO `categories` (`tentheloai`, `hinhtheloai`)  VALUES ('$catename','$image')";
            $qry = mysqli_query($conn,  $sql);
            if( $qry) {
                header('location:manage-categories.php'); 
            }
            else 
            {
            $_SESSION['error']="Something went wrong. Please try again";
            header('location:manage-categories.php');
            }
        }
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
    <title>TruuyenFull | Add Categories</title>
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
                <h4 class="header-line">Add category</h4>
                
            </div>

        </div>
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3"">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        Category Info
                    </div>
                    <div class="panel-body">

                        <form action="" method="post" enctype="multipart/form-data">
                         
                                <div class="form-group">
                                    <label class="control-label">Category Name</label>
                                    <input type="text" name="catename" class="form-control" >
                                </div>
                          

                               <div class="form-group">
                                    <label class="control-label">Category Image</label>
                                    <input type="text" name="image" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <input type="submit" class="btn btn-danger" name="uploadfilesub" value="Upload" />
                                </div>
                               </form>    
                                        
                    </div>
             
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
    <!-- BOOTSTRAP SCRIPTS  -->
    <script src="assets/js/bootstrap.js"></script>
      <!-- CUSTOM SCRIPTS  -->
    <script src="assets/js/custom.js"></script>
</body>
</html>
