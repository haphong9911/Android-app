<?php
session_start();
error_reporting(0);
$conn = mysqli_connect("localhost", "root", "", "apptruyen");
if(strlen($_SESSION['alogin'])==0)
{ 
header('location:../login.php');
}
else{ 

    if(isset($_POST['update']))
    {
        
        $bookid=intval($_GET['IDtruyen']);
        $bookname=$_POST['bookname'];
        $category=$_POST['category'];
        $author=$_POST['author'];
        $status=$_POST['status'];
        $summary=$_POST['summary'];
        $image=$_POST['image'];
        $conn = mysqli_connect("localhost", "root", "", "apptruyen");
        $sql="UPDATE `story` SET `tentruyen`='$bookname', `IDtheloai`='$category', `tacgia`='$author', `hinhanhtruyen`='$image', `tomtat`='$summary', `status`='$status' where `story`.`IDtruyen`='$bookid'";
        $qry = mysqli_query($conn,  $sql);
        if( $qry) 
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
    <title>TruyenFull | Edit Book</title>
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
                <h4 class="header-line">Edit Book</h4>
                
            </div>

        </div>
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3"">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        Book Info
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" enctype="multipart/form-data">
                        <?php 
                            $bookid=intval($_GET['IDtruyen']);
                            $conn = mysqli_connect("localhost", "root", "", "apptruyen");
                            $sql = "SELECT story.IDtruyen,story.tentruyen,categories.tentheloai,tblauthors.authorName,story.status,story.tomtat,story.hinhanhtruyen from  story join categories on categories.IDtheloai=story.IDtheloai join tblauthors on tblauthors.id_author=story.tacgia WHERE story.IDtruyen = '$bookid'";
                          
                            $query = mysqli_query($conn, $sql);
                            $results = $query->fetch_all(MYSQLI_ASSOC);
                            foreach($results as $result => $value)
                            {       
                                ?>  
                                <div class="form-group">
                                    <label>Book Name<span style="color:red;">*</span></label>
                                    <input class="form-control" type="text" name="bookname" value="<?php echo ($value['tentruyen']); ?>"  required />
                                </div>

                                
                                <div class="form-group">
                                    <label>Category<span style="color:red;">*</span></label>
                                    <select class="form-control" name="category" required="required">
                                        <option value="<?php echo $value['IDtheloai']; ?>"><?php echo htmlentities($value['tentheloai']); ?> </option>
                                         <?php 
                                            $conn = mysqli_connect("localhost", "root", "", "apptruyen");
                                            $sql1 = "SELECT * from `categories`";
                                            $query1 = mysqli_query($conn, $sql1);
                                            $results1 = $query1->fetch_all(MYSQLI_ASSOC);
                                            foreach($results1 as $result1 => $value1)
                                            {       ?>  
                                            <option value="<?php echo $value1['IDtheloai']; ?>">
                                                <?php echo htmlentities($value1['tentheloai']); ?>
                                            </option>
                                        <?php } ?>
                                    </select>
                                </div>


                                <div class="form-group">
                                    <label>Author<span style="color:red;">*</span></label>
                                    <select class="form-control" name="author" required="required">
                                        <option value="<?php echo $value['id_author']; ?>"> <?php echo htmlentities($value['authorName']); ?></option>
                                         <?php 
                                            $conn = mysqli_connect("localhost", "root", "", "apptruyen");
                                            $sql2 = "SELECT * from `tblauthors`";
                                            $query2 = mysqli_query($conn, $sql2);
                                            $results2 = $query2->fetch_all(MYSQLI_ASSOC);
                                            foreach($results2 as $result2 => $value2)
                                            {     
                                                ?>  
                                            <option value="<?php echo $value2['id_author']; ?>">
                                                <?php echo htmlentities($value2['authorName']); ?>
                                            </option>
                                        <?php } ?>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label>Status<span style="color:red;">*</span></label>
                                    <select class="form-control" name="status" required="required">
                                        <option value="1">Full</option>
                                        <option value="0">Updating</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label>Summary</label>
                                    <textarea class="form-control" name="summary" id="summary_editor"></textarea>
                                </div>

                                <div class="form-group">
                                    <label>Link Image<span style="color:red;">*</span></label>
                                    <input class="form-control" type="text" name="image" value="<?php echo ($value['hinhanhtruyen']); ?>"  required />
                                </div>

                                <div class="form-group">
                                    <input type="submit" class="btn btn-danger" name="update" value="Update" />
                                </div>
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

    <script src="//cdn.ckeditor.com/4.11.1/standard/ckeditor.js"></script>
    <script>
        CKEDITOR.replace('summary_editor',{
         
        });
    </script>
    <!-- BOOTSTRAP SCRIPTS  -->
    <script src="assets/js/bootstrap.js"></script>
      <!-- CUSTOM SCRIPTS  -->
    <script src="assets/js/custom.js"></script>
</body>
</html>
<?php } ?>
