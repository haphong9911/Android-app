<?php
session_start();
error_reporting(0);
$conn = mysqli_connect("localhost", "root", "", "apptruyen");
if(strlen($_SESSION['alogin'])==0)
{ 
header('location:../login.php');
}
else{ 
    if ($conn)
    {
        if(isset($_POST['update']))
        {
            $IDtheloai=intval($_GET['IDtheloai']);
            $catename=$_POST['catename'];
            $image = $_POST['image'];
            $conn = mysqli_connect("localhost", "root", "", "apptruyen");
            $sql="UPDATE `categories` SET `tentheloai`='$catename', `hinhtheloai`='$image' where `categories`.`IDtheloai`='$IDtheloai'";
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

    
?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>TruyenFull | Edit Categories</title>
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
                <h4 class="header-line">Edit category</h4>
                
            </div>

        </div>
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3"">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        Category Info
                    </div>
         
                    <div class="panel-body">
                        <form role="form" method="post" enctype="multipart/form-data">
                            <?php 
                                $IDtheloai=intval($_GET['IDtheloai']);
                                $conn = mysqli_connect("localhost", "root", "", "apptruyen");
                                $sql="SELECT * from `categories` where IDtheloai='$IDtheloai'";
                                $query = mysqli_query($conn, $sql);
                                $results=$query->fetch_all(MYSQLI_ASSOC);
                                foreach($results as $result => $value)
                                    {               
                                    ?> 
                                        <div class="form-group">
                                            <label>Category Name</label>
                                            <input class="form-control" type="text" name="catename" value="<?php echo ($value['tentheloai']);?>" required />
                                        </div>
                                        <div class="form-group">
                                            <label>Link Category Image</label>
                                            <input class="form-control" type="text" name="image" value="<?php echo ($value['hinhtheloai']);?>" required />
                                        </div>


                                        <button type="submit" name="update" class="btn btn-info">Update </button>
                                    <?php } ?>
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
    <!-- BOOTSTRAP SCRIPTS  -->
    <script src="assets/js/bootstrap.js"></script>
      <!-- CUSTOM SCRIPTS  -->
    <script src="assets/js/custom.js"></script>
</body>
</html>
<?php } ?>
