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

    if(isset($_POST['uploadfilesub']))
    {
        $bookname=$_POST['bookname'];
        $category=$_POST['category'];
        $author=$_POST['author'];
        $status=$_POST['status'];
        $summary=$_POST['summary'];
        $image = $_POST['image'];
            //inserting image details (ie image name) in the database
            $sql = "INSERT INTO `story`(`IDtheloai`, `tentruyen`, `tacgia`, `hinhanhtruyen`, `tomtat`, `status`) VALUES ('$category', '$bookname', '$author', '$image', '$summary', '$status')";
            $qry = mysqli_query($conn,  $sql);
            if( $qry) {
                header('location:manage-books.php'); 
            }

            else 
            {
            $_SESSION['error']="Something went wrong. Please try again";
            header('location:manage-books.php');
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
    <title>TruyenFull | Add Book</title>
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
                    <h4 class="header-line">Add Book</h4>
                    
                </div>

            </div>
            
            <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            Book Info
                        </div>

                        <div class="panel-body">
                            <form role="form" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label>Book Name<span style="color:red;">*</span></label>
                                    <input class="form-control" type="text" name="bookname" autocomplete="off"  required />
                                </div>

                                
                                <div class="form-group">
                                    <label>Category<span style="color:red;">*</span></label>
                                    <select class="form-control" name="category" required="required">
                                        <option value=""> Select Category</option>
                                         <?php 
                                            $conn = mysqli_connect("localhost", "root", "", "apptruyen");
                                            $sql = "SELECT * from `categories`";
                                            $query = mysqli_query($conn, $sql);
                                            $results = $query->fetch_all(MYSQLI_ASSOC);
                                            foreach($results as $result => $value)
                                            {       ?>  
                                            <option value="<?php echo $value['IDtheloai']; ?>">
                                                <?php echo htmlentities($value['tentheloai']); ?>
                                            </option>
                                        <?php } ?>
                                    </select>
                                </div>


                                <div class="form-group">
                                    <label>Author<span style="color:red;">*</span></label>
                                    <select class="form-control" name="author" required="required">
                                        <option value=""> Select Author</option>
                                         <?php 
                                            $conn = mysqli_connect("localhost", "root", "", "apptruyen");
                                            $sql = "SELECT * from `tblauthors`";
                                            $query = mysqli_query($conn, $sql);
                                            $results = $query->fetch_all(MYSQLI_ASSOC);
                                            foreach($results as $result => $value)
                                            {   var_dump($value)    
                                                ?>  
                                            <option value="<?php echo $value['id_author']; ?>">
                                                <?php echo htmlentities($value['authorName']); ?>
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
                                    <input class="form-control" type="text" name="image" autocomplete="off"  required />
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
