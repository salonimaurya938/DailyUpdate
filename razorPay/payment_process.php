<?php
include "db.php";

session_start();
if(isset($_POST['amt']) && isset($_POST['name'])){  
    $amt=$_POST['amt'];
    $name=$_POST['name'];
    $payment_status="Pendding..";
    $added_on=date('y-m-d h:i:s');
    mysqli_query("INSERT INTO `payment`(`id`, `name`, `amount`, `payment_status`, `added_on`) VALUES ('','$name','$amt','$payment_status','$added_on')");
    $_SESSION['OID']=mysqli_insert_id($conn);
}
elseif(isset($_POST['payment_id']) && isset($_SESSION['OID'])){
    $payment_id=$_POST['payment_id'];
    mysqli_query("UPDATE `payment` SET `payment_status`='Complete',`payment_id`='$payment_id' WHERE `id`='"$_SESSION['OID']"'");
    $_SESSION['OID']=mysqli_insert_id($conn);
}else{
    echo "Error";
}
  


?>
